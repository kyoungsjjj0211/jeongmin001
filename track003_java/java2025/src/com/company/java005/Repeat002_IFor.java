package com.company.java005;

import java.util.Scanner;

public class Repeat002_IFor {
	public static void main(String[] args) {
		//1. 무한반복 for(;;) {}  / 2.break 나갈 조건1
		//시작 종료 변화 라는 패턴 아무것도 안써도됨.
		//for(;;) {System.out.println("Hello");} ← 안좋은 코드
		Scanner scanner = new Scanner(System.in);
		for(;;) {
			System.out.println("숫자1을 입력하세요.");
			int a = scanner.nextInt();
			if(a==1) {break;}
			}
		
		//for - break (if == 3) 3이면 나가! 1 2) 
		for(int i=1; i<=10; i++) {if(i==3) {break;} System.out.print(i +"\t");}
		
		//for - continue (if == 3) 3이면 건너뛰기! 1 2 () 4 5 6 7 8 9 10
		for(int i=1; i<=10; i++) {if(i==3) {continue;} System.out.print(i +"\t");}
		
		
		
		
	}//end main
}// end class
