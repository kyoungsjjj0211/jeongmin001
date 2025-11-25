package  spring005_board;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;
import com.thejoa703.service.AppUserService;
 

@RunWith(SpringJUnit4ClassRunner.class)  //1. 스프링구동
@ContextConfiguration(locations = {"classpath:config/root-context.xml", "classpath:config/security-context.xml"}) //2. 설정
public class Test3_Member {
	@Autowired  ApplicationContext context; //3. ioc - Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired  DataSource   ds;
	@Autowired  SqlSession   session; 
	@Autowired  AppUserDao   dao;
	@Autowired  AppUserService  service; 
	@Autowired 	@Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	@Test  public void test8() {
//		//4. 유저읽어오기
		AppUserAuthDto rdto = new AppUserAuthDto(); 
		rdto.setEmail("1@1");
		System.out.println(dao.readAuth(rdto));
		//3. 권한멤버 1@1 ROLE_ADMIN , ROLE_MEMBER / 2@2 ROLE_MEMBER /3@3 ROLE_MEMBER
//		AuthDto adto = new AuthDto();
//		//adto.setEmail("1@1"); adto.setAuth("ROLE_ADMIN");
//		adto.setEmail("3@3"); adto.setAuth("ROLE_MEMBER");
//		System.out.println(dao.insertAuth(adto));
		//2. 회원가입 1@1 1/  2@2 2  / 3@3 3 (암호화 log에서도 암호화 됨)
//		AppUserDto dto = new AppUserDto();
//		dto.setEmail("1@1");  dto.setPassword( pwencoder.encode("1"));  dto.setMbtiTypeId(1);
//		System.out.println("2. " + dao.insert(dto));   
    	//1. 전체
//		System.out.println(dao.selectAll());
}
	
	@Ignore @Test  public void test7() {
		//4. 삭제
		AppUserDto dto = new AppUserDto();   dto.setAppUserId(67);
		System.out.println(dao.deleteAdmin(dto));
		//3. 해당값유저확인
		System.out.println(dao.select(67));
		//2. 수정
		//    	AppUserDto dto = new AppUserDto();
		//    	dto.setMbtiTypeId(3);      dto.setAppUserId(67);
		//    	System.out.println(dao.updateAdmin(dto));   
    	//1. 전체
		System.out.println(dao.selectAll());
		//(appUserId=67, email=d@d, password=1, mbtiTypeId=1, createdAt=2025-11-20 14:30:51, ufile=user7.png
	}
	
	@Ignore @Test  public void test6() {
		System.out.println(dao.iddouble("1@1"));   //1
		System.out.println(dao.iddouble("9@9"));   //0
	}
	
	@Ignore @Test  public void test5() { 
    	//.....................
    	AppUserDto dto = new AppUserDto();
    	dto.setPassword("1");     dto.setAppUserId(45);
    	System.out.println("6. " + service.delete(dto));    	
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setPassword("1");    dto.setMbtiTypeId(2);  dto.setAppUserId(45);
//    	System.out.println("5. " + service.update(dto));
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setEmail("c@c");  dto.setPassword("1111");
//    	System.out.println("4. " + service.selectLogin(dto));
    	//.....................
//    	System.out.println("3. " + dao.select(45)); 
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setEmail("c@c");  dto.setPassword("1111");  dto.setMbtiTypeId(1);
//    	System.out.println("2. " + service.insert(dto)); 
    	//.....................
//    	System.out.println("1. " + service.selectAll());
    }	
	 
	
	@Ignore @Test public void test1() { System.out.println(context); }
	@Ignore @Test public void test2() { System.out.println(ds);      }
	@Ignore @Test public void test3() { System.out.println(session);      }
	 
	@Ignore @Test  public void test4() { 
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setPassword("1");     dto.setAppUserId(44);
//    	System.out.println("6. " + dao.delete(dto));    	
    	
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setPassword("1");    dto.setMbtiTypeId(2);  dto.setAppUserId(44);
//    	System.out.println("5. " + dao.update(dto));
    	
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setEmail("b@b");  dto.setPassword("1111"); 
//    	System.out.println("4. " + dao.selectLogin(dto));
    	//.....................
    	
//    	System.out.println("3. " + dao.select(47)); 

	    	System.out.println("3. " + dao.selectEmail("d@d")); 
    	//.....................
//    	AppUserDto dto = new AppUserDto();
//    	dto.setEmail("b@b");  dto.setPassword("1111");  dto.setMbtiTypeId(1);
//    	insert into appuser (APP_USER_ID , EMAIL, PASSWORD, MBTI_TYPE_ID)  
//    	values (appuser_seq.nextval, 'a@a' , '1111',1); 
//    	System.out.println("2. " + dao.insert(dto)); 
    	//.....................
//    	System.out.println("1. " + dao.selectAll());
    }	
}









