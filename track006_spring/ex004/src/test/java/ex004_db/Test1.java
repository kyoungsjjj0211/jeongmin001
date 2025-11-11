package ex004_db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.MilkDao;
import com.thejoa703.dao.TestDao;
import com.thejoa703.dao.UserInfoDao;

	@RunWith(SpringJUnit4ClassRunner.class) 
	@ContextConfiguration(locations = "classpath:config/root-context.xml")
	
	public class Test1 {
		
		@Autowired ApplicationContext context;
		@Autowired DataSource datasource;
		@Autowired SqlSession sqlsession;
		@Autowired TestDao dao;
		@Autowired UserInfoDao userdao;
		@Autowired MilkDao milkdao;
		
		
		@Test
		public void test6() {
			System.out.println(milkdao.selectAll());}
		
		
		@Ignore //@Test
		public void test5() {
			//5. 삭제
			System.out.println(userdao.delete(2));
			//4. 수정
			//UserInfoDto dto = new UserInfoDto();
			//dto.setEmail("b@b"); dto.setAge(2); dto.setNo(2);
			//System.out.println(userdao.update(dto));
			//3. 한명검색
			//System.out.println(userdao.select(2));
			//2. 삽입
			//UserInfoDto dto = new UserInfoDto();
			//dto.setEmail("a@a"); dto.setAge(1);
			//System.out.println(userdao.insert(dto));
			//1. 전체검색
			System.out.println(userdao.selectAll());}
		
		@Ignore//@Test   
		public void test1() { System.out.println(context);}
		
		@Ignore//@Test
		public void test2() {System.out.println(datasource);}
		
		@Ignore//@Test
		public void test3() {System.out.println(sqlsession);}
		
		@Ignore//@Test
		public void test4() {System.out.println(dao.now());}
		
		
	
}
