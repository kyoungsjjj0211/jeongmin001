package com.company.java005;

import java.util.Scanner;

public class ForEx007 {
	public static void main(String[] args) {
		//변수
		int  kor, eng, mat, totla;
		double evg;
		
		
		
		Scanner scanner=new Scanner(System.in);
		//입력
		System.out.println("학번을 입력해주세요.");
		String id = scanner.nextLine();
		
		for(;;) {
		System.out.println("국어점수를 입력하세요.");
		kor = scanner.nextInt();
		if(kor>=0 && kor<=100) {break;}
		}
		
		for(;;) {
		System.out.println("수학점수를 입력하세요.");
		mat = scanner.nextInt();
		if(mat>=0 && mat<=100) {break;}
		}
		
		for(;;) {
		System.out.println("영어점수를 입력하세요.");
		eng = scanner.nextInt();
		if(eng>=0 && eng<=100) {break;}
		}
		
		int total = kor + mat + eng ;
		double avg = total / 3.0;
		
		String pass = (avg >= 60 && kor >= 40 && mat >= 40 && eng >= 40) ? "합격" : "불합격";
		
		String jang = (avg >= 95) ? "장학생" : " 비장학생";

		String level = (avg >=90) ?  "수" : (avg >=80) ? "우" : (avg >=70) ? "미" : (avg >=60) ? "양" : "가";
		
		//출력
		System.out.println("=====================================================");
		System.out.println("학번  국어   영어   수학  총점    평균   합격여부  레벨   장학생");
		System.out.println("=====================================================");
		System.out.printf("%s %d %d %d %d %.2f %s %s %s ", id, kor, eng, mat, total, avg, pass, level, jang);
			
			
		
		
	}

}
