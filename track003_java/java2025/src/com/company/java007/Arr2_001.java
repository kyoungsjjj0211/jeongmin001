package com.company.java007;

import java.util.Arrays;

public class Arr2_001 {
	public static void main(String[] args) {
		int [][] arr = { {1,2,3}  , // 00  01  02 
						 {4,5,6}  , // 10  11  12
		};
		System.out.println( arr ); // [[I@5aaa6d82
		System.out.println( Arrays.toString(arr)); //[[I@73a28541, [I@6f75e721]
		System.out.println( Arrays.deepToString(arr)); // [[1, 2, 3], [4, 5, 6]]
		
		//ver-1 눈에 보이는대로
		System.out.println("ver-1");
		System.out.println(arr[0][0]+"\t"); System.out.println(arr[0][1]+"\t"); System.out.println(arr[0][2]+"\t");
		System.out.println();
		System.out.println(arr[1][0]+"\t"); System.out.println(arr[1][1]+"\t"); System.out.println(arr[1][2]+"\t");
		System.out.println();
		
		//ver-2 칸정리 arr[0,1] << 요 안에만 바뀜[]
		System.out.println("ver-2");
		for(int kan=0; kan<=2; kan++){System.out.println(arr[0][kan]+"\t");}
		System.out.println();
		for(int kan=0; kan<=2; kan++){System.out.println(arr[1][kan]+"\t");}
		System.out.println();
		//ver-3 층정리
		System.out.println("ver-3");
		for(int ch=0; ch<=1; ch++){
			for(int kan=0; kan<=2; kan++){System.out.println(arr[ch][kan]+"\t");}
			System.out.println();
		}
		
		System.out.println("ver-4");
		// 배열명(아파트).length 층 / 배열명 [0] 층.length 칸
		for(int ch=0; ch<arr.length; ch++){ //아파트.층수
								//층의 칸수
			for(int kan=0; kan<arr[ch].length; kan++){System.out.println(arr[ch][kan]+"\t");}
			System.out.println();
		}
	}//end main
}//end class
