package ex004_db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thejoa703.dao.MilkDao;
import com.thejoa703.dto.MilkDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")
public class Test2_milk {
	@Autowired MilkDao dao;
	@Test public void test() {
		System.out.println(dao.delete(1));
		
		
		/*
		 * MilkDto dto = new MilkDto(); dto.setMname("choco"); dto.setMnum(2);
		 * dto.setMtotal(1000); dto.setMno(1); System.out.println(dao.update(dto));
		 */
		
		//System.out.println(dao.select(1));
		
		/*
		 * MilkDto dto = new MilkDto(); dto.setMname("white"); dto.setMnum(2);
		 * dto.setMtotal(2000); System.out.println(dao.insert(dto));
		 */	
		
		System.out.println(dao.selectAll());
	}
}
