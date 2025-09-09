package com.company.java003_ex;

import java.util.Scanner;

public class Repeat012_1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int num ;
		
		System.out.println("숫자를 입력해주세요");
		num = scanner.nextInt();
		
		if (num==1) {System.out.println("one");}
		else if(num==2) {System.out.println("two");}
		else if (num==3) {System.out.println("three");}
		else {System.out.println("1,2,3 이아닙니다.");}
		}
		
}
	

