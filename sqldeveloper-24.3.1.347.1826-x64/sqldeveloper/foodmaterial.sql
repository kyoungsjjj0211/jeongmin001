commit;
select * from authorities;
-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_seq
START WITH 13
INCREMENT BY 1
NOCACHE;


-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_ingre_map_seq
START WITH 100
INCREMENT BY 1
NOCACHE;

select * from recipes_ingre_map;
select * from recipes;


//로그인
CREATE TABLE BUG (
    APPUSERID   NUMBER          PRIMARY KEY,         
    PASSWORD    VARCHAR2(100)   NOT NULL,           
    NICKNAME    VARCHAR2(50)    UNIQUE,              
    EMAIL       VARCHAR2(100)   UNIQUE,              
    MOBILE      VARCHAR2(20)    UNIQUE,              
    BFILE       VARCHAR2(225),                      
    JOINDATE    DATE DEFAULT SYSDATE                
);

//음식,레시피
CREATE TABLE CATEGORY (
   CATEGORY      NUMBER PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(100)
);

CREATE TABLE recipes (
    RECIPE_ID   NUMBER PRIMARY KEY,
    APPUSERID   NUMBER NOT NULL,
    TITLE       VARCHAR2(255) NOT NULL,
    CATEGORY    NUMBER, 
    IMAGE       VARCHAR2(255) DEFAULT 'user.png',
    COOK_TIME   NUMBER DEFAULT 0,
    DIFFICULTY  VARCHAR2(50),
    SERVINGS    NUMBER DEFAULT 1,
    DESCRIPTION VARCHAR2(4000),
    INSTRUCTIONS VARCHAR2(4000),
    CREATED_AT  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT  TIMESTAMP,
    VIEWS       NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);
CREATE SEQUENCE recipes_ingre_map_seq
START WITH 100
INCREMENT BY 1
NOCACHE;

CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

select * from recipes_img;
select * from recipes_ingre_map;
select * from recipes_ingre;

CREATE SEQUENCE recipes_ingre_map_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE recipes_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

select * from CATEGORY;
INSERT INTO CATEGORY VALUES (1, '전체');
INSERT INTO CATEGORY VALUES (2, '한식');
INSERT INTO CATEGORY VALUES (3, '양식');
INSERT INTO CATEGORY VALUES (4, '중식');
INSERT INTO CATEGORY VALUES (5, '일식');
INSERT INTO CATEGORY VALUES (6, '디저트');
INSERT INTO CATEGORY VALUES (7, '건강식');
INSERT INTO CATEGORY VALUES (8, '기타');

CREATE TABLE  (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);

CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);

CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),

    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID)
);

//재료

create table material (
    materialid          NUMBER(6)        PRIMARY KEY,           -- 재료 고유번호 (PK)
    title                  VARCHAR2(200)    NOT NULL,           -- 재료명
    imageurl            VARCHAR2(300)   default  'defult.png',  -- 이미지 경로 또는 URL
    season               VARCHAR2(100),                         -- 제철 정보
    temperature      VARCHAR2(50),                              -- 보관 온도
    calories100g      NUMBER(6),                                -- 100g당 열량
    efficacy             VARCHAR2(1000),
    buyguide            VARCHAR2(1000),                         -- 구입요령
    trimguide           VARCHAR2(1000),                         -- 손질법
    storeguide          VARCHAR2(1000)                         -- 보관법
);

desc material;
select * from material;
create sequence material_seq start with 1 increment by 1;
 
insert into material(
    materialid, title, imageurl, season, temperature, calories100g,
    efficacy, buyguide, trimguide, storeguide
) values (
      material_seq.nextval,
    '메밀면',
    'https://대충주소.com/img.jpg',
    '연중제철',
    '1~5℃',
    142,
    '소화 촉진',
    '유통기한을 확인하고 구입한다.',
    '끓는 물에 삶아서 사용한다.',
    '직사광선을 피해 보관한다.'
);

select * from material
where materialid = 1;

select * from material
order by materialid desc;



update material set 
title = '메밀면 (국산)',
imageurl = 'https://대충주소.com/defult.png',
season = '6월, 7월, 8월',
temperature ='1~5℃',
calories100g = 150,
efficacy = '소화 촉진, 장 건강 도움',
buyguide = '면의 색깔 및 상태를 확인후 구매한다',
trimguide= '면을 부서서 빻아 매밀 가루로 사용한다.',
storeguide = '서늘하고 통풍이 잘 되는 곳에 보관한다.'
where materialid =1;

delete from material where materialid=1;



