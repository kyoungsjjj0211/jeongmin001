-- join
-- emp (deptno), dept(deptno) 한테이블처럼 사용하는 방법
-- (0) 비표준
select empno, ename, d.deptno, dname
from emp e, dept d
where e.deptno = d.deptno;


-- (1) join on  sql-99 표준
select empno, ename, d.deptno, dname
from emp e join dept d on (e.deptno = d.deptno);
-- (2) join using sql-99 표준
select empno, ename, deptno, dname
from emp e join dept d using(deptno);
-- (3) natural join sql-99 표준
select empno, ename, deptno, dname
from emp e natural join dept d;

-- (4) (+) null 값 붙여줄게 -sql 99 이전
select * from dept;

select empno, ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno;

-- (5) right outer  join
select empno, ename, d.deptno, dname
from emp e right outer join dept d on( e.deptno = d.deptno);

-- (6) left outer join
select empno, ename, d.deptno, dname
from dept d left outer join emp e on( e.deptno = d.deptno);

--(7) full outer join
select empno, ename, d.deptno, dname
from dept e full outer join emp e on( e.deptno = d.deptno);



-- select 안에 selcet 
-- 내 안에 .....
-- 서브 쿼리 select 안에 select

-- #1.단일행( = 2073) 서브쿼리 emp 평균 급여보다 많이 받는 사원들
-- Step 1)
--select ename, sal
--from emp
--where sal >  2073(평균급여)
--order by sal desc;


-- Step 2)
select ename, sal
from emp
where sal > (select avg(sal)from emp)
order by sal desc;

-- #2. 다중행 (in) emp deptno가 10인 부서의 job인 사원들 ename, sal
--step 1)
--select  ename, sal
--from emp
--where job = deptno가 10인 부서의 job
--order by sal desc;

select  ename, sal
from emp
where job in (select job from emp where deptno= 10)
order by sal desc;


-- Q01 EMP 테이블에서 다음과 같이 출력하시오. 사원이름이 JONES 인 사원의 급여를 출력하시오.
select sal
from emp
where ename = 'JONES';

-- Q02 EMP 테이블에서 다음과 같이 출력하시오.급여가 2975보다 높은 사원정보를 출력하시오.
select *  
from emp
where sal >2975;

-- Q03 EMP 테이블에서 다음과 같이 출력하시오. JONES의 급여보다 높은급여를 받는 사원정보를 출력하시오.
select * 
from emp
where sal > (select sal from emp where ename = 'JONES');

-- Q04 EMP 테이블에서 다음과 같이 출력하시오. SCOTT보다 빨리 입사한 사원목록을 출력하시오.
select * 
from emp 
where hiredate < (select hiredate from emp where ename = 'SCOTT');

-- Q05 EMP 테이블에서 다음과 같이 출력하시오. 20번부서에 속한 사원 중 전체사원의 평균급여보다 높은 급여를받는 사원정보와 소속부서정보를 출력하시오.
select e.empno, e.ename, e.job, e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and e.deptno = 20 and e.sal > (select avg(sal) from emp);

-- Q06 EMP 테이블에서 다음과 같이 출력하시오. 부서번호가 20이거나 30인 사원의 정보를 출력하시오.

select *
from emp
where deptno in(20,30);

-- Q07 EMP 테이블에서 다음과 같이 출력하시오. 각 부서별 최고급여와 동일한 급열르 받는 사원정보를 출력하시오.
select *
from emp
where sal in (select max(sal) from emp group by deptno);

-- #3. 다중행연산자
-- 1. in "이 값이 목록에 있나요?" deptno in (10,20,30)
-- 2. any, some "하나라도 만족하면 ok"    ■ 최소값 기준비교
-- 컬럼 > any (서브쿼리) 최소값보다 크면 true
-- 컬럼 < any (서브쿼리) 최소값보다 작으면 true
-- 컬럼 > any (1,2,3)     |(1)   |(2)     |(3)   암기) 컬럼 >  any(1) 최소값보다크다
-- 컬럼 < any (1,2,3)     |(1)   |(2)     |(3)

--3. all    "모두 만족해야 ok"            ■ 최대값 기준비교
-- 컬럼 > all (서브쿼리) 최소값보다 크면 true
-- 컬럼 < all (서브쿼리) 최소값보다 작으면 true
-- 컬럼 > all (1,2,3)     |(1)   |(2)     |(3)
-- 컬럼 < all (1,2,3)     |(1)   |(2)     |(3)

-- 암기) ■ 컬럼 > any 1     커럼 > all 3 
-- 4. exists  "서브쿼리가 존재하면 ok"

