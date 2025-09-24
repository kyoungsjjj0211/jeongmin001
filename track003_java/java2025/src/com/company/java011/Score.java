package com.company.java011;

public class Score {
    private String name;
    private int kor, eng, math, total;
    private double aver;
    private String p, s, rank;

    public Score() {}

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    public void setName(String name) { this.name = name; }
    public void setKor(int kor) { this.kor = kor; }
    public void setEng(int eng) { this.eng = eng; }
    public void setMath(int math) { this.math = math; }

    public void process_total() { this.total = kor + eng + math; }
    public void process_avg() { this.aver = total / 3.0; }
    public void process_p() {
        if (aver < 60) this.p = "불합격";
        else if (kor < 40 || eng < 40 || math < 40) this.p = "재시험";
        else this.p = "합격";
    }
    public void process_s() { this.s = aver >= 95 ? "장학생" : ""; }
    public void process_rank() {
        int stars = (int)(aver / 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stars; i++) sb.append("*");
        this.rank = sb.toString();
    }

    public static void info() {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름   국어   영어   수학   총점   평균   합격여부   장학생   랭킹");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }

    public void show() {
        process_total();
        process_avg();
        process_p();
        process_s();
        process_rank();

        System.out.printf("%-5s\t%-5d\t%-6d\t%-6d\t%-6d\t%-8.2f\t%-8s\t%-8s\t%-10s\n",
                name, kor, eng, math, total, aver, p, s, rank);
    }
}

/*
 * 
 * calc 지우고 show에서 한번만 출력되도록
연습문제3)  지정접근자
패키지명 : com.company.java011_ex
클래스명 : ModifierEx3
다음과 같이 코드를 작성하시오.

ㅁ출력된화면
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
이름   국어   영어   수학   총점   평균   합격여부   장학생   랭킹
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
iron   100   100   100   300   100.00   합격   장학생   **********
hulk   20   50   30   100   33.33   불합격      ***





ㅁ주어진조건
public class Score{
   private String name;
   private int kor, eng, math , total;
   private double aver;
   private String p  , s  , rank;
} // java011_ex에 설정해주세요!

public class ModifierEx3{    // java011 패키지에 설정해주세요.
   public static void main(String[] args) {
      Score iron = new Score();     
      Score hulk = new Score("hulk" , 20,50,30);    
      
      // Score.info()위에 메서드작성해주세요!  ##
      // setter를 이용해주세요!
      iron.setName("iron"); iron.setKor(100); iron.setEng(100); iron.setMath(100);
      
      Score.info();     // 클래스메서드
      iron.show();          
      hulk.show();   
   }

}

Score.info() 사용시화면
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
이름   국어   영어   수학   총점   평균   합격여부   장학생   랭킹
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

*/


/*
// 1. 생성자 (defult / name, kor, eng, math / all arg)
// 2. 상태확인(toString)
// 3. getters/setters
// 4. Score.info(){} [공용] 클래스메서드 public static 클래스명.메서드명(){}
// 5. iron.show(); hulk.show(); [각각, this] 인스턴스메서드
// 6. total 총점함수, ave 평균함수, p 합격여부 함수, s 장학생함수, rank * 별체크 함수 (etc)
// 
 */
