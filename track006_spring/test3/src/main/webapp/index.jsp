<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  response.sendRedirect( request.getContextPath()  + "/security/join"); %>  

<!-- index.jsp -->
<!-- 
SQL> desc appuser;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 APP_USER_ID                               NOT NULL NUMBER(5)
 EMAIL                                     NOT NULL VARCHAR2(100)
 PASSWORD                                           VARCHAR2(100)
 MBTI_TYPE_ID                                       NUMBER(3)
 CREATED_AT                                         DATE
 UFILE                                              VARCHAR2(255) 
 MOBILE                                             VARCHAR2(50)
 NICKNAME                                           VARCHAR2(50)

CREATE TABLE appuser (
    APP_USER_ID   NUMBER(5)    CONSTRAINT pk_appuser PRIMARY KEY,
    EMAIL         VARCHAR2(100) NOT NULL,
    PASSWORD      VARCHAR2(100),
    MBTI_TYPE_ID  NUMBER(3),
    CREATED_AT    DATE DEFAULT SYSDATE,
    UFILE         VARCHAR2(255),
    MOBILE        VARCHAR2(50),
    NICKNAME      VARCHAR2(50)
);
 

-->