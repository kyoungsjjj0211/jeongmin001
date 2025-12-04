package com.company.java010_Ex;

// 1. 인스턴스변수 pay / 클래스변수 su,basicpay, basicpay2 / 지역변수 없다 를 구분하시오.
// 2. 인스턴스메서드 showSu(), showPay(), showAll002() / 클래스메서드 구분하시오. showAll001()
// 3. 오류나는 이유는?
// - System.out.println(this.pay);

class Sawon3{ 
    int pay      =10000;    	 //인스턴스 변수 - heap - new O - 생성자
    static int su=10;     		 //클래스 변수 - method area - new X - 생성자 X > 바로사용가능
    //static int basicpay=pay;     //클래스 변수 - method area - new X - 생성자 X > 바로사용가능 클래스명.basicpay
    							 // static은 this사용 불가  / 당장사용해야하는데 this를 쓰려면 new하고 난 다음에
    static int basicpay2;    	 //클래스 변수 - method area - new X - 생성자 X > 바로사용가능
    
    // 클래스 메서드 - method area - new X - 생성자 X - Sawon3.showSu() > 바로사용가능
    public static void showSu() {   System.out.println(su);  }          
    // 클래스 메서드 - method area - new X - 생성자 X - Sawon3.showSi() > 바로사용가능
    //static은 this 사용 불가 / this (각각) new 사용
    //public static void showPay() {   System.out.println(this.pay);  }    
    
    // 인스턴스메서드 - heap area - new O - 생성자 O 
    public  void  showAll001() {   
       System.out.println(su);  // static 사용가능 - new 전에 메모리상에 static 이 올라가 있어서
       System.out.println(this.pay); //this 사용가능  
    } 
    // 클래스메서드 - method area - new X - 생성장 X - Sawon3.showAll002()
    public static  void  showAll002() {   
        // showAll001(); // static 은 this 사용 불가(인스턴스) 불가    
        //System.out.println(this.pay);
    } 
} 
public class MemberVarEx001{
  public static void main(String[] args) {
   Sawon3   sola = new Sawon3();   // 1) new 번지, 객체생성 2) 생성자초기화 3)sola 번지
   sola.showAll001();
  }
}


/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
>Sawon3.class / MemberVarEx001.class
>static : Sawon3.su, Sawon3.basicpay2, Sawon3.showSu(), Sawon3.showAll002()
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
							showAll001();
1번지 {pay=0 , showAll001()} ← sola [1번지] 34번째줄
					   | main
------------------------------------
*/

/*
_ex
클래스명 :  MemberVarEx001
-- class Sawon3작성해주세요 
    
class Sawon3{ 
    int pay      =10000;    
    static int su=10;     
    static int basicpay=pay;    
    static int basicpay2;    
    
    public static void showSu() {   System.out.println(su);  }          
    public static void showPay() {   System.out.println(this.pay);  }    
  
    public  void  showAll001() {   
       System.out.println(su);  
       System.out.println(this.pay);  
    } 
    public static  void  showAll002() {   
        showAll001();    
       System.out.println(this.pay);
    } 
} 
public class MemberVarEx001{
  public static void main(String[] args) {
   Sawon3   sola = new Sawon3();  
   sola.showAll001();
 */
