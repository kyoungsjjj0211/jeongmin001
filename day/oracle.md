# ■ ORACLE
#1. 저장 단위
변수 < 배열 < 클래스 < 콜렉션 프레임워크 > file > DB
※ DB( mysql, oracle, mssql)

> java : jdbc → dbcp → orm (mybatis , jpa)

#2. RDB (Relational Database) ★
-   관계형 데이터 베이스 
-   테이블 관계
1. 엔티티(Entity) - 테이블 - 관리할대상 (고객, 주문, 상품)
2. 속정(Attribute) - 컬럼 - 대상의 특징 (주민번호, 이름, 주문번호)
3. 관계(Relationship) - 외래키 - 대상간의 연결 - 고객은 주문을 한다.

#3. 데이터베이스 언어 ★
1. 정의어(DDL)  -  create , alter, drop ..... cad
2. 조작어(DML)  -  insert(삽입) , select(조회) , update(수정), delete(지우기) ...... crud
3. 제어어(DCL)  -  grant , revoke

<<사원>>
> desc emp;
SQL> desc emp
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EMPNO                                     NOT NULL NUMBER(4)
 ENAME                                              VARCHAR2(10)
 JOB                                                VARCHAR2(9)
 MGR                                                NUMBER(4)
 HIREDATE                                           DATE
 SAL                                                NUMBER(7,2)
 COMM                                               NUMBER(7,2)
 DEPTNO                                             NUMBER(2)


<<부서>>

> desc dept;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(2)
 DNAME                                              VARCHAR2(14)
 LOC                                                VARCHAR2(13)

> 부서는 많은 사원을 가질수 있다.
  관리대상(table)   :  dept      emp
  속성(attribute)  :  deptno    empno , deptno ,,,
  연결(Relationship): deptno

#4. SELECT

[실습]
1. 테이블 구조확인     
     desc emp;
2. 테이블 전체정보확인 
     select * from emp;

-- #1. 테이블구조확인
desc emp;
desc dept;

show user;  -- 실행) 현재줄 선택하고 ctrl + enter
select table_name from user_tables; --사용할수 있는 테이블 확인

-- #2. 전체테이블 조회
select * from emp;

-- #3. 열조회
select empno, ename from emp;
select ename, job   from emp;

-- #4. 중복 제거 (distinct)
select distinct job          from emp;
select all      job          from emp;

-- #5. 연산 및 별칭
desc emp;

-- 3달치 급여
select ename "유저" , sal as "월급", sal+sal+sal as "3달치 월급" from emp;

-- #6. 정렬
select ename, sal from emp order by sal asc ; -- asc는 오름차순

select ename, sal from emp order by sal desc ; -- desc는 내림차순


--## Step3 연습문제
--  https://sally03915.github.io/stackventure_250825/004_oracle/oracle002_select_basic#15
-- Q1. emp 테이블 구성
desc emp;
-- Q2. DEPT 테이블 구성
desc dept;
-- Q3. SALGRADE 테이블 구성
desc salgrade;
-- Q4. EMP 테이블 전체열을 조회
select * from emp;
-- Q5. EMP 테이블의 EMPNO, ENAME, DEPTNO 열을 조회
select empno, ename, deptno  from emp;
-- Q6. EMP 테이블의 DEPTNO 열의 중복을 제거하고 조회
select distinct deptno  from emp;
-- Q7. EMP 테이블의 JOB, DEPTNO열의 중복을 제거 조회
select distinct job, deptno from emp;
-- Q8. EMP 테이블의 JOB, DEPTNO열의 중복을 제거하지 않고 그대로 모두 조회하시오
select all job,deptno from emp;
select     job,deptno from emp; -- all 생략 가능
-- Q9. EMP 테이블의열에에 연산식을 이용하여 '연간총수입'을 조회하시오.
select ename, sal, sal*12+comm, comm from emp;
-- Q10. EMP 테이블의 열열 더하기 연산식을이용하여 '연간총수입'을 조회하시오.
select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+comm, comm from emp;
-- Q11 EMP 테이블의 열 별칭을 사용하여 '연간총수입'을 조회하시오.
select ename, sal, sal*12+comm as "annsal", comm from emp;
-- Q12 EMP 테이블의 모든 열을 급여기준으로 오름차순 정렬하시오.
select * from emp order by sal asc ;
select * from emp order by sal ; --asc는 생략 가능
-- Q13 EMP 테이블의 모든 열을 급여기준으로 내림차순순 정렬하시오.
select * from emp order by sal desc ;
-- Q14 EMP 테이블의 모든 열을 전체열을 부서번호(오름차순)와 급여(내림차순)으로 정렬하시오.
select * from emp order by deptno asc, sal desc;


