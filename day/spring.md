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

4. component-scan
<context:component-scan base-package="경로설정"/>


-----------------------
#4. DB
-----------------------
1. DataSource
+ SimpleDrdiverDataSource - 가장단순한버전

2. mybatis
- sql을 별도로 파일분리해서 관리
- orm (object relational mapping) 프레임워크

3. 설정내용
root-context.xml 환경정보설정
db.propertis     db정보설정
SqlSessionFactoryBean : SqlSession 생성 및 관리
SqlSesion             : sql 실행, 트랜잭션
mapper.xml


#6. Upload

1. model
    > table : 이미지 경로필드

SQL> desc sboard1; 
name       null?  type
------------------------------------
     ID             NOT NULL    number
     APP_USER_ID    NOT NULL NUMBER  
     BTITLE         NOT NULL    VARCHAR2(1000) 
     BCONTENT       NOT NULL  CLOB  
     BPASS          NOT NULL    VARCHAR2(255)
     BFILE                      VARCHAR2(255)
     BHIT                       NUMBER(10)
     BIP            NOT NULL    VARCHAR2(255) 
     CREATE_AT                  TIMESTAMP(6)




    >dto : bfile

  private String bfile;         // BFILE (default: 'no.png')

    >dao : insert, update

   <insert     id="insert2"  parameterType="Sboard1Dto">
   insert into sboard1 ( ID    , APP_USER_ID , BTITLE , BCONTENT , BPASS , BFILE , BIP)  
   values (sboard1_seq.nextval ,#{appUserId}, #{btitle},#{bcontent},#{bpass},  #{bfile} , #{bip})
   </insert>

   <update     id="update2"  parameterType="Sboard1Dto">
	update  sboard1  
	set     BTITLE=#{btitle} , BCONTENT=#{bcontent}, BFILE=#{bfile} 
	where   id=#{id}   and BPASS= #{bpass} 
    </update>


2. view
    form : encType = "multipart/form-data"
        method="post"
        <input type="file" />

3. controller
    pom.xml
 <!--img upload start-->
<!--img upload start-->
       <!-- commons-fileupload -->
   <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
   </dependency>

   <!-- commons-io -->
   <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.11.0</version>
   </dependency>
<!-- img upload end -->
<!-- img upload end -->  
   
         <!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
    
        

    servlet-context.xml
    FilUplad.java


    UploadUtil.java - service
    Controller.java - service
Q1> 이미지업로드기능추가
Q2> 수정시 기존에 파일을 바꾸지 않으면 기존의 올린값이 나오고, 
               파일을 올리면 값 바꾸게 처리    
    


appuser
Q1. table 에 추가
    1) ufile varchat2(255) default 'member.png'
    2) dto
    3) dao - insert / update


Q2. 멤버가입시 이미지올리기 가능

Q3. 수정시 이미지 수정가능


--
Upgrade1)

문제점발견 : 사용자들이 이미지를 올리는 것을 부담스러워함.
해결방안 : 
    회원가입시
    만약에 사용자가 이미지를 안올리면  7개의 유저이미지가 랜덤하게 올라가게 만들기


    if() {만약 파일을 올린게 있다면.... 파일올리기}
    else{ 아니라면 랜덤하게 이미지 경로추출해서 setUfile()}


---------------------------
#7. Ajax
---------------------------
1. 글 검색
2. 아이디중복검사
3. 유저 수정, 삭제

2. 아이디중복검사
1) model
> table - sql :  해당 아이디가 있는지 검색 - sql 작성 
  ㄴ//오라클 내에서 id = email  select * from appuser where email = '1@1';
아이디 중복 검사
  
> dto : 
> dao : public int iddouble(String email);

sql
ㄴmapper
  <select resultType="int" id="iddouble" parameterType="String">
	     select count(*) cnt from appuser where email=#{email}
	 </select>

ServiceImpl
@Override public int iddouble(String email) {return dao.iddouble(email); }

service
public int iddouble(String email);


2) controller
@RestController //@Controller + @ResponseBody

http://localhost:8181/spring005_board/selectSearch?search=t


3) view



