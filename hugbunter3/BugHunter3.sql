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
create index idx_material3_title on material3(title); -- 재료명 검색 속도 향상 인덱스
create index idx_material3_category on material3(category);  -- 카테고리별 조회 속도 향상 인덱스

create table allergen_master (  -- 알레르겐(알레르기 유발물질) 표준 테이블
  allergen_id    number(6) primary key,   -- 알레르겐 고유번호 (PK)
  allergen_code  varchar2(50) unique,      -- 내부 코드(예: EGG, MILK, PEANUT)
  allergen_name  varchar2(100) not null,   -- 표시명(예: 난류(계란))
  note           varchar2(1000) -- 비고/설명
);

create sequence allergen_master_seq;  -- allergen_master 자동 증가용 시퀀스
create index idx_allergen_name on allergen_master(allergen_name); -- 알레르겐명 검색 속도 인덱스

create table material3_allergen_map ( -- 재료와 알레르겐 관계 테이블
  materialid     number(6) not null,  -- 재료ID (material3 참조)
  allergen_id    number(6) not null, -- 알레르겐ID (allergen_master 참조)
  source         VARCHAR2(50) default 'manual' not null, -- 데이터 출처 manual / api / inferred 등
  confidence     number(3) default 100,                 -- 신뢰도 0~100 (선택)
  created_at     date default sysdate not null,     -- 매핑 생성일

  constraint pk_material3_allergen primary KEY (materialid, allergen_id),
  constraint fk_m3am_material foreign key (materialid) references material3(materialid),
  constraint fk_m3am_allergen foreign key (allergen_id) references allergen_master(allergen_id)
);

create index idx_m3am_material on material3_allergen_map(materialid); -- 재료별 알레르겐 조회 속도 인덱스
create index idx_m3am_allergen on material3_allergen_map(allergen_id); -- 알레르겐별 재료 조회 속도 인덱스


create table material3_product_map (  -- 재료와 외부 쇼핑몰 상품 연결 테이블
  map_id          number(12) primary key,  -- 매핑 고유번호 (PK)
  materialid      number(6) not null,   -- 재료ID (material3 참조)
  mall_name       varchar2(30) default '11st' not null,   -- 쇼핑몰 구문 이름'11st'
  external_item_id varchar2(100) not null,                -- 11번가 상품번호(문자열로 안전)
  item_title      varchar2(500),                         -- 상품명(검색 결과 저장용)
  item_url        varchar2(1000),                       -- 상품 URL
  price           number(12),                                -- 가격(정수 기준으로 저장 권장)
  fetched_at      date default sysdate not null,             -- 상품정보 조회 시각

  constraint fk_m3pm_material foreign key (materialid) references material3(materialid)
);

create table material3_api_cache (
  cache_id      number(12) primary key,     -- 캐시 고유번호 (PK)
  materialid    number(6) not null,         -- 재료ID (material3 참조)
  api_name      varchar2(50) not null,    -- API 이름 '11st_search', 'foodqr_allergy' 등
  cache_key     varchar2(300),            -- 요청키(재료명, 바코드, itemId 등)
  payload_json  clob,                     -- API 응답 원문 JSON 저장
  fetched_at    date default sysdate not null,  -- 호출 시각
  expires_at    date,                            -- 만료 시각
  status        varchar2(20) default 'ok' not null,  -- 상태값(ok/error/empty)
  err_message   varchar2(1000),                       -- 에러 메시지(실패 시)

  constraint ck_cache_status check (status in ('ok','error','empty')),
  constraint fk_cache_material3
    foreign key (materialid) references material3(materialid)
);

create sequence material3_api_cache_seq;
create index idx_cache_m3_api on material3_api_cache(materialid, api_name);
create index idx_cache_m3_key on material3_api_cache(api_name, cache_key);







//crud
//재료 insert 
insert into material3 (
  materialid, title, imageurl, season, temperature, calories100g,
  efficacy, buyguide, trimguide, storeguide, category, created_at, updated_at
) values (
  material3_seq.nextval, '사과', 'apple.png', '가을', '0~4℃', '52kcal',
  '피로 회복', '단단하고 윤기 있는 것', '물로 세척', '냉장 보관', '과일', sysdate, sysdate
);

