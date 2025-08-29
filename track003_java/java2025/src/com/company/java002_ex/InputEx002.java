package com.company.java002_ex;

import java.util.Scanner;

public class InputEx002 {
		public static void main(String[] args) {
			
			int num = 0;
			Scanner scanner = new Scanner (System.in);
			System.out.println("좋아하는 수(정수) 입력하시오 >_");
			num = scanner.nextInt();
			System.out.println("좋아하는 숫자는 " + num +" 입니다.");
			
		}

}
