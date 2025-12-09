package com.thejoa703.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.thejoa703.dao.AppUserMapper;
import com.thejoa703.dto.*;

@Service
public class AppUserSecurityServiceImpl implements AppUserSecurityService{
	@Autowired  AppUserMapper  dao;  
	@Autowired  PasswordEncoder  pwencoder;
	
	@Override public int insert(MultipartFile file, AppUser dto) { //##
      //0. 권한 (ROLE_MEMBER)
		AuthDto   adto =  new AuthDto();
		adto.setEmail(dto.getEmail());    adto.setAuth("ROLE_MEMBER");
		dao.insertAuth(  adto  );   // 권한주기
		
	  //1.파일올리기
	   String fileName   = null;
	   if(  !file.isEmpty() ) {  // 파일이 비어있는게 아니라면
		   fileName   = file.getOriginalFilename(); // 원본파일이름
		   String uploadPath = "C:/file/";
		   File   img        = new File(uploadPath + fileName);  //java.io.File
		   try { file.transferTo(img); }//파일올리기 
		   catch (IOException e) { e.printStackTrace(); }
		   
	   }else { fileName = "user" + ((int)((Math.random()*7)+1)) + ".png"; }

	   dto.setUfile(fileName); 
	   //2. 암호화 ###
	   dto.setPassword(  pwencoder.encode(  dto.getPassword() )  );
	   return dao.insert(dto); 
	}
	 
	@Override public AppUserAuthDto readAuth(String email) 
	{ AppUser dto = new AppUser();    dto.setEmail(email);     return dao.readAuth(dto); }
	@Override public AppUser selectEmail(String email) 
	{ AppUser dto = new AppUser();    dto.setEmail(email);     return dao.select(dto);   }
	
	@Override public int iddouble(String email) { return  dao.iddouble(email); }
	
	@Override public int delete(AppUser dto) { return dao.delete(dto); }
}
