package com.company.java005_ex;

import java.util.Scanner;
public class for_forinfinity {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num;
		
		for(;;) {
			System.out.println("숫자를 입력하세요. < ");
			num = scanner.nextInt();
			
			if (num== 7) { System.out.println("종료합니다!"); break;}
			
		}
		
		
		
	}
}
