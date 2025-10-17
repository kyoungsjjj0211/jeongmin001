-- 003_select_function.sql
-- 1. 문자열 : 
-- 2. 숫자 : round/trunc (반올림/qqjfla), ceil(올림), floor(내림), mod (나머지)
-- 3. 날짜 : sysdate (시스템날짜), add_months(몇달뒤에), next_day, last_day
-- 4. 변환 : to_char(날짜형식변환), to_date 
-- 5. 조건 : nvl, nvl2 ( null), decode, case (조건분기)
---------------------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 1-1. upper 대문자, lower 소문자, initcap 대소문자 변환
-- 1-2. lengthb 문자열길이
-- 1-3. substr 부분문자열, instr 위치문자열
-- 1-4. replace 바꾸기 , lpad, rpad 채우기
-- 1-5. trim, ltrim, rtrim 공백빼기 
-- 1-6. concat 문자열연결

-- #1. 대소문자
select ename, upper(ename), lower(ename), initcap(ename)
from emp;

-- #2. 문자열길이
select ename, length(ename) , '킹' , LENGTH('킹'), lengthb ('킹')
from emp;

-- #3. substr(문자열, 어디서부터 ,몇개) 부분문자열, instr 위치문자열
select ename, substr(ename, 1,2) , substr(ename, 1,3), substr(ename, 2,2) ,  substr (ename, 3,2) from emp;
select substr('oracle' , -1), substr('oracle' , -3)                     ,substr('oracle' , -3, 2) from dual;
--          e뒤에서1번부터끝까지      cle뒤에서부터 세번째부터 끝까지          cl 뒤에 세번째부터 2개
--    -붙이면 끝에서 부터 계산
select substr('oracle', -2) , substr('oracle',-2,1) from dual; -- le

select instr('oracle' , 'a') from dual; -- o(1) r(2) a(3) c(4) l(5) e(6)
select ename, instr(ename,'a') from emp; -- 있으면 위치, 없으면 0

-- #4. replace(어떤문자열을 , 찾아서, 바뀌기) 바꾸기, lpad, rpad 채우기
select replace ('010-1234-5678' , '-', ' ') from dual;
select lpad('oracle', 10, '#') from dual; -- | l(left 채우기)  r(right 채우기)

-- #5. trim , ltrim, rtrim 공백빼기
select trim(' *oracle* '), ltrim(' *oracle* '), rtrim(' *oracle* ')
from dual;

-- #6. concat 문자열연결 - 두개의 문자열만 연결가능
select concat('Hello' , 'Oracle') from dual;
select concat(concat('Hello' , 'Oracle') , '★') from dual; --concat 중첩해서 사용

select 'Hello ' || 'Oracle ' || '♥' from dual;
---------------------------------------------------------------------------------
-- ##1. 문자열 연습문제
-- Q1 -EMP 테이블에서 ENAME을 대문자, 소문자, 첫글자만 대문자로 조회하시오
select ename, upper(ename) as ename_upper, lower(ename) as ename_lower, initcap(ename) as ename_initcap from emp;
-- Q2 -EMP 테이블에서 UPPER를 이용하여 ENAME이 KING인 데이터를 조회하시오.
select ename from emp where upper(ename) =upper( 'KING');
-- Q3 -EMP 테이블에서 UPPER를 이용하여 ENAME에 KING인 포함된 데이터를 조회하시오. 대소문자 상관없이 KING인 사람을 조회하는 것이 가능해짐.
select ename from emp where upper(ename) like upper( '%KING%');
-- Q4 -EMP 테이블에서 LENGTH를 이용하여 ENAME의 문자열 길이를 조회하시오.
select ename, length(ename) from emp;
-- Q5 -EMP 테이블에서 ENAME의 문자열 길이가 5이상인 데이터를 조회하시오.
select ename, length(ename) from emp where length(ename) >= 5;
-- Q6 - LENGTH('한글'), LENGTHB('한글') 문자열길이반환, 문자열 바이트 수 반환환
select length('한글'), length ('한글') from dual;
-- Q7 - 문자열 일부분을 추출 SUBSTR( 문자열 , 시작위치, 추출길이)
select job,  substr(job, 1, 2), substr(job, 3, 2), substr (job, 5) from emp;
-- Q8 -의 의미는? C(-5)L(-4)E(-3)R(-2)K(-1)
-- 음수의 위치 기준 c(1, -5)l(2, -4)e(3, -3)r(4, -2)k(5, -1)
select job , substr(job, -length(job)), substr(job, - length(job) , 2), substr(job, -3)
from emp;

