<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI 글쓰기</h3>
	  <form action="${pageContext.request.contextPath}/upload.quest"
	  		method="post" encType="multipart/form-data"> 
	     <!--  <input type="hidden"   name="appUserId"  value="">  -->
		  <div class="mb-3 mt-3">
		    <label for="title" class="form-label">TITLE:</label>
		    <input type="text" class="form-control" id="title" placeholder="내용을 입력해주세요" name="btitle">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">PASS:</label>
		    <input type="password" class="form-control" id="pass" placeholder="비밀번호를 입력해주세요" name="bpass">
		  </div>
		  <div class="mb-3">
		    <label for="content" class="form-label">CONTENT:</label>
		    <textarea class="form-control" id="content" placeholder="내용을 입력해주세요" name="bcontent"></textarea>
		  </div> 
		  <div class="mb-3">
		    <label for="file" class="form-label">FILE:</label>
		    <input type="file" class="form-control" id="file" placeholder="파일을 입력해주세요" name="file">
		  </div>
		  <div class="mb-3  text-end">
		  	<button type="submit" class="btn btn-primary">글쓰기</button>  
		  	<a href="${pageContext.request.contextPath}/list.quest"  class="btn btn-primary">목록보기</a>
		  </div>
	 </form> 
   </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->