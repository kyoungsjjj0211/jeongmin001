package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx003 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("정수 하나를 입력해주세요. > ");
		int num = scanner.nextInt();
		
		System.out.println("정수 하나를 입력해주세요. > ");
		int num1 = scanner.nextInt();
		
		System.out.println("연산자를 입력해주세요. >");
		char ch = scanner.next().charAt(0);
		int result = 0;
		
		switch (ch) {
		case '+' : {result = num + num1; System.out.println(num +"+"+ num1 +"="+ result);} break;
		case '-' : {result = num - num1; System.out.println(num +"-"+ num1 +"="+ result);} break;
		case '*' : {result = num * num1; System.out.println(num +"*"+ num1 +"="+ result);} break;
		case '/' : {double divresult = (double) num/num1; System.out.printf("%d / %d = %.2f\n", num, num1, divresult);} break;
			}
		// ver-2
		// case '+' : {System.out.printf("%d %c %d = %d", num, ch, num1, num+num1);break;
		// case '-' : {System.out.printf("%d %c %d = %d", num, ch, num1, num-num1);break;
		// case '*' : {System.out.printf("%d %c %d = %d", num, ch, num1, num*num1);break;
		// case '/' : {System.out.printf("%d %c %d = %d", num, ch, num1, (double)num/num1);break;
		
		}
		
		}	
	

