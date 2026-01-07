package com.thejoa703.security;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dao.UserStatusDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.UserStatusDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserDao userDao;

    @Autowired
    private UserStatusDao userStatusDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. 아이디 및 로그인 방식 분리
        String[] parts = username.split(":");
        String email = parts[0];
        String provider = parts.length > 1 ? parts[1] : "local";

        AppUserDto param = new AppUserDto();
        param.setEmail(email);
        param.setProvider(provider);

        // 2. 인증 및 사용자 정보 조회
        AppUserAuthDto authDto = userDao.readAuthByEmail(param);
        if (authDto == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        AppUserDto user = userDao.findByEmail(param);
        if (user == null) {
            throw new UsernameNotFoundException("사용자 기본정보를 찾을 수 없습니다: " + username);
        }

        // 3. [영민님 코드 반영] 콘솔 디버깅 로그 출력
        System.out.println("----------------------------------------");
        System.out.println("로그인 시도 이메일: " + email);
        System.out.println("조회된 유저 ID: " + user.getAppUserId());
        System.out.println("----------------------------------------");

        // 4. [팀원 코드 반영] 정지 상태 확인 및 자동 복구 로직
        Integer appUserId = user.getAppUserId();
        UserStatusDto statusDto = userStatusDao.findByAppUserId(appUserId);

        if (statusDto != null && "SUSPEND".equalsIgnoreCase(statusDto.getStatus())) {
            
            // 정지 기간이 만료되었는지 확인 후 복구
            if (statusDto.getSuspendUntil() != null && statusDto.getSuspendUntil().isBefore(LocalDate.now())) {
                System.out.println(">>> 정지 기간 만료로 인한 자동 복구 진행: " + email);
                userStatusDao.recoverExpiredSuspension(appUserId);
                statusDto = userStatusDao.findByAppUserId(appUserId); // 상태 갱신
            }

            // 여전히 정지 상태라면 로그인 거부
            if ("SUSPEND".equalsIgnoreCase(statusDto.getStatus())) {
                String reason = (statusDto.getSuspendReason() != null) ? statusDto.getSuspendReason() : "사유 없음";
                System.out.println("!!! 차단 시스템 작동: " + email + " 접속 거부 (사유: " + reason + ")");
                
                // 에러 메시지 통합 출력
                throw new InternalAuthenticationServiceException("정지된 계정입니다. 사유: " + reason);
            }
        }

        // 5. 로그인 성공
        return new CustomUserDetails(user, authDto);
    }
}