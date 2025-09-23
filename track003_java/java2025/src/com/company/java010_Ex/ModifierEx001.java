package com.company.java010_Ex;
//Q1. 자바의 접근자를 넓은 범위에서 좁은 범위로 적으시오.
//public > protected(extends) >  default(같은폴더) > private(클래스안에서만)

class ToyBox{
	public String sharedToy = "블록"; // 누구나 꺼내서 놀수있어요.
	private String secretToy = "로봇"; // 다른 친구들이 이 장난감을 못 보게 하려면
			String familyToy = "퍼즐"; // 같은집에 살고있어서 형이 퍼즐을 볼수 있게 하려면
}


//public class ToyBox {public String sharedToy = "블록";}

//public class ToyBox {private String secretToy = "로봇";}

//public class ToyBox {protected String familyToy = "퍼즐";}

/*public class Friend {
    public static void main(String[] args) {
        ToyBox box = new ToyBox();
        System.out.println(box.sharedToy); //보인다
        System.out.println(box.secretToy); //안보인다.
        System.out.println(box.familyToy); //보인다
    }
}
*/




public class ModifierEx001 {

	public static void main(String[] args) {
		ToyBox box = new ToyBox();
		System.out.println(box.sharedToy); // O
	  //System.out.println(box.secretToy); // X
		System.out.println(box.familyToy);
	
	     System.out.println("공유 장난감: " + box.sharedToy); 
	       
	     System.out.println("가족 장난감: " + box.familyToy); 
	}

}
/*연습문제1)   
패키지명 : com.company.java010_ex
클래스명 :  ModifierEx001


Q1.   자바의 접근자를 넓은범위에서 좁은범위로 적으시오.
Q2.   public class ToyBox 를 다은 문제 단계별을 이용해서 작성하시오.
Q3.   public class Modifier001_Friend 를  작성하고 문제를 풀으시오.


[문제 1]
길동이는 장난감 상자에 블록을 넣었어요. 이 블록은 누구나 꺼내서 놀 수 있어요.  
자바 코드에서 이 장난감은 어떤 modifier로 선언되어야 할까요?

public class ToyBox {
    _____ String sharedToy = "블록";
}


[문제 2]
길동이는 로봇 장난감을 혼자만 갖고 놀고 싶어요.  
다른 친구들이 이 장난감을 못 보게 하려면 어떤 modifier를 써야 할까요?

public class ToyBox {
    _____ String secretToy = "로봇";
}

[문제 3]
길동이의 형이 같은 집에 살고 있어서 퍼즐 장난감을 같이 쓰고 싶어요.  
형이 퍼즐을 볼 수 있게 하려면 어떤 modifier를 써야 할까요?

public class ToyBox {
    _____ String familyToy = "퍼즐";
}

[문제 4]
다음은 친구가 장난감 상자를 열어보는 코드입니다.  
친구가 볼 수 있는 장난감은 무엇일까요?

public class Friend {
    public static void main(String[] args) {
        ToyBox box = new ToyBox();
        System.out.println(box.sharedToy);
        System.out.println(box.secretToy);
        System.out.println(box.familyToy);
    }
}
*/