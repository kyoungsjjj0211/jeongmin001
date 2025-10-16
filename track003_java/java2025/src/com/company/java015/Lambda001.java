
package com.company.java015;

/*

//1. 클래스는 부품객체 - 설계도(틀, can do this~!)
//2. 상태 + 행위 - interface(public static final / public abstract)
////////////////////////////////////////////////////////////////
interface Inter1{void method(); }
class Inter1Impl implements Inter1{
	@Override
	public void method() {
		System.out.println("Hello :D");}
}
////////////////////////////////////////////////////////////////
public final class Lambda001 {

	public static void main(String[] args) {
			//#1. interface 구현객체(자식)
			// 부모    = 자식
			Inter1 i1 = new Inter1Impl(); i1.method();
			//#2. 익명이너클래스 (test목적, 1번 쓰고 버릴목적, 잘안쓰는 이벤트)
			//Inter1 i 2 = new Inter1(0; interface 는 추상메서드이기때문에 new 사용못함.
			
			Inter1 i21 = new Inter1(){
				@Override public void method(); {System.out.println("일회용 - Hello :D");}
				}; i21.method();
			
				@Override public void method(); {System.out.println("일회용 - Hello :D");}
				}; i22.method();
			
			//#3. lambda
				Inter1 i3 () -> { System.out.println("줄이기~! Hello :D:D:D");};
				i3.method();
	}

}
*/


interface Inter1 {
    void method();
}

class Inter1Impl implements Inter1 {
    @Override
    public void method() {
        System.out.println("Hello :D");
    }
}

public final class Lambda001 {

    public static void main(String[] args) {
        // #1. 일반 구현 클래스
        Inter1 i1 = new Inter1Impl();
        i1.method();

        // #2. 익명 클래스
        Inter1 i21 = new Inter1() {
            @Override
            public void method() {
                System.out.println("일회용 - Hello :D");
            }
        };
        i21.method();

        Inter1 i22 = new Inter1() {
            @Override
            public void method() {
                System.out.println("또 다른 일회용 - Hello :D");
            }
        };
        i22.method();

        // #3. 람다식
        Inter1 i3 = () -> {
            System.out.println("줄이기~! Hello :D:D:D");
        };
        i3.method();
    }
}


/*

트러블슈팅

✅ 문제 1: 익명 클래스 문법 오류
증상 : @Override public void method(); { System.out.println("일회용 - Hello :D"); }
세미콜론(;)이 메서드 선언부에 잘못 들어가 있음

중괄호 {}와 @Override 위치도 어색함


해결 방법

Inter1 i21 = new Inter1() {
    @Override
    public void method() {
        System.out.println("일회용 - Hello :D");
    }
};

*/