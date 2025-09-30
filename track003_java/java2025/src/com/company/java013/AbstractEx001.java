package com.company.java013;

/*	Abstract : 일반클래스 + 설계
 		
			      Object
			 	    ↑
			 	  Robot { abstract charge() , move(), speak() }
 	 ↑              ↑                 ↑
 CleaningRobot    SecurityRobot  CookingRobot
 {@charge(),        {@charge(),      {@charge(),
  @move(),           @move(),         @move(),
  @speak()}}         @speak()}}       @speak()}}
 */
abstract class Robot{
		String model; int batteryLevel;
		void myrobot() {System.out.println("로봇입니다.");}
		abstract void charge(); //충전방식
		abstract void move(); //이동방식
		abstract void speak(); //말하기방식
}
class CleaningRobot extends Robot{
	@Override void charge() { System.out.println("청소로봇 충전 중... 배터리");}
	@Override void move() { System.out.println("청소로봇 :  먼지를 제거합니다!");}
	@Override void speak() { System.out.println("청소로봇 : 안녕하세요.");}
}
class SecurityRobot extends Robot{
	@Override void charge() { System.out.println("경비로봇 태양광 충전 중.... 배터리");}
	@Override void move() { System.out.println("경비로봇 : 경비 중");}
	@Override void speak() { System.out.println("경비로봇 : 이상 없음. 안전 확보!");}
}
class CookingRobot extends Robot{
	@Override void charge() { System.out.println("요리로봇 인덕션 충전 중... 배터리");}
	@Override void move() { System.out.println("요리로봇 : 요리만드는 중");}
	@Override void speak() { System.out.println("요리로봇 : 오늘의 메뉴는 파스타입니다!");}
}
// class CleaningRobot extends Robot{
	
//}
public class AbstractEx001 {
	public static void main(String[] args) {
		//Robot robot = new Robot(); //Q1. why? A.{} 구현부가 없음
		System.out.println("\n----- 로봇 배열 시뮬레이션----");
		//     부모          =    자식1                 자식2            자식3
		Robot [] bots = { new CleaningRobot(), new SecurityRobot(), new CookingRobot() };
		int[] levels = {50, 70, 95};

		//Q2. 
		for(int i=0; i<bots.length; i++) {
			bots[i].model = "Robo" + (i+1);
			bots[i].batteryLevel = levels[i];
			bots[i].charge(); System.out.println(bots[i].batteryLevel + "%");
			bots[i].move();
			bots[i].speak();
		}
		//bots[0] = 1번지 CleanintRobot{@charge(), @move(), @speak() } -- Robot{model, batteryLevel/charge(),move(),speak()}
		//							-Robot{model="Robo1" , batteryLevel=50 /----,---,----}
		//bots[1] = 2번지 SecurityRobot{@charge(), @move(), @speak() } -- Robot{model, batteryLevel/charge(),move(),speak()}
		//							-Robot{model="Robo1" , batteryLevel=50 /----,---,----}
		//bots[2] = 3번지 CookingRobot{@charge(), @move(), @speak() } -- Robot{model, batteryLevel/charge(),move(),speak()}
		//                          -Robot{model="Robo1" , batteryLevel=50 /----,---,----}
	}

}
/*
 method area : 클래스정보
 
 heap area : 동적, 배열             stack area : 임시
 1번지{model,battery,charge()X} ← robot(1번지)
 
 -------로봇 배열 시뮬레이션 --------
 Robo1 청소로봇 충전중.....배터리 50%
 Robo1 청소로봇 : 먼지를 제거합니다!
 Robo2 경비로봇 태양광 충전 중... 배터리70%
 Robo2 경비로봇 : 이상없음. 안전 확보!
 Robo3 요리로봇 인덕션 충전 중 ... 배터리95%
 Robo3 요리로봇 : 오늘의 메뉴는 파스타입니다!
 
CleanBot-X 청소로봇 충전 중.... 배터리80%
CleanBot-X 청소로봇 바닥을 따라 이동!
CleanBot-X 청소로봇 : 먼지를 제거합니다! 

GuardBot-Z 경비로봇 태양광 충전 중.... 배터리 65%
GuardBot-Z 경비로봇 태양광 충전 중.... 배터리 65%
GuardBot-Z 경비로봇 태양광 충전 중.... 배터리 65%
 */