-- Q9 - 특정문자위치 찾기 INSTR(문자열, 찾을거, 시작위치, 몇번째) 'HELLO, ORACLE!' 문자열에서 다음과 같이 찾으시오
--'HELLO, ORALE! -- INSTR(문자열, 찾을거, 시작위치, 몇번째) -- 1. 해당위치의 글자가 뭔지 확인 3, 12, 4 (L) -- H(1)E(2)L(3)L(4)O(5),(6) (7)O(8)R(9)A(10)C(11)L(12)E(13)!(14) -- 2. INTER이용해서 해당값 구하기
select 'HELLO, ORACLE!'
, instr('HELLO, ORACLE!', 'L') as instr_1
, instr('HELLO, ORACLE!', 'L', 5) as instr_2
, instr('HELLO, ORACLE!', 'L', 2, 2) as instr_3
from dual;

-- Q10 EMP테이블에서 INSTR 함수로 사원이름에 S가 있는 데이터를 조회하시오
select * 
from emp
where instr(ename, 'S') > 0; -- instr은 못찾으면 0  -- where ename like '%S%';
-- Q11 EMP테이블에서 LIKE를 이용하여 사원이름에 S가 있는 데이터를 조회하시오
select * 
from emp
where ename like '%S%';
-- Q12 REPLACE를 이용하여 연락처의 -을 공백으로, -을 뺀데이터로 조회하시오
select '010-12347-5678' as before
, replace('010-1234-5678' , '-', ' ') replace1
, replace('010-1234-5678' , '-') replace2
from dual;

-- Q13 LPAD, RPAD를 이용하여 다음과 같이 데이터를 출력하시오
select 'ORACLE'
, lpad('Oracle' , 10 , '#') lpad_1
, rpad('Oracle' , 10 , '*') rpad_1
, lpad('Oracle' , 10 )      lpad_2
, rpad('Oracle' , 10 )      rpad_2
from dual; 
-- Q14 RPAD를 이용하여 개인정보뒷자리 *로 출력하시오.
select rpad('911225-',14,'*') JMIN
, rpad('010-1234-',13,'*') PHONE
from dual;
-- Q15 EMP 테이블에서 EMPNO와 ENAME 사이에 :을 넣고 문자열을 연결하시오.
select concat (empno, ename) , concat(empno ,  concat(':',ename))
from emp
where ename = upper('scott');
-- Q16 TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
select
  '[' || trim(' * * Oracle * * ') || ']' as trim -- 양쪽공백제거 (중간에 있는 공백은 제거 하지 않음)
, '[' || ltrim(LEADING FROM' * * Oracle * * ') || ']' as trim -- 앞쪽 공백 없애기
, '[' || rtrim(TRAILING FROM' * * Oracle * * ') || ']' as trim -- 뒤쪽 공백 제거
, '[' || trim(BOTH      FROM' * * Oracle * * ') || ']' as trim -- 양쪽공백제거
from dual;

select
  '[' || trim(' * * Oracle * * ') || ']' as trim -- 양쪽공백제거 (중간에 있는 공백은 제거 하지 않음)
, '[' || ltrim(' * * Oracle * * ') || ']' as trim -- 왼쪽 공백 없애기
, '[' || rtrim(' * * Oracle * * ') || ']' as trim -- 오른쪽 공백 제거
, '[' || trim(' * * Oracle * * ') || ']' as trim -- 양쪽공백제거
from dual;

