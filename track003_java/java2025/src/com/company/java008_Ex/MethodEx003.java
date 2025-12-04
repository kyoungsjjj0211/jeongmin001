package com.company.java008_Ex;

public class MethodEx003 {
	public static void printProfile(String name, int age, String zi) {
		System.out.println("====사용자 프로필====");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("지역 : " + zi);
		System.out.println("==================");
	}
	public static void checkAge(int age) {
		if (age<19) {
			System.out.println("미성년자입니다.");}
		else {System.out.println("성인입니다.");
		}
	}
	public static void repeatMessage(String ms, int count) {
		for(int i=0; i<count; i++) {
			System.out.println(ms);
		}
	}
	public static void drawBox(int num, char ch) {
		for(int i=0; i<num;i++) {
			for(int s=0; s<num; s++){
				System.out.print(ch);
				}System.out.println();
			}
	}
	public static void line() {System.out.println();}
	
	public static void main(String[] args) {
		printProfile("홍길동",25,"서울");
		checkAge(17);
		repeatMessage("안녕하세요!",3);
		drawBox(5,'#');
		
	}

}
