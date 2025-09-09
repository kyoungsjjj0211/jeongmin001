package com.company.java006Ex;

import java.util.Scanner;

public class ForEx006 {
	public static void main(String[] args) {
		// 변수
		Scanner scanner = new Scanner(System.in);
		int num, num1;
		char ch;
		double result = 0;
		// 입력
		
		/*ver-1
		
		int num=-1, num1=-1;
		char ch =' ';
		double result =0;
		
		
		for(;;) { //1 무한반복
			 if(!(num >=0 && num <=100)){ // 1-1. 0~100 범위가 아니라면 << 변수에 입력된 값이 영역 범위 밖일 경우 다시 입력하여, 제대로 입력 될경우 num1 변수로 이동 그렇지 않을경우 아래를 계산하지 않고 처음으로 이동,
					 System.out.println("1. 정수를 하나 입력해주세요."); // 1-2. 입력받기
					 num=scanner.nextInt();
					 continue; // 1-3. 아래쪽 진행하지 말것! skip 건너뛰기! 잘 입력받았는지 체크!
			} 
		
			if(!(num1 >=0 && num1 <=100)){ // 0~100범위가 아니라면 2-1. num2=-1 3
				 System.out.println("2. 정수를 하나 입력해주세요."); // 2-2. 입력받기
				 num1=scanner.nextInt();
				 continue; // 2-3. 아래쪽 진행하지 말것! skip 건너뛰기! 잘 입력받았는지 체크!
			}
			if(!(ch=='+'||ch=='-'||ch=='*'||ch=='/')){ //3-1 ' '
				 System.out.println("3. 연산자를 입력해주세요(+,-,*,/)"); //3-2 . 입력받기
				 ch=scanner.next().charIAt(0);
				 continue; // 3-3. 아래쪽 진행하지 말것! skip 건너뛰기! 잘 입력받았는지 체크!
			}
			break; //break를 만났다면 num, num1, ch 잘 쓴 경우
		}
		
		switch(ch) {
		case '+' : result = num + num1; break;
		case '-' : result = num - num1; break;
		case '*' : result = num * num1; break;
		case '/' : result = num / (double)num1; break;
		}
		 */
		
		//ver-2
		for(;;) {
			// if(!(num >=0 && num <=100))
		System.out.println("1. 정수를 하나 입력해주세요.");
		num=scanner.nextInt();
		if(num>=0 && num<=100) {break;}
		} 
		
		for(;;) {
		System.out.println("2. 정수를 하나 입력해주세요.");
		num1=scanner.nextInt();
		if(num1>=0 && num1<=100) {break;}
		}
		for(;;) {
		System.out.println("3. 연산자를 입력해주세요(+,-,*,/)");
		ch=scanner.next().charAt(0);
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {break;}
		}
		// 처리
		
		switch(ch) {
		case '+' :  System.out.println(""+num+ch+num1+"="+(num+num1));break;
		case '-' :  System.out.println(""+num+ch+num1+"="+(num-num1));break;
		case '*' :  System.out.println(""+num+ch+num1+"="+(num*num1));break;
		case '/' :  System.out.println(""+num+ch+num1+"="+(num/num1));break;
		}
		
		
		// 출력
	
		//System.out.println("" + num + ch + num1 + "=" + (ch!='/'? "" +(int)result : String.format("%.2f", result)));
	
		
	}// end main
}// end class
/*
 * 연습문제6) for 무한반복
 * 
 * 패키지명 : com.company.java006_ex 클래스명 : ForEx006 출력내용 : 계산기
 * 
 * 1) 각 연산자에 맞게 계산처리 2) 숫자1, 숫자2는 0~100사이만 입력가능하게 아니면 무한반복 3) 연산자는 +, - ,*, /만
 * 입력가능하게 아니면 무한반복
 * 
 * 
 * 1. 정수를 하나 입력해주세요 > 10 2. 정수를 하나 입력해주세요 > 3 3. 연산자를 입력해주세요(+,-,*,/) > +
 * 10+3=13
 */