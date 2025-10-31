-- ■ 제약조건
1. NOT NULL     NULL 입력금지
2. UNIQUE       중복금지, NULL 허용
3. PRIMARY KEY  고유식별자,중복,NULL금지
4. FOREIGN KEY  다른테이블 참조
5. CHECK        조건검사

-- rdb
-- 테이블 관계 속성
-- FOREIGN KEY
-- 1. 다른테이블 참조
-- 2. 부모테이블의 값만 입력 가능
-- 3. 참조무결성 유지

-- 부서는 많은 사원(EMP_FK)을 가진다.
-- 부서테이블(DEPT_FK)이 먼저 존재
CREATE TABLE DEPT_FK(
    DEPTNO NUMBER PRIMARY KEY,
    DNAME VARCHAR2(50)
    );


CREATE TABLE EMP_FK(
    EMPNO NUMBER       PRIMARY KEY,
    ENAME VARCHAR2(50) NOT NULL,
    DEPTNO NUMBER(2),
    CONSTRAINT FK_DEPT FOREIGN KEY(DEPTNO) REFERENCES DEPT_FK(DEPTNO) ON DELETE CASCADE
    
);                       -- 내테이블의 DEPTNO    부모테이블 (DEPTNO)



-- 1. INSERT : dept
INSERT  INTO DEPT_FK (DEPTNO, DNNAME)  VALUES (10 , 'bug_hunter');
INSERT  INTO DEPT_FK VALUES (20 ,  'pawject');
INSERT  INTO DEPT_FK VALUES (30, 'test');
-- 2. 사원테이블에는 DEPT_FK에 존재하는 값만 삽입가능
insert into emp_fk (empno,ename, deptno) values (1, 'first' , 30);
insert into emp_fk (empno,ename, deptno) values (2, 'second' , 40); -- parent key not found   부모에 없는값은 못넣음


-- EMP_FK
-- 3. ONDELETE CASECADE 
delete from dept_fk where deptno=30; --부모를 삭제했더니
select * from emp_fk; --자식도 자동삭제 확인

-- Q1. jsp + oracle 외래키
1. 구조파악
desc appuser;
이름           널?       유형            
------------ -------- ------------- 
APP_USER_ID  NOT NULL NUMBER(38)    
EMAIL                 VARCHAR2(100) 
PASSWORD              VARCHAR2(255) 
MBTI_TYPE_ID          NUMBER(38)    
CREATED_AT            TIMESTAMP(6) 

desc post;
이름          널?       유형            
----------- -------- ------------- 
ID          NOT NULL NUMBER        
APP_USER_ID NOT NULL NUMBER        
TITLE       NOT NULL VARCHAR2(200) 
CONTENT     NOT NULL CLOB          
PASS                 VARCHAR2(100) 
CREATED_AT           DATE          
HIT                  NUMBER        

2. 부모와 자식테이블관계
유저는 많은 글을 가질 수 있다.

ALTER TABLE  post  ADD CONSTRAINT  fk_post_appuser  FOREIGN KEY(APP_USER_ID)   REFERENCES  appuser(APP_USER_ID);

SELECT  constraint_name, table_name , column_name 
from  user_cons_columns
where  table_name='POST'; --대문자

delete from appuser;
delete from post;
commit;

-- 포트폴리오상담
-- 프로젝트올리기

