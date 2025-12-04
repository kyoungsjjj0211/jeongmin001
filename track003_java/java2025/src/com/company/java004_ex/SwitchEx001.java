package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx001 {
		public static void main(String[] args) {
			
			int a=0;
			Scanner scanner=new Scanner (System.in);
			
			System.out.println("숫자를 입력하세요");
			a=scanner.nextInt();
			
			
			System.out.println();
			 switch(a) {
			 case 3: System.out.println("봄이다"); /*a==3*/break;
			 case 6: System.out.println("여름이다"); /*a==6*/break;
			 case 9: System.out.println("가을이다"); /*a==9*/break;
			 case 12: System.out.println("겨울이다"); /*a==12*/break;
			 }
			
			
		}
}
