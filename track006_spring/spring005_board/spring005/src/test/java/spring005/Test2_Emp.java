package spring005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.EmpDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.EmpDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
public class Test2_Emp {
	@Autowired EmpDao dao;
	
	@Ignore
	public void test1() {
		Map<String, String> para = new HashMap<>();
		para.put("searchType", "ename");
		para.put("keyword", "SMITH");
		System.out.println(dao.test1(para));
	}
	
	@Ignore
	public void test2() {
		EmpDto dto = new EmpDto();
		dto.setEname("SMITH");
		//dto.setJob("CLERK");
		System.out.println( dao.test2(dto) );
	}
	
	@Ignore
	public void test3() {
		EmpDto dto = new EmpDto();
		dto.setEmpno(7369);
		dto.setEname("SMITH");
		dto.setMgr(7902);
		System.out.println( dao.test3(dto) );
	}
	
	@Ignore
	public void test4() {
		EmpDto dto = new EmpDto();
		
		dto.setEname("SMITH");
		dto.setJob("CLERK");
		
		System.out.println( dao.test4(dto) );
	}
	
	@Ignore
	public void test5() {
		EmpDto dto = new EmpDto();
		dto.setEmpno(7369);
		dto.setEname("SMITH");
		dto.setJob("CLERK-new");
		
		System.out.println( dao.test5(dto) );
	}
	
	@Ignore
	public void test6() {
		EmpDto dto = new EmpDto();
		List<Integer> list = new ArrayList<>();
		list.add(7369); 
		list.add(7499);
		list.add(7521);
		
		System.out.println( dao.test6(list) );
	}
	
	@Test
	public void test7() {
		AppUserAuthDto dto = new AppUserAuthDto();
		dto.setEmail("iis1@naver.com");
		System.out.println(dao.readAuth(dto));
	}
}
