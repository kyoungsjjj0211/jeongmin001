package com.company.java005_ex;

import java.util.Scanner;

public class ForEx002 {
	public static void main(String[] args) {
		//변수
		int dan=0;
		Scanner scanner=new Scanner(System.in);
		//입력
		System.out.print("단을 입력해주세요 : ");
		dan = scanner.nextInt();
		//처리+출력 (1)
		//2*1=2
		//2*2=4
		//2*3=6
		//System.out.println(2+"*" +1+"=" +2*1);
		//System.out.println(2+"*" +2+"=" +2*2);
		//System.out.println(2+"*" +3+"=" +2*3);
		
		for (int i = 1; i<=9; i++ ) { System.out.printf("%d x %d = %d%n" , dan, i, dan * i);}
	}
}
