package com.company.java014Ex;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx002 {
    public static void main(String[] args) {

        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");

        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자 1, 2, 3 중 하나를 입력하세요: ");
        int num=-1;
        num = scanner.nextInt();
        int input = scanner.nextInt();

        System.out.println(numbers.get(input - 1));

        scanner.close();
    }
}	
	//	System.out.println(numbers.get(0));
		
	//	System.out.println(numbers.get(1));
//		System.out.println(numbers.get(2));
	
/*
연습문제2)  Collection  Framework
패키지명 : com.company.java014_ex
클래스명 : ListEx002
1.  numbers ArrayList 만들기
2.  one, two, three 데이터 추가
3.  사용자에게 1,2,3 입력받기
4.  1을 입력받으면 one 출력
    2를입력받으면 two 출력
    3을입력받으면 three 출력
    */