list.jsp Ajax
if(keyword.length === 0){
            	$("#resultArea tbody").empty().append('<tr><td colspan="5">검색어를 입력하세요.</td></tr>');
            	return;
            }else{ 
            	
            	$.ajax({
            		url:"${pageContext.request.contextPath}/selectSearch",
            		type:"GET",
            		data:{ search : keyword },
            		success:function(res){
            			console.log(res);
            			 $("#resultArea tbody").append(res); 
            		}
            	});
       		  }


---------------------
#8. AOP + Mybatis
---------------------
1. AOP 개요
STEP1)
- 핵심기능 : (비지니스로직)
- 부가기능 : 핵심기능(비지니스로직)을 도와줌
>> AOP - 부가기능

  @Controller    /list.do
          ■ 부가기능                    ■ 부가기능
         [시작]-  Service  (전체리스트뽑아주는 service) -[끝]
             |  처리뷰   
             ↓
         [시작]- Repository(전체리스트뽑아주는 sql   )  -[끝]


STEP2) Aspect
- 기능분리
- 런타임 시 필요한 위치에 동적으로 처리
        Advice + PointCut = Aspect
         ↓             ↓
         부가기능정의   적용부위

STEP3) 용어
Target   -  대상
Advice   -  부가기능
PointCut -  적용할 타겟의 메서드를 선별하는 정규식
Weaving  -  Target에 부가기능 처리(삽입)하는 과정


STEP4) 
<<BEFORE>>         
application         
[
 [  비지니스로직    ]
 [  보안, 인증, 로직]
]

<<AFTER>>
application         
[
 **********************           
 *[   PointCut 적용부위 ]    Weaving  →    [  비지니스로직    ]
        ↑
 *[   Advice 부가기능   ] *
       ↑
 *[  보안, 인증, 로직   ] *
 *   [Aspect]
 **********************  
]
Target   -  대상
Advice   -  부가기능
PointCut -  적용할 타겟의 메서드를 선별하는 정규식
Weaving  -  Target에 부가기능 처리(삽입)하는 과정


2. AOP 특징
>> 프록시 기반 aop를 지원
- 프록시는 advice(부가기능)을 target(대상객체)에 적용하면서 생성되는 객체
- Target(대상객체)를 감싸는 프록시는 런타임 시에 생성됨.
- 타겟객체에 대한 호출을 intercept(가로채서)해서  
  A. 부가기능 수행 후 타겟의 핵심기능 로직호출(전처리)  , 
  B. 타겟의 핵심기능 로직호출  부가기능 수행  (후처리) 
  

   호출 --->   [ Proxy  [Target]  ]

3. 구현방식
1) xml
2) annotation

실습1) pom.xml
1. AspectJ runtime   -> AspectJrt
2. AspectJ weaver    -> AspectJweaver
3. Spring aop        -> spring-aop
4. api 문서
https://www.eclipse.org/aspectj/doc/next/runtime-api/

<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.7.3</version>
    <!-- <scope>runtime</scope>  -->
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



실습2)  Advice + PointCut = Aspect
  부가기능정의   적용부위

com.thejoa703.aop_xml
>> AopTrace.java


import org.aspectj.lang.ProceedingJoinPoint;

public class AopTrace {
   public Object trace( ProceedingJoinPoint  joinPoint)  throws Throwable{
      // 타겟메서드의 정보
      String signature = joinPoint.getSignature().toShortString();
      System.out.println(">>>> " + signature + " START! ");
      // 타겟메서드 호출시간확인
      long start = System.currentTimeMillis();
      // 타겟메서드 호출
      Object  result = joinPoint.proceed();
      long end  = System.currentTimeMillis();
      System.out.println("..... 실행시간 : " + (end - start)  + "ms");
      System.out.println(">>>> " + signature + " END! ");
      return result;
   }
}


