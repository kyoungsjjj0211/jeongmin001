package com.thejoa703.external;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class ApiScheduledTask {

//@Scheduled(fixedRate =2000) // 2chakek 1000이 1초
//	public void runTask1() { 
//	System.out.println(".......스케줄러 실행중 : "+ System.currentTimeMillis());  
//}

@Scheduled(cron="0 42 12 * * ?") // 0초 37분 12시 날짜 월 요일 (?특정하지않음) 
	public void runTask2(){
	  System.out.println(".......스케줄러 실행중 : "+ System.currentTimeMillis()); 
	}
}
/**************************
 * 1. 스케줄링구동	
	  @Scheduled(fixedRate =2000) // 2chakek 1000이 1초
	  public void runTask1() { 
	  System.out.println(".......스케줄러 실행중 : "+ System.currentTimeMillis());  
	  }
	  
	// @Scheduled(fixedRate =) 어떤작업이 끝난후에 지정된 시간에 시행
	 * 
	  @Component
	  public class ApiScheduledTask {
	  @Scheduled(fixedRate =2000){} 2초마다 실행
	  @Scheduled(fixedDelay =) 어떤작업이 끝난후에 지정된 시간에 시행
	  @Scheduled(cron="0 42 12 * * ?") // 0초 37분 12시 날짜 월 요일 (?특정하지않음) 
	  public void runTask2(){
		  System.out.println(".......스케줄러 실행중 : "+ System.currentTimeMillis()); 
	  }
	  cron="0 0 0 * * ?" // 0초 0분 0시 일 월 요일 -매일자정
	  cron="0 0 12 * * ?" // 0초 0분 12시 일 월 요일 -매일정오
	  cron="0 30 18 * * ? "//매일 오휴 6시 30분
	  cron="0 0 0 1 * ?" //매월 1일 자정
	  cron="0 0 0 ? * MON" //매주 월요일 자정
	  
	  *제한없는 모든값
	  ?특정값 없음
	  SUN 일, MON 월, TUE 화, WED 수, THU 목, FRI 금, SAT 토
	  
	  *******************/


