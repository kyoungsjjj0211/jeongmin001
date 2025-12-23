create table material3 ( -- 재료 마스터 테이블 생성
 materialid number(6) primary key, -- 재료 고유번호 (PK)
 title varchar2(200) not null, -- 재료명 (필수)
 imageurl varchar2(300) default 'defult.png', -- 이미지 경로/URL (기본값)
 season varchar2(100), -- 제철 정보
 temperature varchar2(50), -- 보관 온도
 calories100g varchar2(50), -- 100g당 열량
 efficacy varchar2(1000), -- 효능/특징 설명
 buyguide varchar2(1000), -- 구입요령
 trimguide varchar2(1000), -- 손질법
 storeguide varchar2(1000), -- 보관법 
 category        varchar2(100), -- 카테고리 (예: 과일/채소/육류)
 created_at     date default sysdate not null, -- 생성일
 updated_at     date default sysdate not null ); -- 수정일
 
create sequence material3_seq; -- material3 자동 증가용 시퀀스

CREATE TABLE material_allergy (
  allergy_id      NUMBER PRIMARY KEY,
  materialid      NUMBER NOT NULL,
  allergen_name   VARCHAR2(100) NOT NULL,
  note            VARCHAR2(500),

  CONSTRAINT fk_material_allergy
    FOREIGN KEY (materialid)
    REFERENCES material3(materialid)
);

CREATE TABLE material_alias ( //별칭 테이블 
  alias_id     NUMBER PRIMARY KEY,
  materialid   NUMBER NOT NULL,          -- 대표 재료 FK
  alias_name   VARCHAR2(200) NOT NULL,   -- 저지방우유 / 무지방우유 / 서울우유 등
  CONSTRAINT fk_material_alias
    FOREIGN KEY (materialid)
    REFERENCES material3(materialid)
);

CREATE SEQUENCE material_alias_seq;


CREATE TABLE buy_click_log (
  log_id      NUMBER PRIMARY KEY,
  materialid  NUMBER(6) NOT NULL,
  mall_name   VARCHAR2(30) DEFAULT '11st' NOT NULL,
  keyword     VARCHAR2(200) NOT NULL,   -- 예: 양파
  clicked_at  DATE DEFAULT SYSDATE NOT NULL,

  CONSTRAINT fk_buylog_material
    FOREIGN KEY (materialid) REFERENCES material3(materialid)
    ON DELETE CASCADE
);

CREATE SEQUENCE material3_buy_click_log_seq;
CREATE INDEX idx_buylog_material ON material3_buy_click_log(materialid, mall_name, clicked_at);





//crud

insert into material3 (materialid, title, category)
  values (material3_seq.nextval, '양파', '채소');

insert into material3 (materialid, title, category)
 values (material3_seq.nextval, '우유', '유제품');

insert into material_allergy (allergy_id, materialid, allergen_name, note) 
  values (1, (select materialid from material3 where title = '우유'), '우유', '유당 불내증 주의');
insert into material_alias (alias_id, materialid, alias_name)
  values ( material_alias_seq.NEXTVAL, (SELECT materialid FROM material3 WHERE title = '우유'), '저지방우유');

insert into material_alias (alias_id, materialid, alias_name)
  values (material_alias_seq.NEXTVAL,(select materialid from material3 where title = '우유'), '무지방우유');

insert into buy_click_log (
  log_id, materialid, mall_name, keyword)
  values (material3_buy_click_log_seq.nextval, (select materialid from material3 where title = '양파'), '11st', '양파');
