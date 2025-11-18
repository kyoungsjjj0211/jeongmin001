<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/header.jsp"%>

<div class="container card  my-5 p-4 ">
	<h3 class="card-header">MBTI 탈퇴</h3>
	<form action="${pageContext.request.contextPath}/delete.users"
		method="post">
		<input type="hidden" name="appUserId" value="${param.appUserId}">
		<div class="my-3">
			<label for="password" class="form-label">비밀번호:</label> <input
				type="password" name="password" id="password"
				placeholder="비밀번호를 입력해주세요" required name="password">
		</div>
		<div class="mb-3 text-end">
			<button type="submit" class="btn btn-primary">탈퇴하기</button>
			<a href="javascript:history.go(-1)" class="btn btn-danger">BACK</a>
		</div>
	</form>

</div>
<%@ include file="../inc/footer.jsp"%>