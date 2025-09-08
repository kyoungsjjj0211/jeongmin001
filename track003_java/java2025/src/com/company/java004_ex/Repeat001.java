package com.company.java004_ex;

import java.util.Scanner;

public class Repeat001 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
				
		//변수
		//입력
		System.out.println("정수 하나를 입력해주세요. > ");
		int num = scanner.nextInt();
		
		System.out.println("정수 하나를 입력해주세요. > ");
		int num1 = scanner.nextInt();
		
		System.out.println("연산자를 입력해주세요. >");
		char ch = scanner.next().charAt(0);
		int result = 0;
		
		//double result = 0 ;
		
		
		if 	   (ch == '+') {result = num + num1; System.out.println(num +"+"+ num1 +"="+ result);}
		else if(ch =='-')  {result = num - num1; System.out.println(num +"-"+ num1 +"="+ result);}
		else if(ch == '*') {result = num * num1; System.out.println(num +"*"+ num1 +"="+ result);}
		else if(ch == '/') {double divresult = (double) num/num1; System.out.printf("%d / %d = %.2f\n", num, num1, divresult);}
		else {System.out.println("계산할수없습니다.");}
			}
}




