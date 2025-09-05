package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {		
		public static void main(String[] args) {
			
			Scanner scanner= new Scanner(System.in);
			char result;
			char ch='\u0000';
			
			System.out.println("문자를 입력해주세여");
		    ch = scanner.next().charAt(0);
			
			
			//if		(ch >= 'A' && ch <= 'Z') {result = (char)(ch + 32); System.out.println("소문자로 변환: " + result);}
			if		(ch >= 'A' && ch <= 'Z') {result = (char)(ch + 32); System.out.println(result +"="+ ch +"+"+ 32);}
			//else if (ch >= 'a' && ch <= 'z') {result = (char)(ch - 32); System.out.println("대문자로 변환: " + result);}
			else if (ch >= 'a' && ch <= 'z') {result = (char)(ch - 32); System.out.println(result +"="+ ch +"-"+ 32);}
			else {System.out.println("영문자가 아닙니다.");
			}


	
		}
}