create table atest                as  select 1 num from dual
                            union all select 2     from dual
                            union all select 3     from dual
                            union all select 4     from dual                        
                            union all select 5     from dual                        
                            union all select 6     from dual;                        
select * from atest;

-- 컬럼 > any 1 최소값보다 크다 , 컬럼 > all 3 최대값보다 크다
-- 애니1, 올3
select num  from atest where  num < any(select num from atest  where num in(3,4,5)) order by num; -- 5보다 작다 1 2 3 4
select num  from atest where  num > any(select num from atest  where num in(3,4,5)) order by num; -- 3보다 크다 4 5 6
select num  from atest where  num < all(select num from atest  where num in(3,4,5)) order by num; -- 3보다 작다 1 2
select num  from atest where  num > all(select num from atest  where num in(3,4,5)) order by num; -- 5보다 크다 6

-- Q08 EMP 테이블에서 다음과 같이 출력하시오. 부서번호 별로 최대 급여를 출력하시오. 7번문제가 잘풀렸는지 확인하시오.
select max(sal)
from emp
group by deptno;

-- Q09 EMP 테이블에서 다음과 같이 출력하시오. ANY 연산자를 이용하여 다음과같이 출력해보시오
select * 
from emp
where sal = any ( select max(sal) from emp group by deptno);

-- Q010 EMP 테이블에서 다음과 같이 출력하시오. ANY 연산자를 이용하여 다음과같이 출력해보시오
select *
from emp
where sal = some(select max(sal) from emp group by deptno);

-- Q011 EMP 테이블에서 다음과 같이 출력하시오. ANY를 이용하여 30번 부서 사원들의 최대 급여보다 적은 급여를 받는 사원정보를 출력하시오.
select * 
from emp
where sal < any (select sal from emp where deptno = 30) order by sal, empno;

-- Q12 EMP 테이블에서 다음과 같이 출력하시오. 부서번호가 30인 사원들의 급여를 출력하시오.
select sal
from emp
where deptno = 30;

-- Q13 EMP 테이블에서 다음과 같이 출력하시오. ANY를 이용하여 30번 부서 사원들의 최소 급여보다 많은은 급여를 받는 사원정보를 출력하시오.
select *
from emp
where sal >any ( select sal from emp where deptno = 30);

-- Q014 EMP 테이블에서 다음과 같이 출력하시오. ALL를 이용하여 30번 부서 사원들의 최소 급여보다 더 적은 급여를 받는 사원정보를 출력하시오.
select * 
from emp
where sal < all (select sal from emp where deptno = 30);

-- Q15 EMP 테이블에서 다음과 같이 출력하시오. ALL를 이용하여 30번 부서 사원들의 최대 급여보다 더 많은 급여를 받는 사원정보를 출력하시오.
select *
from emp
where  sal > all(select sal from emp where deptno = 30);

-- Q16 EMP 테이블에서 다음과 같이 출력하시오. EXISTS - 서브쿼리에 결과 값이 하나이상 존재하면 조건식이 모두 TRUE, 아니면 FALSE 됨
-- 결과값이 모두 존재히기때문에 EMP 모든행이 출력됨
select * 
from emp
where exists ( select dname from dept where deptno = 10);

-- #4. 다중 열 서브쿼리
select ename, deptno, job
from emp
where (deptno, job) in (select deptno, job from emp where sal >2000);

-- #5. 인라인뷰 (from)
select empno, ename, depno, dname
from (select * from emp where deptno=20) e,
     (select * from dept) d
where  e.deptno = d.deptno;

-- #6. with
with
e6 as (select * from emp where deptno=30),
d6 as (select * from dept)
select empno, ename, d.deptno, dname
from e6, d6
where e6.deptno = d6.deptno;

with
e6 as(select * from emp where  deptno=30)
select count(*) from e6;

-- #7.스칼라서브쿼리
-- 데이터가 많은경우 성능저하
select empno, ename, sal,
       ( select grade from salgrade where emp.sal between losal and hisal )salgrade
       , deptno
       , (select loc from dept where emp.deptno = dept.deptno) location
from emp;



-- Q17 EMP 테이블에서 모든 행을 선택하되, 다음 조건을 만족하는 경우에만 출력한다: DEPT 테이블에 DEPTNO = 50인 행이 하나라도 존재하는 경우
select * 
from emp 
where exists (select dname from dept where deptno = 50);

-- Q18 EMP 테이블에서 다음과 같이 출력하시오. 다중열 서브쿼리를 이용하여 WHERE (DEPTNO, SAL) IN ( ... )
-- 부서별 최대급여를 받는 사원정보를 출력하시오.
select * 
from emp
where (deptno, sal )in (select detpno, max(sal) from emp group by deptno);

