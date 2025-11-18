<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>
 <script>
   $(function(){
	   let result = '${success}';
	   console.log(result); 
	   if(result == "회원가입 실패"){   alert( result );   history.go(-1); }
	   else if(result == '비밀번호를 확인해주세요'){  alert( result  );  history.go(-1); }
	   else if(result.length  != 0 ){  alert(result); }  //아까 처음 값이없을때 공백 
   });
   
   </script>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI QUEST BOARD</h3>  
      <table class="table table-striped table-bordered table-hover">
      	<caption>mbti </caption>
      	<thead>
      		<tr>
      			<th scope="col">NO</th>
      			<th scope="col">EMAIL</th>
      			<th scope="col">DATE</th>
      			<th scope="col">수정</th>
      			<th scope="col">삭제</th>
      		</tr>	
      	</thead>
      	<tbody> 
      	</tbody>
      </table>
      <p class="text-end">
      	<a href="${pageContext.request.contextPath}/join.users" class="btn btn-primary">회원가입</a>
      </p>
 
        
   </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->