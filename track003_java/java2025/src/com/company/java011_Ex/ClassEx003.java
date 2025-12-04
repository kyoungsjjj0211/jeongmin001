package com.company.java011_Ex;
/*클래스의 재사용
Object                          Object
  ↑								↑
Grand {one() , two()}           Aunt
  ↑                             ↑ 
Father {three() } Uncle {one() , two() , four() }

*/
class Grand extends Object {
	public void one() {System.out.println("grand : one");}
	public void two() {System.out.println("grand : two");}
}
class Father extends Grand { 
	public void three() {System.out.println("Father : three");}
}
class Uncle extends Grand{
	public void four() {System.out.println("Uncle : four");}
	@Override public void one() {System.out.println("Uncle : one");}
	@Override public void two() {System.out.println("Uncle : two");}
}
class Aunt{
	String name="mimi";
			@Override public String toString() { return "Aunt[name= " + name + "]";}// Object 
}

public class ClassEx003 {
	public static void main(String[] args) {
		Father papa = new Father(); papa.one(); papa.two(); papa.three();
		Uncle uncle = new Uncle(); uncle.four(); uncle.one(); uncle.two();
		//Q1. uncle이 쓸수있는 메서드는? Uncle - > {four() one(), two()} 정의 , Grand { one(), two()} 오버라이딩  
		//Q2. 26번째줄에서 출려되는 내용은  Uncle - > {four() @one(), @two()} 정의 , Grand { one(), two()} 오버라이딩
		//Q3. 19, 20번째의 개념은? @Override 상속시 부모와 같은 메서드를 자식 클래스에 맞게 수정한것.  
		//father은 grand를 상속받았기 때문에 grand의 one() two()를 사용할수 있다.  , father 클래스에서 정의한 three()메서드는 father 객체에서만 사용 가능

	}
}
