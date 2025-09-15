package com.company.java007_Ex;

public class Array2Ex004 {
	public static void main(String[] args) {
	char[][] arr = new char [2][3];
	char data='A';
			for(int ch=0; ch<arr.length; ch++) {
				for (int kan = 0; kan < arr[ch].length; kan++) {
					arr[ch][kan] = data++;
				
				}
				data = 'B';
			}
			for (int ch = 0; ch < arr.length; ch++) {
				for (int kan = 0; kan < arr[ch].length; kan++) {
					System.out.print(arr[ch][kan] + "\t");
				}
				System.out.println();
			}
	}
}

/*연습문제4)  array
패키지명 : com.company.java007_ex
클래스명 :  Array2Ex004
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   A   B   C
   B   C   D
*/