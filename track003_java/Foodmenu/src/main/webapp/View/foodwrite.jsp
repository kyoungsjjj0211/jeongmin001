<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

<div class="container card my-5 p-4">
	<h3 class="card-header">음식 추가하기</h3>
	<form action="<%=request.getContextPath()%>/write.food" method="post">
	<div class="mb-3 mt-3">
		<label for="name" class="form-label"> NAME:</label>
		 <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요" name="name">
		 </div>
	<div class="mb-3 mt-3">
		<label for="categoryId" class="form-label"> CATEGORYID:</label>
		 <input type="text" class="form-control" id="categoryId" placeholder="카테고리번호를 입력해주세요" name="categoryId">
		 </div>	 
	<div class="mb-3">
		<label for="kcal" class="form-label"> KCAL: </label>
		 <input type="text" class="form-control" id="kcal" placeholder="칼로리를 입력해주세요" name="kcal">
		 </div>
	<div class="mb-3">
		<label for="protein" class="form-label"> PROTEIN: </label>
		 <input type="text" class="form-control" id="protein" placeholder="단백질을 입력해주세요" name="protein">
		 </div>
		 <div class="mb-3">
		<label for="carb" class="form-label"> CARB: </label>
		 <input type="text" class="form-control" id="carb" placeholder="탄수화물을 입력해주세요" name="carb">
		 </div>
		 <div class="mb-3">
		<label for="fat" class="form-label"> FAT: </label>
		 <input type="text" class="form-control" id="fat" placeholder="지방를 입력해주세요" name="fat">
		 </div>
		 <div class="mb-3">
		<label for="recipe" class="form-label"> RECIPE: </label>
		 <input type="text" class="form-control" id="recipe" placeholder="조리방법을 입력해주세요" name="recipe">
		 </div>
		 
		 <div class="mb-3  text-end">
		  	<button type="submit" class="btn btn-primary">글쓰기</button>  
		  	<a href="<%=request.getContextPath()%>/list.food"  class="btn btn-primary">목록보기</a>
		  </div>
		  </form>
	</div>

<%@include file="../inc/footer.jsp" %>