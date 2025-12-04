package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char ch='\u0000';
		
		System.out.println("문자를 입력해주세요.");
		ch = scanner.next().charAt(0); //"abc 문자를 입력받는 "
		    // 대문자의 범위
		if (ch >= 'A' && ch<='Z') { System.out.println("대문자입니다");}
	    	// 소문자의 범위 유니코드 a~z 또는 97~122로 입력하여도 된다.	
		else if (ch>=97 && ch<='z') {System.out.println("소문자입니다");}
		else {                        System.out.println("문자가 아닙니다"); //영문, 소문자, 대문자가 아닙니다.
		}

		}
	}

