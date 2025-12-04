package com.company.java010_Ex;
//클래스는 부품객체
//클래스는 상태(멤버변수)와 행위(멤버함수)
class LunchTray {
	//멤버변수(클래스변수 : 공용, 인스턴스변수 : this(각각), 지역변수:임시)
    String owner;        //인스턴스 변수 
    int rice = 90;       //인스턴스 변수        
    int soup = 85;       //인스턴스 변수        
    
	static int trayCount = 0;  //클래스변수
    // static int totalFood = rice + soup; // 클래스변수 - > 인스턴스변수
    static int maxRice = 100; //클래스변수       

    
    public LunchTray() {
		this.owner = "std-" + ++ trayCount;
    	
	}

	public int getFoodAmount() { //인스턴스메서드
        return rice + soup;         
    }

    public static void showTrayCount() { //클래스메서드
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public  void showOwner() {  //클래스메서드 -> 인스턴스메서드
       //System.out.println(this.owner);
    }

    public void showTray() { //인스턴스메서드
        System.out.println("\n\n:: 주인 이름: " + this.owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}

public class MemberVarEx003 {

	public static void main(String[] args) {
		LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         

	}

}
/*
------------------------------[ runtime Data Area ]
[ Method Area : 클래스 정보, static, final - 공용 영역 ]
> Student.class / MemberVarEx002.class
> static : Student.maxScore
           Student.showStudentCount()
           Student.showName()
---------------------------------------------
[heap : 동적]         | [ Stack : 잠깐빌리기]
                                      |
2번지 { name=홍, kor=90, eng=85 }       |   studentCount()
 ← s2 [2번지] 호출됨 (38번째 줄)       	  |   getTotalScore()
                                      |
1번지 { name=홍, kor=90, eng=85 }       |   studentCount()
 ← s1 [1번지] 호출됨 (38번째 줄)           |   getTotalScore()
                                      |
                                      |   main()
---------------------------------------------
*/
/*
연습문제3)  멤버변수
패키지명 : com.company.java010_ex
클래스명 :  MemberVarEx003
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
:: 주인 이름: std-1
총 음식량: 175
전체 급식판 수: 1


:: 주인 이름: std-2
총 음식량: 175
전체 급식판 수: 2

 
class LunchTray {
    String owner;        
    int rice = 90;               
    int soup = 85;               

    static int trayCount = 0;      

    static int totalFood = rice + soup;

    static int maxRice = 100;       

    public int getFoodAmount() {
        return rice + soup;         
    }

    public static void showTrayCount() {
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public static void showOwner() { 
       System.out.println(owner);
    }

    public void showTray() {
        System.out.println("\n\n:: 주인 이름: " + owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}


public class MemberVarEx003 {
   public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         
   }
} 
*/