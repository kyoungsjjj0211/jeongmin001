package com.company.java005_ex;

public class RepeatEx010 {
	public static void main(String[] args) {
		// 변수

		// 입력+처리
		for (char a = 'A'; a <= 'Z'; a++) {
			if (a % 5 == 0) {
				System.out.println();
			}
			System.out.print(a);
		}

		// 출력

		///////////////////////////////


		char a = 'A';
		while (a <= 'Z') {
			if (a % 5 == 0) {
				System.out.println();
			}
			System.out.print(a);
			a++;
		}

		///////////////////////////////


		a = 'A';
		do {
			if (a % 5 == 0) {
				System.out.println();
			}
			System.out.print(a);
			a++;
		} while (a <= 'Z');

	}
}
/*
 * 연습문제10) for/while/do while 패키지명 : com.company.java005_ex 클래스명 : RepeatEx010
 * for , while , do while 3가지 버젼으로 ABCDE FGHIJ KLMNO PQRST UVWXY Z
 */

//ver-1 눈에 보이는 그대로
//System.out.println();
//System.out.println('A');65 System.out.println('B');  System.out.println('C');  System.out.println('D');  System.out.println('E');69
//System.out.println();
//System.out.println('F');70 System.out.println('G'); System.out.println('H'); System.out.println('I'); System.out.println('J');

//ver-2 구조 {반복 System.out.println(); System.out.println('A');65} { 변수 } for(시작; 종료; 변화)
//ver-3 특별한 문제 풀이 조건
//for(char a='A'; a<='Z'; a++){5번째 마다 줄바꿈-숫자카운트,문자가 갖고 있는 숫자로 체크 System.out.println( a );      }
//for(char a='A'; a<='Z'; a++){a를 5로 나눳을때 0이라면               줄바꿈     System.out.println( a );      }