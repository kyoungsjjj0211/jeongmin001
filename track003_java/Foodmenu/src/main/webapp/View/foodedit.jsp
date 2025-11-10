<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

<div class="container card my-5 p-4">
	<h3 class="card-header">음식 수정하기</h3>
	<form action="<%=request.getContextPath()%>/edit.food?id=${dto.foodId}" method="post">
	<div class="mb-3 mt-3">
		<label for="name" class="form-label"> NAME:</label>
		 <input type="text" class="form-control" id="name" name="name" value="${dto.name}">
		 </div>
	<div class="mb-3 mt-3">
		<label for="categoryId" class="form-label"> CATEGORYID:</label>
		 <input type="text" class="form-control" id="categoryId" name="categoryId" value="${dto.categoryId}">
		 </div>	 
	<div class="mb-3">
		<label for="kcal" class="form-label"> KCAL: </label>
		 <input type="text" class="form-control" id="kcal" name="kcal" value="${dto.kcal}">
		 </div>
	<div class="mb-3">
		<label for="protein" class="form-label"> PROTEIN: </label>
		 <input type="text" class="form-control" id="protein" name="protein" value="${dto.protein}">
		 </div>
		 <div class="mb-3">
		<label for="carb" class="form-label"> CARB: </label>
		 <input type="text" class="form-control" id="carb" name="carb" value="${dto.carb}">
		 </div>
		 <div class="mb-3">
		<label for="fat" class="form-label"> FAT: </label>
		 <input type="text" class="form-control" id="fat" name="fat" value="${dto.fat}">
		 </div>
		 <div class="mb-3">
		<label for="recipe" class="form-label"> RECIPE: </label>
		 <input type="text" class="form-control" id="recipe" name="recipe" value="${dto.recipe}">
		 </div>
		 
		 <div class="mb-3  text-end">
		  	<button type="submit" class="btn btn-primary">글수정</button>  
		  	<a href="<%=request.getContextPath()%>/list.food"  class="btn btn-primary">목록보기</a>
		  </div>
		  </form>
	</div>

<%@include file="../inc/footer.jsp" %>