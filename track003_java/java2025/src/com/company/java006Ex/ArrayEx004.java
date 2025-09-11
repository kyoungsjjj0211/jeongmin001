package com.company.java006Ex;

public class ArrayEx004 {
	public static void main(String[] args) {
		//변수
		char [] ch = {'B', 'a', 'n', 'a', 'n', 'a'};
		int count =0;
		//입력+처리
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == 'a') {count++;}
		}
		//출력
		System.out.println("'a'의 개수는 : " + count);
	}
}
/*연습문제4)  array
패키지명 : com.company.java006_ex
클래스명 :  ArrayEx004
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 a의 갯수 세기
*/

//ver-1. 만약 'B'가 'a' 라면 카운트, 만약 'a'가 'a'라면 카운트
//ver-2. if('B'가 'a'라면){카운트} if(만약'a'가 'a'라면) {카운트}
//ver-3. if(ch[0]=='a'){count++;} if(ch[1]=='a'){count++}