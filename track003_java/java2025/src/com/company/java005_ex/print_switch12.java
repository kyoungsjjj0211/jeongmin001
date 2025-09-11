package com.company.java005_ex;

import java.util.Scanner;
public class print_switch12 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner (System.in);
		char ch;
		
		System.out.println("문자를 입력하세요 (x, y, z) : ");
		ch= scanner.next().charAt(0);
		
		if (ch== 'x') {
			System.out.println("x-ray");
		}else if (ch == 'y') {
			System.out.println("yogurt");
		}else if (ch == 'z') {
			System.out.println("zebra");}
		else { System.out.println("x, y, z가 아닙니다");
	
		/*
		- ver-2
		switch (ch){
		case 'x' : System.out.println("x-ray"); break;
		case 'y' : System.out.println("yogurt"); break;
		case 'z' : System.out.println("zebra"); break;
		default : System.out.println("x, y, z가 아닙니다");
		}
		*/
		
		}
		
	}
}
