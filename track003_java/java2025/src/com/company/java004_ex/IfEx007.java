package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("계산기");
		
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
		else if(ch == '/') {double divResult = (double) num/num1; System.out.printf("%d / %d = %.2f\n", num, num1, divResult);}
		else {System.out.println("계산할수없습니다.");}
			}
}


// ver -2
/* 
public class IfEx007{
public static void main)String[] args){
//변수
int num1, num2, String result ="";
char op;

//입력
Scanner scanner = new Scanner(System.in);
System.out.print("정수 하나를 입력해주세요. > ");
num1 = scanner.nextInt();
System.out.print("정수 하나를 입력해주세요. > ");
num2 = scanner.nextInt();
System.out.print("정수 하나를 입력해주세요. > ");
op = scanner.next().charAt(0);

//처리 출력 숫자 연산자 숫자 =
result = ""= num1 + op + num2 +"="; //
	if(op == '+') {result += (num1+num2);}
else if(op == '-') {result += (num1-num2);}
else if(op == '*') {result += (num1*num2);}
else if(op == '/') {result += String.format("%.2f", (double)num1/num2);}

//출력
System.out.println(result);
	}
}
 */

		