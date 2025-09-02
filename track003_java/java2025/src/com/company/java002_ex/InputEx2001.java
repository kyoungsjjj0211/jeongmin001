package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2001 {
	public static void main(String[] args) {
		//변수
		double pi = 0.0;
		Scanner scanner = new Scanner(System.in) ;
		//입력 - 파이값을 입력하시오 > _입력받기
		System.out.print("파이값을 입력하시오 >");
		pi = scanner.nextDouble();
		//처리
		//출력 - 파이값은 **입니다.
		System.out.print("파이값은" + pi + "입니다.");
			
	}
	

}