-- Q17  TRIM을 이용하여 삭제할 문자 삭제후 출력가능
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim1  -- 양쪽공백제거 (중간에 있는공백은 제거하지 않음)
,  '[' ||  trim( LEADING  '*' FROM   '* *Oracle* *') || ']' as trim2 --  앞쪽공백제거
,  '[' ||  trim( TRAILING '*' FROM   '* *Oracle* *') || ']' as trim3   --  뒤쪽공백제거
,  '[' ||  trim( BOTH     '*'  FROM   '* *Oracle* *') || ']' as trim4  -- 양쪽공백제거
from   dual;  -- '* *Oracle* *'



-- Q18  TRIM, LTRIM, RTRIM 사용하여 문자열 출력하기
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim0 --trim 양쪽공백없애기
,  '[' ||  ltrim(' * *Oracle* *') || ']' as ltrim1 -- ltrim 왼쪽공백없애기
,  '[' ||  ltrim('*-Oracle-*', '*') || ']' as ltrim2 --ltrim 원하는문자열 없애기
,  '[' ||  rtrim('* *Oracle* * ') || ']' as rtrim1 -- rtirim 오른쪽 공백없애기
,  '[' ||  rtrim('*-Oracle-*', '*') || ']' as rtrim2 --rtrim 원하는문자열 없애기
from   dual;  -- '* *Oracle* *'
---------------------------------------------------------------------------------------
-- 2. 숫자 : round/trunc (반올림/qqjfla), ceil(올림), floor(내림), mod (나머지)
select round( 1234.5678 ) , round( 1234.5678 , 2) , trunc(  1234.5678 , 2 ), ceil(1.1) , floor(4.8) , mod(10,3)
from dual;  --1235                    1234.57                   1234.56           2             4            1

----------------------------------------------------------------------------------------
-- 3. 날짜 : sysdate (시스템날짜, 시간반환), add_months(몇달뒤에), next_day, last_day, months_between ('날짜 ' , '날짜 ') (몇달 차이나니)
select  sysdate, add_months(sysdate, 2) , months_between( '25-12-1' , '24-12-1' )
from dual; --25/10/16        25/12/16                           12달 차이

select NEXT_DAY(SYSDATE, '월요일') "다음주 월요일" , LAST_DAY(SYSDATE) "해당월의 마지막 날짜"
from dual;

select NEXT_DAY(SYSDATE, 1) "다음주 월요일" , LAST_DAY(SYSDATE) "해당월의 마지막 날짜"
from dual;


----------------------------------------------------------------------------------------
-- 4. 변환 : to_char(날짜형식변환), to_date 
--             날짜를       문자로                  문자를        날짜로
select TO_CHAR(sysdate, 'yyyy-mm-dd') , TO_DATE('2025-10-16', 'YYYY-MM-DD')
from dual;

--     숫자1234를 문자열로 변환한 다음 +1 (자동변환해서 오류가 안날수 있음.)
select TO_CHAR(1234)               + 1 ,TO_NUMBER('5678') + 1
from dual;

select TO_CHAR('일이삼사')               + 1 ,TO_NUMBER('5678') + 1 -- 오류
from dual;