-- Q19 EMP 테이블에서 다음과 같이 출력하시오. FROM 절에서 사용하는 인라인 뷰를 이용하여
-- 부서번호가 10인 사용자 정보와 부서정보를 가져와 EMPNO, ENAME, DEPTNO, DNAME, LOC 를 출력하시오.
select e10.empno, e10.ename, e10.deptno, d.dname ,d.loc 
from (select *from emp where deptno = 10) e10, (select*from dept) d
where e10.deptno =d.deptno;

-- Q20 WITH FROM 절에 명시하는 방식보다 몇십, 몇백줄의 규보가 되었을때 유용하게 사용됨.
with e10 as(select * from emp where deptno = 10), d as (select * from dept)
select e10. empno, e10.ename, e10. deptno, d.dname, d.loc from e10, d
where e10.deptno = d.deptno;

-- Q21 열에 명시하는 스칼라서브쿼리이용 EMP 테이블의 EMPNO, ENAME, JOB, SAL EMP 테이블의 SAL을 이용하여 SALGRADE에서 등급(GRADE)을 구하고
-- EMP 테이블의 DEPTNO를 이용하여 DEPTNO가 같은 부서명(DNAME)을 구하시오.
select empno, ename, job, sal,(select grade from salgrade where e.sal between losal and hisal) as salgrade,
deptno,(select dname  from dept where e.deptno = dept.deptno) as dname from emp e;

-- EX1 EMP 테이블에서 다음과 같이 출력하시오. 전체 사원 중 ALLEN과 같은 직책(JOB)인 사원들의 사원정보, 부서정보를 다음과 같이 출력하시오.
--1-1
select e.job, e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.job = (select job from emp where ename = 'ALLEN');
--1-2
select e.job, e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.deptno = d.deptno
and job = (select job from emp where ename = 'ALLEN');
--1-3
select job, empno, ename, sal, deptno, dname
from emp e join dept d using(deptno)
where job = (select job from emp where ename = 'ALLEN');

--1-4
select job, empno, ename, sal, deptno, dname
from emp e join dept d using(deptno)
where job in(select job from emp where ename = 'ALLEN');

--1-5 ★
with allen_job as (select job from emp where ename='ALLEN')
select job, empno, ename, sal, deptno, dname
from emp e join dept d using(deptno)
           join allen_job using(job);

--1-6
select  job, empno, ename, sal, deptno, dname
from emp e join dept d using(deptno)
where exists (select 1 from emp a where a.ename='ALLEN' and a.job=e.job);
-- EX2 EMP 테이블에서 다음과 같이 출력하시오. 전체 사원의 평균급여(SAL) 보다 높은 급여를 받는 사원들의 사원정보, 부서정보, 급여등급정보를 출력하시오.
-- 급여가 많은 순으로 정렬하되 급여가 같은경우에는 사원번호를 기준으로 오름차순으로 정렬
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
from emp e join dept d on e.deptno =d.deptno join salgrade s on e.sal between s. losal and s.hisal
where e.sal > (select avg(sal) from emp)
order by e.sal desc, e.empno asc;

-- EX3 EMP 테이블에서 다음과 같이 출력하시오. 10번부서에서 근무하는 사원 중 30번부서에는 존재하지 않는 직책을 가진 사원들의 사원정보, 부서정보를 다음과 같이 출력하는 SQL문을 작성하시오.
select e.empno, e.ename, e.job, e.deptno, d.dname, d.loc
from emp e join dept d on e.deptno = d.deptno
where e.deptno = 10 and e.job not in ( select job from emp where deptno = 30);


-- EX004 EMP 테이블에서 다음과 같이 출력하시오. 직책이 SALESMAN인 사람들의 최고급여보다 높은 급여를 급여를 받는 사원들의 사원정보, 급여등급정보를 다음과 같이 출력하시오.
-- 다중행 함수 사용하지 않는 방법, 다중행 함수 사용하는 방법 2가지로 작성하시오. 사원번호를 기준으로 오름차순으로 정렬하시오.
select e.empno, e.ename, e.sal, s.grade
from emp e 
join salgrade s on e.sal between s.losal and s.hisal
where e.sal > (select max(sal) from emp where job = 'SALESMAN')
order by e.empno;

select e.empno, e.ename, e.sal, s.grade
from emp e , salgrade s
where e.sal between s.losal and s.hisal
and sal > (select max(sal)from emp where job='SALESMAN') --MAX 들어가야함!
order by empno;


