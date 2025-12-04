package com.company.java008_Ex;

import java.util.Scanner;

public class Repeat1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		char ch;
		for (;;) {
            System.out.println("연산자를 입력해주세요(+,-,*,/)");
            ch = scanner.next().charAt(0);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                System.out.println("당신이 입력한 연산자는 " + ch + " 입니다.");
                break;
            }
            /* ch=' ';
             for (; !(ch == '+' || ch == '-' || ch == '*' || ch == '/';) {) {
            System.out.println("연산자를 입력해주세요(+,-,*,/)");
            ch = scanner.next().charAt(0);
            System.out.println("당신이 입력한 연산자는 " + ch + " 입니다.");
            }*/
        }
        ch = ' ';
        while (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
            System.out.println("연산자를 입력해주세요(+,-,*,/)");
            ch = scanner.next().charAt(0);
        }
        System.out.println("당신이 입력한 연산자는 " + ch + " 입니다.");

        ch=' ';
        do {
            System.out.println("연산자를 입력해주세요(+,-,*,/)");
            ch = scanner.next().charAt(0);
        } while (ch != '+' && ch != '-' && ch != '*' && ch != '/');
        System.out.println("당신이 입력한 연산자는 " + ch + " 입니다.");
        
		/*
		switch(ch) {
		case '+' :  System.out.println("당신이 입력한 연산자는 " + ch +" 입니다.");break;
		case '-' :  System.out.println("당신이 입력한 연산자는 " + ch +" 입니다.");break;
		case '*' :  System.out.println("당신이 입력한 연산자는 " + ch +" 입니다.");break;
		case '/' :  System.out.println("당신이 입력한 연산자는 " + ch +" 입니다.");break;
		}
		*/
		}

	}

