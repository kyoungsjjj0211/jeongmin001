package spring005;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.Sboard1Dao;
import com.thejoa703.dto.Sboard1Dto;
import com.thejoa703.service.Sboard1Service;
import com.thejoa703.service.Sboard1ServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
public class test {
	@Autowired ApplicationContext context;
    @Autowired DataSource datasource;
    @Autowired SqlSession sqlSession;
    @Autowired Sboard1Dao dao;
    @Autowired Sboard1Service service;
    
    @Ignore
    public void test1() {System.out.println(context);}
    @Ignore
    public void test2() {System.out.println(datasource);}
    @Ignore
    public void test3() {System.out.println(sqlSession);}
    @Ignore
    public void test4() {System.out.println(dao.selectAll());}
    @Ignore
    public void test5() {
    	Sboard1Dto dto = new Sboard1Dto();
    	dto.setAppUserId(1001);
    	dto.setBtitle("게시글1"); dto.setBcontent("내용1");
    	dto.setBpass("123");
    	dto.setBip("192.168.0.1");
    	
    	System.out.println(dto);
    	System.out.println(dao.insert(dto));
   }
   @Ignore
   public void test6() {
	   System.out.println(dao.select(4));
   }
   @Ignore
   public void test7() {
	   Sboard1Dto dto = new Sboard1Dto();
	   dto.setBtitle("게시글3"); dto.setBcontent("내용3");
	   dto.setId(2); dto.setBpass("123");
	   System.out.println(dao.update(dto));
	   
   }
   @Ignore
   public void test8() {
	   Sboard1Dto dto = new Sboard1Dto();
	   dto.setId(6); dto.setBpass("123");
	   System.out.println(dao.delete(dto));
   }
   @Ignore
   public void test9() throws UnknownHostException{
	   Sboard1Dto dto = new Sboard1Dto();
	   dto.setAppUserId(1001);
   		dto.setBtitle("게시글25"); dto.setBcontent("내용25");
   		dto.setBpass("123");
	   System.out.println(service.insert(dto));
   }
   @Ignore
   public void test10() {
	   
	   int updated = dao.updateHit(24);
	    System.out.println("update count = " + updated);

	   System.out.println(service.select(24));
	   
	   
   }
   
   @Test
   public void test11() {
	   HashMap<String, String> para = new HashMap<>();
	   para.put("search", "%글%");
	   
	   System.out.println(dao.selectSearch(para));
   }
   
}
