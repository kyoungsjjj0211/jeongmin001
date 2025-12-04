package com.company.java011_Ex;

import java.util.Arrays;

import com.company.java011_Ex.Apple;

public class ClassArrEx1 {

	public static void main(String[] args) {

		// 1) a[] 나 주소 받을수 있어~!
		Apple[] apples = new Apple[3]; // 2) new 번지, a 형태의 자료형 3개

		// 사용방법2

		// Apples[0].name, Apples[0].age
		// Apples[1].name, Apples[1].age

		apples[0] = new Apple("RED", "Iron", 2, 1000);
		apples[1] = new Apple("GREEN", "Hulk", 1, 1500);
		apples[2] = new Apple("GOLD", "Captain", 3, 2000);

		
		Apple[] apples2 = new Apple[] { new Apple("RED", "Iron", 2, 1000), new Apple("GREEN", "Hulk", 1, 1500),
				new Apple("GOLD", "Captain", 3, 2000) };
		System.out.println(Arrays.deepToString(apples));

		
		for (Apple apple : apples) {
			System.out.println(apple);

		}
		System.out.println("ver-1 for");
		for (int i = 0; i < apples2.length; i++) {
			apples[i].show();
		}

		System.out.println("ver-2 향상된 for");
		for (Apple a : apples) {
			System.out.println(a);
		}

				//toys[0].name, toys[0].age
				//toys[1].name, toys[1].age
				
					

			
				
			
		}

	}




/*
  연습문제1)  클래스배열
패키지명 : com.company.java011_ex
클래스명 : ClassArrEx1
다음과 같이 코드를 작성하시오.
ㅁ출력된 화면
Apple [name=RED, order=iron, num=2, price=1000]
Apple [name=GREEN, order=hulk, num=1, price=1500]
Apple [name=GOLD, order=captain, num=3, price=2000]

ㅁ주어진 옵션
public class Apple{   //// 실행 main과 파일을 분리해주세요!
   private String name;
   private String order;
   private int num;
   private int price;
}

public class ClassArrEx1{
  public static void main(String[] args) {
        Apple[] apples= new Apple[3]; 
        //위의 화면처럼 값 셋팅
        //위의 화면처럼 출력
  }
}

 
 */
