package com.company.java005_ex;

public class ForEx001 {
	public static void main(String[] args) {
	//q1
		System.out.println("\n\nq1");
		  for (int i = 1; i <= 5; i++) {System.out.print(i + "\t");}
	        
	//q2
		  System.out.println("\n\nq2");
	      for (int i = 5; i >= 1; i--) {System.out.print(i + "\t");}
	//q3
	      System.out.println("\n\nq3");
	      for (int i = 1; i <=3; i++) {System.out.print("JAVA" + i + "\t");}
	//q4  
	      System.out.println("\n\nq4");
	      for (int i = 3; i >=1; i--) {System.out.println("HAPPY" + i + "\t");}
	//q5  
	      System.out.println("\n\nq5");
	      System.out.print("" + 0 + "\t");
	      System.out.print(","+ 1 + "\t");
	      System.out.print(","+ 2 + "\t"); //## {} {변수} for(시작; 종료; 변화){}
	      
	      System.out.println("\n\nq5-2");
	      for (int i= 0; i <=2; i++ ) {System.out.println((i==0? "": "") + i);}
	//q6    
	      System.out.println("\n\nq6");
	      for (int i=0; i <=99; i++ ) {System.out.println((i==0? "": "") + i);}
	      
	 //q7     
	      System.out.println("\n\nq7");
	      for (int i=10; i>=0; i--) {System.out.println((i==10? "": "") + i);}
	      
	//q8      
	      System.out.println("\n\nq8");
	      for (int i=0; i<=8; i+= 2) {System.out.println((i==0? "": "") + i);}
	//q9      
	      System.out.println("\n\nq9");
	      for (int i=0; i<=18; i+= 2) {System.out.println((i==0? "": "") + i );}
	}
}

