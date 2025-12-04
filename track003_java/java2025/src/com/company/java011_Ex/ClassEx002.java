package com.company.java011_Ex;
/*클래스의 재사용
   Object
     ↑
   MobileNote {show()}
     ↑
   MobileNote7 { iris,face/newshow()}
   	 ↑
   MobileNote8 { oface/newshow()}
   	 ↑
   MobileNote9 { battery/ newshow()}

   
   ----------------------------------
   MobileNote9 my9 = new MobileNote9();
   ----------------------------------
  1.MobileNote8 는 MobileNote 이다.
  2. 생성자호출순서 : MobileNote9() → MobileNote8() → MobileNote7() → MobileNote() → Object()
  3. 객체생성순서 : Object → MobileNote → MobileNote7 → MobileNote8 → MobileNote9
  		2번지 {battery / newshow()} → { face / newshow()} → {iris,face / new show()} → {show()}
  		
  		Q1. note8, note7의 newshow() 호출방법은?

   
   ----------------------------------
   MobileNote8 my8 = new MobileNote8();
   ----------------------------------
  1.MobileNote8 는 MobileNote 이다.
  2. 생성자호출순서 : MobileNote8() → MobileNote7() → MobileNote() → Object()
  3. 객체생성순서 : Object → MobileNote → MobileNote7 → MobileNote8
  		2번지 {face / newshow()} → { iris, face / newshow()} → { show()}
  		
  		상속시 부모와 같은 메서드 자식에게 맞게 수정
   ----------------------------------
   MobileNote7 my7 = new MobileNote7();
   ----------------------------------
  1.MobileNote7 는 MobileNote 이다.
  2. 생성자호출순서 : MobileNote7() → MobileNote() → Object()
  3. 객체생성순서 : Object → MobileNote → MobileNote7
  		1번지 : {iris,face / newShow() } - {show()}
  ------------------------------------------------
 
 */
class MobileNote{
	void show() {
		System.out.println("기본기능");
	}

	void newshow() {
	
	}
}
class MobileNote7 extends MobileNote{
	 private String Iris;
	 private String Face;
	 public void setIris(String iris) {this.Iris = iris;}
	 public void setFace(String face) {this.Face = face;}
	
	 @Override void newshow() {
		 super.newshow();
		 System.out.println("NOTE7 객체 기능(Overriding)");
		 System.out.println("Iris = " + this.Iris);
		 System.out.println("Face = " + this.Face);
	 }
}

class MobileNote8 extends MobileNote{
	 private String Face;
	 public void setFace(String face) {this.Face = face;}
	 
	 @Override void newshow() {
		 super.newshow();
		 System.out.println("NOTE8 객체 기능(Overriding) 추가");
		 System.out.println("Face = " + this.Face);
	 }
}
class MobileNote9 extends MobileNote{
	private int battery;
	 
	public void setBattery(int battery) {
		this.battery = battery;
	}
	@Override void newshow() {
		super.newshow();
		System.out.println("NOTE9 객체 기능(Overriding) 추가");
		System.out.println("battery 사용");
		System.out.println("battery = " + this.battery);
	}

		

}

public class ClassEx002 {	
	public static void main(String[] args) {
		MobileNote7 my7 = new MobileNote7();
        my7.setIris("brown");
        my7.setFace("pretty");
        my7.newshow();

        MobileNote8 my8 = new MobileNote8();
        my8.setFace("pretty");
        my8.newshow();

        MobileNote9 my9 = new MobileNote9();
        my9.setBattery(24);
        my9.newshow();
        
        /*MobileNote9 my92 = new MobileNote9();
        my92.setIris("black");
        my92.setFace("cuty");
        my92.setBattery(24);
        my92.newshow();*/
	}

}


/*
연습문제2)     클래스 상속과 메서드 오버라이딩
패키지명 : com.company.java011_ex 
클래스명 : ClassEx002.java

1. 아래 조건에 맞게 ClassEx002.java 파일을 작성하고,
   main() 메서드를 수정하여 다음과 같은 출력 결과가 나오도록 하시오.
2. 주어진 코드 (수정 전)
```java
public class ClassEx002 {
    public static void main(String[] args) {
        MobileNote7 my7 = new MobileNote7();
        my7.setIris("brown");
        my7.setFace("pretty");
        my7.newShow();

        MobileNote8 my8 = new MobileNote8();
        my8.setFace("pretty");
        my8.newShow();

        MobileNote9 my9 = new MobileNote9();
        my9.setBattery(24);
        my9.newShow();
    }
}
```
3. 출력 결과 

NOTE7 객체 기능(Overriding)
iris = brown
face = pretty

NOTE8 객체 기능(Overriding) 추가
face = pretty

NOTE9 객체 기능(Overriding) 추가
battery 예쁘게 사용하기!
battery = 24

4. 클래스 구조 설명
클래스명      멤버변수        멤버메서드
MobileNote   없음                        void show()
MobileNote7   String iris, String face  void newShow()
MobileNote8   String face                 void newShow()
MobileNote9   int battery                 void newShow()
모든 멤버변수는 private으로 선언

-각 클래스는 MobileNote 클래스를 상속받음
-newShow() 메서드는 각 클래스에서 오버라이딩되어 고유한 출력 형식을 가짐

5. 요구사항
-MobileNote 클래스를 기반으로 상속 구조를 설계할 것 (MobileNote7, MobileNote8, MobileNote9 모두 상속)
-각 클래스에서 setter 메서드를 통해 멤버변수 값을 설정할 수 있도록 구현할 것
-newShow() 메서드를 오버라이딩하여 출력 형식을 문제에서 제시한 형태로 맞출 것
-출력 순서와 내용이 정확히 일치하도록 main() 메서드를 구성할 것


*/