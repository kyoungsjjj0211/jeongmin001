package com.company.java003_ex;

import java.util.Scanner;

public class Repeat012_2 {
	public static void main(String[] args) {
		//변수
		Scanner scanner=new Scanner(System.in);
		
		int num =0;
		//처리+입력
		System.out.println("숫자를 입력해주세요.");
		num = scanner.nextInt();
		//출력
		switch (num) {
		case 1: System.out.println("one");break;
		case 2: System.out.println("two");break;
		case 3: System.out.println("three");break;
		default: System.out.println("1,2,3이 아닙니다.");
		}
	}

}
