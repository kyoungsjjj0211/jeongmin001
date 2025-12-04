package spring005_board;

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


@RunWith(SpringJUnit4ClassRunner.class)  //1. 스프링구동
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2. 설정
public class Test2_Emp {
	@Autowired EmpDao dao;
	
	@Ignore @Test public void test1() {
		Map<String, String> para = new HashMap<>();
		para.put("searchType", "ename");
		para.put("keyword", "SMITH");
		System.out.println(dao.test1(para));
	}
	
	@Ignore @Test public void test2() {
		EmpDto dto = new EmpDto();
		dto.setEname("SMITH");
		dto.setJob("CLERK");
		System.out.println(dao.test2(dto));
	}
	
//select *from emp where empno=7369 and mgr=7902
//select *from emp where empno=7369 and ename='SMITH' and mgr=7902
//select *from emp where empno=7369 and ename='SMITH' and job='CLERK'
//select *from emp where empno=7369 and ename='SMITH' and job='CLERK' and mgr=7902	
	@Ignore @Test public void test3() {
		EmpDto dto = new EmpDto();
		dto.setEmpno(7369);
		dto.setEname("SMITH");
		dto.setJob("CLERK");
		dto.setMgr(7902);
		System.out.println(dao.test3(dto));
	}
	
	@Ignore @Test public void test4() {
		EmpDto dto = new EmpDto();
		dto.setEname("SMITH");
		dto.setJob("CLERK");
		System.out.println(dao.test4(dto));
	}
	@Ignore @Test public void test5() {
		EmpDto dto = new EmpDto();
//		dto.setEname("SMITH-new"); dto.setJob("CLERK-new"); dto.setEmpno(7369);
//		dto.setEname("SMITH");
		dto.setJob("CLERK");
		dto.setEmpno(7369);
		System.out.println(dao.test5(dto));
	}
	@Ignore @Test public void test6() {
		List<Integer> list = new ArrayList<>();
		list.add(7369); list.add(7499); list.add(7521);
		System.out.println(dao.test6(list));
	}
	@Test public void test7() {
		AppUserAuthDto dto= new AppUserAuthDto();
		dto.setEmail("1@1");
		System.out.println(dao.readAuth(dto));
	}
}
