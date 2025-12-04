package com.company.java011;

/* 상속 : 클래스의 재사용
	Objecet (실선-속이빈화살표) ■3) Object{                       ■4) }
	   ↑
	Animal   ■2) Animal() {name=null, age=0 / set(), sleep(), poo()  ■5) } 
	↑    ↑   ■1) Cat()    { animal_card / qukquk()             ■6) } 
Person  Cat  ■0) 1번지        
-----------------------------------------------
Cat myo = new Cat();
-----------------------------------------------
1) Cat은 Animal이다  ↑
2) 생성자호츌 : Cat() → Animal() → Object()
3) 객체생성 : Object → Animal   → Cat
 */

class Animal{
	String name;
	int age;
	void eat  () {System.out.println("먹고");}
	void sleep() {System.out.println("자고");}
	void poo  () {System.out.println("배변");}
}
class Cat extends Animal{
	String animal_card;
	void qukquk() {System.out.println(this.name + "꾹꾹이");}
}


public class Extends002 {

	public static void main(String[] args) {
			Cat myo = new Cat();
			myo.name="kitty"; myo.age=52;
			myo.animal_card="ani-1234";
			myo.eat(); myo.sleep(); myo.poo(); myo.qukquk();
	}

}
