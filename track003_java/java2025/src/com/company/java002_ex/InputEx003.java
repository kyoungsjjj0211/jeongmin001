package com.company.java002_ex;

import java.util.Scanner;

public class InputEx003 {
	public static void main(String[] args) {
		//변수
		
		int year=0;
		Scanner scanner = new Scanner(System.in);
		
		//입력
		System.out.println("태어난 년도를 입력하세요>");
		year=scanner.nextInt();
		
		//처리
		year = 2025 - year ; // 나이 : 2025(현재년도)-2001(입력값)
		//출력
		System.out.println("당신의 나이는 " + year + "살 입니다.");
		
	
	}

}
