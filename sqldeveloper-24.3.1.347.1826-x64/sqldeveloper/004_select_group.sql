select *from emp;

-- 집계 sum , max, min, avg, count
select sum(sal) from emp; -- 급여의 합계
select sum(comm) from emp; --null 값이 있어도 계산가능

--    14줄     1줄
--select sal, sum(sal), max(sal), min(sal), avg(sal), count(sal) from emp; --error
select sum(sal) 합, max(sal) 최대, min(sal) 최소, round(avg(sal),2) 평rbs, count(sal) 갯수 from emp;

-- 3. group by
--select
--from --1
--where --2
--group by --3 그룹핑
--having --4 그룹핑안에서 조건
--order by; --6
--부서[별] 급여의합
select deptno, sum(sal)
from emp
group by deptno;

--4. having (합계를 구했을떄 9000이상인그룹)
select deptno, sum(sal) , count(*)
from emp
group by deptno
having sum(sal) >= 9000;

-- #### https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#14

-- Q01 EMP 테이블에서 SUM 함수를 이용하여 급여 합계(SAL)를 출력하시오.
SELECT  SUM(SAL)
FROM EMP;

-- Q02 EMP 테이블에서 SUM 함수를 이용하여 사원이름과 급여 합계를 출력하시오.
-- 에러가 난다면 그이유를 적으시오. ORA-00937:  SELECT SUM(SAL)  FROM EMP; OR
--   SELECT ENAME, SUM(SAL) 
--   FROM EMP;
-- ENAME이란 그룹의 기준을 정의를 안해주었기에 컴퓨터는 바보라서 몰라서?
SELECT ENAME, SUM(SAL)
FROM EMP
GROUP BY ENAME;

-- Q03 EMP 테이블에서 SUM 함수를 이용하여 추가수당(COMM) 합계를 출력하시오.
SELECT SUM(COMM)
FROM EMP;

-- Q04 EMP 테이블에서 SUM (DISTINCT, ALL)함수를 이용하여 급여 합계를 출력하시오.
SELECT SUM(DISTINCT SAL), SUM(ALL SAL), SUM(SAL)
FROM EMP;

-- Q05 EMP 테이블에서 COUNT를 이용하여 데이터의 갯수를 출력하시오.
SELECT COUNT(*)
FROM EMP;

-- Q06 EMP 테이블에서 COUNT를 이용하여 부서번호가(EMPNO) 30인 데이터의 갯수를 출력하시오.
SELECT COUNT(*)
FROM EMP
WHERE DEPTNO = 30

-- Q07 EMP 테이블에서 COUNT ( DISTINCT, ALL) 를 이용하여 데이터의 갯수를 출력하시오.
SELECT COUNT(DISTINCT SAL),COUNT(ALL SAL), COUNT(SAL)
FROM EMP;

-- Q08 EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
SELECT COUNT(COMM)
FROM EMP;

-- Q09 EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오. 위와 실행결과가 같음 COUNT는 NULL 처리가 들어가 있음.
SELECT COUNT(COMM)
FROM EMP
WHERE COMM IS NOT NULL;

-- Q10 EMP 테이블에서 MAX를 이용하여 부서번호(DEPTNO)가 10번인 사원들의 최대 급여를 출력하시오.
SELECT MAX(SAL)
FROM EMP
WHERE DEPTNO = 10;

-- Q11 EMP 테이블에서 부서번호(DEPTNO)가 10번인 사원들의 최소 급여를 출력하시오.
SELECT MIN(SAL)
FROM EMP
WHERE DEPTNO = 10;

-- Q12 EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 최근 입사일을 출력하시오.
SELECT MAX(HIREDATE)
FROM EMP
WHERE DEPTNO = 20;

-- Q13 EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 오래된 입사일을 출력하시오.
SELECT MIN(HIREDATE)
FROM EMP
WHERE DEPTNO = 20;

