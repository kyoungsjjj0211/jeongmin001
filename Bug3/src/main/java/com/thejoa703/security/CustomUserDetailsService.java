package com.thejoa703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
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
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        /*
         * username 형식
         *  - local 로그인  : email
         *  - 통합 처리용  : email:provider
         */
        String[] parts = username.split(":");
        String email = parts[0];
        String provider = parts.length > 1 ? parts[1] : "local";

        AppUserDto param = new AppUserDto();
        param.setEmail(email);
        param.setProvider(provider);

        // 🔹 인증 정보 조회 (비밀번호 + 권한)
        AppUserAuthDto authDto = userDao.readAuthByEmail(param);
        if (authDto == null) {
            throw new UsernameNotFoundException(
                "사용자를 찾을 수 없습니다."
            );
        }

        // 🔹 사용자 기본 정보 조회
        AppUserDto user = userDao.findByEmail(param);
        if (user == null) {
            throw new UsernameNotFoundException(
                "사용자 기본정보를 찾을 수 없습니다."
            );
        }

        // 🔥🔥🔥 핵심: 회원 정지 상태 체크
        UserStatusDto status =
                userStatusDao.findByAppUserId(user.getAppUserId());
        System.out.println("정지 사유 = [" + 
                (status != null ? status.getSuspendReason() : "status 자체가 null") 
        + "]");

        if (status != null && "SUSPEND".equals(status.getStatus())) {

            String reason =
                    status.getSuspendReason() != null
                            ? status.getSuspendReason()
                            : "사유 없음";
            System.out.println("정지 사유 = [" + status.getSuspendReason() + "]");
            // ❗ 반드시 DisabledException
            throw new DisabledException(
                "활동 정지 상태입니다. 관리자에게 문의해주세요. (사유: " + reason + ")"
                
            );
        }

        // 정상 사용자
        return new CustomUserDetails(user, authDto);
    }
}
