package com.company.java009_Ex;

class Card {
 
    int cardNum;
    boolean isMembership;

   
    public Card() {
        this.cardNum = 0;
        this.isMembership = false;
    }

    @Override public String toString() {return "Card[card Num = " + cardNum + ", isMembership=" + isMembership + "]";}
    
    public void show() {
        System.out.println("card Num : " + cardNum + ", isMembership : " + isMembership);}
}
public class ClassEx005 {

	public static void main(String[] args) {
		Card c1 = new Card();
        System.out.println(c1);

	}

}
/*
연습문제5)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx005
-- 생성자 작성하시오.
class Card{
   //상태-멤버변수  : 채널/볼륨 int cardNum; boolean  isMembership;   
   //행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
}
public class ClassEx005{
   public static void main(String[] args) {
   Card  c1= new Card(); 
   System.out.println(c1);  
   }
}

출력내용 :
Card[cardNum=0, isMembership=false]
*/
