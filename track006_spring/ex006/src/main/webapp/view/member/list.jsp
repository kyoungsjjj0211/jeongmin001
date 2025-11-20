<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI QUEST BOARD</h3>  
      <table class="table table-striped table-bordered table-hover">
      	<caption>mbti </caption>
      	<thead>
      		<tr>
      			<th scope="col">NO</th>
      			<th scope="col">USERNO</th>
      			<th scope="col">EMAIL</th>
      			<th scope="col">MBTI TYPE</th>
      			<th scope="col">DATE</th>
      			<th scope="col">수정</th>
      			<th scope="col">삭제</th>
      		</tr>	
      	</thead>
      	<tbody> 
      	<c:forEach var="dto" items="${list}" varStatus="status" >
      	<tr>
      		<%--<td>${dto}</td> --%>
      		<td>${list.size()-status.index}</td>
      		<td>${dto.appUserId}</td>
      		<td> <a href="${pageContext.request.contextPath}/mypage.users?appUserId=${dto.appUserId}">
      		${dto.email} 
      		</a></td>
      		<td>${dto.mbtiTypeId}</td>
      		<td>${dto.createdAt}</td>
      		<td><input type="button" value="수정" class="btn btn-primary" /></td>
      		<td><input type="button" value="삭제" class="btn btn-danger" /></td>
      		</tr>
      		</c:forEach>
      	</tbody>
      </table>
      <%-- <p class="text-end">
      	<a href="${pageContext.request.contextPath}/join.users" class="btn btn-primary">회원가입</a>
      </p> --%>       
   </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->