select      "1234"    +1 , 1+"1234"      -- 자료형이 안맞으면 오류남
from dual;
----------------------------------------------------------------------------------------
-- 5. 조건 : nvl, nvl2 ( null), decode, case (조건분기)
 
 select nvl( null , '대체값') from dual; -- null 이면 대체값 / null value logic ( replacement)
 select nvl(    comm, '입력안됨.')  from emp; -- X 오류 "unable to convert string value containing %s to a number: %s"
 select nvl( to_char(comm) , '입력안됨.') from emp; -- O  자료형을 맞춰야함.
 
 
 select nvl2(NULL, 'A' , 'B' ) from dual;   -- null 일때 b, 아니면 a
 
 select nvl2(mgr, mgr, '--' ) from emp;    -- 오류나는 이유는 ? "unable to convert string value containing %s to a number: %s"
 select nvl2(mgr, to_char(mgr), '상위관리자 x') from emp;    -- 해결방안 문자열 위치 변경
 
 ------
 
 select decode(deptno, 10, '부서10', 20, '부서20', 30, '부서30' )
 from emp;
 
 ------
 
 select case
            when deptno=10 then '부서10'
            when deptno=20 then '부서20'
            when deptno=30 then '부서30'
            else                '부서x'
        end 
 from emp;
 
 ------
 
 select case deptno
            when 10 then '부서10'
            when 20 then '부서20'
            when 30 then '부서30'
            else         '부서x'
        end 
 from emp;
 ---------------------------------------------------------------------------------------
 -- ##1. answkduf dustmqanswp (45~49)  EX
 -- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#61
 
 -- Q45 EMP테이블에서 NVL 함수를 사용하여 다음과 같이 출력하시오.
 select empno, ename, sal, comm, sal+comm as sal_plus_comm, nvl(comm,0) as comm_nvl,
 sal+nvl(comm, 0) as sal_plus_nvl_comm
 from emp;
-- Q46 EMP테이블에서 NVL2 함수를 사용하여 다음과 같이 출력하시오.
 select empno, ename, comm, nvl2(comm,'O','X')as comm_flag, annsal
 from emp;
-- Q47 EMP테이블에서 DECODE 함수를 사용하여 다음과 같이 출력하시오.  (decode) 
-- JOB이 MANAGER 는 급여의 10% 인상한 급여    sal*1.1
-- SALESMAN 는 급여의 5% 인상한 급여          sal*0.5
-- ANALYST 는 그대로                         sal
-- 나머지는 3% 인상된 급여       sal*0.3
 select empno, ename, job, sal, decode(job, 'MANAGER', sal * 1.1,
                                            'SALESMAN', sal * 1.05,
                                            'ANALYST', sal,
                    sal * 1.03) as upsal
 from emp;
 
-- Q48
-- EMP테이블에서 CASE 함수를 사용하여 다음과 같이 출력하시오. case when then else end
-- JOB이 MANAGER 는 급여의 10% 인상한 급여
-- SALESMAN 는 급여의 5% 인상한 급여
-- ANALYST 는 그대로
-- 나머지는 3% 인상된 급여
select empno, ename, job, sal,
    case job
                when 'MANAGER' then sal*1.1
                when 'SALESMAN' then sal*1.05
                when 'ANALYST' then sal
                else       sal*1.03
                end as upsal
    from emp;
-- Q49
-- 기준데이터 없이 조건식으로만 CASE 사용가능
-- COMM 값이 NULL 이면 해당사항 없음
-- 0 이면 수당없음
-- 0 초과시 초과한 수당을 출력력   
select empno, ename, comm, 
    case
            when comm is null then '해당사항없음'
            when comm = 0 then '수당없음'
            when comm > 0 then to_char(comm)
        end as comm_text
from emp;

------------------------------------------------------------------------------------
-- EX001
-- EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
-- EMP 테이블에서 ENAME이 다섯글자 이상이며 여섯글자 미만인 사원을 조회하시오.
-- MASKING_EMPNO 는 EMPNO 앞두자리외 뒷자리를 *로 출력
-- MASKING_ENAME 는 사원이름의 첫글자만 보여주고 나머지는 *로 출력
-- ※ 앞자리 추출 - SUBSTR(문자열, 어디에서, 몇개)
-- ※ RPAD - RPAD( 문자열, 몇자리, 채울값)
select empno,
substr(empno, 1, 2) || rpad('*', length(empno) -2, '*') as masking_empno,
ename,
substr(ename, 1,1) || rpad('*', length(ename) -1, '*') as masking_ename
from emp
where length(ename) > =5 and length(ename) <6;
    
