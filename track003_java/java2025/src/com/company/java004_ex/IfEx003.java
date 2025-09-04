package com.company.java004_ex;

import java.util.Scanner;

public class IfEx003 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int num = 3;
		System.out.println("1,2,3중 숫자 한개를 입력해주세요");
		num = scanner.nextInt();
		//처리 + 출력 -60점이상이면 합격, 불합격 여부
		
			 if(num == 1){System.out.println("one");}
		else if(num == 2) {System.out.println("two");}
		else if(num == 3) {System.out.println("three");}
		else              {System.out.println("1,2,3이 아닙니다.");}

	}

}
