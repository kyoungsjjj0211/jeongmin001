package com.company.java008;

import java.util.Random;

public class Method003 {
	public static String sign() {
		return "🎇「전설의_마법의_도끼를_든_초코우유_중동자_용감한_불꽃전사」🎇";
		//System.out.println("........나 짤려요~~~......"); //Unreachable code
	}
	public static String intro(String name , int level){
		return"["+name+"]님의 레벨["+level+"]";
		
	}
////////////////////////////////////////////////////////////////////
	public static void main(String[] args)  {
		// public static 리턴값 매서드명(파라미터){}
		// 1. 당신의 이름은? 전설의_마법의_도끼를_든_초코우유_중동자_용감한_불꽃전사
		System.out.println("1.당신의 이름은? " + sign());
		// 2. 이름, 직업, 레벨을 주면 위에서 소개문장
		// 2. 당신 설명 ? [홍길동]님은 레벨[9]
		//public static String intro(){}
		System.out.println("2. 당신 설명?" + intro("홍길동",9 ));
		System.out.println("2. 당신 설명?" + intro(sign(),10 ));
		// 3. 두개의 숫자를 넣어주면 나누기처리 9>4.5
		//public static double spell(int level)
		System.out.println("3. 반타작 저주 >" + spell(9));
		// 4. 오늘의 운세 1~100사이
		System.out.println("4. 운세 > " + luck());
	}
//////////////////////////////////////////////////////////////////
		public static int luck() {
			Random rand = new Random();
		int result = rand.nextInt(100) +1; // 0~100보다 작은 숫자 랜덤
				return result;
		}
		public static double spell(int level) {return level/2.0;}
}
