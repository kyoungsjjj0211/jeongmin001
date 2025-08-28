package com.company.java002; //폴더 (저장 위치)

public class Print001 {// 어디서든지 부품객체  이름 : Print001
	public static void main(String [] args) {
		//1. System.out.println()
		System.out.println("1. 줄바꿈");
		
		//2. System.out.print()
		System.out.print("2.줄바꿈안됨.");
		System.out.print("줄바꿈 특수문자 \n 이용 \n" );
		
		
		//3. System.out.printf() %s "abc" %d 1 %f 1.23
		System.out.printf("3. 정수 %d, 실수 %f 문자열 %s" , 1, 1.2 , "abc"); 
		
		//4. +의 의미
		System.out.println(10+3);
		System.out.println(10+3 + "+" + 1+2);
		//아래의 결과는? 숫자 + 숫자 = 문자열		
		//                  13 + "+" +  1 (출력) + 2(출력)
		//                  13    +     12
		System.out.println(10+3 + "+" + (1+2)); //13+3
		//                   13   +    (1+2)먼저
		// Q. System.out.println( 1+2=3);
		// 1+2=3로 출력해주세요!
		System.out.println( "1+2=3" ); //이부분을
		System.out.println( 1+"+"+2+"="+3 ); 
		System.out.printf( "%d+%d=%d",1,2,1+2 );
		System.out.println((10+3) + (1+2));	

	}
} // ctrl + f11

