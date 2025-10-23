-- 조건에 맞는데이터 조회
-- #1. where
-- #2. 비교연산자 : (같다) = ,(다르다) != , <> , ^=
-- #3. 논리연산자 : AND/ BETWEEN    AND  (범위지정) , OR /IN , NOT
-- #4. like     : 패턴검색
-- #5. null 처리 : null 여부확인
-- #6. 집합연산자 : union (중복제거하고 합집합) ,  union all (중복 포함하고 합집합), minus(차집합), intersect(교집합)


-- #1. 전체데이터 조회 (emp 테이블에서)
select * from emp;

-- #2. where 조건조회
select * from emp where empno =7839;  -- 같다 =
select * from emp where empno !=7839; -- 다르다 !=
select * from emp where empno <>7839; -- 다르다 <>
select * from emp where empno ^=7839; -- 다르다 ^=

select * from emp where ename ='KING';

select * from emp where empno=7839 and ename='KING'; -- and 두가지다 조건이 맞아야함.
select * from emp where empno=7839 and ename='SCOTT'; -- x
select * from emp where empno=7839 or ename='SCOTT'; -- or 둘중에 하나

select * from emp where sal*12 = 36000;
select * from emp where sal >= 3000;

select * from emp where ename >='S';
select * from emp where ename <='SOR';

select * from emp where deptno>=20 and deptno<=30;  -- >=, <=
select * from emp where deptno between 20 and 30;   -- between and는 이상과 이하

select * from emp where deptno=10 or deptno=30;
select * from emp where deptno in(10,30);

select * from emp where ename =    'KING'; -- 이름이 알때
select * from emp where ename LIKE 'A%'; -- 이름이 A로 시작할때
select * from emp where ename LIKE '%A%'; -- 이름이 A가 중간에 들어갈때
select * from emp where ename LIKE '%G'; -- 이름이 G로 끝나는 애들 찾아줘
select * from emp where ename LIKE '_I%'; -- _(첫글자) 두번째 글자가 I

select * from emp where comm = null; -- x null (데이터없어 -  상태)
select * from emp where comm is null;
select * from emp where comm is not null;

-- 연습문제
--

-- Q11 EMP테이블에서 ^= 를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
select * from emp where sal ^= 3000;
-- Q12 EMP테이블에서 NOT를를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
select * from emp where not sal = 3000;
-- Q13 EMP테이블에서 OR 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회하시오.
select * from emp where job = 'MANAGER' or job = 'SALESMAN' or job = 'CLERK' ;
-- Q14 EMP테이블에서 IN 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회하시오.
select * from emp where job in('MANAGER', 'SALESMAN' ,'CLERK');
-- Q15 EMP테이블에서 등가연산자(!= , <>, ^=)와 AND 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되지않는 행을 조회하시오.
select * from emp where job != 'MANAGER' and job <> 'SALESMAN' and job ^= 'CLERK';
-- Q016 EMP테이블에서 NOT IN 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되지않는 행을 조회하시오.
select * from emp where job not in ('MANAGER', ' SALESMAN' , 'CLERK');
-- Q17 EMP테이블에서 대소비교연산자(<= , >= ) and 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회하시오.
select * from emp where sal >= 2000 and sal <= 3000;
-- Q18 EMP테이블에서 BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회하시오.
select * from emp where sal between 2000 and 3000;
-- Q19 EMP테이블에서 NOT BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인 사이 이외의 행을 조회하시오.
select * from emp where sal not between 2000 and 3000;
-- Q20 EMP테이블에서 ENAME이 S로 시작하는 행을 조회하시오.
select * from emp where ename like 'S%';
-- Q21 EMP테이블에서 ENAME의 두번째 글자가 L인 행을 조회하시오.
select * from emp where ename like '_L%';
-- Q22 EMP테이블에서 ENAME에 AN이 포함되어 있는 행을 조회하시오.
select * from emp where ename like '%AN%';
-- Q23 EMP테이블에서 ENAME에 AN이 포함되어 있지 않는 행을 조회하시오.
select * from emp where ename not like '%AN%';
-- Q24 EMP테이블에서 별칭을 사용하여 다음과 같이 '연간총수입' 행을 조회하시오.
select ename, sal, sal*12+comm as  annsal, comm from emp;
-- Q25 코드확인
select * from emp where comm = null;
-- Q26 IS NULL
select * from emp where comm is null;
-- Q27 EMP테이블에서 직송상관이 있는데이터만 조회하시오 MGR열이 NULL 이 아닌 행조회
select * from emp where mgr is not null;
-- Q28 - 되는 코드는?
select * from emp where sal > null and comm is null;
-- Q29 - 되는 코드는?
select * from emp where sal > null or comm is null;

