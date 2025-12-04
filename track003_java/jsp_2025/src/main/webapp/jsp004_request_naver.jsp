<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request-요청</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled and JavaScript CSS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container card my-5">
	<h3 class="card-header">REQUEST-요청</h3>
	<Pre class ="alert alert-success">
	https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=Chicken+breast&oquery=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4&tqi=jn8jXlqo1aVssQyVt4lssssstN8-353290&ackey=zl47af2s	
	 1. 처리컨테이너 (해결사)   -  	https://search.naver.com/search.naver
	 2. 처리방식 (GET 검색/POST 삽입 : method) - get
	 3. 보관용기(넘겨줄데이터 - 쿼리스트링 : name) - query
	</Pre>
		<form action="https://search.naver.com/search.naver" method="get">
			  <div class="mb-3 mt-3">
			    <label for="search" class="form-label">NAVER에 물어보세요~! 검색어</label>
			    <input type="search" class="form-control" id="search" placeholder="검색어를 입력해주세요" name="query">
			  </div>
			  <button type="submit" class="btn btn-success">Submit</button>
		</form>
	</div>
</body>
</html>

<!-- 
CLUENT (요청 : request) ↔ SERVER(응답 : response)
1. window -preferences
2. 검색 : jsp
3. Templates - [New] - Name 입력 / ★ Context - New jsp / 탬플릿 붙여넣기
 -->