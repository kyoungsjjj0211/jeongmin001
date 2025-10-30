<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI 글상세보기</h3>
      <div>
	      <input type="hidden"   name="app_user_id"  value=""> 
		  <div class="mb-3 mt-3">
		    <label for="title" class="form-label">TITLE:</label>
		    <input type="email" class="form-control" id="title"
		     	placeholder="내용을 입력해주세요" name="title"  readonly value="">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="pass" class="form-label">PASS:</label>
		    <input type="password" class="form-control" id="pass"
		     	placeholder="비밀번호를 입력해주세요" name="pass" readonly value="">
		  </div>
		  <div class="mb-3">
		    <label for="content" class="form-label">CONTENT:</label>
		    <textarea class="form-control" id="content" placeholder="내용을 입력해주세요"
		    readonly name="content"></textarea>
		  </div> 
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath() %>/editView.do" class="btn btn-primary">글수정</a>
		  </div>
		  <div class="mb-3">
		  	<a href="<%=request.getContextPath() %>/deleteView.do" class="btn btn-danger form-control">글삭제</a>
		  </div>
		<div class="mb-3">
		  	<a href="<%=request.getContextPath() %>/list.do" class="btn btn-default form-control">목록보기</a>
		  </div>
   </div>
</div>   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->