--Q30 UNION을 이용하여 DEPTNO가 10이거나, 20인 데이터의 EMPNO, ENAME, SAL, DEPTNO 열을 조회하시오.
select empno, ename, sal, deptno from emp where deptno = 10 
union
select empno, ename, sal, deptno from emp where deptno = 20;
--Q31 에러가 나는 이유는? 열의 갯수가 다를때
select empno, ename, sal, deptno
from emp
where deptno=10

select empno, ename, sal
from emp
where deptno-20;

--https://docs.oracle.com/error-help/db/ora-00933/00933. 00000 -  "unexpected keyword at or near %s"
--*Cause:    An unexpected keyword was encountered in the SQL statement at
--           or near the position printed in the error message.
--           One of the following occurred:
--           1. You had a typo in your SQL statement.
--           2. Unsupported syntax was encountered for a clause in the
--           statement.
--           3. An unsupported clause was encountered in the statement.
--           4. A string was terminated prematurely leading to the rest
--           of the string to be interpreted as keywords. For example, an
--           apostrophe in the string may be causing it to
--           end prematurely.
--*Action:   Take the action that corresponds with the Cause
--           1. Check that your SQL statement has no typos.
--           2. Check Oracle Database documentation to find the
--           correct syntax for the clause and update the problematic
--           clause appropriately.
--           3. Check Oracle Database documentation to find the correct
--           syntax for the statement and remove the unsupported clause.
--           4. Enter two single quotes instead of one to represent an
--           apostrophe within a string.
--*Params:   1) keyword_value
--           keyword near the keyword causing the error. The keyword value
--           may be truncated for readability if it is too long.
--98행, 1열에서 오류 발생

-- Q32 에러가 나는 이유는? 자료형이 다를때
select empno, ename, sal, deptno
from emp
where deptno =10
union
select  ename, empno, deptno, sal
from emp
where deptno =20;

--Q33 동작하는 이유는? 출력 열개수와 자료형이 같으므로 동작가능!
select empno, ename, sal, deptno
from emp
where deptno = 10
union
select sal, job, deptno, sal
from  emp
where deptno = 20;
-- Q34 UNION과 UNION ALL의 차이는?
-- 3개가 나오는 이유는? (union - 중복빼고 합집합)
select empno, ename, sal, deptno
from emp
where deptno = 10
union
select empno, ename, sal, deptno
from emp
where deptno = 10;
 
 -- Q35 UNION과 UNION ALL의 차이는? (union - 중복포함하고 합집합)
 select empno, ename, sal, deptno
 from emp
 where deptno =10
 union all
 select empno, ename, sal, deptno
 from emp
 where deptno = 10;
 
 -- Q36 MINUS의 의미는?
 select empno, ename, sal, deptno
 from emp
 minus
 select empno, ename, sal, deptno
 from emp
 where deptno = 10;
 
 -- Q37 INTERSECT 의미는? 교집합
 select empno, ename, sal, deptno
 from emp
 intersect
 select empno, ename, sal, deptno
 from emp
 where deptno = 10;
 
 -- EX1 EMP테이블에서 ENAME이 S로 끝나는 사원데이터를 모두 조회하시오
 select *
 from emp
 where ename like '%S';
 -- EX2 EMP테이블에서 DEPTNO가 30인 사원 중 직책이(JOB)이 SALESMAN 인 사원의 EMPNO, ENAME, JOB, SAL, DEPTNO를 조회하시오
 select empno, ename, job, sal, deptno
 from emp
 where deptno = 30
 and job = 'SALESMAN';
-- EX3 집합연산자( UNION을 )를 사용하지 않은 방식
select empno, ename, job, sal, deptno
from emp
where deptno in (20, 30)
and sal > 2000;
-- EX3.1 집합연산자( UNION을 )를 사용한 방식
select empno, ename, job, sal, deptno
from emp
where deptno = 20
and sal > 2000
union
select empno, ename, job, sal, deptno
from emp
where deptno = 30
and sal > 2000;
-- EX4 EMP테이블에서 NOT BETWEEN AND 연산자를 사용하지 않고 SAL이 2000이상 3000이하의 값을 가진 데이터만 조회하시오.
select *
from emp
where sal >= 2000
and sal <= 3000;
-- EX5 EMP테이블에서 ENAME에 E가 포함되고 DEPTNO가 30인 사원의 급여가 1000~2000사이가 아닌 사원의 ENAME, EMPNO, SAL, DEPTNO 를 조회하시오.
select ename, empno, sal, deptno
from emp
where ename like '%E%'
and deptno = 30
and sal not between 1000 and  2000;
-- EX6 EMP테이블에서 COMM 이 없고 , MGR은 존재하면 JOB 이 'MANAGER', 'CLERK' 인 사원 중 사원의 이름2번째 글자기 L 이 아닌 사원의 정보를 조회하시오.
select *
from emp
where comm is null 
and MGR is not null
and job in ('MANAGER', 'CLERK')
and ENAME not like '%_L%';