-- Q14 EMP 테이블에서 부서번호가 30인 사원의 평균급여를 출력하시오.
SELECT AVG(SAL)
FROM EMP
WHERE DEPTNO = 30;

-- Q15 EMP 테이블에서 부서번호가 30인 사원의 DISTINCT로 중복을 제거한 급여 열의 평균급여를 출력하시오.
SELECT AVG(DISTINCT SAL)
FROM EMP
WHERE DEPTNO = 30;

-- Q16 EMP 테이블에서 집합연산자(UNION ALL) 를 사용하여 각 부서별 평균급여를 출력하시오.
SELECT 10 AS DEPTNO, AVG(SAL)
FROM EMP
WHERE DEPTNO = 10
UNION ALL
SELECT 20, AVG(SAL)
FROM EMP
WHERE DEPTNO = 20
UNION ALL
SELECT 30, AVG(SAL)
FROM EMP
WHERE DEPTNO = 30;

-- Q17 EMP 테이블에서 GROUP BY를 사용하여 부서별 평균급여를 출력하시오.
SELECT AVG(SAL), DEPTNO
FROM EMP
GROUP BY DEPTNO;

-- Q17 EMP 테이블에서 GROUP BY를 사용하여 부서별 평균급여를 출력하시오.
SELECT AVG(SAL),DEPTNO
FROM EMP
WHERE DEPTNO IN (30, 20, 10)
GROUP BY DEPTNO;

-- Q18 EMP 테이블에서 부서번호(DEPTNO) 및 직책별(JOB) 평균급여(SAL)로 정렬한 후 출력하시오.
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB;

-- Q19 EMP 테이블에서 GROUP BY절에 없는 열을 SELECT절에 포함하면 에러가 난다. 그이유를 적으시오.
--SELECT ENAME, DEPTNO, AVG(SAL)
--FROM EMP
--GROUP BY DEPTNO;
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO;

-- Q20 EMP 테이블에서 GROUP BY 와 HAVING 절을이용하여 각부서의 직책별 평균급여를 구하되 그 평균급여가 2000이상인 그룹만 출력하시오.

SELECT DEPTNO, JOB, AVG(SAL
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 

-- Q21 다음 코드가 오류나는 이유를 적으시오 
-- SELECT DEPTNO, JOB, AVG(SAL) 
-- FROM EMP 
-- WHERE AVG(SAL) >= 2000 GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
-- AVG(SAL)은 HAVING 절에서 사용해야 합니다
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;

-- Q22 WHERE 절을 사용하지 않고 HAVING절만 사용한 경우
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000;

-- Q23 WHERE절과 HAVING절을 모두 사용한경우
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE SAL >= 1000
GROUP BY DEPTNO , JOB
HAVING AVG(SAL) >= 2000;

-- Q24
-- EMP 테이블에서 부서별(큰그룹) 직책(소그룹)의
-- 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
SELECT DEPTNO, JOB,
COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM EMP
GROUP BY DEPTNO,JOB
ORDER BY DEPTNO,JOB;


-- 1.
select * from emp;

-- 2. 집계함수 - sum, count, max, min, avg
select sum(sal) from emp; -- 1개

-- 3. 부서별 급여의 평균 group by > deptno , job
select deptno, job,  avg(sal) from emp group by deptno, job;

-- 4. where vs having -- [급여의 평균]에서 2000이상
select deptno, job, avg(sal) -- 5
from emp                -- 1
where sal>=1500         -- 2 전체데이터에서 필터
group by deptno, job;   -- 3 [부서의 직업별], 급여의 평균
having avg(sal) > 2000; -- 4 3번에서 나온 급여의 평균으로 having

-- 5. rollup, cube, grouping sets / pivot, unpivot
--     [부서의 직업별], 명수, 급여의 평균
-- rollup : 10부서의 직업 급여의 평균 20부서의 급여의 평규느 30부서의 급여의 평균 = 전체 총계 소 > 대
select deptno, job, count(*), round(avg(sal),1)
from emp
group by rollup(deptno, job);

-- cube : deptno + job  전체총계,  job총계, deptno 총계, deptno + job 각각의 세부내용 큰거에서 >작은걸로
select deptno, job, count(*), round(avg(sal),1)
from emp
group by cube(deptno, job);

-- grouping 해당컬럼이 실제로 그룹화 되었니? 0 그룹화에 포함됨 / 1 그룹화에 포함이 되지 않음
select deptno, job, grouping(deptno), grouping(job)
from emp --
group by cube(deptno, job); -- deptno + job, job, deptno, 둘다세부

--pivot
select *
from (select 컬럼1, 컬럼2, 집계대상컬럼 from 테이블명) --원본데이터 : pivot을 적용할 대상
pivot (집계함수(집계대상) for 컬럼기준 in(값1, 값2, 값3 ,,,); --집계합수 : 어떤컬럼기준으로 만들 것인지 지정

--1) job별 부서 10,20,30 의 최대급여
select *
from (select deptno, job, sal from emp)
pivot (max(sal) for deptno in(10,20,30) );

-- 2)직무별 부서 사원수 - job  별  부서 10, 20, 30의 최대급여
select *
from (select job, deptno, empno from emp)
pivot (count (empno) for deptno in(10,20,30) );

