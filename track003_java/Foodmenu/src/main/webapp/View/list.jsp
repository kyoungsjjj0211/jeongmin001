<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

	<div class="container card my-5 p-4">
		<h3 class="card-header">Food Board</h3>

<table class="table table-striped table-bordered table-hover">
	<caption> food</caption>
	<thead>
		<tr>
		<th scope="col">음식번호</th>
		<th scope="col">이름</th>
		<th scope="col">카테고리ID</th>
		<th scope="col">칼로리</th>
		<th scope="col">단백질</th>
		<th scope="col">탄수화물</th>
		<th scope="col">지방</th>
		<th scope="col">음식설명</th>
		<th scope="col">음식 이미지</th>
		<th scope="col">등록일</th>
		
		</tr>
	</thead>
	<tbody>
	<c:forEach var="dto" items="${list}" varStatus="status">
	<tr>
	<td>${list.size() - status.index}</td>
	<td>
	<a href="<%=request.getContextPath()%>/detail.do?id=%{dto.FooDId}">
	${dto.name}
	</a>
	</td>
	<td>${dto.hit}</td>
	<td>${dto.categoryid}</td>
	<td>${dto.kcal}</td>
	<td>${dto.protein}</td>
	<td>${dto.carb}</td>
	<td>${dto.fat}</td>
	<td>${dto.recipe}</td>
	<td>${dto.imageurl}</td>
	<td>${dto.regdate}</td>
	</tr>
	</c:forEach>
</tbody>
<% if(email!=null){ %>
	  <p class="text-end">
	  	<a href="<%=request.getContextPath() %>/writeView.do" class="btn btn-primary">글쓰기</a>
	  	</p>
	  	<%}else{    %>
	  	<p class="text-end alert alert-primary"> 관리자만 글쓰기가 가능합니다.</p>
	  	<% }   %>

</div>


<%@include file="../inc/footer.jsp" %>