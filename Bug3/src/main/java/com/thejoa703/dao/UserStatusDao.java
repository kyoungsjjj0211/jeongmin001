package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.AdminUserStatusDto;
import com.thejoa703.dto.UserStatusDto;

@Mapper
public interface UserStatusDao {

    /** 단일 사용자 상태 조회 (로그인/마이페이지용) */
    UserStatusDto findByAppUserId(int appUserId);

    /** 최초 생성 (회원가입 시) */
    int insert(UserStatusDto dto);

    /** 상태 변경 (정지 / 해제) */
    int update(UserStatusDto dto);

    /** 관리자: 전체 회원 상태 조회 */
    List<AdminUserStatusDto> findAllUserStatus();
    
    AdminUserStatusDto findAdminUserByAppUserId(int appUserId);
}
