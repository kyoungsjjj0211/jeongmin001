package com.company.java004_ex;

import java.util.Scanner;

public class If_SwitchEX {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		int num;
		char a;
		System.out.println("알파벳을 입력해주세요.");
		a=scanner.next().charAt(0);
		
		if(a == 'a') {System.out.println("apple");}
			else if(a=='b') {System.out.println("banna");}
			else if(a=='c') {System.out.println("coconut");}
			else {System.out.println("a,b,c가 아닙니다.");}
		
		switch (a) {
			case 'a' : {System.out.println("apple");}break;
			case 'b' : {System.out.println("banna");}break;
			case 'c' : {System.out.println("coconut");}break;
			default : {System.out.println("a,b,c가 아닙니다.");}break;
		}
	
		for(;;) {
			System.out.println("1을 입력해주세요.");
			num = scanner.nextInt();
			if(num == 1) {break;}
			System.out.println("");
			}
			
	}
}

		




/*if 버전으로 다음을 작성하시오
 1. a를 입력 받으면 apple, b를 입력 받으면 banna, c를 입력받으면 coconut
  그 외에는 a,b,c가 아니다
  
  switch 버전으로 다음을 작성하시오
  2. a를 입력받으면 apple, b를 입력 받으면 banna, c를 입력받으면 coconut 그외에는 a,b,c가 아니다
  
  무한반복으로 다음을 작성하시오
  1을 입력받을때까지 사용자에게 무한반복으로 입력을 받아주세요~!
*/