-- ※ 테이블 emp
-- 사용가능한테이블 확인
select table_name from user_tables;

--emp 테이블삭제 (복구x)
drop table emp;
select table_name from user_tables;

-- emp 테이블 만들기 정의어(DDL) - CREATE, ALTER, DROP
CREATE TABLE emp (
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2)
);
desc emp;

-- emp 테이블 값넣기 2. 조작어(DML) - insert(삽입) , select (조회), update(수정), delete(지우기)
INSERT INTO emp VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17','YYYY-MM-DD'), 5000, NULL, 10);
INSERT INTO emp VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1981-05-01','YYYY-MM-DD'), 2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('1981-06-09','YYYY-MM-DD'), 2450, NULL, 10);
INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('1981-04-02','YYYY-MM-DD'), 2975, NULL, 20);
INSERT INTO emp VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('1981-12-03','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('1980-12-17','YYYY-MM-DD'), 800, NULL, 20);
INSERT INTO emp VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('1987-07-13','YYYY-MM-DD'), 3000, NULL, 20);
INSERT INTO emp VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('1987-07-13','YYYY-MM-DD'), 1100, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('1982-01-23','YYYY-MM-DD'), 1300, NULL, 10);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('1981-09-28','YYYY-MM-DD'), 1250, 1400, 30);
INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('1981-02-20','YYYY-MM-DD'), 1600, 300, 30);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('1981-09-08','YYYY-MM-DD'), 1500, 0, 30);
INSERT INTO emp VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('1981-12-03','YYYY-MM-DD'), 950, NULL, 30);
INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('1981-02-22','YYYY-MM-DD'), 1250, 500, 30);

commit; --삽입[반영]

delete from emp;


-- EX1. EMP테이블의 JOB열 데이터를 중복없이 조회하시오.
select distinct job from emp;
-- EX002.
--조회할 테이블은 EMP 테이블이며 모든 열을 출력하시오.
--별칭
--EMPNO → EMPLOYEE_NO,
--ENAME → EMPLOYEE_NAME,
--MGR → MANAGER,
--SAL → SALARY,
--COMM → COMMISSION,
--DEPTNO → DEPARTMENT_NO
--부서번호를 기준으로 내림차순으로 정렬하되,
--부서번호가 같다면 사원이름을 기준으로 오름차순 정렬하시오.
select empno as employee_no, ename as employee_name, job, mgr as manager, sal as salary, comm as commission, deptno as department_no from emp order by deptno desc, ename asc;



-- Q. DESC EMP 명령어는 어떤 정보를 보여주나요?
--  A.  컬럼 이름 데이터 타입 (예: NUMBER, VARCHAR2 등) NULL 허용 여부
-- Q. SELECT DISTINCT DEPTNO FROM EMP 는 어떤 결과를 반환하나요?
--  A. EMP 테이블에서 중복 없이 고유한 부서 번호(DEPTNO)만 추출합니다.
-- Q. SAL*12+COMM 는 어떤 계산을 수행하나요?
--  A. 연봉 + 커미션 사원의 연봉 계산식입니다. SAL: 월급 SAL*12: 연간 급여 COMM: 커미션
-- Q. ORDER BY DEPTNO ASC, SAL DESC 는 어떤 방식으로 정렬하나요?
--   A. 결과를 부서 번호(DEPTNO) 오름차순으로 먼저 정렬하고, 같은 부서 내에서는 급여(SAL) 내림차순으로 정렬


1. 조작어 crud에서 cr은 뭐에 줄임말인가요? c(insert), r()