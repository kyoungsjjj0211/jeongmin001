package com.company.java008_Ex;

import java.util.Arrays;

public class MethodEx008_2 {

	
	///////////////////////////////////////////////////////
	public static void main(String[] args) {
		char[] letters = {'A','B','C','1','@'};
		lower(letters); 
		//public static void lower(char [] letters){}
		//
		/* [heap]                      [stack]
		 * 							 ←	4) lower(1000번지) 7번째줄
		  2) 1000번지					 ← 	3) letters[1000번지]   6번째줄
		  {'A','B','C','1','@'}
		 							   1) main 									
		  
		 */
		System.out.println(Arrays.toString(letters));
		}
	//////////////////////////////////////////////////////////
		public static void lower(char [] letters) {
		for(int i=0; i<letters.length; i++) {
		if(letters[i]>='A' && letters[i] <='Z') { letters[i] += 32;}
		}
	}
}

