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
	<h3 class="card-header">RESPONSE</h3>
	<pre class="alert alert-success">
	1. sendRedirect- 브라우저 url 변경 / request,response가 유지 안됨.
	2. RequestDispatcher - 경로가 숨겨져서 안보임 / request, response가 유지 됨
	</pre>
	<pre class="alert alert-warning">
	1. Servlet - DeptWhat
	2. form    - 부서번호 입력
	3. DeptWhat 사용자정보 요청처리후 요청값 주기 (dispatcher)
	
	[필요파일]
	1. Dto (전달용) - DeptDto
	2. Dao 서클릿에서 처리 - DeptWhat
	3. from - action(처리대상), method(get:검색/post:삽입), name
	4. jsp010_result.jsp
	
	
	</pre>
			<form action="<%=request.getContextPath() %>/DeptWhat" method="get">
		  <div class="mb-3 mt-3">
		    <label for="deptno" class="form-label">부서번호</label>
		    <input type="number" class="form-control" id="deptno" min="10" max="40" step="10" placeholder="부서번호를 입력해주세요" name="deptno">
		  </div>
		  <button type="submit" class="btn btn-primary">부서검색</button>
			</form>
	
	</div>

</body>
</html>

<!-- jsp0033_tmpt.jsp
1. window -preferences
2. 검색 : jsp
3. Templates - [New] - Name 입력 / ★ Context - New jsp / 탬플릿 붙여넣기
 -->