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

create table material_allergy (
  allergy_id      number primary key,
  materialid      number not null,
  allergen_name   varchar2(100) not null,
  note            varchar2(500),

  constraint fk_material_allergy
    foreign key (materialid)
    references material3(materialid)
);

create sequence material_allergy_seq;

create table material_alias ( --별칭 테이블 
  alias_id     number primary key,
  materialid   number not null,          -- 대표 재료 FK
  alias_name   varchar2(200) not null,   -- 저지방우유 / 무지방우유 / 서울우유 등
  
 constraint fk_material_alias foreign key (materialid) references material3(materialid)
);

create sequence material_alias_seq;


create table buy_click_log (
  log_id      number primary key,
  materialid  number(6) not null,
  mall_name   varchar2(30) default '11st' not null,
  keyword     varchar2(200) not null,   -- 예: 양파
  clicked_at  date default sysdate not null,

  constraint fk_buylog_material
    foreign key (materialid) references material3(materialid)
    on delete cascade
);

create sequence buy_click_log_seq;

create index idx_buylog_material
on buy_click_log(materialid, mall_name, clicked_at);




// 재료 crud
insert into material3 (
  materialid, title, imageurl, season, temperature, calories100g, efficacy, buyguide, trimguide, storeguide, category)
  values ( material3_seq.nextval, '양파', 'defult.png', '사계절', '상온', '40', '항산화 성분 함유', '껍질이 단단한 제품 선택', '껍질 제거 후 세척', '서늘한 곳 보관', '채소');
  
insert into material3 (
  materialid, title, imageurl, season, temperature, calories100g,efficacy, buyguide, trimguide, storeguide, category) 
  values ( material3_seq.nextval, '우유', 'defult.png', '사계절', '냉장', '60', '칼슘과 단백질 공급', '유통기한 확인', '개봉 후 바로 섭취', '0~4도 냉장 보관','유제품');  
  
select * from material3 where materialid = 1;  

select materialid, title, category, temperature, created_at from material3
order by created_at desc;

update material3 set temperature = '냉장', buyguide    = '단단하고 마른 양파 선택', updated_at  = sysdate
where materialid = 1;

delete from material_allergy where materialid = 4; 
delete from material_alias   where materialid = 4; 
delete from material3        where materialid = 4;


// 알러지 crud

insert into material_allergy (allergy_id, materialid, allergen_name, note)
  values (material_allergy_seq.nextval, 1, '없음', '일반적으로 주요 알러지 없음');
  
select allergy_id, allergen_name, note from material_allergy where materialid = 1;  

select a.allergy_id, m.title, a.allergen_name, a.note 
from material_allergy a
join material3 m on m.materialid = a.materialid
order by a.allergy_id desc;

update material_allergy
set note = '알러지 유발 사례 거의 없음'
where materialid = 1
  and allergen_name = '없음';
  
delete from material_allergy
where materialid = 1
  and allergen_name = '없음';

// 알리아스 crud
insert into material_alias (alias_id, materialid, alias_name)
values (material_alias_seq.nextval, 3, '저지방우유');

insert into material_alias (alias_id, materialid, alias_name)
values (material_alias_seq.nextval, 3, '무지방우유');

select alias_id, alias_name
from material_alias
where materialid = 3;

select a.alias_id, m.title, a.alias_name
from material_alias a
join material3 m on m.materialid = a.materialid
order by a.alias_id desc;

update material_alias
set alias_name = '저지방 우유'
where alias_name = '저지방우유';

delete from material_alias
where alias_name = '무지방우유';

// buy_click_log crud
insert into buy_click_log (log_id, materialid, mall_name, keyword)
  values ( buy_click_log_seq.nextval,1,'11st','양파');
  
  //최근 10건
select * from ( select b.log_id, m.title, b.mall_name, b.keyword, b.clicked_at from buy_click_log b join material3 m on m.materialid = b.materialid order by b.clicked_at desc ) where rownum <= 10;
//select all
select b.log_id, m.title, b.mall_name, b.keyword, b.clicked_at
from buy_click_log b
join material3 m on m.materialid = b.materialid
order by b.clicked_at desc;

//update
update buy_click_log
set keyword = '양파 1kg'
where log_id = (select max(log_id) from buy_click_log);

//delete
delete from buy_click_log
where log_id = (select max(log_id) from buy_click_log);


commit;