실습3)  servlet-context.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:aop="http://www.springframework.org/schema/aop"
   xsi:schemaLocation="http://www.springframework.org/schema/beans    http://www.springframework.org/schema/beans/spring-beans.xsd
   http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
   
   <aop:config>
      <aop:aspect  id="traceAspect"   ref="aopTrace" >
         <aop:around     method="trace"  
                    pointcut="execution(public * com.company.service..*(..))"
          />
      </aop:aspect>
   </aop:config>
   
   <!-- Advice 클래스 Bean 등록 -->
   <bean  id="aopTrace"   class="com.company.aop_xml.AopTrace" />
</beans>



Aop 설정    
   1. aop:config  aop 설정정보  -  bean
   2. aspect :  advice + point cut
   3. aop:around
   aop:around
   aop:before  실행 전
   aop:after   실행 후
   aop:after-returning   정상 실행시  
   aop:after-throwing    예외 발생시  
   
   1) exection(* hello(..) )  
      hello라는 이름 메서드 / 파라미터종류는 모두
   2) exection(* hello()   )  
      hello라는 이름 메서드 / 파라미터종류는 안됨.
   3) exection(* com.company.service.UserSeviceImpl.*(..)   )  
      UserSeviceImpl 클래스의 모든메서드
   4) exection(* com.company.service.*.*(..)   )      
      service안의 모든클래스
   5) exection(* com.company.service..*(..)   )  
      .. 서브패키지의 모든클래스  

   >> https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html






 ■ Q12. controller
 MVC
 >> 서로 영향없이 고칠수 있느 애플리케이션을 만들 수 있음.
 -MODEL : DB (TABLE, DTO, DAO, SERVICE)
 -VIEW : 화면 (html, css, js/jquery)
 -CONTROLLER : MODEL과 VIEW 사이의 관리

 >> MVC1 VS MVC2

 >> Frontcontroller
[클라이언트] → [Frontcontroller *.do]  → 세부 Controller → View
                                      → 세부 Controller → View
                                      → 세부 Controller → View
1. Frontcontroller - 공통작업먼저수행
2. 세부 Controller 작업 View 최종결과 생성

>> SPRING MVC

[클라이언트]

[Frontcontroller]  <<DispatcherServlet>>
    ↓  ↑             Handler Mapping @Controller - View(ViewResolver)
  세부 Controller → View
  세부 Controller → View
  세부 Controller → View  - db연동

1) 클라이언트 요청
2) DispatccherServlet - Handler Mapping @Controller
3) Controller 클라이언트의 요청처리
4) DispatcherServlet - ViewResolver 통해서 응답결과 처리

[실습]
1. [pom.xml] - spring-webmvc , jstl / jackson-mapper-asl
2. [web.xml] - ContextLoaderListener(스프링구동) / DispatcherServlet (FrontController)
3. [servelt-context.xml] Controller위치설정, ViewResolver
4. [controller] list.do(처리, view),,,, 설정

controller 작성 예시
@RequestMapping("/list.do")  //주소
	public String list() {
		return "quest_board/list";   //파일 위치
	}


/list.quest       /view/quest_board/list.jsp  
/write.quest      /view/quest_board/write.jsp 	(글쓰기폼)
/detail.quest     /view/quest_board/detail.jsp 	(상세보기)
/edit.quest       /view/quest_board/edit.jsp 	(수정하기 폼)
/delete.quest     /view/quest_board/delete.jsp 	(삭제하기 폼)


■ Q13. view
5. [view] 연동





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
     <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>3.2.17.RELEASE</version>
  </dependency>
  
     <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
   
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
   
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
   

     <!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
   <dependency>
       <groupId>org.codehaus.jackson</groupId>
       <artifactId>jackson-mapper-asl</artifactId>
       <version>1.9.13</version>
   </dependency>

   <!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
   <dependency>
      <groupId>javax.xml.bind</groupId>
      <artifactId>jaxb-api</artifactId>
      <version>2.3.1</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-core -->
   <dependency>
      <groupId>org.glassfish.jaxb</groupId>
      <artifactId>jaxb-core</artifactId>
      <version>2.3.0.1</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-impl -->
   <dependency>
      <groupId>com.sun.xml.bind</groupId>
      <artifactId>jaxb-impl</artifactId>
      <version>2.3.1</version>
   </dependency>   
         
         
</dependencies>
<!-- 수정 -->
<!-- 수정 -->  






