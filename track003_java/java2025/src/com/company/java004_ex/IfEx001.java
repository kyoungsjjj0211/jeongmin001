package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int avg ;  
		
		System.out.println("평균 점수를 입력하세요");
		avg = scanner.nextInt();
		
		if (avg >= 60 ) {System.out.println("합격");}
		else {	        System.out.println("불합격");

		// #방법 2
		// String result ="불합격"; << 변수
		// if (avg >= 60) {result ="합격";} << 처리
		// System.out.println(result); << 출력
		
		// #방법 3 처리 + 출력
		// system.out.println(avg >= 60 ? "합격" : "불합격");
				
				
			}
		}	
	}

