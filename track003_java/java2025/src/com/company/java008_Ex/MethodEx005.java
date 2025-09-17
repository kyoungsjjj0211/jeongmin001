package com.company.java008_Ex;

import java.util.Scanner;

public class MethodEx005 {
	public static void main(String[] agrs) {
		
		  String name  = ""; 
	      int kor, eng, math, total ;
	      float avg = 0.0f; 
	      String pass = "", jang = "", star = "";
	      
	      Scanner scanner = new Scanner(System.in);
	      
	      System.out.println("이름입력 : ");
	      name = scanner.nextLine();
	      System.out.println("국어 점수 입력 : ");
	      kor = scanner.nextInt();
	      System.out.println("영어 점수 입력 : ");
	      eng = scanner.nextInt();
	      System.out.println("수학 점수 입력 : ");
	      math = scanner.nextInt();
	     
	      total = process_total (kor, eng, math);
	      avg = process_avg (total);
	      pass = process_pass (avg, kor, eng, math);
	      jang = process_scholar(avg);
	      star=process_star (avg);
	      
	      process_show (name, kor, eng, math, total, avg, pass, jang, star);
	}
    
    public static int process_total(int kor, int eng, int math) {
  	  return kor + eng + math;
    	}
    public static float process_avg(int total) {
  	  return total /3.0f;
  	  }
    public static String process_pass(float avg, int kor, int eng, int math) {
  	  if (avg >= 60 && kor >= 40 && eng>= 40 && math>=40) {
  		  return "합격";
  	  }else if (kor < 40 || eng < 40 || math < 40) {
  		  return "재시험";
  	  }else {
  		  return"불합격";
  	  }
    }
  
    public static String process_scholar(float avg) {
  	  return avg >= 95 ? "장학생" : "비장학생" ;
    }
  public static String process_star(float avg) {
	  //String result="";
	  // for(int i=0; i<(int)(avg/10); i++) { result += "★";}
  	       int stars = (int) avg / 10;
  	       String result = "";
  	       for (int i = 0; i < stars; i++) {
  	    	   result += "★";
  	        }
  	       return result;
  	  
    }		
	      public static void process_show(String name, int kor, int eng, int math, int total,float avg,String pass,String jang,String star) {
	    	  	System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \r\n");
	    	  	System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n","name",      "kor",   "eng",   "math",   "total",  "avg",   "pass",   "jang",    "star");
	    	  	System.out.println("--------------------------------------------------------------------------------------------");
	    	  	System.out.printf("%-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%.2f\t%-5s\t%-5s\t%-5s\n", name, kor, eng, math, total, avg, pass, jang, star);
	    	  	System.out.println("--------------------------------------------------------------------------------------------");
	      }

	}

/*연습문제5)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx005

public class MethodEx005{ 
   public static void main(String[] args) {
   /////////////////////(1)  변수
      String name  = ""; 
      int kor, eng, math, total ;
      float avg = 0.0f; 
      String pass = "";
      String jang = "";
      String star= "";  
      Scanner scanner = new Scanner(System.in);
      
      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
   
      /////////////////////(3) 처리 : 
      total = process_total(kor , eng, math);    // 1. 총점처리
      
      avg = process_avg(total);    //2.  평균처리
      
      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
      pass = process_pass(avg , kor, eng, math);  
      
      //////// 4. 평균이 95점이상이면 장학생
      jang = process_scholar(  avg  ); 
      
      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
      star = process_star(avg);  
      
      
      /////////////////////(4) 출력
      process_show(name, kor, eng, math, total, avg, pass, jang, star);
    
      
   }// end main
 
   
}// end class

 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
--------------------------------------------------------------------------------------------
아이언맨   100   100   100   300    100.0    합격      장학생   **********
--------------------------------------------------------------------------------------------
*/