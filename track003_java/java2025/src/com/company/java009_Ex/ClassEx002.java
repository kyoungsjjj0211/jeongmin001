package com.company.java009_Ex;

import java.util.Scanner;

class MyPrice001{
	String name;
	int price;
	Scanner scanner = new Scanner(System.in);

	void input() {
		System.out.println("상품이름 입력 > ");
		name = scanner.nextLine();
		System.out.println("상품가격 입력 > ");
		price = scanner.nextInt();
	}

	void show() {
		System.out.println("상품정보입니다.");
		System.out.printf("상품이름 : %s  /  상품가격 : %d ", this.name, this.price);
	


}
}


public class ClassEx002 {

	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		p1.input();
		p1.show();
		
	}

}
/*
MYpRICE001 P1 = NEW mYprice001();
-------------------------------[runtime data area]
[method : 정보, static, final : 공용정보]
 Mypricd001.Class, ClassEx002.Class     클래스 (설계도)
------------------------------------------객체 (p1) 인스턴스 (p1.name="apple"/p1.price-1500)
[heap:동적]                         | [stack: 잠깐 빌리기 ]
										p1.show(){}
1번지										p1.input(){}
{name=null, price=0, input(), show()} ← p1 [1번지]


									|main
-----------------------------------------------------
*/