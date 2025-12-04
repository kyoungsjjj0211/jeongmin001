# https://hi-sally03915.tistory.com/1669

#1. ERD
- ERD
- ENTITY (테이블)
- RELATIONSHIP (관계)
- ATTRIBUTE (속성)

예) EMP(deptno : 부서번호, FK) - DEPT(deptno : 부서번호, PK)
> 데이터 간에 **관계**에 초점을 둔 모델 (ERD)

#2. 정규화? (NF : Normal Form)
1. 이상을 제거하는것
2. 이상 - 공간낭비, 삽입, 갱신, 삭제  
3. 1NF ~ 5NF 

#3. 1NF (원자값)
- 원자값, 더이상 쪼갤수 없는 단위
1) 각속성은 하나의 값만

예) 
BEFORE)
-----------------------------------
STD_ID      ENAME     GRADE
-----------------------------------
1111        SALLY      A+, A

AFTER)
-----------------------------------
STD_ID      ENAME     GRADE
-----------------------------------
1111        SALLY       A+
1111        SALLY       A


#2. 2NF (부분함수 종속제거 / 원자값)
1. 종속관계 :  ~를 알면 ~를 할수있다
            X(결정자) → Y(종속자)
  > 모든속성이 기본키에 완전함수 종속되면 : 제 2 정규형
  >  A , B(기본키), C(종속자) ,중 종속자가 기본키에만 종속


예)
<img src="2NF.png" alt=""/>
<학번, 수강과목> → 성적

X(결정자) →  Y(종속자)
1-1. <학번, 수강과목> → 성적
1-2. {학번}          → 학부
1-3. {학번}          → professor
1-4. {professor}    → 학부

1-2 ~ 1-4 
- 부분함수 종속
: 기본키가 복합키 (학번, 수강과목)
: 종속자가 기본키를 구성하는 속성중 일부에게만 종속된 경우

#3. 3NF (이행함수 종속제거)
1. X → Y → Z
2. 다른후보키에 의존하지 않음!
3. 테스트시 insert, update, delete 이상 확인

예) <학번 : PK>을 알면 <지도교수 : 후보키>를 알고
                <지도교수 : 후보키>를 알면 <학부>를 알수 있다
[학번(PK), 지도교수] , [지도교수(PK), 학부]

※ KEY
1. KEY? 튜플,행, 레코드 (1, 홍길동, 10) 들을 구분할수 있는 기준필드(열, attribute)
2. 종류 : 후보키, 기본키, 대체키, 슈퍼키(복합키), 외래키
3. 후보키 - 기본키로 사용할 수 있는 속성 (주민증, 학생증, 사원증)
        유일성(구분, 유일하게 식별) + 최소성(최소한의 속성)
4. 기본키 - 선택된 주키(primary key) , 중복된값 x / null x
5. 대체키 - 선택 안된 키
6. 슈퍼키(복합키) - 속성 + 속성 구성되어있는 키
        유일성(구분) + 최소성 x
7. 외래키 - 테이블(entity) 와 테이블연결 속성


#4. BCNF : 모든 결정자 후보키
- 후보키? 기본키로 사용할 수 있는 속성


#5. 4NF : EKCLWHDTHRWPRJ
- 프로그래밍과목에
- 담당교수 2, 교재코드 2
BEFORE
<과목, 교수코드, 교재코드>
2*2 = 4
2*3 = 6

AFTER
<과목, 교수코드> 2
<과목, 교재코드> 2

#6. 5NF : 조인종속제거
- 하나의 테이블을 여러개의 테이블로 분해했다가 다시 조인했을때 데이터 손실은 없지만,
- 필요없는 데이터가 생김.

예) 다:다 관계 > 중간테이블 생성 (많이 쓰는 필드를 빼서)
교수는 여러개의 교재를 갖는다
교재는 여러명의 교수가 사용할 수 있다.
BEFORE
<교수>  ∋---------------------∈ <교재>

AFTER
<교수> +-----∈<교수 교재>∋-----∈ <교재>




Q6. CONTROLLER
6-1. frontcontroller - .do, *.hi, *,mbti 경로 / view 연결확인
6-2. service 구조
6-3. service 각각 안에 코드처리
6-4 view 연동


1. frontcontroller
1-1 @WebServblet 개발용 path경로주의!
1-2 web.xml 배포용

ㄴ index.jsp
	ㄴ [등록폼] /regForm.food    □           /foodtype/insert.jsp
	ㄴ [동록기능] /reg.food        ■ insert() /foodAll.food
	ㄴ [전체보기] /foodAll.food   ■ selectAll() /foodtype/list.jsp
	ㄴ [상세보기] /food.food      ■ select() /foodtype/detail.jsp
	ㄴ [수정폼] /updateform.food■ updateForm() /footrtpe/update.jsp
	ㄴ [수정기능] /update.food   ■ update() /food.food 해당번호의 글이 바로 수정
	ㄴ [삭제기능] /delete.food    ■ delete() /food.food


1-3. [com.company.controller] FoodController.java    * .food
1-4. view와 연동