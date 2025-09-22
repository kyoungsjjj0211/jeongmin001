package com.company.java009_Ex;

import java.util.Scanner;

class Calc {
    int num1, num2;
    char op;
    double result;


    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자1> ");
        num1 = scanner.nextInt();
        System.out.print("숫자2> ");
        num2 = scanner.nextInt();
        System.out.print("연산자> ");
        op = scanner.next().charAt(0);

    }

    void opcalc() {
        switch (op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = (double) num1 / num2; break;
            default: System.out.println("지원하지 않는 연산자입니다."); break;
        }
    }

    public void show() {
        if (op == '/') {
            System.out.printf("%d%c%d=%.2f\n", num1, op, num2, result);
        } else {
        	System.out.printf("%d%c%d=%.0f\n", num1, op, num2, result);
        }
    }
    public Calc() {super();}
    public Calc(int num1, int num2, char op) {super(); this.num1=num1; this.num2 =num2; this.op =op;}
}


public class ClassEx007 {

	public static void main(String[] args) {
		Calc c1 = new Calc(10, 3, '+');
		c1.show();

		Calc c2 = new Calc();
		c2.input();
		c2.show();	
	

	}

}



/*
-----------------------[runtime data area]
[method : 정보, static, final : 고용정보] Cala.class, public Class Ex007.class    클래스(설계도)
[heap : 동적]                           | [stack : 잠깐 빌리기]
											c2.show(){}
											c2.input();
2번지 {num1=3, num2=4, op=*, result=12} ←  c2[2번지]
											c1.show(){}
1번지 {num1=10, num2=3, op='+', result =13} ← c1[1번지] Calc c1= new Calc(10,3,'+')
 										|main
----------------------------------------------------
객체(new)  / 인스턴스 - c2(2번지의).num1 , c1(1번지의).num1
					
 */
/*
연습문제7)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx007
-- 생성자 작성하시오.
class Calc{
   //상태-멤버변수  :  int num1, num2;  char op;  double result;
   //행위-멤버함수  :  void input()   입력받기
   //               void opcalc() +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
   //                      void show()    연산출력   
}
public class ClassEx007{
   public static void main(String[] args) {
   Calc  c1= new Calc(10,3,'+');  
   c1.show();
   
   Calc  c2= new Calc();  
   c2.input();   
   c2.show(); 
    
   }
}

출력내용)
10+3=3

숫자1> 10
숫자2> 3
연산자> /
10/3=3.33
*/