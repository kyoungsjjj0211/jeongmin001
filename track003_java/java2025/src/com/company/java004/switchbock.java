package com.company.java004;

import java.util.Scanner;

public class switchbock {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("숫자를 입력해주세요 : ");
		int a = scanner.nextInt();
		
		switch (a) {
		case 1 : System.out.println("mango"); break;
		case 2 : System.out.println("noodle"); break;
		case 3: System.out.println("orange"); break;
		default : System.out.println("1,2,3이 아닙니다.");
		}
	}
}
