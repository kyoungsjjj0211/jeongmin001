package com.company.java013_Ex;

import java.sql.Date;

interface Launch {
    int MONEY = 10000;
    void eat();
}
class Burger      implements Launch{ 
   int price;
   public Burger() { this.price = 3900; }
   @Override public String toString() { return "Burger"; }
   @Override public void eat() { System.out.println("Burger 냠냠!"); } 
}
class KimchiStew  implements Launch{ 
   int price;
   public KimchiStew() { this.price = 4000; }
   @Override public String toString() { return "KimchiStew"; }
   @Override public void eat() { System.out.println("KimchiStew 냠냠!"); } 
}

class User {  
    int money =Launch.MONEY;
    int cnt = 0;
    Launch[] plate = new Launch[10];

    public void order(Launch a) {
        int price = 0;

        if (a instanceof Burger) {
            price = ((Burger) a).price;
            System.out.println("버거하나요~");
        } else if (a instanceof KimchiStew) {
            price = ((KimchiStew) a).price;
            System.out.println("김치찌개하나요~");
        }

        if (money < price) {
            System.out.println("잔액 부족으로 주문할 수 없습니다.");
            return;
        }

        money -= price;
        plate[cnt++] = a;
        a.eat();
    }

    public void show() {
        System.out.print("\n주문 : ");
        int total = 0;

        for (int i = 0; i < cnt; i++) {
            System.out.print(plate[i]);
            if (i < cnt - 1) System.out.print(", ");

            if (plate[i] instanceof Burger) {
                total += ((Burger) plate[i]).price;
            } else if (plate[i] instanceof KimchiStew) {
                total += ((KimchiStew) plate[i]).price;
            }
        }

        System.out.println("\n주문금액 : " + total);
        System.out.println("잔액    : " + money);

        Date today = new Date(System.currentTimeMillis());
        System.out.println(today.toString());
        System.out.println(today);

        for (int i = 0; i < cnt; i++) {
            plate[i].eat();
        }
    }
}

public class InterfaceEx003 {

	public static void main(String[] args) {
		User launch_order = new User();
        //리턴값 메서드명(파라미터)
			launch_order.order(new Burger());   //void order(Launch a){}
			launch_order.order(new KimchiStew());   //Launch a = new Kimchi()  부모=자식
			launch_order.order(new Burger());   //Launch a = new Burger()  부모=자식
			      
			launch_order.show();//리턴값 메서드명(파라미터)
			// void   show(){}

	}

}