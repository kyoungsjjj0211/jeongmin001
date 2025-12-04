package com.company.java014Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("피구왕", "통키");
		map.put("제빵왕", " 김탁구");
		map.put("요리왕", "비룡");
		
		System.out.println("======================");
		System.out.println("KING\tNAME");
		System.out.println("======================");
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue()	);
			System.out.println("------------------------");
		}
		System.out.println("KING의 정보를 제공중입니다");
		Scanner scanner=new Scanner(System.in);
		System.out.println("이름을 입력하세요 > ");
		String input = scanner.nextLine();
		
		if (map.containsKey(input)) {
			System.out.println(input + " : " + map.get(input));
		} else {
			System.out.println("해당 KING의 정보가 없습니다.");
		}

	}

}


/*
연습문제2)  Collection  Framework
패키지명 : com.company.java014_ex
클래스명 : MapEx001
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

제빵왕 : 김탁구
*/