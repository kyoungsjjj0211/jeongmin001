package com.company.ioctest1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.company.ioctest.AnimalFarm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/test1.xml")

public class Test1 {
	@Autowired ApplicationContext context;
	
	@Test public void test() {
		AnimalFarm farm = (AnimalFarm) context.getBean("animalFarm");
		farm.print();
	}
}
