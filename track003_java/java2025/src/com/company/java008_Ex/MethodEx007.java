package com.company.java008_Ex;

public class MethodEx007 {

	   public static int add(int x, int y) {return x+y;} //1
	   
	   public static int  add(byte x, byte y)   {return x+y;} //2
	   
	   public static int  add(short x, short y) {return x+y;} //3
	   
	   // public static long add(int  x, int y)    {return x+y;} //4
	   
	   public static long add(long  x, long y)  {return x+y;} //5   
	   
	   public static void main(String[] args) {
		   //Q1. 메서드오버로딩? 비슷한 목적의 메서드 이름을 같게 하는것.
		   
		   /*예, 메서드 오버로딩을 시도한 코드입니다. add
		   	-메서드 이름이 같아야 함

 			 -매개변수의 타입, 개수, 또는 순서가 달라야 함
 
			 -리턴 타입만 다른 경우는 오버로딩이 성립하지 않음*/
		   
		   //Q2. 왜 오류? 이유 - 파라미터의 개수와 자료형으로 구분
		   
		   /*1,4번의 파라미터의 자료형이 같음 / 메서드 시그니처(int)가 같기 때문
		   하나를 제거하거나 이름을 바꾸기

		   매개변수 타입을 다르게 지정하기 (예: 하나는 float, 하나는 int 등)
		   */
	   }

}

/*
연습문제7)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx007
오류나는 메서드는?
*/