package com.company.java007_Ex;

public class Repeat001 {
	  public static void dog() {
	        System.out.println("멍멍");
	    }

	   public static void disp(int count, char ch) {
	        for (int i = 0; i < count; i++) {
	            System.out.print(ch);
	        }
	   }
	 public static String stdAvg(int sc) {
	        if (sc >= 90) {
	            return "A";
	        } else if (sc >= 80) {
	            return "B";
	        } else if (sc >= 70) {
	            return "C";
	        } else {
	            return "D";
	        }
	 }
	public static void main(String[] args) {
		System.out.println("강아지가 등장합니다!");
		dog();
		System.out.println("\n 강아지가 시험을 봤습니다. 점수를 공개합니다!");
		disp(7, '*');
		System.out.println("\n 평가 결과는?");
		System.out.println("당신의 평균은? " + stdAvg(88));
	}
}
