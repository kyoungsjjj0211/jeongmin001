package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx002 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner (System.in);
		
		int a =0;
		System.out.println("숫자를 입력해주세요.");
		a=scanner.nextInt();
		
		
		System.out.println();
		 switch(a) {
		 case 3: case 4: case 5: System.out.println("봄이다"); /*a==3,4,5*/break;
		 case 6: case 7: case 8: System.out.println("여름이다"); /*a==6,7,8*/break;
		 case 9: case 10: case 11: System.out.println("가을이다"); /*a==9,10,11*/break;
		 case 12: case 1: case 2: System.out.println("겨울이다"); /*a==12,1,2*/break;
		 }
		
		
	}
}
