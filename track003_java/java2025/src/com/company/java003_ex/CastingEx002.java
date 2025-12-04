package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {
	public static void main(String[] args) {
		//변수
		int kor, eng, mat, total;
		double avg;
		
		Scanner scanner = new Scanner (System.in);
		
	    //입력
        System.out.println("국어점수 입력 > ");
        kor = scanner.nextInt();

        System.out.println("영어점수 입력 > ");
        eng = scanner.nextInt();

        System.out.println("수학점수 입력 > ");
        mat = scanner.nextInt();
        
        //처리
        total = kor + eng + mat;
        avg = total / 3.0; // 정수/실수 99.67 → 9.967 → 9  
        
       
        
        
        int level = ((int) avg / 10);  //      99.67/10  →  (int)9.967
        // int level = (int) (avg / 10);

        //출력
        // 기본 출력 방법
        //System.out.println("국어   영어   수학   총점   평균   레벨\n");
        //System.out.printf("%3d   %3d   %3d   %3d   %.2f   %d\n", kor,  eng, mat,  total,  avg, level);
        
        
        System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":: GOOD  IT SCORE ::");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        
        //                 %s  문자열   %d 정수   %.2f 실수
        System.out.printf("국어   영어   수학   총점   평균   레벨\n");
        System.out.printf("%3d   %3d   %3d   %3d   %.2f   %d\n", kor, eng, mat, total, avg, level);
        //둘다 함수로 만들경우
        //System.out.printf(" %-5s \  t%-5s \  t%-5s  \ t%-5s  \ t%-5s \  t%-5s\n" , "국어","영어","수학","총점","평균","레벨");
        //System.out.printf(" %-5d \  t%-5d \  t%-5d  \ t%-5d  \ t%-5.2f \  t%-5d\n" , kor, eng, mat, total, avg, level);
	}
}
