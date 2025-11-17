package com.thejoa703.service;

import java.util.List;

import com.thejoa703.dto.AppUserDto;

public interface AppUserService {
		public int insert(AppUserDto dto);
		public int update(AppUserDto dto);
		public int delete(AppUserDto dto);
		public List<AppUserDto> selectAll();
		public AppUserDto       select(int appUserId);
		public AppUserDto       selectEmail(String email);
		public int selectLogin(AppUserDto dto);
}
