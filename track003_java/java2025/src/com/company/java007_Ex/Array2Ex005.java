package com.company.java007_Ex;

public class Array2Ex005 {
	public static void main(String[] args) {
		int [][] arr = {{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
		
		int total = 0;
		double avg =0.0;
		int count =0;
			
		for(int i=0; i<arr.length; i++) {
			for(int a=0; a<arr[i].length; a++) {
				total += arr[i][a];
				count++;
			}
			avg = (double) total/count;
			System.out.println("총점 :  " + total);
			System.out.println("평균 :  " + avg);
		}
	}
}

/*
연습문제5)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex005
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.

 int[][] arr = {
   { 1, 1, 1,},
   { 2, 2, 2,},
   { 3, 3, 3,},
   { 4, 4, 4,},
 };
 int total=0;  double avg=0.0;

출력내용:
총점 : 30
평균 : 2.5
*/