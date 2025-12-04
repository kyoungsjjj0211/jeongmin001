<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="kor">
<head>
  <title>Bootstrap 5 Website Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style> .fakeimg { height: 200px; background: #aaa; }  
  </style>
</head>
<body>

<div class="p-5 bg-primary text-white text-center">
  <h1>오늘 뭐먹지?</h1>
  <p>메뉴선택이 힘든자들을 위한 공간</p> 
</div>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav"> 
    
    <sec:authorize access="hasRole('ROLE_ADMIN')">
	    <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/security/admin/list">유저관리</a>
	    </li>
	</sec:authorize>

    
	<sec:authorize access="isAuthenticated()">
    	  <li class="nav-item">
	        <a class="nav-link"   href="${pageContext.request.contextPath}/security/mypage">
	        	<sec:authentication property="principal.dto.email"/>
	        </a>
	      </li> 
	      <li class="nav-item">
	      <a class="nav-link" href="${pageContext.request.contextPath}/admin/materiallist">
	      	재료관리
	      </a>
	      </li>
	       
	      <li class="nav-item">
	       <form  action="${pageContext.request.contextPath}/security/logout"   method="post">
	        	<input type="hidden"   name="${_csrf.parameterName}"    value="${_csrf.token}"/>
 	        	<input type="submit"   value="로그아웃"   class="btn btn-danger" /> 
	        </form>
	      </li>    
	</sec:authorize>  
	
    <sec:authorize   access="isAnonymous()">  <!-- ##  아무나다 접근가능하게 -->
	      <li class="nav-item">
	        <a class="nav-link"    href="${pageContext.request.contextPath}/security/login">LOGIN</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link"    href="${pageContext.request.contextPath}/security/join">JOIN</a>
	      </li> 
	</sec:authorize>            
    </ul> 
  </div>
</nav>
<!-- 	header		 -->
<!-- 	header		 -->
<!-- 	header		 -->
    