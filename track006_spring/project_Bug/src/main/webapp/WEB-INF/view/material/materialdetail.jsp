<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>

<div style="max-width: 900px; margin: 0 auto; text-align:center;">
	<form action="${pageContext.request.contextPath}/admin/materialedit"
		method="post" enctype="multipart/form-data">
		
			<h2>${dto.title}</h2>
		
		<div style="text-align:center; margin-bottom:20px;">
		<img src="${pageContext.request.contextPath}/upload/${dto.imageurl}"
				style="width: 250px; margin-bottom:20px" />
		<%-- <img src="${pageContext.request.contextPath}/upload/${dto.imageurl}" style="width:250px; margin-bottom:20px;" /> --%>
		</div>
		<div style="display:inline-block; text-align:left; margin-top:20px;">
		
		<div class="mb-3">
			<label for="title" class="form-lable">계절: ${dto.season}</label>
		</div>
		<div class="mb-3">
			<label for="title" class="form-lable">온도: ${dto.temperature}</label>
		</div>
		<div class="mb-3">
			<label for="title" class="form-lable">칼로리(100g):
				${dto.calories100g}</label>
		</div>
		
		<hr>

		<h3>효능</h3>
		<p>${dto.efficacy}</p>
		<h3>구입 가이드</h3>
		<p>${dto.buyguide}</p>
		<h3>손질 방법</h3>
		<p>${dto.trimguide}</p>
		<h3>보관 방법</h3>
		<p>${dto.storeguide}</p>
		</div>
	</form>
	<div class="mb-3 text-end">
		<a href="javascript:history.go(-1)" class="btn btn-danger">뒤로가기</a>
	</div>
</div>
<%@ include file="../inc/footer.jsp"%>