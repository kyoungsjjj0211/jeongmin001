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



INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (1, '1111', 'AdminUser', '1@1', '01011110001', 'ma.png', SYSDATE);

-- 2. 일반 회원 계정 (2@2, 3@3 사용)
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (2, '2222', 'MemberJoy', '2@2', '01011110002', 'profile1.png', SYSDATE);

INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (3, '3333', 'CookingKim', '3@3', '01011110003', 'profile1.png', SYSDATE);

-- 4. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (4, '4444', 'RecipeLover', '4@4', '01011110004', 'profile1.png', SYSDATE);

-- 5. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (5, '5555', 'FreshFoodie', '5@5', '01011110005', 'profile1.png', SYSDATE);

-- 6. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (6, '6666', 'TheChef', '6@6', '01011110006', 'profile1.png', SYSDATE);

-- 7. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (7, '7777', 'HappyBaker', '7@7', '01011110007', 'profile1.png', SYSDATE);

-- 8. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (8, '8888', 'GourmetGuy', '8@8', '01011110008', 'profile1.png', SYSDATE);

-- 9. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (9, '9999', 'KitchenStar', '9@9', '01011110009', 'profile1.png', SYSDATE);

-- 10. 일반 회원 계정
INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE, JOINDATE)
VALUES (10, '1010', 'TasteTester', '10@10', '01011110010', 'profile1.png', SYSDATE);

-- 1. 관리자 권한
INSERT INTO authorities (email, auth) VALUES ('1@1', 'ROLE_ADMIN');

-- 2. 일반 회원 권한
INSERT INTO authorities (email, auth) VALUES ('2@2', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('3@3', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('4@4', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('5@5', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('6@6', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('7@7', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('8@8', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('9@9', 'ROLE_MEMBER');
INSERT INTO authorities (email, auth) VALUES ('10@10', 'ROLE_MEMBER');


INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 2, '칼칼한 돼지고기 김치찌개', 2, '김치찌게.png', 40, '중', 4, '깊고 진한 맛의 돼지고기 김치찌개 레시피입니다.', '돼지고기를 먼저 볶고 김치와 육수를 넣어 끓입니다.', SYSDATE, 120);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 4, '묵은지 참치 김치찌개', 2, '김치찌게.png', 30, '하', 2, '캔 참치를 넣어 감칠맛을 살린 김치찌개입니다.', '묵은지와 참치를 넣고 양념을 풀어 끓입니다.', SYSDATE - 1, 95);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 6, '햄 듬뿍 부대 김치찌개', 2, '김치찌게.png', 35, '중', 3, '햄과 소시지를 넣은 푸짐한 스타일의 김치찌개.', '부대찌개 재료를 넣어 한 번에 끓입니다.', SYSDATE - 2, 70);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 8, '초간단 15분 김치찌개', 2, '김치찌게.png', 15, '하', 1, '자취생을 위한 빠르고 쉬운 김치찌개 레시피.', '모든 재료를 넣고 끓이기만 하면 완성!', SYSDATE - 3, 150);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 1, '백종원 만능 김치찌개', 2, '김치찌게.png', 45, '상', 4, '국민 레시피, 실패 없는 김치찌개 황금 레시피.', '만능 소스로 깊은 맛을 냅니다.', SYSDATE - 4, 200);



INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 3, '바삭한 경양식 돈까스', 5, '돈까스.png', 60, '상', 2, '옛날 스타일의 얇고 바삭한 돈까스 레시피.', '돼지고기를 얇게 펴서 튀김옷을 입혀 튀깁니다.', SYSDATE - 5, 180);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 5, '에어프라이어 치즈 돈까스', 5, '돈까스.png', 25, '중', 3, '기름 없이 깔끔하게 만드는 치즈 돈까스.', '치즈를 넣고 에어프라이어에 굽습니다.', SYSDATE - 6, 130);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 7, '일식 정통 로스까스', 5, '돈까스.png', 50, '상', 1, '두툼한 등심을 사용한 일식 정통 돈까스.', '두껍게 썰어 저온에서 두 번 튀깁니다.', SYSDATE - 7, 100);


INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 9, '구수한 시골 된장찌개', 2, '된장찌개.png', 30, '하', 4, '집된장으로 끓인 정겨운 시골 된장찌개 맛.', '멸치 육수에 재료를 넣고 끓입니다.', SYSDATE - 8, 80);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 10, '차돌박이 된장찌개', 2, '된장찌개.png', 25, '중', 2, '차돌박이의 기름진 고소함이 일품!', '차돌박이를 볶다가 된장을 풀고 끓입니다.', SYSDATE - 9, 110);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 2, '해물 뚝배기 된장찌개', 2, '된장찌개.png', 40, '중', 3, '새우, 꽃게 등 해물을 넣은 시원한 된장찌개.', '해물 육수로 깊은 맛을 냅니다.', SYSDATE - 10, 60);



INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 4, '소고기 듬뿍 미역국', 2, '미역국.png', 50, '하', 4, '생일 상에 빠질 수 없는 기본 소고기 미역국.', '소고기를 볶고 미역을 넣은 후 물을 붓고 끓입니다.', SYSDATE - 11, 50);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 6, '깔끔한 조개 미역국', 2, '미역국.png', 40, '하', 2, '바지락을 넣어 시원함을 살린 조개 미역국.', '바지락 육수를 내어 미역과 함께 끓입니다.', SYSDATE - 12, 40);


INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 8, '휴게소식 튀김 우동', 5, '우동.png', 20, '하', 1, '순식간에 완성하는 감칠맛 나는 국물 우동.', '면을 삶고 국물에 튀김을 올려냅니다.', SYSDATE - 13, 90);

