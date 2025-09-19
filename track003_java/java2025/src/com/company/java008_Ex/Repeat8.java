package com.company.java008_Ex;

import java.util.Arrays;

public class Repeat8 {
	public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
    }
	  public static int print(int value) {
	        return value + 10;
	    }
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(print(arr[1]));  //12
		print(arr);
		System.out.println(Arrays.toString(arr)); //11, 12, 13

	}

}

// 다음 코드를 살펴보고 예상되는 결과를 적으시오.
// public static void print(int[] arr){for(int i=0; i<arr.length;i++){arr[i] +=10;}}