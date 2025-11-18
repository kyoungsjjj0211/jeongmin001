package com.thejoa703.test;

import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")
public class Test1_Board {
@Autowired ApplicationContext context;
@Autowired DataSource ds;
@Autowired SqlSession session;
@Autowired AppUserDao dao;
@Autowired AppUserService service;

@Ignore @Test public void test1() {System.out.println(context);}
@Ignore @Test public void test2() {System.out.println(ds);}
@Ignore @Test public void test3() {System.out.println(session);}

@Test public void test5(){
	//delete
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1"); dto.setAppUserId(45);
//	System.out.println("6. " + service.delete(dto));
	//update
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1"); dto.setMbtiTypeId(2); dto.setAppUserId(45);
//	System.out.println("5. " + service.update(dto));
	//login
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("c@c"); dto.setPassword("1111");
//	System.out.println("4. " + service.selectLogin(dto));
	//select
//	System.out.println("3. " + dao.select(45));
	//insert
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("a@a"); dto.setPassword("1111"); dto.setMbtiTypeId(1);
//	System.out.println("2. " + service.insert(dto));
	//selectAll
//	System.out.println("1. " + service.selectAll());
}

@Ignore @Test public void test4(){
	
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1"); dto.setAppUserId(44);
//	System.out.println("6. " + dao.delete(dto));
	

	//update
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1"); dto.setMbtiTypeId(2); dto.setAppUserId(44);
//	System.out.println("5. " + dao.update(dto));

	//login
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("a@a"); dto.setPassword("1111");
//	System.out.println("4. " + dao.selectLogin(dto));

	//select
//	System.out.println("3. " + dao.select(44));
	
	//insert
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("b@b"); dto.setPassword("1111"); dto.setMbtiTypeId(1);
//	insert into appuser (APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID)
//	values (appuser_seq.nextval, 'a@a', '1111',1);
//	System.out.println("2. " + dao.insert(dto));
	
	//selectAll
	System.out.println("1. " + dao.selectAll());

}

}
