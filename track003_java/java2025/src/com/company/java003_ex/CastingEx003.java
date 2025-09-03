package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx003 {
	public static void main(String[] args) {
		int walk, time, sleep, total;
		double avg;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("하루 걸음 수를 입력하세요");
		walk = scanner.nextInt();
		
		System.out.print("운동시간을 입력하세요");
		time = scanner.nextInt();
		
		System.out.print("수면시간을 입력하세요");
		sleep = scanner.nextInt();
		
		
		 int walkscore = walk / 1000;
	     int timescore = time / 10;
	     int sleepscore = sleep * 2;

	      total = walk + time + sleep;
	      avg = total / 3.0;
	      int heal = (int) avg / 2;

	        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	        System.out.println(":: HEALTH TRACKER ::");
	        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	        System.out.printf("걸음수   운동시간   수면시간    총점   평균   건강레벨%n");
	        System.out.printf("%-8d %-10d %-10d %-6d %.2f   %d%n",
	                walkscore, timescore, sleepscore, total, avg, heal);
	}
}
