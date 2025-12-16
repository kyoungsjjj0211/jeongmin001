desc appuser;
create table appuser(
APP_USER_ID     NUMBER(5)    primary key,
EMAIL        VARCHAR2(100)  NOT NULL,
PASSWORD     VARCHAR2(100),
MBTI_TYPE_ID  NUMBER(3),
CREATED_AT     DATE,
ufile        varchar2(255) default 'member.png',
mobile varchar2(50),
nickname varchar2(50),
provider  varchar2(50) not null,
provider_id varchar2(100)
);

create sequence authorities_seq;

CREATE TABLE authorities (
    AUTH_ID     NUMBER(5)   NOT NULL,
    EMAIL       VARCHAR2(255),
    AUTH        VARCHAR2(255) NOT NULL,
    APP_USER_ID NUMBER(5)
);
select email from appuser;
select email , auth from authorities;
SELECT * FROM APPUSER;
SELECT * FROM AUTHORITIES;
DESC APPUSER;

DROP TABLE authorities;

desc authorities;
SELECT constraint_name, table_name
FROM user_constraints
WHERE r_constraint_name IN (
    SELECT constraint_name
    FROM user_constraints
    WHERE table_name = 'APPUSER'
);




create sequence appuser_seq;
DROP SEQUENCE appuser_seq;
//create 회원가입 (시퀀스이용)
create sequence appuser_seq start with 1 increment by 1;

insert into appuser(APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID, CREATED_AT) values (appuser_seq.nextval ,'a@a','1111', 3, sysdate);

//read : 로그인(이메일과 비번이 같으면 로그인), 마이페이지(세션이용),전체유저확인
select count(*) from appuser where email='a@a' and password='1111';

select * from appuser order by APP_USER_ID desc; //전부 조회

select * from appuser where app_user_id=23; //선택 조회

// update:마이페이지 정보수정(mbti와 비밀번호 수정할수 있게)
update appuser
set password='1234', MBTI_TYPE_ID=2 
where app_user_id=23 and password='1111';

// delete : 탈퇴
delete from appuser
where APP_USER_ID=23 and PASSWORD='1111';

commit;

select app_user_id, email, password, mbti_type_id, created_at
from appuser;


desc appuser;
--      create : 회원가입 (시퀀스이용)
insert into appuser (APP_USER_ID , EMAIL, PASSWORD, MBTI_TYPE_ID)  values (appuser_seq.nextval, 'a@a' , '1111',3);

--      read   : 로그인(이메일과 비번이 같으면 로그인) , 마이페이지 (세션이용), 전체 유저확인
select count(*) cnt from appuser  where  email='a@a'  and PASSWORD='1111';
select * from appuser   order by app_user_id desc; 
select * from appuser   where app_user_id=3; 
--
--      update : 마이페이지 정보수정 (mbti와 비밀번호 수정할수 있게)
update appuser  set  password='1234' , MBTI_TYPE_ID=2  where app_user_id=43;
--      delete : 탈퇴
delete from appuser  where app_user_id=43  and password='1234'; 

alter table appuser rename column APPUSERID to APP_USER_ID;
alter table appuser rename column MBTITYPEID to MBTI_TYPE_ID;

SELECT * FROM mbti WHERE MBTITYPEID IN (1, 2, 3);
SELECT * FROM mbti WHERE MBTI_TYPE_ID = 3;
INSERT INTO mbti (MBTI_TYPE_ID, MBTI_NAME)
VALUES (1, 'ISTJ');  -- 예시 MBTI 이름

select * from appuser;

alter table appuser drop column UFILE ;
alter table appuser drop column CREATE_AT;
alter table appuser add UFILE VARCHAR2(255) DEFAULT 'thejoa703.png';
commit;
ALTER TABLE appuser
ADD UFILE VARCHAR2(255) DEFAULT 'member.png';
delete from appuser;

select * from appuser  email = '1@1';


ALTER TABLE appuser MODIFY (APP_USER_ID NUMBER(5));
ALTER TABLE appuser MODIFY (MBTI_TYPE_ID NUMBER(3));
ALTER TABLE appuser ADD (MOBILE VARCHAR2(50));
ALTER TABLE appuser ADD (NICKNAME VARCHAR2(50));

select * from appuser;
desc appuser;
insert into appuser(APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID,UFILE, MOBILE, NICKNAME) values (appuser_seq.nextval ,'1@1','1', 1, '1.png' , '1', 'na');

select   u.email, password, auth 
from appuser u left join authorities a on  u.email = a.email
where u.email = '1@1'

select * from appuser where email='1@1'

select password from appuser   where email='1@1' 

update appuser  set  MBTI_TYPE_ID=2, UFILE='2.png' , MOBILE='1', NICKNAME='1' where app_user_id=1;
commit;
delete from appuser  where app_user_id=15; 