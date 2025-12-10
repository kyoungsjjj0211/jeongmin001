package com.thejoa703.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.Sboard2Dto;

@Mapper
public interface Sboard2Dao {
	public int insert(Sboard2Dto dto);
	public int update(Sboard2Dto dto);
	public int delete(Sboard2Dto dto);
	public int updateHit(int id);
	public List<Sboard2Dto> selectAll();
	public Sboard2Dto select(int id);
}



/*
Q3. Dao
	SQL>
	SQL> desc sboard2;
Name          Null?       Type             
----------- -------- -------------- 
ID          NOT NULL NUMBER         
APP_USER_ID NOT NULL NUMBER         
BTITLE      NOT NULL VARCHAR2(1000) 
BCONTENT    NOT NULL CLOB           
BPASS       NOT NULL VARCHAR2(255)  
BFILE                VARCHAR2(255)  
BHIT                 NUMBER         
BIP         NOT NULL VARCHAR2(255)  
CREATED_AT           DATE      

1. 테이블
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

2. dto
3. dao
*/