--//기본 JOIN 방식 (FROM A, B WHERE A= B)
--SELECT m.materialid,
--       m.title,
--       mc.category_name
--FROM material m, materialcategory mc
--WHERE m.materialid = mc.materialid
--  AND m.materialid = 1;
--//2. NATURAL JOIN 방식
--  SELECT materialid, title, categoryname
--FROM material 
--NATURAL JOIN materialcategory
--WHERE materialid = 1;
--//3. LEFT JOIN (명시적 ON 사용)
--SELECT m.materialid,
--       m.title,
--       mc.category_name
--FROM material m
--LEFT JOIN materialcategory mc
--       ON m.materialid = mc.materialid
--WHERE m.materialid = 1;
--//4. LEFT JOIN USING (공통 컬럼 자동 인식)
--SELECT materialid, title, categoryname
--FROM material
--LEFT JOIN materialcategory USING(materialid)
--WHERE materialid = 1;


//테이블 합본

CREATE TABLE BUG (
    APPUSERID   NUMBER          PRIMARY KEY,         
    PASSWORD    VARCHAR2(100)   NOT NULL,           
    NICKNAME    VARCHAR2(50)    UNIQUE,              
    EMAIL       VARCHAR2(100)   UNIQUE,              
    MOBILE      VARCHAR2(20)    UNIQUE,              
    BFILE       VARCHAR2(225),                      
    JOINDATE    DATE DEFAULT SYSDATE                
);
create sequence users_seq;

CREATE TABLE CATEGORY (
   CATEGORY      NUMBER PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(100)
);

CREATE TABLE recipes (
    RECIPE_ID   NUMBER PRIMARY KEY,
    APPUSERID   NUMBER NOT NULL,
    TITLE       VARCHAR2(255) NOT NULL,
    CATEGORY    NUMBER, 
    IMAGE       VARCHAR2(255) DEFAULT 'user.png',
    COOK_TIME   NUMBER DEFAULT 0,
    DIFFICULTY  VARCHAR2(50),
    SERVINGS    NUMBER DEFAULT 1,
    DESCRIPTION VARCHAR2(4000),
    INSTRUCTIONS VARCHAR2(4000),
    CREATED_AT  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT  TIMESTAMP,
    VIEWS       NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);




CREATE TABLE recipes_img (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);

CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);


CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),

    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID)
);
create sequence material_seq;
create table material (
    materialid          NUMBER(6)        PRIMARY KEY,           -- 재료 고유번호 (PK)
    title                  VARCHAR2(200)    NOT NULL,           -- 재료명
    imageurl            VARCHAR2(300)   default  'defult.png',  -- 이미지 경로 또는 URL
    season               VARCHAR2(100),                         -- 제철 정보
    temperature      VARCHAR2(50),                              -- 보관 온도
    calories100g      NUMBER(6),                                -- 100g당 열량
    efficacy             VARCHAR2(1000),
    buyguide            VARCHAR2(1000),                         -- 구입요령
    trimguide           VARCHAR2(1000),                         -- 손질법
    storeguide          VARCHAR2(1000)                         -- 보관법
);
select * from material;
delete from material;
commit;
select * from BUG;
select * from authorities;
create table authorities (
userid varchar2(100) not null
auth varchar2(100) not null
);
insert into authorities values ('1@1', 'ROLE_ADMIN');
commit;

alter table authorities rename column userid to email;

select * from authorities;

CREATE TABLE BUG (
    APPUSERID   NUMBER          PRIMARY KEY,         
    PASSWORD    VARCHAR2(100)   NOT NULL,           
    NICKNAME    VARCHAR2(50)    UNIQUE,              
    EMAIL       VARCHAR2(100)   UNIQUE,              
    MOBILE      VARCHAR2(20)    UNIQUE,              
    BFILE       VARCHAR2(225),                      
    JOINDATE    DATE DEFAULT SYSDATE                
);


CREATE TABLE CATEGORY (
   CATEGORY      NUMBER PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(100)
);


-- RECIPES 테이블
CREATE TABLE recipes (
    RECIPE_ID    NUMBER PRIMARY KEY,
    APPUSERID    NUMBER NOT NULL,
    TITLE        VARCHAR2(255) NOT NULL,
    CATEGORY     NUMBER, 
    IMAGE        VARCHAR2(255) DEFAULT 'user.png',
    COOK_TIME    NUMBER DEFAULT 0,
    DIFFICULTY   VARCHAR2(50),
    SERVINGS     NUMBER DEFAULT 1,
    DESCRIPTION  VARCHAR2(4000),
    INSTRUCTIONS VARCHAR2(4000),
    CREATED_AT   DATE DEFAULT SYSDATE,
    UPDATED_AT   DATE,
    VIEWS        NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);


