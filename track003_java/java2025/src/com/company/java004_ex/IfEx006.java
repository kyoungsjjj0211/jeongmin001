package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
		public static void main(String[] arge){
		Scanner scanner=new Scanner(System.in);
		
		int num;
		
		System.out.println("숫자를 입력하세요.");
		num = scanner.nextInt();
		
		if (num % 2 == 0) {System.out.println("여자");}
		else {			   System.out.println("남자");}
		
		//ver-2
		//result =num%2 == 0? "여자" : "남자";
		
		}
}
