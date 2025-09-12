### 🔰 나의 포트폴리오
나의 배움 순서
### JAVA
```
줄바꿈 없이 출력하는 명령어는 `System.out.print()`이다.  
줄바꿈이 포함된 출력은 `System.out.println()`이다.  
줄바꿈을 위한 특수문자는 `\n`이다.  
포맷 형식으로 문자열과 숫자를 출력할 때 사용하는 명령어는 `System.out.printf()`이며,
형식은 문자 : %s  정수 : %d 실수 : %f 이다.  
```
```
### 변수
변수란
1. 값?
- 토큰 : 특정의미를 가진문자
- 리터럴, 키워드, 식별자, 연산자,구분자

  System.out.println("hello");

2. 값의 보관
- 값의 보관 == 메모리확보
- 변수 : 변하는 수 (오픈박스) ,  한개의 값
- 상수 : 변하지 않는(상) 수  (밀봉박스)
- 변수이름규칙 :   $_소문자7

3. 변수사용법
   자료형  변수명   

   int a; - int  정수 1,2,3  a[ ]
   double b; - double  실수 1.23  b[ ]
   
   a=10;     a[10]
   a=20;     a[20]
※ 상수    final   int    JAVA_HOME ;   - 수정못함!
```
```
### 자료형
4. 자료형
1) 자료형의 구분
- 기본형 : 실제값 저장
- 참조형 : 주소값 저장 ( String )

2) 기본 자료형
- 논리형 - boolean true/false
- 정수형 - byte(1byte) -short(2byte) -int(4byte) ★ -long(8byte)
               long 1 = 4L;
- 실수형 - float(4byte) - double(8byte)
      float f = 3.14f  double d = 3.14
```
```
5. 대입연산자
        a=10; b=3;
        System.out.println("1: " +    (a+=b) );  //1)a+b 2_ a=13     a+=b   a+b=a
        System.out.println("2: " +    (a-=b) );  //1)a+b 2_ a=13     a-=b   a-b=a
        
6. 단항 
    
       // 함수 있는곳 먼저  al = 1 , ; al >> ++(증가) >> preintln  >> 2
       //                 al = 1 , ++(증가) >> al >> println >> 1 다음에 사용시 은 2의를 갖게됨
        int a1 = 1, b1=1, c1=1, d1=1;
        System.out.println(++a1); //2 증가출력
        System.out.println( a1); //2 출력
        System.out.println(b1++); //1 출력증가
        System.out.println(b1); //2
        
        System.out.println(--c1); //0 감소출력
        System.out.println(c1); //0 
        System.out.println(d1--);//1 출력감소
        System.out.println(d1); //0
7. 형식
1. 1형식 
    System.out.println(" ■ 1형식 - 조건을 무조건 읽음 ");
		int num = 0;
        num 이(가) 1이라면 1이라면 one , 2이라면 two , 3이라면 three
        //if (num 가 1이라면 {one})
        //if (num 가 2이라면 {two})
        //if (num 가 3이라면 {three})
        if( num == 1) {System.out.println("one");  }
        if( num == 2) {System.out.println("two");  } // 1에서 이미 충족이 되어 조건을 처리했는지 알수없음
        if( num == 3) {System.out.println("three");  } // 1에서 이미 충족이 되어 조건을 처리했는지 알수없음

2. 2형식
    System.out.println(" ■ 2형식 - 맞다/틀리다 ");
		num = 0;
		if( num==1) {System.out.println("one");  }
		else {       System.out.println("one이(가) 아니다"); }

3.  다형식
    System.out.println(" ■ 다형식 ");
		num=0;
			 if( axe == 1) {System.out.println("one"); }
		else if( axe == 2) {System.out.println("two"); }
		else if( axe == 3) {System.out.println("three"); }
		else {              System.out.println("1,2,3의 숫자가 입력되지않았습니다.");}

4. 문자를 입력 받을경우
    
    변수 char 을 사용하며 (char ch='\u0000';)
    입력을 받을때 스캐너를 사용하며, next().charAt(0)을 사용한다.
```
프로그램 코드 실행흐름
  - 위 → 아래, 왼쪽 → 오른쪽
  - 제어문은 개발자가 원하는 방향으로 변경할수 있도록 도와줌.

2. 제어문의 종류
    조건문      : if , switch  
    반복문      : for# , while # , do while #
    제어키워드 : break , continue


