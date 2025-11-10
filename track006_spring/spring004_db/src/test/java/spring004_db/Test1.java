package spring004_db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2. 설정
public class Test1 {
	
	@Autowired ApplicationContext context; //3. Bean (스프링이 고나리하는 객체) 생성~소멸
	@Autowired DataSource datasource;
	@Autowired SqlSession sqlSession;
	
	@Ignore // @Test
	public void test1() { System.out.println(context);}
	
	@Ignore // @Test
	public void test2() {System.out.println(datasource);} //datasource (connection)
	
	@Test public void test3() {System.out.println(sqlSession);}  //실제 crud
	
}
