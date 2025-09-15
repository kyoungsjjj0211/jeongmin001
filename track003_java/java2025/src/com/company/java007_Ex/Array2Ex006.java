package com.company.java007_Ex;

public class Array2Ex006 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int data = 1;
		
		  for (int i = 0; i < arr.length; i++) { 
	            for (int a = 0; a < arr[i].length; a++) {
	                arr[i][a] = data;
	                data++;
	            }
		  }
		  for (int i = 0; i < arr.length; i++) {
	            for (int a = 0; a < arr[i].length; a++) {
	                System.out.print(arr[i][a] + "\t");
	            }
	            System.out.println(); 
	        }
	}
}

/*
연습문제6)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex006
> 2차원배열 
1.  new 로 만들고   5*5
2.  데이터 넣기  for+length
3.  데이터 출력  for+length

1   2   3   4   5
6   7   8   9   10
11   12   13   14   15
16   17   18   19   20
21   22   23   24   25
*/