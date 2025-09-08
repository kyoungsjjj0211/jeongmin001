package com.company.java005_ex;

public class ForEx003_2 {
	public static void main(String[] args) {
		//변수
		int sum = 0;
		//입력+처리
	    for (int i = 1; i <= 10; i++) {sum += i;
	            System.out.print(i);if (i < 10) {System.out.print("+");}
	            else {System.out.print("=");}
	            }
	    //출력
	    System.out.println(sum);
	}
}
