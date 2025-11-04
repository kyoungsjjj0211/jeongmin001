<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

	<div class="container card my-5 p-4">
		<h3 class="card-header">Food Board</h3>






<table class="table table-striped table-bordered table-hover">
	<caption> food</caption>
	<thead>
		<tr>
		<th scope="col">NO</th>
		<th scope="col">TITLE</th>
		<th scope="col">NAME</th>
		<th scope="col">DATE</th>
		<th scope="col">HIT</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="dto" items="${list}" varStatus="status">
	<tr>
	<td>${list.size() - status.index}</td>
	<td>
	<a href="<%=request.getContextPath()%>/detail.do?id=%{dto.id}">
	${dto.title}
	</a>
</tbody>
</div>

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
<h3 class="card-header"></h3>

	</div>

</body>
</html>
