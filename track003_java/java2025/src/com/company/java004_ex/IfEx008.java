package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("성적처리 프로그램입니다.");

        System.out.print("학번을 입력하세요 > ");
        String Id = scanner.nextLine();

        System.out.print("국어점수를 입력하세요 > ");
        int kor = scanner.nextInt();

        System.out.print("수학점수를 입력하세요 > ");
        int math = scanner.nextInt();

        System.out.print("영어점수를 입력하세요 > ");
        int eng = scanner.nextInt();

        int total = kor + math + eng;
        double avg = total / 3.0;

        // 합격 여부
        String pass = (avg >= 60 && kor >= 40 && math >= 40 && eng >= 40) ? "합격" : "불합격";

        // 장학생 여부
        String jang = (avg >= 95) ? "장학생" : " 비장학생";

        // 레벨
        //삼항연산자
        String level = (avg >= 90) ? "수" : (avg >= 80) ? "우" : (avg >= 70) ? "미" : (avg >= 60) ? "양" :"가" ;
        
        //if 	  (avg >= 90) {level = "수";}
        //else if (avg >= 80) {level = "우";}
        //else if (avg >= 70) {level = "미";}
        //else if (avg >= 60) {level = "양";}
        //else 	  {level = "가";}

        // 출력
        System.out.println("===================================================================================");
        System.out.println(" 학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생");
        System.out.println("===================================================================================");
        System.out.printf("%s   %d   %d   %d   %d   %.2f   %s   %s   %s\n", Id, kor, eng, math, total, avg, pass, level, jang);
    }
}
/* ver-2
public class IfEx008_1

public static void main(String[] args){

//변수
String std;
int kor, eng, mat, total;
double avg;
String pass='불합격', lv="가", jang="-";
Scanner scanner = new Scanner(System.in);

//입력
System.out.print("학번 입력 >"; std = scanner.next();
System.out.print("국어점수 입력 >"; kor = scanner.nextInt();
System.out.print("영어점수 입력 >"; eng = scanner.next();
System.out.print("수학 점수 입력 >"; mat = scanner.next();

//처리
//1. 총점 구하기
total = kor +eng +mat;
//2.평균 구하기
avg = total/3.0;
//3.평균이 60점 이상이고 각 과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
if(avg>=60 && kor >=40 && eng>=40 && mat>=40 ) {pass="합격";}
//4.평균이 95점 이상이면 장학생
if(avg>=95){jang = "장학생";}
//5. 평균이 90점 이상이면 수, 80점 이상이면 우, 70점 이상이면, 미, 60점 이상이면 양, 아니라면 가
if(avg>=90) {lv+"수";}
else if(avg>=90) {lv+"우";}
else if(avg>=90) {lv+"미";}
else if(avg>=90) {lv+"양";}

//출력
        System.out.println("===================================================================================");
        System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t", "학번","국어","영어","수학","총점","평균","합격여부","레벨","장학생");
        System.out.println("===================================================================================");
        System.out.printf("%s-5s\t%-5d\t%-5d\t%-5d\t%-5d\t%.2f\t%-5d\t%-5d\t%-5d\n", Id, kor, eng, math, total, avg, pass, level, jang);
 */
