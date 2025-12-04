package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		//변수
		int a,b ;
		double c ;
		
		
		Scanner scanner = new Scanner (System.in);
		//입력
		System.out.println("숫자입력 1>");
		a = scanner.nextInt();
		System.out.println("숫자입력 2>");
		b = scanner.nextInt();
		//처리
		c = a  / (double) b ;
		// c = a  / b ; // 정수/정수 = 정수 
		// c = a / (double)b; // 정수/실수 =실수
		// c = (double)a / (double) b ; // 실수/실수 = 실수
		// c = (double) a / b ; // 실수/실수 = 실수
		
		//출력
		//System.out.println("10/3 = " + c + "입니다.");
		System.out.printf("%d/%d = %.2f\n", a, b, c);

	}

}
// 1단계
// 변수 - 입력- 처리 - 출력
// 2단계  
// 정수/정수 = 정수
// 정수/실수 = 실수
// 실수/정수 = 실수
// 실수/실수 = 실수  