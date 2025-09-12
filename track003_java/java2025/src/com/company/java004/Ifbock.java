package com.company.java004;

import java.util.Scanner;

public class Ifbock {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("문자를 입력하세요 (m, n, o) : ");
		char ch =scanner.next().charAt(0);
		
		if(ch=='m') {
			System.out.println("mango");
		}	else if (ch=='n') {
			System.out.println("noodle");
		}else if (ch=='o') {
			System.out.println("orange");
		} else {System.out.println("m,n,o가 아닙니다.");
		}
	}
}
