package ex006;

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
public class Test1_ex006 {
@Autowired ApplicationContext context;
@Autowired DataSource datasource;
@Autowired SqlSession session;
@Autowired AppUserDao dao;
@Autowired AppUserService service;

@Ignore @Test public void test1() {System.out.println(context);}
@Ignore @Test public void test2() {System.out.println(datasource);}
@Ignore @Test public void test3() {System.out.println(session);}

@Test public void test5() throws UnknownHostException{
	//delete
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1111"); dto.setAppUserId(1);
//	System.out.println(service.delete(dto));
	//update
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("a@a"); dto.setPassword("1111"); dto.setMbtiTypeId(3);
//	System.out.println(service.update(dto));
	//select
//	System.out.println(service.select(23));
	//insert
//	AppUserDto dto = new AppUserDto();
//	dto.setAppUserId(23); dto.setEmail("a@a"); dto.setPassword("1111"); dto.setMbtiTypeId(3);
//	System.out.println(service.insert(dto));
	//selectAll
	System.out.println(service.selectAll());
}

@Ignore @Test public void test4() throws UnknownHostException{
	
	

	//delete
//	AppUserDto dto = new AppUserDto();
//	dto.setPassword("1111"); dto.setAppUserId(23);
//	System.out.println(dao.delete(dto));

	//update
//	AppUserDto dto = new AppUserDto();
//	dto.setEmail("a@a"); dto.setPassword("1111"); dto.setMbtiTypeId(3);
//	System.out.println(dao.update(dto));

	//select
//	System.out.println(dao.select(23));
	
	//insert
//	AppUserDto dto = new AppUserDto();
//	dto.setAppUserId(23); dto.setEmail("a@a"); dto.setPassword("1111"); dto.setMbtiTypeId(3);
//	System.out.println(dao.insert(dto));
	
	//selectAll
	System.out.println(dao.selectAll());

}

}