1) for( 초기문; 조건문; 증감문  ){  반복해야할 내용  }    -  반복횟수를 알고 있을때
2) while( 조건문 ){    반복해야할 내용 }  - 반복횟수 모를때   예)게시판
   
   초기문; 
   while( 조건문  ){  반복해야할 내용        증감문; } 

3) do{  반복해야할 내용  }while( 조건문  ); - 무조건 1번은 실행

   초기문; 
   do{  반복해야할 내용        증감문; }while( 조건문  ); 

4) 무한반복
   for(;;){//break; continue}
   
6) break/continue
```
```
### array
. 배열?
- [같은 타입]의 데이터를 [연속된 공간에 저장]하는 자료구조
- 각 데이터의 저장위치 [인덱스]를 통해서 접근
```
```
- package 파일명
- public class A000 
<!--(public)어디에서든지 접근 가능 , (class)부붐객체, (클래스 이름)A000-->
 - public static void main(String[] args){
 <!--(pupblic)어디서든지 접근 가능, (static) 바로사용가능 메모리, (void mainString[] args) 전원 옵션-->

2025.09.11
- Q.질문
package com.company.java006Ex; public class ArrayEx008 { public static void main(String[] args) { String[] name= {"아이언맨" ,"헐크","캡틴","토르","호크아이"}; int[] kor= {100,20,90,70,35}; int[] eng= {100,20,90,70,35}; int[] mat= {100,20,90,70,35}; int[] aver=new int[5]; String[] pass = new String[5]; String[] jang = new String[5]; for (int i = 0; i < name.length; i++) { aver[i] = (kor[i] + eng[i] + mat[i]) / 3; if (aver[i] >= 60) {pass[i] = "합격";} else {pass[i] = "불합격";} if (aver[i] >= 95) {jang[i] = "장학생";} else {jang[i] = "비장학생";} } System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"); System.out.println("이름 국어 영어 수학 평균 합격여부 장학생"); System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"); for(int i=0; i<name.length; i++) {System.out.printf("%s\t %d\t %d\t %d\t %d\t %s\t %s\n", name[i], kor[i],eng[i],mat[i],aver[i],pass[i],jang[i]);} System.out.println("\t"); }//end main }//end class 해당 코드의 결과값은 항상 동일한거야? 아니면 계속 바뀔수도 있는거야?

- A.답
좋은 질문이에요! 👀 이 Java 프로그램의 결과값은 항상 동일하게 출력됩니다.

🔍 이유는 다음과 같아요:
name, kor, eng, mat 배열에 들어 있는 값들이 고정된 상수값이기 때문에,

aver, pass, jang 배열은 이 고정된 값들을 기반으로 계산되며,

프로그램 실행 시 외부 입력이나 랜덤 요소가 전혀 없기 때문에, 실행할 때마다 항상 같은 결과를 출력하게 됩니다.

💡 예외가 생기려면?
결과가 바뀌려면 다음 중 하나가 있어야 해요:

사용자 입력 (Scanner 등으로 값을 입력받는 경우)

랜덤 값 (Math.random() 또는 Random 클래스 사용)

외부 데이터 (파일, DB, API 등에서 값 가져오기)

지금 코드에서는 그런 요소가 없으니, 결과는 항상 동일하죠.

혹시 이 코드를 조금 더 동적으로 바꾸고 싶다면, 사용자 입력이나 랜덤 요소를 넣어볼 수도 있어요. 원해? 😄

- Q.질문
좋아 너가말한데로 name,kor,eng,mat의 값이 아이언맨, 헐크, 캡틴, 토르, 호크아이 와 100,20,90,70,35 값을 내가 정해두었는데 이거에서 변칙적인 값이 나올수도 있는건가?


- A.답
아주 정확하게 짚었어요! 👌 지금처럼 name, kor, eng, mat 배열에 직접 값을 지정해두었을 경우, 프로그램을 실행할 때마다 항상 같은 결과가 나옵니다. 즉, "변칙적인 값"이 나올 가능성은 없습니다.

✅ 왜 결과가 고정되는가?
배열에 들어 있는 값들이 하드코딩되어 있음 → kor = {100, 20, 90, 70, 35} 등

외부 입력이나 랜덤 요소가 없음 → 사용자 입력 (Scanner)이나 Math.random() 같은 코드가 없어요

반복문은 단순히 고정된 데이터를 순회하며 계산만 함 → 평균, 합격 여부, 장학생 여부 모두 고정된 계산 결과

🔄 변칙적인 결과를 만들고 싶다면?
다음과 같은 방식으로 코드를 바꾸면 매번 다른 결과가 나올 수 있어요:

1. 랜덤 점수 생성
java
import java.util.Random;
Random rand = new Random();
int[] kor = new int[5];
int[] eng = new int[5];
int[] mat = new int[5];
for (int i = 0; i < 5; i++) {
    kor[i] = rand.nextInt(101); // 0~100 사이 점수
    eng[i] = rand.nextInt(101);
    mat[i] = rand.nextInt(101);
}
2. 사용자 입력 받기
java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
for (int i = 0; i < 5; i++) {
    System.out.print("국어 점수 입력: ");
    kor[i] = sc.nextInt();
    // 영어, 수학도 동일하게 입력받기
}
이렇게 하면 실행할 때마다 결과가 달라질 수 있어요. 혹시 랜덤 버전으로 전체 코드를 바꿔보고 싶어? 내가 도와줄게 😄

변칙적인 값을 원한게 아니야 내가 워하는 출력 구문이 어디인지를 묻고싶은거야 나는 i라는 변수에 ++fkrh sjgdmsrjqkRdp djqtsmsrjrkxdmsrjf
아하! 이제 정확히 이해했어요 😄 당신이 궁금했던 건 "어떤 출력 구문이 i라는 반복 변수에 따라 실행되는지", 즉 i가 증가하면서 어디서 출력이 발생하는지였군요.

🔍 i가 영향을 주는 출력 구문은 여기입니다:
java
for(int i=0; i<name.length; i++) {
    System.out.printf("%s\t %d\t %d\t %d\t %d\t %s\t %s\n", 
        name[i], kor[i], eng[i], mat[i], aver[i], pass[i], jang[i]);
}
💡 설명:
이 for 반복문은 i = 0부터 i < name.length까지 반복하면서,

각 인덱스에 해당하는 학생의 이름, 점수, 평균, 합격 여부, 장학생 여부를 한 줄씩 출력합니다.

즉, i가 0일 때는 아이언맨의 정보가 출력되고, i가 1일 때는 헐크의 정보가 출력되고... 이런 식으로 5번 반복됩니다.

📌 출력 예시:
코드
아이언맨     100     100     100     100     합격  장학생
헐크       20      20      20      20      불합격     비장학생
캡틴       90      90      90      90      합격  장학생
토르       70      70      70      70      합격  비장학생
호크아이     35      35      35      35      불합격     비장학생
즉, i는 학생 인덱스를 의미하는 반복 변수이고, 그에 따라 System.out.printf(...) 구문이 학생별로 한 줄씩 출력을 담당하는 거예요.

혹시 이 출력 형식을 더 예쁘게 바꾸고 싶거나, 다른 방식으로 정렬하고 싶다면 내가 도와줄게! 😊

- Q.질문
아 이해했어, 0에는 아이언맨 100 100 100100이 0~4까지의 정보가 들어있는 i[]를 만든거였구나


- A.답
맞아요! 완전히 이해하셨어요 👏 i는 반복문에서 인덱스 역할을 하면서, 각 배열 (name, kor, eng, mat, aver, pass, jang)의 같은 위치의 데이터를 동시에 꺼내오는 열쇠 같은 거예요.

🔑 예를 들어 볼게요:
i = 0일 때 → name[0] = "아이언맨", kor[0] = 100, eng[0] = 100, mat[0] = 100

i = 1일 때 → name[1] = "헐크", kor[1] = 20, eng[1] = 20, mat[1] = 20

...

i = 4일 때 → name[4] = "호크아이", kor[4] = 35, eng[4] = 35, mat[4] = 35

이렇게 i가 0부터 4까지 증가하면서, 각 학생의 정보를 한 줄씩 출력하는 구조예요. 그래서 i는 단순한 숫자가 아니라, 학생 한 명의 전체 정보를 연결해주는 인덱스 역할을 하고 있는 거죠.
```

혹시 이걸 객체로 바꿔서 더 깔끔하게 관리하는 방법도 궁금해? Java에서는 class를 활용하면 훨씬 구조화된 코드가 될 수 있어요 😄
