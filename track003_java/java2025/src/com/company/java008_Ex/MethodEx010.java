package com.company.java008_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx010 {
	public static void name(String[][] pets) {
		Scanner scanner=new Scanner (System.in);
		
		String name="";
		String result="정보를 확인해주세요";
		
		System.out.println("🐶 동물 이름을 입력해주세요 > "); name=scanner.next();
		
	for(int i=0; i<pets.length; i++) {
		if(name.equals(pets[i][0])) {result = "✅ " + name + "는 " + pets[i][2] + "예약이 되어 있어요. \n"; break;}
	}
	System.out.println(result);
}
	public static void jin(String[][] pets) {
		Scanner scanner=new Scanner (System.in);
	String name="", phone="";
			
		
	System.out.println("🐱 동물 이름을 입력해주세요 >");
	name = scanner.next();
	System.out.println("📞 보호자 전화번호를 입력해주세요 >");
	phone = scanner.next();
	
	int findIndex=-1;
	
	for(int i=0; i<pets.length; i++) {
		if(name.equals(pets[i][0]) && phone.equals(pets[i][1])) {
			System.out.println("🩺 변경하실 진료 항목을 입력해주세요 > ");
			pets[i][2] = scanner.next();
			findIndex=i;
			break;
		}
	}
	if(findIndex !=-1) {
		System.out.println("✅ 예약 정보 확인: " + Arrays.toString(pets[findIndex]));
	}else {System.out.println("❌ 등록 정보를 확인해주세요!"); }
	}
	
	
///////////////////////////////////////////////////
	public static void main(String[] args) {
		String name ;
		int num = 0;
		Scanner scanner=new Scanner(System.in);
		
		String[][] pets = {
			    {"콩이", "010-1234-5678", "예방접종"},
			    {"초코", "010-2345-6789", "건강검진"},
			    {"보리", "010-3456-7890", "치아관리"}
			};
		
		for(;;) {
		System.out.println("🐾 동물 병원 시스템 메뉴\r\n"
				+ "		1. 진료 항목 조회\r\n"
				+ "		2. 진료 항목 변경\r\n"
				+ "		3. 종료\r\n"
				+ "		👉 메뉴 번호를 선택해주세요:");
		num=scanner.nextInt();
		if(num==3) {System.out.println("👋 시스템을 종료합니다. 안녕히 가세요!"); break;}
		else if (num==1){
			name(pets);
		}
		else if (num==2) {
			jin(pets);
		}
		
		}
	}
///////////////////////////////////////////////////
}
 /*
연습문제10)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx010
다음 조건을 만족하는 동물 병원 예약 시스템을 만들어보세요.

■[1단계] 데이터 구성
다음과 같은 정보를 담고 있는 2차원 배열을 선언하세요:

String[][] pets = {
    {"콩이", "010-1234-5678", "예방접종"},
    {"초코", "010-2345-6789", "건강검진"},
    {"보리", "010-3456-7890", "치아관리"}
};

- 각 행은 한 마리의 동물에 대한 정보입니다.
  - [0] 동물 이름
  - [1] 보호자 전화번호
  - [2] 예약된 진료 항목

■ [2단계] 메뉴 출력 및 선택
다음과 같은 메뉴를 **무한 반복**으로 출력하세요:

🐾 동물 병원 시스템 메뉴
1. 진료 항목 조회
2. 진료 항목 변경
3. 종료
👉 메뉴 번호를 선택해주세요:
 


■ [3단계] 기능 구현

#### ① 진료 항목 조회
- 동물 이름을 입력받아 해당 동물의 진료 항목을 출력하세요.
> 출력예시
🐶 동물 이름을 입력해주세요 > 콩이
✅ 콩이는 예방접종 예약이 되어 있어요.
 

#### ② 진료 항목 변경
> 출력예시
- 동물 이름과 보호자 전화번호를 입력받아 정보가 맞으면 진료 항목을 변경하세요.

🐱 동물 이름을 입력해주세요 > 초코
📞 보호자 전화번호를 입력해주세요 > 010-2345-6789
🩺 변경하실 진료 항목을 입력해주세요 > 피부검사
✅ 예약 정보 확인: [초코, 010-2345-6789, 피부검사]
 

- 정보가 틀리면 다음과 같이 출력하세요:
 
❌ 등록 정보를 확인해주세요!
 

#### ③ 종료
- 메뉴에서 3번을 선택하면 프로그램을 종료하세요.
 
👋 시스템을 종료합니다. 안녕히 가세요!
 
 
 

###  ④  보너스 과제 (선택)

- 신규 동물 등록 기능을 추가 
- 전체 예약 목록을 출력하는 기능 
- 진료 항목을 랜덤으로 추천해주는 기능 
 
*/