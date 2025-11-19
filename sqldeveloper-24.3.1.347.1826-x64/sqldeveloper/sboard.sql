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