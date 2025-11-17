package com.thejoa703.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserDto;

@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired AppUserDao dao;
	@Override public int insert(AppUserDto dto) {return dao.insert(dto);}
	@Override public int update(AppUserDto dto) {return dao.update(dto);}
	@Override public int delete(AppUserDto dto) {return dao.delete(dto);}
	@Override public List<AppUserDto> selectAll() {return dao.selectAll();}
	@Override public AppUserDto select(int appUserId) {return dao.select(appUserId);}
	@Override public AppUserDto selectEmail(String email) {return dao.selectEmail(email);}
	@Override public int selectLogin(AppUserDto dto) {return dao.selectLogin(dto);}
	
}
