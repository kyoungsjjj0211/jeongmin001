package com.company.java009_Ex;

class Coffee extends Object {
	String name;
	int price, num;
	
	public Coffee() {super();//제일 많이사용하는 기본값
		this.name = "아메리카노";
		this.num = 1;
		this.price = 2000;
	}
	 public Coffee(String name, int num, int price) {
		 	super();
	        this.name = name;
	        this.num = num;
	        this.price = price;
	 }
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", num=" + num + "]";
	}

	void show() {System.out.println("====커피");
	System.out.println("커피명  : " + name);
	System.out.println("커피잔수 : " + num);
	System.out.println("커피가격 : " + (price * num));} //커피정보출력

}
public class ClassEx003 {

	public static void main(String[] args){
		Coffee a1 = new Coffee("까페라떼" , 2, 4000);
		a1.show();
		Coffee a2 = new Coffee();
		a2.show();

	}
}


/*

출력내용 :
=====커피
커피명 : 까페라떼
커피잔수 : 2 
커피가격 : 8000
=====커피
커피명 : 아메리카노
커피잔수 : 1
커피가격 : 2000

*/