-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_seq
START WITH 10
INCREMENT BY 1
NOCACHE;


-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_ingre_map_seq
START WITH 100
INCREMENT BY 1
NOCACHE;

-- 이미지 테이블 (CASCADE 적용)
CREATE TABLE recipes_img (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

-- 재료 매핑 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);


commit;

-- 재료 상세 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),
    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID) ON DELETE CASCADE
);


create table material (
    materialid          NUMBER(6)        PRIMARY KEY,           -- 재료 고유번호 (PK)
    title                  VARCHAR2(200)    NOT NULL,           -- 재료명
    imageurl            VARCHAR2(300)   default  'defult.png',  -- 이미지 경로 또는 URL
    season               VARCHAR2(100),                         -- 제철 정보
    temperature      VARCHAR2(50),                              -- 보관 온도
    calories100g      NUMBER(6),                                -- 100g당 열량
    efficacy             VARCHAR2(1000),
    buyguide            VARCHAR2(1000),                         -- 구입요령
    trimguide           VARCHAR2(1000),                         -- 손질법
    storeguide          VARCHAR2(1000)                         -- 보관법
);


-- 1. 관리자 권한
INSERT INTO authorities (email, auth) VALUES ('1@1', 'ROLE_ADMIN');
commit;




//새로 추가하는 테이블

CREATE TABLE BUG (
    APPUSERID   NUMBER          PRIMARY KEY,         
    PASSWORD    VARCHAR2(100)   NOT NULL,           
    NICKNAME    VARCHAR2(50)    UNIQUE,              
    EMAIL       VARCHAR2(100)   UNIQUE,              
    MOBILE      VARCHAR2(20)    UNIQUE,              
    BFILE       VARCHAR2(225),                      
    JOINDATE    DATE DEFAULT SYSDATE                
);



CREATE TABLE CATEGORY (
   CATEGORY      NUMBER PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(100)
);


-- RECIPES 테이블
CREATE TABLE recipes (
    RECIPE_ID    NUMBER PRIMARY KEY,
    APPUSERID    NUMBER NOT NULL,
    TITLE        VARCHAR2(255) NOT NULL,
    CATEGORY     NUMBER, 
    IMAGE        VARCHAR2(255) DEFAULT 'user.png',
    COOK_TIME    NUMBER DEFAULT 0,
    DIFFICULTY   VARCHAR2(50),
    SERVINGS     NUMBER DEFAULT 1,
    DESCRIPTION  VARCHAR2(4000),
    INSTRUCTIONS VARCHAR2(4000),
    CREATED_AT   DATE DEFAULT SYSDATE,
    UPDATED_AT   DATE,
    VIEWS        NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);


-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_seq
START WITH 10
INCREMENT BY 1
NOCACHE;


-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_ingre_map_seq
START WITH 100
INCREMENT BY 1
NOCACHE;

-- 이미지 테이블 (CASCADE 적용)
CREATE TABLE recipes_img (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

-- 재료 매핑 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

CREATE SEQUENCE recipes_ingre_map_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- 레시피 PK용 시퀀스
CREATE SEQUENCE recipes_seq
START WITH 1
INCREMENT BY 1
NOCACHE;



-- 재료 상세 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),
    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID) ON DELETE CASCADE
);


create table material (
    materialid          NUMBER(6)        PRIMARY KEY,           -- 재료 고유번호 (PK)
    title                  VARCHAR2(200)    NOT NULL,           -- 재료명
    imageurl            VARCHAR2(300)   default  'defult.png',  -- 이미지 경로 또는 URL
    season               VARCHAR2(100),                         -- 제철 정보
    temperature      VARCHAR2(50),                              -- 보관 온도
    calories100g      NUMBER(6),                                -- 100g당 열량
    efficacy             VARCHAR2(1000),
    buyguide            VARCHAR2(1000),                         -- 구입요령
    trimguide           VARCHAR2(1000),                         -- 손질법
    storeguide          VARCHAR2(1000)                         -- 보관법
);
create sequence material_seq;

select * from CATEGORY;
INSERT INTO CATEGORY VALUES (1, '전체');
INSERT INTO CATEGORY VALUES (2, '한식');
INSERT INTO CATEGORY VALUES (3, '양식');
INSERT INTO CATEGORY VALUES (4, '중식');
INSERT INTO CATEGORY VALUES (5, '일식');
INSERT INTO CATEGORY VALUES (6, '디저트');
INSERT INTO CATEGORY VALUES (7, '건강식');
INSERT INTO CATEGORY VALUES (8, '기타');
commit;
