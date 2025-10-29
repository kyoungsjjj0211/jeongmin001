<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled and JavaScript CSS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
	<h3 class="card-header">부서검색</h3>
	<!--request.setAttribute("dto",result); -->
	${dto}
	<table class="table table-striped table-bordered table-hover">
    <thead>
      <tr>
        <th scope="col">DEPTNO</th>
        <th scope="col">DNAME</th>
        <th scope="col">LOC</th>
      </tr>
    </thead>
<%--    출력구문1:<%=dto.deptno%>
    	출력구문2: ${dto.deptno}			--%>
    <tbody>
      <tr>
        <td>${dto.deptno}</td>
        <td>${dto.dname}</td>
        <td>${dto.loc}</td>
      </tr>
    </tbody>
  </table>
	</div>

</body>
</html>

<!-- jsp0033_tmpt.jsp
1. window -preferences
2. 검색 : jsp
3. Templates - [New] - Name 입력 / ★ Context - New jsp / 탬플릿 붙여넣기
 -->