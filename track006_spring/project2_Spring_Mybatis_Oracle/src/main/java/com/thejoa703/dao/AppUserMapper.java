package com.thejoa703.dao;

import com.thejoa703.dto.AppUser;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AuthDto;

@MbtiDao
public interface AppUserMapper {
	public int 			  insert(AppUser dto);
	public AppUserAuthDto readAuth(AppUser dto); //email, password, 권한을 주는
	public AppUser 		  select(AppUser dto);
	public AppUser 		  selectPassword(AppUser dto);
	public int 	update (AppUser dto);
	public int 	delete (AppUser dto);
	public int  insertAuth(AuthDto dto);
	
}

/*
- create (회원가입) 					 : insert into appuser(APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID,UFILE, MOBILE, NICKNAME) values (appuser_seq.nextval ,'1@1','1', 1, '1.png' , '1', 'na');
- read   (로그인, 아이디찾기-해당이메일로, 비밀번호 찾기-해당이메일로) : 
 * 해당 이메일로 email, password, 권한들 가져오기 : 
	 select   u.email, password, auth 
	 from appuser u left join authorities a on  u.email = a.email
	 where u.email = '1@1'
 
 * 해당 이메일로 정보가져오기 :
  select * from appuser where email='1@1'  
 * 해당 이메일로 비밀번호찾기 :
  select password from appuser where email='1@1'
  
- update (정보수정) 해당 id의 유저 업데이트 : 
update appuser  set  MBTI_TYPE_ID=2, UFILE='2.png' , MOBILE='1', NICKNAME='1' where app_user_id=1;

- delete (정보삭제) 해당 id의 유저 삭제    :
 delete from appuser  where app_user_id=1;
 */  