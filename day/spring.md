1. jsp(mvc1, mvc2) + oracle
2. spring
3. spring boot (mybatis jpa)

■ 스프링
----------------------
#1. SPRING 특징
----------------------
면접에서 많이나오는 문제 

▶ STEP0 . JSP
1. MVC1 - JSP (CONTROLLER) 스파게티소스 (섞인)
2. MVC2 - SERVELT (CONTROLLER) 부품조립  ☆

▶ STEP1. SW 재사용방안들
Q. SW 재사용
- copy& paste, 복사붙여넣기
- 메서드
- 클래스의 사용
    <<interface>>
    BoardService - exec()
     △..... BLIST
     △..... BInsert
팀프로젝트의 고민 

▶ STEP2. 프레임워크 
2-1 프레임워크? ☆
[디자인패턴 + 라이브러리 = 프레임워크]
1. 디자인패턴 (가이드라인)
2. 라이브러리 (특정기술구현을 라이브러리의 형태)
        $("#id").on("click",); , $.ajax()

- 소프트웨어 개발의 뼈대역할
- 애플리케이션들의 최소한의 공통점을 찾아서 하부구조를 제공
  개발자들은 개벌에 집중
- 제공괴는 유틸의 모음, 레시피들의 모음

2-2 프레임워크의 주체
프레임워크는 [프레임워크]에서 실행흐름을 담당.
 new를 앞으로 스프링이?
※ 라이브러리는[개발자]가 실행흐름을 담당.

3. 프레임워크의 특징
★ IOC (Inversion of Control) 제어의 역전 면접문제받고 10번이상은 연습해야할곳
- 인스턴스의 생성~소멸까지 개발자가 아닌 컨테이너가 하는것
- PJO(Plain old java object)
  필요에 따라 재활용 될수 있는 방식으로 설계된 객체

Sample
Class A {}
A  a1  = new A();

생성 → 초기화 → 서비스 → 소멸

※ IOC가 아닌경우
 [개발자 생성 → Class BList
        개발자 생성 → Class BINSERT]

※ IOC인 경우
 [개발자 생성 ← Class BList
        개발자 생성 ← Class BINSERT
            개발자 생성 ← Class BEdit] 컨테이너

★ IOC 분류
DI( Dependency Injection : 의존성 주입 )
  - 각클래스 간의 의존관계 [설정파일]을 통해 [컨테이너]가 자동으로 연결

4. 프레임워크 구성기능요소
[  AOP  ]  [ ORM - DAO-Mybatis,Jpa ] [Spring web MVC]   // AOP CCTV 로그기록 남길때
[                        Spring Core             ] 

실습1)  spring1     [◎ 프로젝트명 : spring001]
  1. 스프링 3버젼 다운로드 Eclipse 4.21의 전체 배포
  2. 다운로드 경로 
      https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3
  3. 압축풀기 (공백, 한글, 특수기호:x, 여기에 압축풀기)
  4.  E:\hyojung\6_spring\sts-bundle\sts-3.9.18.RELEASE
      > STS.exe
  5.  순수 스프링버젼
    1. dynamic web project - spring001
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path  - fac


실습2) spring2[ ◎프로젝트명 : spring002]]
    ▶ 1. 롬복 셋팅
    ▶ 2. IOC + DI 관계
    
    1. 프로젝트만들기
    2. 롬복 다운로드 VAR  lombok-1.18.18.jar    -   cmd 관리자 모드로  dir 에 폴더가 있는지 확인  
    java -jar lombok-1.18.18.jar 실행 명령어
    3. 롬복설치
    4. 스프링에서 사용하기

---
5. ioc + di
    DI ( Dependency Injection : 의존성 주입)
    - 각클래스 간의 의존관계 [ 설정파일]을 통해 [컨테이너]가 자동으로 연결


#1. 프레임워크
    - 소프트웨어 개발의 뼈대역할
    - 실행흐름 담당
#2. IOC
    - 인스턴스 생성~ 소멸까지 생명주기를 스프링이 관리
#3. DI
    각 클래스의 의존관계를 [설정파일]을 통해서 컨테이너가 자동연결
#4. BEAN
    - 관리되는 객체

#5. 예시)

class MyA{
    private String name;
    private Animal ani;

    public MyA(String name, Animal ani){
        this.name=name;
        this.ani = ani;
    }
}
1. setter 방식
<bean id="myA" class="com.company.MyA">
    <property name="name" value="sally"/>
    <property name="ani" ref="cat"/>
</bean>

2. 생성자 방식
<bean id="myA" class="com.company.MyA">
    <constructor-are index="0"  value="sally"/>
    <constructor-are index="1"  ref="ani"/>
</bean>

3. di-properties
name=sally
ani=cat
<context:property-playholder location="classpath:config/test.properties"/>

<bean id="myA" class="com.company.MyA">
    <constructor-are index="0"  value="${name}"/>
    <constructor-are index="1"  ref="${ani}"/>
</bean>

------------------
#3. Bean
------------------

1.  xml vs Annotation
>> xml : 운영
>> Annotation : 개발


2. @Component
-  @Component 일반적인 컴포넌트 <bean> 스프링이 관리하는 객체
-  @Component 구체화된 형식
    @Controller 웹요청받아서 응답
    @Service    서비스 레이어, 비즈니스 로직
    @Repository 데이터베이스

3.  Bean 의존관계주입
    1. @Autowired - 정밀한 의존관계
        -프로퍼티, setter, 생성자,, 적용
    2. @Qualifier - 동일한타입의 bean 구분
    3. @Value 단순값
    4. @Resource - 자원연결(    . properties)

<!-- 수정 -->
<!-- 수정 -->
<dependencies>
   <!-- https://mvnrepository.com/artifact/junit/junit -->
   <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.27.RELEASE</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.3.27.RELEASE</version>
      <scope>test</scope>
   </dependency>
   
   <!--  MYSQL + CONNECTOR-J       -->
   <dependency>
      <groupId>com.oracle.database.jdbc</groupId>
      <artifactId>ojdbc11</artifactId>
      <version>21.9.0.0</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.28</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
       <version>4.3.20.RELEASE</version>
   </dependency>
         
   <!-- MYBATIS -->
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.6</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis-spring</artifactId>
       <version>2.0.6</version>
   </dependency>
   
   <!-- webmvc -->
   <!-- webmvc -->
   <!-- webmvc -->
      <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>3.2.17.RELEASE</version>
   </dependency>
   
    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
         
   <!-- LOMBOK  -->      
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.18</version>
       <scope>provided</scope>
   </dependency>            
        
   <!-- AOP -->   
   <!-- AOP -->      
   <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjrt</artifactId>
       <version>1.7.3</version>
      <!-- <scope>runtime</scope> -->
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>1.7.3</version>
       <!-- <scope>runtime</scope> -->
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aop</artifactId>
       <version>4.3.28.RELEASE</version>
   </dependency>
         
         
   <!-- HikariCP -->
   <!-- HikariCP -->
   <!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
   <dependency>
       <groupId>com.zaxxer</groupId>
       <artifactId>HikariCP</artifactId>
       <version>2.7.4</version>
   </dependency>
      
   <!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4 -->
   <dependency>
       <groupId>org.bgee.log4jdbc-log4j2</groupId>
       <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
       <version>1.16</version>
   </dependency>
   <!-- HikariCP -->
   <!-- HikariCP -->
   <!-- HikariCP -->          
         
         
</dependencies>
<!-- 수정 -->
<!-- 수정 -->  