insert into material3 (
  materialid, title, imageurl, season, temperature, calories100g,
  efficacy, buyguide, trimguide, storeguide, category, created_at, updated_at
) values (
  material3_seq.nextval, '우유', 'milk.png', '사계절', '0~4℃', '60kcal',
  '칼슘 보충', '유통기한 확인', '흔들어 사용', '냉장 보관', '유제품', sysdate, sysdate
);
//알레르기 inser
insert into allergen_master (allergen_id, allergen_code, allergen_name, note)
values (allergen_master_seq.nextval, 'MILK', '우유', '유제품 알레르기');
insert into allergen_master (allergen_id, allergen_code, allergen_name, note)
values (allergen_master_seq.nextval, 'EGG', '난류(계란)', '계란 알레르기');

//재료+알러지 mapping insert
insert into material3_allergen_map (materialid, allergen_id, source, confidence, created_at)
select m.materialid, a.allergen_id, 'manual', 100, sysdate
from material3 m, allergen_master a
where m.title = '우유'
  and a.allergen_code = 'MILK';
//11번가 mapping test
insert into material3_product_map ( map_id, materialid, mall_name, external_item_id, item_title, item_url, price, fetched_at)
  values (1, (select materialid from material3 where title='사과'), '11st', '1234567890', '국산 사과 5kg', 'https://www.11st.co.kr/products/1234567890', 29900, sysdate);
//알래르기 api 캐시 insert 
insert into material3_api_cache (cache_id, materialid, api_name, cache_key, payload_json, fetched_at, expires_at, status, err_message)
  values ( material3_api_cache_seq.nextval,(select materialid from material3 where title='우유'), 'foodqr_allergy', 'barcode:8800000000000', '{"allergens":["우유"],"source":"FoodQR"}', sysdate, sysdate + 1, 'ok', null);


//재료 select
select * from material3
where title = '사과';

//재료 select all
select materialid, title, category, season, imageurl, created_at
from material3
order by created_at desc;

//재료별 알레르기
select m.materialid, m.title AS material_title, a.allergen_code, a.allergen_name, mam.source, mam.confidence, mam.created_at
from material3 m
join material3_allergen_map mam on mam.materialid = m.materialid
join allergen_master a on a.allergen_id = mam.allergen_id
where m.title = '우유'
order by a.allergen_name;

//재료별 11번가 매핑
select m.title as material_title, p.mall_name, p.external_item_id, p.item_title, p.price, p.item_url, p.fetched_at
from material3 m
join material3_product_map p on p.materialid = m.materialid
where m.title = '사과'
order by p.fetched_at desc;

//api 캐시 조회 재료 + api_name
select c.cache_id, m.title as material_title, c.api_name, c.cache_key, c.status, c.fetched_at, c.expires_at
from material3_api_cache c
join material3 m on m.materialid = c.materialid
where c.api_name = 'foodqr_allergy'
order by c.fetched_at desc;

//재료 update
update material3
set calories100g = '48kcal', updated_at = sysdate
where title = '사과';

//알레르기 update
update allergen_master
set note = '유제품(우유) 알레르기 주의'
where allergen_code = 'MILK';

//매핑 수정 update
update material3_allergen_map
set source = 'api',
    confidence = 95
where materialid = (select materialid from material3 where title='우유')
  and allergen_id = (select allergen_id from allergen_master where allergen_code='MILK');
  
//캐시 수정
update material3_api_cache
set status = 'error',
    err_message = 'API TIMEOUT'
where api_name = 'foodqr_allergy'
  and materialid = (select materialid from material3 where title='우유');
  
//매핑 삭제
delete from material3_allergen_map
where materialid = (select materialid from material3 where title='우유');
//상품 매핑 삭제
delete from material3_product_map
where materialid = (select materialid from material3 where title='사과');

//캐시 삭제
delete from material3_api_cache
where materialid = (select materialid from material3 where title='우유');

//알레르기 삭제
delete from allergen_master
where allergen_code in ('MILK','EGG');

//재료 삭제
delete from material3
where title in ('사과','우유');

