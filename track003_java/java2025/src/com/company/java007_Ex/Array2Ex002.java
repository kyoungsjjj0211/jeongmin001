package com.company.java007_Ex;

public class Array2Ex002 {
	public static void main(String[] args) {
		int[][] arr2={{101,102,103},{201,202,203}};
		
		for (int ch = 0; ch < arr2.length; ch++) {
			for (int may = 0; may < arr2[ch].length; may++) {
				System.out.print(arr2[ch][may] + "\t");
			}System.out.println();
		}
		
		
		//   int[][] arr2={{101,102,103},{201,202,203}};

		//   이중for 이용해서 출력하기
	}
}
