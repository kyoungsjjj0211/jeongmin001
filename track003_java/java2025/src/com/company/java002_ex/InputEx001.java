package com.company.java002_ex;

import java.util.Scanner;

public class InputEx001 {
		public static void main(String[] args) {
			
			int age = 0;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("당신의 나이를 입력하시오 >");
			age = scanner.nextInt();
			System.out.println("내 나이는 " + age + "살 입니다.");
		}

		
}
