<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../inc/header.jsp" %>

	<div class="container card my-5 p-4">
	<h3 class="card-header">음식영양소 상세보기</h3>
	<div>
	<input type="hidden" name="app_user_id" value="">
	<div class="mb-3 mt-3">
		<label for="title" class="form-label"> NAME:</label>
		 <input type="text" class="form-control" id="name" name="title" readonly value="${dto.name}">
		 </div>
	<div class="mb-3">
		<label for="title" class="form-label"> KCAL: </label>
		 <input type="text" class="form-control" id="title" name="title" readonly value="${dto.kcal}">
		 </div>
	<div class="mb-3">
		<label for="title" class="form-label"> PROTEIN: </label>
		 <input type="text" class="form-control" id="title" name="title" readonly value="${dto.protein}">
		 </div>
		 <div class="mb-3">
		<label for="title" class="form-label"> CARB: </label>
		 <input type="text" class="form-control" id="title" name="title" readonly value="${dto.carb}">
		 </div>
		 <div class="mb-3">
		<label for="title" class="form-label"> FAT: </label>
		 <input type="text" class="form-control" id="title" name="title" readonly value="${dto.fat}">
		 </div>
		 <div class="mb-3">
		<label for="title" class="form-label"> RECIPE: </label>
		 <input type="text" class="form-control" id="title" name="title" readonly value="${dto.recipe}">
		 </div>
		 <c:if test="${not empty email}">
		  </c:if>
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath() %>/editView.food?id=${dto.foodId}" class="btn btn-primary  form-control">글수정</a>
		  </div>
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath() %>/delete.food?id=${dto.foodId}" class="btn btn-danger form-control">글삭제</a>
		  </div>
		<div class="mb-3">
		  	<a href="<%=request.getContextPath() %>/list.food" class="btn btn-default form-control">목록보기</a>	
		</div>
	</div>
	</div>
	<%@include file="../inc/footer.jsp" %>
	