package com.company.java008_Ex;

import java.util.Scanner;

public class Test001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch=' ';
		
		System.out.println("\n\n1. for(1)");
		for(;;) {  // 시작; 종료; 변화  - 몇번째까지~!
			System.out.print("+,-,*,/를 입력해주세요.");
			ch = scanner.next().charAt(0);
			if(ch=='+' || ch=='-' || ch=='*'|| ch=='/'){break;}  //잘썼으면 나와!
		}
		System.out.println(ch);
		
		System.out.println("\n\n1. for(2)");
		ch=' ';
		for(; !( ch=='+' || ch=='-' || ch=='*'|| ch=='/' ) ;) {  // 시작; 조건; 변화  - 몇번째까지~!
			System.out.print("+,-,*,/를 입력해주세요.");
			ch = scanner.next().charAt(0); 
		}
		System.out.println(ch);
		
		
		System.out.println("\n\n2. while");
		ch=' ';
		for(; !( ch=='+' || ch=='-' || ch=='*'|| ch=='/' ) ;) {  // 시작; 조건; 변화  - 몇번째까지~!
			System.out.print("+,-,*,/를 입력해주세요.");
			ch = scanner.next().charAt(0); 
		}
		System.out.println(ch);
		
		
		
	}
}

/*
	for/while/dowhile
		+,-,*,/ 입력받을때까지 무한반복

*/