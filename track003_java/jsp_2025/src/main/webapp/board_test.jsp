<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled and JavaScript CSS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
	<h3 class="card-header">DAO TEST</h3>
	<pre class="alert alert-success">
	1. insert
	 	   insert into post ( id                 , app_user_id ,title , content , pass )  
           values ( post_seq.nextval   ,          ?  , ?    ,      ?  ,    ? ) 
	</pre>
	<%@page import="com.thejoa703.dto.PostDao"%>
	<%@page import="com.thejoa703.dto.PostDto"%>
<%-- 	<%
	PostDao dao = new PostDao();
	PostDto dto = new PostDto();
	dto.setAppUserId(1);
	dto.setTitle("첫번째 글쓰기입니다.");
	dto.setContent("내용");
	dto.setPass("1111");
	out.println(dao.insert(dto)); //1나오면 글쓰기 성공!
	%> --%>
	<pre class="alert alert succecc">
	2. selectAll
	</pre>
	<%
	PostDao dao = new PostDao();
	out.println(dao.selectAll());
	%>
	</div>

</body>
</html>

<!-- jsp0033_tmpt.jsp
1. window -preferences
2. 검색 : jsp
3. Templates - [New] - Name 입력 / ★ Context - New jsp / 탬플릿 붙여넣기
 -->