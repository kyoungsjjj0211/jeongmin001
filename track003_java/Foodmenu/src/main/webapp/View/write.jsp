<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

<div class="container card my-5 p-4">
	<h3 class="card-header">음식 추가하기</h3>
	<from action="<%=request.getContextPath()%>/write.do" method="post">
	<div class="mb-3 mt-3">
		<label for="title" class="form-label"> NAME:</label>
		 <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요" name="title">
		 </div>
	<div class="mb-3">
		<label for="title" class="form-label"> KCAL: </label>
		 <input type="text" class="form-control" id="title" placeholder="칼로리를 입력해주세요" name="title">
		 </div>
	<div class="mb-3">
		<label for="title" class="form-label"> PROTEIN: </label>
		 <input type="text" class="form-control" id="title" placeholder="단백질을 입력해주세요" name="title">
		 </div>
		 <div class="mb-3">
		<label for="title" class="form-label"> CARB: </label>
		 <input type="text" class="form-control" id="title" placeholder="탄수화물을 입력해주세요" name="title">
		 </div>
		 <div class="mb-3">
		<label for="title" class="form-label"> FAT: </label>
		 <input type="text" class="form-control" id="title" placeholder="지방를 입력해주세요" name="title">
		 </div>
		 <div class="mb-3">
		<label for="title" class="form-label"> RECIPE: </label>
		 <input type="text" class="form-control" id="title" placeholder="조리방법을 입력해주세요" name="title">
		 </div>
		 
		 <div class="mb-3  text-end">
		  	<button type="submit" class="btn btn-primary">글쓰기</button>  
		  	<a href="<%=request.getContextPath()%>/list.do"  class="btn btn-primary">목록보기</a>
		  </div>
		  </from>
	</div>

<%@include file="../inc/footer.jsp" %>