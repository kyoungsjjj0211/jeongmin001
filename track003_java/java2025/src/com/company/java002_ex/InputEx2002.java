package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2002 {
	public static void main(String[] args) {
		// 변수
		int 국어, 영어, 수학, 총점;
	    double 평균;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.println("국어점수를 입력하시오 >");
		국어=scanner.nextInt();
		
		System.out.println("영어점수를 입력하시오 >");
		영어=scanner.nextInt();
		
		System.out.println("수학점수를 입력하시오 >");
		수학=scanner.nextInt();
		
		//처리
		총점 = 국어 + 영어 + 수학 ;
		평균 = 총점 / 3.0 ;
		//출력
		System.out.printf("당신의 총점은 %d 입니다.\n", 총점 );
		System.out.printf("당신의 평균은 %.1f 입니다.\n", 평균 );
	}

}