-- 3 부서별 직무 평균 급여
select * 
from (select deptno, job, sal from emp)
pivot (avg(sal) for job in ('CLERK' , 'MANAGER', 'SALESMAN') );

-- unpivot 열데이터를 행으로

--1)
```
select *
from (
    select deptno, max(decode(job, 'CLERK' , sal )    ) CLERK
                   , max(decode(job, 'CLERK' , sal)   )manager
from emp
group by deptno
) --원본데이터 : unpivot을 적용할대상(열형태로 집계된 데이터)
unpivot (
    sal for job in (CLERK, MANAGER )
); -- unpivot : 열을 행으로 변환, 기준컬럼 열이름이었던것을 행 값으로 변환
--풀이1) DEPTNO, CLERK(열), MANAGER(열)
--풀이2) DEPTNO, JOB, SAL
--               CLERK
--               MANAGER
--1)         ↓          ↓
   DEPTNO   CLERK   MANAGER
-----------------------------
1   30	    950 	950
2   20	    1100	1100
3   10	    1300	1300

--2) unpivot
DEPTNO      JOB         SAL
-------- ------------- -------
    30	    CLERK	    950
    30	    MANAGER	    950
    20	    CLERK	    1100
    20	    MANAGER	    1100
    10	    CLERK	    1300
    10	    MANAGER	    1300





-- Q25~39
-- Q25
-- EMP 테이블에서 ROLLUP 함수를 이용하여 부서별(큰그룹) 직책(소그룹)의
-- 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.

SELECT DEPTNO, JOB,
       COUNT(*),
       MAX(SAL),
       SUM(SAL),
       AVG(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

-- Q26 EMP 테이블에서 CUBE(DEPTNO, JOB) 함수를 이용하여
-- 부서별(큰그룹) 직책(소그룹)의 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
SELECT DEPTNO, JOB,
COUNT(*),
MAX(SAL),
SUM(SAL),
AVG(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO, JOB;

-- Q27 EMP 테이블에서 DEPTNO를 먼저 그룹화한후 ROLLUP 함수에 JOB을 지정하여 사원수를 출력하시오.
SELECT DEPTNO,JOB, COUNT(*)
FROM EMP
GROUP BY DEPTNO, ROLLUP(JOB)
ORDER BY DEPTNO, JOB;

-- Q28 EMP 테이블에서 JOB을 먼저 그룹화한후 ROLLUP 함수에 DEPTNO을 지정하여 사원수를 출력하시오.
SELECT JOB, DEPTNO, COUNT(*)
FROM EMP
GROUP BY JOB, ROLLUP(DEPTNO);


-- Q29 EMP 테이블에서 GROUPING SETS (DEPTNO, JOB) 함수를 사용하여 열별 그룹으로 묶어어 결과로 출력하시오.
SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY GROUPING SETS((DEPTNO),(JOB));


-- Q30 EMP 테이블에서 DEPTNO JOB열의 그룹화결과를 GROUPING 함수로 출력하시오.
SELECT DEPTNO, JOB, COUNT(*),GROUPING(DEPTNO), GROUPING(JOB)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB);


-- Q31 DECODE문으로 GROUPING 함수를 적용하여 결과를 표기하시오
SELECT COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL),
  DECODE(GROUPING(DEPTNO), 1, 'ALL DEPT', DEPTNO) AS DEPTNO,
  DECODE(GROUPING(JOB), 1, 'ALL JOB', JOB) AS JOB
FROM EMP
GROUP BY CUBE(DEPTNO, JOB) 
ORDER BY DEPTNO, JOB;


-- Q32 DEPTNO, JOB을 함께 명시한 GROUPING_ID 함수를 사용하시오.
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), GROUPING(DEPTNO), GROUPING(JOB), GROUPING_ID(DEPTNO,JOB)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY DEPTNO NULLS LAST, JOB NULLS LAST;

1) DEPTNO (O), JOB(0)            GROUPING_ID (0) 정상조합                   0*2^1 + 0*2^1 = 0
2) DEPTNO (O), JOB(1:NULL)       GROUPING_ID (1) DEPTNO  실제값, JOB NULL   0*2^1 + 1*2^0 = 1
3) DEPTNO (1: NULL), JOB(0)      GROUPING_ID (2) JOB 실제값 , DEPTNO NULL   1*2^1 + 0*2^0 = 2
4) DEPTNO (1: NULL), JOB(1: NULL)GROUPING_ID (3) 전체집계 둘다 NULL          1*2^1 + 1*2^0 = 3  2^0은 1



-- Q33 EMP 테이블에서 GROUP BY로 그룹화하여 부서번호와 사원이름을 출력하시오.
SELECT DEPTNO, ename
FROM EMP
GROUP BY DEPTNO, ename;

-- Q34 EMP 테이블에서 부서별 사원이름을 나란히 나열하여 출력하시오. LISTAGG( 나열할 열, 구분자) WITHIN GROUP(ORDER BY 나열할 열의 정렬기준)
SELECT DEPTNO, LISTAGG(ENAME, ', ') WITHIN GROUP(ORDER BY ENAME) ENAMES
FROM EMP
GROUP BY DEPTNO;


-- Q35 EMP 테이블에서 부서, 직책별 그룹화하여 최고급여데이터를 출력하시오
SELECT DEPTNO, JOB, MAX(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO, JOB;

-- Q36 EMP 테이블에서 PIVOT함수를 사용하여 직책별* 부서별 최고급여를 2차원 표 형태로 출력하시오
SELECT *
FROM (SELECT JOB, DEPTNO, SAL  FROM EMP)
PIVOT ( MAX(SAL) FOR DEPTNO IN (10 , 20, 30)) ;

-- Q37 EMP 테이블에서 PIVOT함수를 사용하여 부서별*직책책별 최고급여를 2차원 표 형태로 출력하시오
SELECT *
FROM (SELECT DEPTNO, JOB, SAL FROM EMP)
PIVOT (MAX(SAL) FOR JOB IN ('CLERK','MANAGER','SALESMAN','ANALYST','PRESIDENT'))
ORDER BY DEPTNO;
-- Q38 EMP 테이블에서 DECODE문을 활용하여 PIVOT 함수와 같은 결과를 출력하시오
SELECT DEPTNO,
       MAX(DECODE(JOB, 'CLERK', SAL)) CLERK,
       MAX(DECODE(JOB, 'SALESMAN', SAL)) SALESMAN,
       MAX(DECODE(JOB, 'PRESIDENT', SAL)) PRESIDENT,
       MAX(DECODE(JOB, 'MANAGER', SAL)) MANAGER,
       MAX(DECODE(JOB, 'ANALYST', SAL)) ANALYST
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- Q39 EMP 테이블에서 UNPIVOT 활용하여 열로 구분된 그룹을 행으로 출력하시오
SELECT *
FROM (SELECT DEPTNO,
        MAX(DECODE(JOB, 'CLERK', SAL)) CLERK,
        MAX(DECODE(JOB, 'MANAGER', SAL)) MANAGER,
        MAX(DECODE(JOB, 'SALESMAN', SAL)) SALESMAN,
        MAX(DECODE(JOB, 'ANALYST', SAL)) ANALYST,
        MAX(DECODE(JOB, 'PRESIDENT', SAL)) PRESIDENT
FROM EMP
GROUP BY DEPTNO)
UNPIVOT (SAL FOR JOB IN (CLERK, MANAGER, SALESMAN, ANALYST, PRESIDENT))
ORDER BY DEPTNO, SAL;


-- EX 01 EMP 테이블을 이용하여 다음과 같이 출력하시오. 
-- 부서번호(DEPTNO) , 평균급여(AVG_SAL) , 최고급여(MAX_SAL) , 최저급여(MIN_SAL) , 사원수(CNT) 를 조회하시오
-- 평균급여를 출력시 소수점을 제외하고 각 부서번호별로 출력하시오.
SELECT DEPTNO, TRUNC(AVG(SAL)), MAX(SAL), MIN(SAL), COUNT(*)
FROM EMP
GROUP BY DEPTNO;

-- Ex 02 EMP 테이블을 이용하여 다음과 같이 출력하시오. 같은직책(JOB)에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하시오.
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB
HAVING COUNT(*) >= 3;

-- Ex03 EMP 테이블을 이용하여 다음과 같이 출력하시오. 사원들의 입사년도(HIRE_YEAR)를 기준으로 부서별 몇명이 입사했는지 조회하시오.
SELECT TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YEAR,DEPTNO,COUNT(*) AS CNT
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY'),DEPTNO
ORDER BY HIRE_YEAR, DEPTNO;

-- Ex04 EMP 테이블을 이용하여 다음과 같이 출력하시오. 추가수당(COMM)을 받는 사원수와 받지않는 사원수를 조회하시오.
SELECT --  NVL2(COMM, 'O', 'X') EXIST_COMM, COUNT(*) CNT FROM EMP GROUP BY NVL2(COMM, 'O' , 'X');
       --  DECODE(COMM,NULL, 'X', 'O') EXIST_COMM , CONUT(*) CNT FROM EMP GROUUP BY DECODE(COMM, NULL,'X', 'O');
CASE WHEN COMM IS NOT NULL THEN 'O'
                          ELSE 'X'
    END AS EXIST_COMM, COUNT(*) AS CNT
FROM EMP
GROUP BY  CASE WHEN COMM IS NOT NULL THEN 'O' ELSE 'X' END
ORDER BY EXIST_COMM;]

-- Ex05 EMP 테이블을 이용하여 다음과 같이 출력하시오. 각 부서의 입사연도별 사원수, 최고급여, 급여합,
-- 평균급여를 출력하고 각 부서별 소계와 총계를 출력하시오. (ROLLUP)
SELECT DEPTNO, TO_CHAR(HIREDATE, 'YYYY') AS HIRE_YEAR, COUNT(*) AS CNT,MAX(SAL) AS MAX_SAL,SUM(SAL) AS SUM_SAL,AVG(SAL) AS AVG_SAL
FROM EMP
GROUP BY ROLLUP(DEPTNO, TO_CHAR(HIREDATE, 'YYYY'))
ORDER BY DEPTNO, HIRE_YEAR;