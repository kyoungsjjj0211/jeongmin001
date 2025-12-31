package com.thejoa703.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dao.UserStatusDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.dto.UserStatusDto;
import com.thejoa703.util.UtilUpload;

@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired private UserStatusService userStatusService;
    @Autowired private AppUserDao userDao;
    @Autowired private UserStatusDao userStatusDao;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private UtilUpload utilUpload;

    /* insert,update 파일업로드(공통) */
    private String uploadFile(MultipartFile file, String existingFile) {
        if (file != null && !file.isEmpty()) {
            try {
                return utilUpload.fileUpload(file);
            } catch (IOException e) {
                throw new RuntimeException("파일 업로드 실패", e);
            }
        }
        return existingFile;
    }

    // ================= 회원가입 =================
    @Transactional
    @Override
    public int insert(MultipartFile file, AppUserDto dto) {
    	

        // 1. 기본 세팅
        dto.setProvider("local");
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        dto.setUfile(uploadFile(file, null));

        if (userDao.iddoubleByEmail(dto) > 0) {
            throw new IllegalStateException("이미 존재하는 계정입니다.");
        }

        // 2. 유저 INSERT
        int result = userDao.insertAppUser(dto);
        if (result <= 0) {
            return 0;
        }

        // 3. 권한 INSERT
        userDao.insertAuth(new AuthDto(dto.getEmail(), "ROLE_MEMBER"));

        // 4. 🔥 상태 테이블 INSERT (BUG3_MANAGE)
        UserStatusDto statusDto = new UserStatusDto();
        statusDto.setAppUserId(dto.getAppUserId()); // 중요
        statusDto.setStatus("ACTIVE");

        userStatusDao.insert(statusDto);

        return result;
    }

    // ================= 회원정보 수정 =================
    @Transactional
    @Override
    public int update(MultipartFile file, AppUserDto dto) {

        AppUserDto dbUser = userDao.findByEmail(
            new AppUserDto(dto.getEmail(), dto.getProvider())
        );

        if (dbUser == null) {
            return 0;
        }

        // local 계정만 비밀번호 검증
        if ("local".equals(dbUser.getProvider())) {
            if (dto.getPassword() == null ||
                !passwordEncoder.matches(dto.getPassword(), dbUser.getPassword())) {
                return 0;
            }
        }

        dto.setAppUserId(dbUser.getAppUserId());
        dto.setProvider(dbUser.getProvider());
        dto.setUfile(uploadFile(file, dbUser.getUfile()));
        dto.setNickname(dto.getNickname() != null ? dto.getNickname() : dbUser.getNickname());
        dto.setMobile(dto.getMobile() != null ? dto.getMobile() : dbUser.getMobile());
        dto.setPassword(dbUser.getPassword());

        return userDao.updateAppUser(dto);
    }

    // ================= 회원 삭제 =================
    @Transactional
    @Override
    public int delete(AppUserDto dto, boolean requirePasswordCheck) {

        AppUserDto dbUser = userDao.findByEmail(dto);
        if (dbUser == null) {
            return 0;
        }

        if (requirePasswordCheck) {
            if (dto.getPassword() == null ||
                !passwordEncoder.matches(dto.getPassword(), dbUser.getPassword())) {
                return 0;
            }
        }

        dto.setAppUserId(dbUser.getAppUserId());
        userDao.deleteAuth(new AuthDto(dto.getEmail(), "ROLE_MEMBER"));

        return userDao.deleteAppUser(dto);
    }

    // ================= 기타 =================
    @Override
    public AppUserAuthDto readAuth(String email, String provider) {
        return userDao.readAuthByEmail(new AppUserDto(email, provider));
    }

    @Override
    public AppUserDto selectEmail(String email, String provider) {
        return userDao.findByEmail(new AppUserDto(email, provider));
    }

    @Override
    public int iddouble(String email, String provider) {
        return userDao.iddoubleByEmail(new AppUserDto(email, provider));
    }

    @Override
    public boolean matchesPassword(String email, String provider, String rawPassword) {
        AppUserDto dbUser = userDao.findByEmail(new AppUserDto(email, provider));
        return dbUser != null &&
               dbUser.getPassword() != null &&
               passwordEncoder.matches(rawPassword, dbUser.getPassword());
    }
}
