create table material (
    materialid          NUMBER(6)        PRIMARY KEY,           -- 재료 고유번호 (PK)
    imageurl            VARCHAR2(300)   default  'defult.png',  -- 이미지 경로 또는 URL
    title                  VARCHAR2(200)    NOT NULL,           -- 재료명
    season               VARCHAR2(100),                         -- 제철 정보
    temperature      VARCHAR2(50),                              -- 보관 온도
    calories100g      NUMBER(6),                                -- 100g당 열량
    efficacy             VARCHAR2(1000),
    buyguide            VARCHAR2(1000),                         -- 구입요령
    trimguide           VARCHAR2(1000),                         -- 손질법
    storeguide          VARCHAR2(1000),                         -- 보관법
    recipelink          VARCHAR2(500)                       	-- 레시피 검색 링크(URL)
);
desc material;
select * from material;
insert into material(
    materialid, title, imageurl, season, temperature, calories100g,
    efficacy, buyguide, trimguide, storeguide, recipelink
) values (
       1,
    '메밀면',
    'https://대충주소.com/img.jpg',
    '연중제철',
    '1~5℃',
    142,
    '소화 촉진',
    '유통기한을 확인하고 구입한다.',
    '끓는 물에 삶아서 사용한다.',
    '직사광선을 피해 보관한다.',
    'https://대충주소.com/"검색파트 가져오기"?keyword=국산메밀면'
);

select * from material
where materialid = 1;

select * from material
order by materialid desc;

//기본 JOIN 방식 (FROM A, B WHERE A= B)
SELECT m.materialid,
       m.title,
       mc.category_name
FROM material m, materialcategory mc
WHERE m.materialid = mc.materialid
  AND m.materialid = 1;
//2. NATURAL JOIN 방식
  SELECT materialid, title, categoryname
FROM material 
NATURAL JOIN materialcategory
WHERE materialid = 1;
//3. LEFT JOIN (명시적 ON 사용)
SELECT m.materialid,
       m.title,
       mc.category_name
FROM material m
LEFT JOIN materialcategory mc
       ON m.materialid = mc.materialid
WHERE m.materialid = 1;
//4. LEFT JOIN USING (공통 컬럼 자동 인식)
SELECT materialid, title, categoryname
FROM material
LEFT JOIN materialcategory USING(materialid)
WHERE materialid = 1;


update material set 
title = '메밀면 (국산)',
calories100g = 150,
efficacy = '소화 촉진, 장 건강 도움',
recipelink = 'https://대충주소.com/"검색파트 가져오기"?keyword=국산메밀면',
storeguide = '서늘하고 통풍이 잘 되는 곳에 보관한다.'
where materialid =1;

delete from material
where materialid=1;
