<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled and JavaScript CSS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
		<h3 class="card-header">회원가입</h3>
		<pre class ="alert alert-success">
		1. 처리컨테이너 - jsp005_result.jsp
		2. 처리방식    - post
		3. 보관용기    - email, password, mbti_type_id
		</pre>
		<form action="jsp005_result.jsp" method="post">
			  <div class="mb-3 mt-3">
			    <label for="email" class="form-label">Email:</label>
			    <input type="email" class="form-control" id="email" required placeholder="Enter email" name="email">
			  </div>
			  <div class="mb-3">
			    <label for="password" class="form-label">Password:</label>
			    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
			  </div>
			  <div class="form-check mb-3">
			    <label for="mbti" class="form-label">MBTI 유형 : </label>
			    <select id="mbti" name = "mbti_type_id">
			    <option value="1"> ISTJ</option> 
			    <option value="2"> ISFJ</option>
			    <option value="3"> INTJ</option>
			    </select>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>

<!-- jsp0033_tmpt.jsp
1. window -preferences
2. 검색 : jsp
3. Templates - [New] - Name 입력 / ★ Context - New jsp / 탬플릿 붙여넣기
 -->