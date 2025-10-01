package com.company.java013_Ex;
/*
 		Vehicle { public abstract void run();}
 ⋯⋯⋯△			⋯⋯⋯△
 MotorCycle      Car
 {@run()}        {@run()} 		
 
 1. 인터페이스는 설계클래스 (상태:public static final / 행위 : public abstract)
 		method area[공용] , new x, 생성자 x, this 각각 X, {}X
 2. 부모 = 자식 : 한가지타입(부모)으로 여러객체(자식, 자식,,,,,, 자식들) 관리
 			업캐스팅 /타입캐스팅 X / 부모에서 메서드호출 시 오버라이드가 되서 자식메서드가 호출
 */

interface Vehicle {
	public void run();
}

class MotorCycle implements Vehicle {
	@Override
	public void run() {
		System.out.println("오토바이가 달립니다.");
	}
}

class Car implements Vehicle {
	@Override
	public void run() {
		System.out.println("자동차가 달립니다.");
	}
}

class Driver {
	 void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
/* ------------------------------------------------------
 method[공통: static, final, abstract] Vehicle, MotorCycle, Car{abstract void run(); },
  												Driver ,InetrfaceEx002
 --------------------------------------------------------
 heap[동적]                               |stack[지역]		   			부모.메서드호출()
 											//void drive(Vehicle vehicle){vehicle.run(); }
 											driver.drive(mo:3번지) {Vehicle vehicle=mo; vehicle(3번지).run();}
 											driver.drive(car:2번지) {Vehicle vehicle=car; vehicle(2번지).run();}    
		vehicle.run();
	}
 3번지 MotorCycle{@run() 오토바이달려}      ← mo   [3번지]
 2번지 Car    {@run() 자동차달려}          ← car   [2번지]
 1번지 Driver {drive(Vehicle vehicle);} ← driver[1번지]
                                         |main
 --------------------------------------------------------                                        
  */
 

public class InterfaceEx002 {

	public static void main(String[] args) {
		   Driver driver = new Driver();
		      
		      Car car = new Car();
		      MotorCycle mo = new MotorCycle();
		      //The method drive(Car) is underfined for the type Driver
		      //메서드기본구조 : 리턴값 메서드명(){}
		      //				void drive(){}
		      driver.drive(car); //자동차가 달립니다.
		      driver.drive(mo);	//오토바이가 달립니다.

	}

}

/*
연습문제2)  
패키지명 :  package com.company.java013_ex;
클래스명 :  public class InterfaceEx002

1. Driver 클래스를 작성하시오.  
2. 주어진조건
interface Vehicle {
   public void run();
} 
class MotorCycle implements Vehicle {
   @Override
   public void run() {
      System.out.println("오토바이가 달립니다.");
   }
}
class Car implements Vehicle {
   @Override
   public void run() {
      System.out.println("자동차가 달립니다.");
   }
}

3. 메인화면
public class Oop014_method_polymorphism {
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
      driver.drive(car);
      driver.drive(mo);
   }
}

4. 실행화면
자동차가 달립니다.
오토바이가 달립니다.
 
 */
