-- 1. Join
-- 여러테이블을 한개의 테이블처럼 사용하는 것
-- 공통컬럼 기준으로 연결
-- 1-1.등가조인 (=)     : where 절       emp.deptno = dept.deptno
-- 비등가조인 (= x) :                sal  between losal and hisal
-- 자체조인         :  emp e1, emp e2
-- 1-2. outer join : 매칭되지 않은 행도 포함. left, right, full outer join


-- ERD : Entity(테이블) , Relationship(관계) , diagram(표)
--       Entity(테이블) , Relationship(관계) , Attribute(속성)

-- #1. 등가조인
select *
from emp e, dept d
where e.deptno = d.deptno;  -- 14 * 4 = 56

select *
from emp e, join dept d on (e. deptno = d.deptno);

select *
from emp e, join dept d using (deptno);

select *
from emp  natural join dept d;


-- #2. 외부조인 (매칭되지 x)
select * from dept;   -- deptno 10, 20, 30, 40(40, operations, boston)
select * from emp;    -- deptno 10, 20, 30

-- 1. (+) ORACLE에서만  -- (+) 없는데이터 NULL 보충해줄께, (+) 안붙은 테이블의 데이터를 보장
select ename , dname
from emp e,dept d 
where e.deptno = d.deptno(+); --14 emp 테이블 보장, dept에서 모자라는 데이터 없는 데이터 null채울께

select ename , dname 
from emp e,dept d 
where e.deptno(+) = d.deptno; --15 dept 테이블 보장, emp에서 모자라는 데이터 없는데이터 null 채울께

-- 2. LEFT JOIN , RIGHT JOIN (ANSI조인)
select ename, dname
from emp e inner join dept d on(e.deptno = d.deptno);  --INNER JOIN, 내부조인, 겹치는 애들만

select ename, dname
from emp e right outer join dept d
on (e.deptno = d.deptno); -- RIGHT 쪽에 있는 테이블 보장 (null , OPERATIONS)
select e name, D name
from dept d left outer join  emp e
on (e.deptno = d.deptno);

-- 3. FULL OUTER JOIN ( 두 테이블에 있는 모든 데이터를 결합)
select ename, dname
from emp e full outer join d
on e.deptno = d.deptno;

-- 1. emp e , dept d 별명 / empno, ename, deptno, dname
select empno, ename, e.deptno, dname
from emp e, dept d 
where e.deptno = d.deptno;

select empno, ename, e.deptno, dname
from emp e join dept d on(e.deptno =d.deptno);

select empno, ename, deptno, dname
from emp e join dept d using(deptno);
select empno, ename, deptno, dname
from emp e  natural join dept d


-- Q01 EMP, DEPT 테이블을 이용하여 FROM 절에 여러 테이블을 선언해해 다음과 같이 출력하시오 모든 행과 열이 곱해진 값
select *
from emp, dept;
ORDER BY EMPNO;

-- Q02 EMP, DEPT 테이블을 이용하여 EMP의 DEPTNO와 DEPT테이블의 DEPTNO가 같은 데이터를 다음과 같이 출력하시오
select * 
from emp, dept
where emp. deptno = dept.deptno
order by empno;

-- Q03 EMP, DEPT 테이블을 이용하여 FROM 절에 EMP 테이블의 별칭은 E, DEPT 테이블의 별칭은 D로 다음과 같이 출력하시오
select * 
from emp e, dept d
where e.deptno = d.deptno
order by empno;

-- Q04 EMP, DEPT 테이블을 이용하여 두테이블에 부서번호가 같은 열의이름이 포함되었을때 다음과 같이 출력하시오 (에러발생)
select deptno, ename, empno
from emp e, dept d
where e.deptno = d.deptno;

-- Q04 해결법
select emp.deptno, emp.ename
from emp, dept
where emp.deptno = dept.deptno;

-- Q05 EMP, DEPT 테이블을 이용하여 열 이름에 각각의 테이블 이름도 함께 명시시 다음과 같이 출력하시오 ( 위의 문제 해결 )
select  e.empno, e.ename, d.deptno, d.dname, d.loc
from emp e, dept d
where e.etno = d.deptno
order by d.deptno, e.empno;

-- Q06 EMP, DEPT 테이블을 이용하여 급여가 3000이상인 사원의 사원번호, 이름, 급여, 근무부서를 다음과 같이 출력하시오
select e.empno, e.ename,e.sal, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and sal>=3000;

select empno, ename, sal, d.deptno, dname, loc
from emp e join dept d on(e.deptno =d.deptno)
where e.sal >=3000;

select empno, ename, sal, deptno, dname, loc -- deptno
from emp e join dept d using(detno)          --using(deptno)
where e.sal >=3000;

select empno, ename, sal, deptno, dname, loc
from emp e natural join dept d
where e.sal >= 3000;

-- Q07 EMP, SALGRADE 테이블을 이용하여 유저 정보, 급여등급 , 그 등급의 최소급여와 최대급여를 다음과 같이 출력하시오
select * from emp
select * from salgrade; -- grade, losal(최소급여), hisal(최대급여)

select * 
from emp e, salgrade s
where e.sal between losal and hisal; -- 비등가조인

select * 
from emp e, salgrade s on(e.sal between losa and hisal); -- 비등가조인

-- Q08 자체조인 EMP테이블을 2번 이용하여 사원정보 (EMPNO, ENAME, MGR)와 직속상관(EMPNO,ENAME)의 사원번호를 다음과 같이 출력하시오
select e1.empno, e1.ename, e1.mgr, e2.empno mgr_empno, e2.ename mgr_ename
from EMP E1, EMP E2
where E1.MGR = E2.EMPNO; -- 사원의 직속상관(MGR), 직속상관(EMPNO)

select e1.empno, e1.ename, e1.mgr, e2.empno mgr_empno, e2.ename mgr_ename
from EMP E1 join EMP E2 on(E1.MGR = E2.EMPNO)
where E1.MGR = E2.EMPNO; -- 사원의 직속상관(MGR), 직속상관(EMPNO)
order by E1.MGR ASC;

--select e1.empno, e1.ename, e1.mgr, e2.empno mgr_empno, e2.ename mgr_ename
--from EMP E1 join EMP E2 on(E1.MGR = E2.EMPNO) (같은필드 x)
--order by E1.MGR ASC;

-- Q09 EMP테이블을 2번 이용하여 사원정보(EMPNO, ENAME, MGR) 와 직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오
-- 직속상관이 없는 사원의 정보도 출력하시오

select e1.empno, e1.ename, e1.mgr, e2.empno as mer_empno, e2.ename as mgr_ename
from emp e1,emp e2
where e1.mgr = e2.empno(+)
order by e1. empno;

-- Q10 (+)의 위치를 바꿔서 출력해보고 다음이 의미하는 바를 적으시오

select e1.empno, e1.ename, e1.mgr, e2.empno mgr_empno, e2.ename mgr_ename
from emp e1, emp e2
where e1.mgr(+) = e2.empno
order by e1.empno;
