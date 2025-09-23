package com.company.java010_Ex;

class Student {
    String name = "홍길동";     //인스턴스변수 -heap area - new O - 생성자 O - this(각각)
    int kor = 90;               //인스턴스변수 - heap area - new O - 생성자 O - this(각각)   
    int eng = 85;                //인스턴스변수 - heap area - new O - 생성자 O - this(각각) 
    static int studentCount = 0;    //클래스변수 - method area - new X - 생성자 X > static (now)

    //static int total = kor + eng;   // 클래스변수 -  method area - new X - 생성자 X > static (now)
    									// static 이 붙은곳에는 인스턴스변수를 사용할수 없다.

    static int maxScore = 100; // 클래스 변수 - method area - new X - 생성자 X > static (now)     
    //인스턴스 메서드 - heap area - new O - 생성자 O 
    
    public Student() { 	  // 생성자
        studentCount++;   // static 사용가능      
    }
    //인스턴스 메서드 - heap area - new O - 생성자 O 
    public int getTotalScore() {
        return this.kor + this.eng;        
    }
    //클래스 메서드 - method area - new X - 생성자 X - Sawon3.showSu() > 바로사용가능
    public static void showStudentCount() {
        System.out.println("전체 학생 수: " + studentCount);  
    }
    //클래스 메서드 - method area - new X - 생성자 X - Sawon3.showSu() > 바로사용가능
   public static void showName() {
         //System.out.println(name); //static에는 인스턴스 변수 출력 불가  
   }
   //인스턴스 메서드 - heap area - new O - 생성자 O  
    public void showInfo() {
        System.out.println("이름: " + this.name);            
        System.out.println("총점: " + this.getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     // 1) new 번지, 객체생성 2) 생성자초기화 3) s1 번지
        Student s2 = new Student();     // 1) new 번지, 객체생성 2) 생성자초기화 3) s2 번지

        s1.showInfo();                  
        Student.showStudentCount();    

	}

}
/* 초기화 :  					기본값       				명시적초기화     						   초기화블록      생성자
  studentCount     			 0							= 0	      						       x0 
  maxScore          		 0							= 100            					   x100
  s1{name, kor, eng}      {name=null, kor=0, eng=0} {name=홍, kor=90, eng=85}				   x		{name=홍, kor=90, eng=85}
  s2{name, kor, eng}      {name=null, kor=0, eng=0} {name=홍, kor=90, eng=85}				   x		{name=홍, kor=90, eng=85}
  
  
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
>student.class / MemberVarEx002.class
>static : Student.maxScore, Student.showStudentCount(), Student.showName()
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
							studentCount();
							getTotalScore();
2번지 {name=홍, kor=90, eng=85 / ← s2 [2번지] 38번째줄
 getTotalScore(); studentCount()} 
1번지 {name=홍, kor=90, eng=85 / ← s1 [1번지] 38번째줄
 getTotalScore(); studentCount()} 
					   | main
------------------------------------
 */


/*
패키지명 : com.company.java010_ex
클래스명 : MemberVarEx002

-- class Student 작성해주세요

- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
- 문제 3. 오류가 발생하는 이유를 설명하시오.
- 문제 4. runtime data area 위치영역 그림그리기

class Student {
    String name = "홍길동";        
    int kor = 90;                  
    int eng = 85;                 
    static int studentCount = 0;    

    static int total = kor + eng;   

    static int maxScore = 100;     

    public Student() {
        studentCount++;             
    }

    public int getTotalScore() {
        return kor + eng;        
    }

    public static void showStudentCount() {
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {
         System.out.println(name);  
   }

    public void showInfo() {
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}
*/