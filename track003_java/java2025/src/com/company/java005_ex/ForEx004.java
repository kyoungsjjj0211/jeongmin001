package com.company.java005_ex;

public class ForEx004 {
	public static void main(String[] args) {
		 //변수
		//String result="";
		 int count = 0; //1~10까지의 3의 배수의 갯수 카운트 담을 변수
		 //입력+처리 (1) 문제파악
		 //1이3의 배수라면 카운트
		 //2가 3의 배수라면 카운트
		 //3이 3의 배수라면 카운트
		 //입력 +처리(2) 구조
		 //if(1이 3의 배수라면){카운트, 화면에 출력부분} //() ,3 ,6 ,9
		 //if(1이 3의 배수라면){카운트, 화면에 출력부분} //() ,3 ,6 ,9
		 //if(1이 3의 배수라면){카운트, 화면에 출력부분} //() ,3 ,6 ,9
		 
		 
		 //입력+처리
	     for (int i = 1; i <= 10; i++) {if (i % 3 == 0) {count++;}}
	     //출력
	     System.out.println("1~10까지 3의 배수 갯수 : " + count + "개");
	    }
	}
		