-- 선생님 답    
-- select empno,rpad( substr( empno , 1,2  ) ,4,'*')MASKING_EMPNO 
-- , ename, rpad( substr( ename , 1,1  ) ,   length(ename)    , '*'    )  MASKING_ENAME 
-- from     emp  
--where    length(ename) >=5   and  length(ename)<6;  
-- EX002
-- EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
-- EMP 테이블에서 사원들의 월 평균 근무일 수는 21.5일
-- 2 하루 근무시간을 8시간으로 보았을때 사원들의 하루급여(DAY_PAY) 와 시급(TIME_PAY)을 계산하여 결과를 조회하시오.
-- ※ 하루급여는 소수점 세번째 자리에서 버리고(TRUNC), 시급은 두번째 소수점에서 반올림(ROUND)하시오
select empno, ename, sal ,
trunc(sal / 21.5, 2) as day_pay,
round((sal / 21.5) / 8, 1) as time_pay
from emp;

-- 선생님 답안
-- select  empno, ename, sal,  trunc(  sal/21.5  ,2)
-- day_pay, round( sal/21.5/8 , 1)  time_pay
-- from    emp;
-- EX003
-- EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
-- EMP테이블에서 사원들은 입사일(HIREDATE)을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 됨
-- 사원들이 정직원이 되는 날짜(R_JOB)를 YYYY-MM-DD 형식으로 오른쪽과 같이 출력하시오.
-- 추가 수당(COMM)이 없는 사원들의 추가수당은 N/A로 출력하시오.
select empno,ename, hiredate,
to_char(next_day(add_months(hiredate, 3), '월요일'),
'yyyy-mm-dd') as r_job, nvl(to_char(comm), 'n/a') as comm
from emp;

-- 선생님 답안
-- select    empno, ename, hiredate 
-- , TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,3) , '월요일') ,'YYYY-MM-DD')     R_JOB    
-- 3개월이(ADD_MONTHS) / 첫 월요일 NEXT_DAY( 날짜 , '월요일'  ) /  TO_CHAR  YYYY-MM-DD
--, NVL(  TO_CHAR( COMM ) , 'N/A'   ) COMM 
-- from      emp;
-- EX004
-- EMP 테이블에서 다음과 같은 결과가 나오도록 SQL문을 작성하시오.
-- 직속상관의 사원번호(MGR)를 다음과 같은 조건을 기준으로 변환해서 CHG_MGR열에 출력하시오
-- 직속상관의 사원번호가 존재하지 않을경우 : 00000
-- 직속상관의 사원번호 앞 두자리가 75일 경우 : 5555
-- 직속상관의 사원번호 앞 두자리가 76일 경우 : 6666
-- 직속상관의 사원번호 앞 두자리가 77일 경우 : 7777
-- 직속상관의 사원번호 앞 두자리가 78일 경우 : 8888
-- 그 외 직속상관 사원번호의 경우 : 본래 직속상관의 사원번호 그대로 출력
select empno, ename, mgr, 
        case 
             when mgr is null then '0000'
             when substr(to_char(mgr), 1,2 ) ='75' then '5555'
             when substr(to_char(mgr), 1,2 ) ='76' then '6666'
             when substr(to_char(mgr), 1,2 ) ='77' then '7777'
             when substr(to_char(mgr), 1,2 ) ='78' then '8888'
             else  to_char(mgr)
       end chg_mgr
from emp;


-- 선생님 답안
--select   empno, ename, mgr, 
--         case
--            when  mgr is null  then  '0000'
--            when  substr(  mgr  , 1, 2 )  = '78' then  '8888'
--            when  substr(  mgr  , 1, 2 )  = '77' then  '7777'
--            when  substr(  mgr  , 1, 2 )  = '76' then  '6666'
--            when  substr(  mgr  , 1, 2 )  = '75' then  '5555'
--            else  to_char(mgr)
--        end chg_mgr    
--from    emp

