create table sboard1(
     ID number NOT NULL ,
      APP_USER_ID NUMBER NOT NULL ,
      BTITLE VARCHAR2(1000) NOT NULL ,
      BCONTENT CLOB NOT NULL ,
      BPASS VARCHAR2(255)NOT NULL ,
      BFILE VARCHAR2(255),
      BHIT NUMBER(10),
      BIP VARCHAR2(255) NOT NULL, 
      CREATE_AT  TIMESTAMP(6)
);
desc sboard1;
select * from sboard1;
create sequence sboard1_seq start with 1 increment by 1;

insert into sboard1(ID, APP_USER_ID, BTITLE, BCONTENT, BPASS, BIP) values (sboard1_seq.nextval, 21, 'title', 'content', '1111', '127.0.0.1');

select * from sboard1 order by id desc;

select * from sboard1 where id=4;

update sboard1
set BTITLE='new1', BCONTENT='content1'
where id=4 and bpass='1111';

delete from sboard1 where id=4 and BPASS='1111';

commit;

select * from sboard1 where like '%a%';

select * from sboard1;

delete from sboard1;

desc sboard1;

select  count(*) from sboard1;

insert into sboard1 ( ID    , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip )
      select  sboard1_seq.nextval , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip   from sboard1
      
insert into sboard1 ( ID    , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip )
      values ( sboard1_seq.nextval, 1 , 'title', 'content', '1111', '', '127.0.0.1');
      
      
select * from (
    select row_number() over( order by created_at desc) as rnum ,
    ID    , app_user_id , btitle, bcontent, bpass, bfile,  bip, bhit, created_at
    from sboard1
    ) A
where A.rnum between  1 and 10

select count(*) from sboard1;
      
      
alter table sboard1  modify   bfile varchar2(100)  default '';      
commit;

desc sboard1;
drop table sboard1;


	CREATE SEQUENCE sboard1_seq; 
	CREATE TABLE sboard1 (
		id          NUMBER PRIMARY KEY,
		app_user_id   NUMBER NOT NULL ,
		btitle      VARCHAR2(1000)  NOT NULL,
		bcontent    CLOB   NOT NULL,
		bpass       VARCHAR2(255)   NOT NULL,
		bfile       VARCHAR2(255)  default  'no.png' ,
		bhit        NUMBER(10) default 0,
		bip         VARCHAR2(255)   NOT NULL,
		created_at   TIMESTAMP(6)    default sysdate
		-- create_at   DATE    default sysdate
		-- created_at TIMESTAMP(6) DEFAULT   SYSTIMESTAMP
	)
    
    
    
create table sboard2(    
    id number not null primary key,
    app_user_id number not null ,
    btitle varchar2(1000) not null ,
    bcontent clob not null ,
    bpass varchar2(255) not null ,
    bfile varchar2(255),
    bhit number default 0 ,
    bip varchar2(255) not null, 
    created_at date default sysdate
);
create sequence sboard2_seq;
commit;


desc sboard2;

