package com.company.java008;

public class Repeat019 {
	public static void start() {System.out.print("부우웅......");}
	
	public static void scan(int num, char ch) {
		for(int i=0; i<num;i++) {System.out.print(ch);}
	}
	 public static String signalGrade(int signalGrade) {
	        if (signalGrade <= 65) {
	        return "C";
	        } else {
	        	return "배터리 충전이 필요합니다.";
	        }
	 }
	 
	 public static int charge(int count, int point) {
	        return count + point;
	    }
	public static void main(String[] args) {
		System.out.println("탐사 로봇이 기동합니다!");
		start();   //"부우웅...." 출력
		System.out.println("\n 행성스캔중...");
		scan(5,'#');  // ###### 출력
		System.err.println("\n 신호 강도 분석 결과.");
		System.out.println("신호등급 : " + signalGrade(65)); //c출력)
		System.out.println("\n 배터리 충전 중...");
		System.out.println("충전완료 : " +  charge(40, 40)+ "%"); //80출력
		
		}

}