------------------------------------------------------------------------------------
-- Q19 ROUND를 이용하여 반올림 된 숫자 출력하기

 select  round(1234.5678),
 round(1234.5678, 0) round_0,
 round(1234.5678, 1) round_1,
 round(1234.5678, 2) round_2,
 round(1234.5678, -1) round_minus1,
 round(1234.5678, -2) round_minus2
  from dual;

--Q20 특정위치에서 버리는 TRUNC 함수
select 
trunc(1234.5678)  trunc,
trunc(1234.5678, 0)  trunc_0,
trunc(1234.5678, 1)  trunc_1,
trunc(1234.5678, 2)  trunc_2,
trunc(1234.5678, -1)  trunc_minus1,
trunc(1234.5678, -2)  trunc_minus2
from dual;

--Q21 
-- CEIL : 가장 가까운 큰 정수,
-- FLOOR : 가장 가까운 작은 정수 반환
-- select ceil(3.14) , floor(3.96), ceil(-3.14) , floor(-3.96) from dual;
select
ceil(3.14) as ceil_pos,
floor(3.14) as floor_pos,
ceil (-3.14) as ceil_neg,
floor(-3.14) as floor_neg
from dual;

--Q22 MOD : 특정 숫자를 나누고 그 나머지 출력
-- select mod(10,3) , mod(10,2) , mod(10,4) from dual;
select
mod(15, 6) ,mod(10,2), mod(11,2)
from dual;

--Q23 SYSDATE 함수를 사용하여 날짜 출력 SELECT하루이전, 이후
select sysdate 오늘, sysdate-1 어제, sysdate+1 내일
from dual;

-- Q24 ADD_MONTHS 3개월 후 날짜
select sysdate, add_months(sysdate, 3) "3개월뒤"
from dual;

-- Q25 EMP 테이블에서 입사 10주년이 되는 사원들의 데이터를 출력하시오
select empno, ename, hiredate, addmonths(hiredate, 120) "10주년"
from emp;

--sysdate, next_day, add_months, last_day, to_char
-- Q26 EMP 테이블에서 입사 42년 미만인 사원데이터를 출력하시오. 12*42 = 504 42년이 지나 안나올 수 도 있음. 안나오면 개월수 늘려서 테스트해볼것
select empno, ename, hiredate, add_months(hiredate, 504) "42년"
from emp
where add_months(hiredate, 504) > sysdate;

-- Q27 EMP 테이블에서 HIREDATE와 SYSDATE사이의 개월수를 출력하시오. empno, ename, hiredate, sysdate, months1, months2, months3
select empno, ename, hiredate, to_date('2024-12-21' , 'yyyy-mm-dd'),
MONTHS_BETWEEN(hiredate , to_date('2024-12-21' , 'yyyy-mm-dd')  ) months1,
MONTHS_BETWEEN(to_date('2024-12-21' , 'yyyy-mm-dd'), hiredate  )months2,
TRUNC(MONTHS_BETWEEN(to_date('2024-12-21' , 'yyyy-mm-dd'), hiredate )    )months3

from emp;

-- Q28 돌아오는 요일에 해당하는 날짜와 달의 마지막 날짜를 자도으로 계산 
-- sysdate, add_months, next_day / last_day / months_between
select sysdate, next_day(sysdate, '월요일') , last_day(sysdate)
from dual;

-- Q29 ROUND를 사용하여 날짜 데이터를 출력하시오.
select sysdate , 
round(sysdate, 'CC') "CC 세기 - Century",
round(sysdate, 'YYYY') "YYYY-★",
round(sysdate, 'Q') "Q-분기",
round(sysdate, 'DDD') "DDD-연중일수",
round(sysdate, 'HH') "HH 시간"
from dual;

-- Q30 TRUNC 함수를 사용하여 날짜 데이터를 출력하시오.

select sysdate , 
trunc(sysdate, 'CC') "CC 세기 - Century",
trunc(sysdate, 'YYYY') "YYYY-★",
trunc(sysdate, 'Q') "Q-분기",
trunc(sysdate, 'DDD') "DDD-연중일수",
trunc(sysdate, 'HH') "HH 시간"
from dual;

