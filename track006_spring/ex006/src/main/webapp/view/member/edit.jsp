<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>

<div class="container card  my-5 p-4">
     <h3 class="card-header">유저정보수정</h3> 
         
     <form action="${pageContext.request.contextPath}/uploadEdit.users"
       method="post" encType ="multipart/form-data">   
     <input type="hidden" name="appUserId" value="${param.appUserId}">
	  <div class="mb-3 mt-3">
	    <label for="email" class="form-label">EMAIL:</label>
	    <input type="email" class="form-control" id="email" 
	    	  placeholder="EMAIL를 입력해주세요" name="email"   
	    	  value="${dto.email}" readonly>
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">PASS:</label>
	    <input type="password" class="form-control" id="password" 
	    	placeholder="비밀번호를 입력해주세요" name="password">
	  </div>
	    	<div class="mb-3">
	    	<label for="file" class="form-label">프로필이미지수정</label>
			<input type="file" class="form-control" id="file" placeholder="파일을 입력해주세요" name="file">
		    </div>
		    <div class="mb-3">
		    <input type="text" class="form-control" id="ufile" readonly name="ufile" value="${dto.ufile}">
		  	</div>
		  
		<div class="mb-3">
			<label class="form-check-label"  for="mbtiTypeId">MBTI TYPE : </label>  
			<select   name="mbtiTypeId"  id="mbtiTypeId"  class="form-control">
				<option value="1">ISTJ</option>
				<option value="2">ISFJ</option>
				<option value="3">INFJ</option>
			</select>
		</div>
	
	  <div class="mb-3  text-end">
	  	<button type="submit" class="btn btn-primary">정보 수정-비밀번호/MBTI TYPE</button>
	 <!--  	<a href="javascript:history.go(-1)"  class="btn btn-danger">BACK</a> -->
	  </div>
 </form>
  </div>

<%@ include file="../inc/footer.jsp"%>