package spring003_di;

public interface IceCream {
		void taste(); 
}

/*
 1-1. 스프링프로젝트 만들어주세요~!  
      ※  힌트)    
        1. dynamic web project - spring003
        2. configure  - [Convert to Maven Project]
        3. spring      - add Spring project Nature 
        4. java se-11 / project facts, build path

    1-2. pom.xml 에 dependency 설정
      - junit  / spring-context   / spring-test   / lombok

    1-3. 인터페이스와 클래스는 다음과 같다. [ IceCream , White ,  Choco ,IceCreamShop   ]
   - 각클래스 간의 의존관계  [설정파일]을 통해 [컨테이너]가 자동으로 연결
   [com.thejoa703.ioc]
    [IceCreamShop]  (사용)→    [<<interface>>IceCream]   
       ↑(삽입)                      ↑(구현)          ↑ (구현)   
    [beans.xml ]  (생성)→    [White         /       Choco]

   ``` 
   public interface IceCream {     void taste();    }

   public class White implements IceCream {
       public void taste() {  System.out.println("바닐라 아이스크림은 부드럽고 달콤해요!"); }
    }
   public class Choco implements IceCream {
      public void taste() {    System.out.println("초코 아이스크림은 진하고 풍부해요!");   }
   }

   public class IceCreamShop {
      private String   name;
      private IceCream iceCream;
      
      public void open() {
         System.out.print("아이스크림 가게 오픈! 오늘의 맛은: ");
         iceCream.taste();
      }
   }   
   ```

 
    1-4.  beans.xml 파일 만들기
      White 빈등록 
      Choco 빈등록  
      IceCreamShop 빈등록  - name에는 베라31,   iceCream  choco로 등록

   1-5. 테스트파일만들어서 jUnit로 테스트하기
 */