-- Q31 숫자와 문자열을 더하여 출력하시오 [문자 + 숫자 연습문제]
-- empno 숫자 + '500' (문자열 500이지만 , 알파벳포함x A) = 자동변환
select empno, ename, empno +'500'
from emp
where ename='SCOTT';

select empno, ename, empno + TO_NUMBER('500')
from emp
where ename='SCOTT';

-- Q32문자열과 숫자를 더하여 출력하시오.
-- 오류가 난다면 그이유를 적으시오.
select empno, ename, empno || '500a'
from emp
where ename='SCOTT';

-- Q33 SYSDATE 날짜 형식지정하여 출력하시오.
select sysdate, to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS' )
from dual;

-- Q34~38

-- Q6-34
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'MON') AS MON,
       TO_CHAR(SYSDATE, 'MONTH') AS MONTH,
       TO_CHAR(SYSDATE, 'DD') AS DD,
       TO_CHAR(SYSDATE, 'DY') AS DY,
       TO_CHAR(SYSDATE, 'DAY') AS DAY
  FROM DUAL;

-- Q6-35
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MON_KOR,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE') AS MON_JPN,
       TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MON_ENG,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = KOREAN' ) AS MONTH_KOR,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = JAPANESE') AS MONTH_JPN,
       TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS MONTH_ENG
  FROM DUAL;

-- Q6-36
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'MM') AS MM,
       TO_CHAR(SYSDATE, 'DD') AS DD,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = KOREAN' ) AS DY_KOR,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DY_JPN,
       TO_CHAR(SYSDATE, 'DY', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS DY_ENG,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = KOREAN' ) AS DAY_KOR,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = JAPANESE') AS DAY_JPN,
       TO_CHAR(SYSDATE, 'DAY', 'NLS_DATE_LANGUAGE = ENGLISH' ) AS DAY_ENG
  FROM DUAL;

-- Q6-37
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HH24MISS,
       TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HHMISS_AM,
       TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM
  FROM DUAL;

-- Q6-38
SELECT SAL,
       TO_CHAR(SAL, '$999,999') AS SAL_$,
       TO_CHAR(SAL, 'L999,999') AS SAL_L,
       TO_CHAR(SAL, '999,999.00') AS SAL_1,
       TO_CHAR(SAL, '000,999,999.00') AS SAL_2,
       TO_CHAR(SAL, '000999999.99') AS SAL_3,
       TO_CHAR(SAL, '999,999,00') AS SAL_4
  FROM EMP;
  
-- Q39 문자데이터와 숫자데이터를 연산하여 출력하시오.
select 1300-'1500' , '1300' + 1500
from dual;

-- Q40 '숫자로만 이뤄진 문자열'
select '1500 - 1300'
from dual;

select '1,500 - 1,300'
from dual; -- X

-- Q41. TO_NUMBER (포멧형식에 맞춰서)
select TO_NUMBER('1,500' , '999,999') - TO_NUMBER('1,300', '999,999')
from dual;

-- Q42. TO_CHAR
select  TO_DATE('2025-10-17' , 'YYYY-MM-DD')
from dual;

-- Q6-43
SELECT *
  FROM EMP
 WHERE HIREDATE > TO_DATE('1981/06/01', 'YYYY/MM/DD');

-- Q6-44
SELECT TO_DATE('49/12/10', 'YY/MM/DD') AS YY_YEAR_49,
       TO_DATE('49/12/10', 'RR/MM/DD') AS RR_YEAR_49,
       TO_DATE('50/12/10', 'YY/MM/DD') AS YY_YEAR_50,
       TO_DATE('50/12/10', 'RR/MM/DD') AS RR_YEAR_50,
       TO_DATE('51/12/10', 'YY/MM/DD') AS YY_YEAR_51,
       TO_DATE('51/12/10', 'RR/MM/DD') AS RR_YEAR_51
  FROM DUAL;