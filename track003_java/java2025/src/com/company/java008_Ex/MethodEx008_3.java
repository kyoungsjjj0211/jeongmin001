package com.company.java008_Ex;

import java.util.Arrays;

public class MethodEx008_3 {
/////////////////////////////////////////////////
	public static void main(String[] args) {
		String[] toybox= {"레고","주방놀이세트","물고기낚시놀이","우주선","공룡"};
		System.out.println("main 처음 toybox > " + Arrays.toString(toybox));
		lend(toybox);
		
		System.out.println("main 친구가 빌려간 후 toybox > " + Arrays.toString(toybox));
	}
///////////////////////////////////////////////////////
		public static void lend(String[] toybox) {toybox[0] = "X";}
}
/* [method area] 1)MethodEx008_3 정보
   [heap area]					[stack area]
 							←   lend[1000번지]
  3) 1000번지					←	toybox[1000번지] 8번째
  {"레고" , "주방놀이세트",,,}
 								2) main
 */
