package com.company.java007_Ex;

public class Array2Ex_upgrade1 {
	public static void main(String[] args) {
		int[][] arr2 = {{101, 102, 103},{200, 201, 202},{301, 302, 303}};
		for (int i = 0; i<arr2.length; i++) {
			for (int a=0; a<arr2[i].length; a++) {
				if(arr2[i][a] % 2 ==0) {
					System.out.print("짝수 arr2["+i+"]["+a+"] ="+arr2[i][a] + "\t");
					
				}System.out.println();
			}
		}
	}
}



/*다차원 배열 + 조건 처리
 
1. 문제 설명 : 
다음과 같은 2차원 배열이 주어졌을 때,
각 요소를 이중 for 문으로 순회하면서
짝수인 값만 출력하시오.
출력 시 각 값의 위치(index)도 함께 출력하시오.

2. 출력예시:
짝수 arr2[0][1] = 102
짝수 arr2[1][0] = 200
짝수 arr2[1][2] = 202
짝수 arr2[2][1] = 302

int[][] arr2 = {
    {101, 102, 103},
    {200, 201, 202},
    {301, 302, 303}
};
*/