INSERT INTO RECIPES (RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS, CREATED_AT, VIEWS)
VALUES (recipes_seq.NEXTVAL, 1, '얼큰한 해물 볶음 우동', 5, '우동.png', 30, '중', 2, '매콤한 양념에 해물을 넣고 볶은 우동.', '해물과 면을 센 불에 빠르게 볶습니다.', SYSDATE - 14, 75);


-- recipes_ingre_map_seq 시퀀스를 사용하여 INGRE_MAP_ID 자동 부여

-- RECIPE_ID 1~20 에 대한 INGRE_MAP_ID 생성
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (1, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (2, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (3, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (4, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (5, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (6, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (7, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (8, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (9, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (10, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (11, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (12, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (13, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (14, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (15, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (16, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (17, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (18, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (19, recipes_ingre_map_seq.NEXTVAL);
INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID) VALUES (20, recipes_ingre_map_seq.NEXTVAL);





-- RECIPE_ID 1~5: 김치찌게.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (1, '김치찌게.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (2, '김치찌게.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (3, '김치찌게.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (4, '김치찌게.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (5, '김치찌게.png');

-- RECIPE_ID 6~8: 돈까스.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (6, '돈까스.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (7, '돈까스.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (8, '돈까스.png');

-- RECIPE_ID 9~11: 된장찌개.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (9, '된장찌개.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (10, '된장찌개.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (11, '된장찌개.png');

-- RECIPE_ID 12~13: 미역국.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (12, '미역국.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (13, '미역국.png');

-- RECIPE_ID 14~15: 우동.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (14, '우동.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (15, '우동.png');

-- RECIPE_ID 16~17: 육개장.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (16, '육개장.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (17, '육개장.png');

-- RECIPE_ID 18~19: 짬뽕.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (18, '짬뽕.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (19, '짬뽕.png');

-- RECIPE_ID 20: 초밥.png
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (20, '초밥.png');



-- INGRE_MAP_ID 1 (김치찌개) 상세 재료
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (1, '돼지고기 목살', '300g');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (1, '묵은지', '1/4포기');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (1, '두부', '1/2모');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (1, '대파', '1/2대');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (1, '다진 마늘', '1T');

-- INGRE_MAP_ID 6 (돈까스) 상세 재료
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (6, '돼지고기 등심', '2장');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (6, '밀가루', '1컵');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (6, '계란', '2개');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (6, '빵가루', '1.5컵');

-- INGRE_MAP_ID 9 (된장찌개) 상세 재료
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (9, '된장', '2T');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (9, '애호박', '1/3개');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (9, '감자', '1개');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (9, '양파', '1/2개');
INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM) VALUES (9, '두부', '1/2모');




-- 1. 김치
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (1, '배추김치', '배추김치.png', '사계절', '5°C 이하', 18, '장 건강, 면역력 증진', '배추가 무르지 않고 양념이 잘 배어있는 것', '별도 손질 불필요', '김치냉장고에 밀봉 보관');

-- 2. 돼지고기 (돈까스, 김치찌개)
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (2, '돼지고기 등심', '돼지고기.png', '사계절', '0°C~5°C', 150, '단백질 공급, 피로 회복', '선홍색을 띠고 탄력이 있는 것', '핏물을 제거하고 용도에 맞게 손질', '냉장 또는 냉동 보관');

-- 3. 된장
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (3, '재래식 된장', '된장.png', '사계절', '상온', 198, '항암 효과, 해독 작용', '색이 밝고 구수한 향이 나는 것', '별도 손질 불필요', '밀봉하여 서늘한 곳에 보관');

-- 4. 미역
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (4, '건미역', '미역.png', '겨울~초여름', '상온', 133, '산후 조리, 혈액 순환', '줄기가 가늘고 윤기가 나는 것', '물에 불려 헹구기', '건조하고 서늘한 곳에 보관');

-- 5. 우동 면
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (5, '생 우동면', '우동면.png', '사계절', '0°C~5°C', 200, '주요 에너지원', '유통기한 확인 및 탄력이 있는 것', '끓는 물에 살짝 데치기', '냉장 보관');

-- 6. 소고기 (육개장)
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (6, '소고기 양지', '소고기.png', '사계절', '0°C~5°C', 180, '철분 보충, 기력 회복', '붉은색을 띠고 지방이 적당히 분포된 것', '핏물을 빼고 덩어리째 끓여 사용', '냉장 또는 냉동 보관');

-- 7. 해산물 (짬뽕, 초밥)
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (7, '새우', '새우.png', '가을', '0°C~5°C', 93, '고단백 저지방, 칼슘 풍부', '껍질이 단단하고 윤기가 나는 것', '머리와 내장 제거', '냉동 보관');



-- 8. 두부
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (8, '부침용 두부', '두부.png', '사계절', '0°C~5°C', 76, '식물성 단백질, 소화 용이', '모양이 흐트러지지 않고 신선한 것', '흐르는 물에 헹구기', '밀봉하여 물에 잠기게 냉장 보관');

-- 9. 양파
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (9, '양파', '양파.png', '초여름', '상온', 40, '항산화 작용, 혈당 조절', '껍질이 잘 마르고 단단한 것', '겉껍질을 벗겨내고 세척', '망에 담아 서늘하고 건조한 곳에 보관');

-- 10. 쌀
INSERT INTO material (materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide)
VALUES (10, '백미', '백미.png', '가을', '상온', 360, '주요 에너지원, 포만감', '윤기가 돌고 깨진 쌀알이 적은 것', '여러 번 깨끗이 씻기', '밀봉하여 서늘한 곳에 보관');