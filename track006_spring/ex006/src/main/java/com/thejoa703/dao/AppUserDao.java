package com.thejoa703.dao;

import java.util.List;

import com.thejoa703.dto.AppUserDto;

@MbtiDao
public interface AppUserDao {
	public int insert(AppUserDto dto);
	public int update(AppUserDto dto);
	public int delete(AppUserDto dto);
	public List<AppUserDto> selectAll();
	public AppUserDto       select(int appUserId);
	public AppUserDto       selectEmail(String email);
	public int selectLogin(AppUserDto dto);	
	/*upload*/
	public int insert2(AppUserDto dto);
	public int update2(AppUserDto dto);
	
	/*iddouble*/
	public int iddouble(String email);
	
	
	/*admin 유저관리 - 전체유저정보 selectAll / 이메일주면 해당 유저정보찾기 / 수정하기 updateAdmin / 삭제하기 deleteAdmin */
	public int deleteAdmin(AppUserDto dto);
	public int updateAdmin(AppUserDto dto);
}


/*

# insert
 	insert into appuser(APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID, CREATED_AT)
 	values (appuser_seq.nextval ,#{EMAIL},#{PASSWORD},#{MBTI_TYPE_ID},#{CREATED_AT});

# selectAll
 	select * from appuser order by APP_USER_ID desc; //전부 조회

# select
	select * from appuser where app_user_id=#{app_user_id}; //선택 조회

# update
 	update appuser
	set PASSWORD=#{PASSWORD}, MBTI_TYPE_ID=#{MBTI_TYPE_ID}  
	where email=#{email} and PASSWORD=#{PASSWORD};
	
# delete	
	delete from appuser
	where APP_USER_ID=#{app_user_id} and PASSWORD=#{PASSWORD};
*/