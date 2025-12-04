package com.company.java009_Ex;

class Student001{
	String name; 
	int no, kor, eng, math;
	
	void info()  {int total = kor + eng + math; double avg = total / 3.0;
	 System.out.println("이름: " + name);
     System.out.println("총점 : " + total);
     System.out.printf("평균 : %.2f\n", avg);
	}
	}



public class ClassEx001 {

	public static void main(String[] args) {
	      Student001   s1 = new Student001();
	      s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
	      s1.info();
	}
}
