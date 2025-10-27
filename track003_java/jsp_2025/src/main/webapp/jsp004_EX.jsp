<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST- EX GOOGLE</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled and JavaScript CSS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container card my-5">
<h3 class="card-header"> REQUEST -EX GOOGLE</h3>
<Pre class ="alert alert-success">
		https://www.google.com/search?q=%EB%8B%A4%EC%9D%B4%EC%96%B4%ED%8A%B8&sca_esv=47dab9ba39490397&hl=ko&sxsrf=AE3TifM9gAtQrIKtbtkUL3ESDMjLk8DKLg%3A1761550439833&source=hp&ei=ZyD_aJ-xMI781e8Pr5nNyAg&iflsig=AOw8s4IAAAAAaP8udzECc_xcPlkdiFLuvv2ofRhN2Vvj&ved=0ahUKEwjfgN_h7sOQAxUOfvUHHa9ME4kQ4dUDCBo&uact=5&oq=%EB%8B%A4%EC%9D%B4%EC%96%B4%ED%8A%B8&gs_lp=Egdnd3Mtd2l6Igzri6TsnbTslrTtirgyCxAAGIAEGLEDGIMBMggQABiABBixAzIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyCxAAGIAEGLEDGIMBMgUQABiABDIFEAAYgAQyBRAAGIAESIc7ULEEWOU5cA54AJABBJgBggGgAekQqgEEMC4xObgBA8gBAPgBAZgCEaACpAaoAgrCAgcQIxgnGOoCwgIHEC4YgAQYCsICERAuGIAEGLEDGNEDGIMBGMcBwgIHEAAYgAQYCsICBBAjGCfCAgoQIxiABBgnGIoFwgILEC4YgAQYsQMYgwHCAgQQABgDwgILEC4YgAQYsQMY1ALCAggQLhiABBixA8ICBRAuGIAEmAML8QWzV8kyruj6BpIHBDExLjagB_qOAbIHAzAuNrgHzAXCBwcwLjMuOS41yAdp&sclient=gws-wiz
	 1. 처리컨테이너 (해결사)   -  			https://www.google.com/search
	 2. 처리방식 (GET 검색/POST 삽입 : method) - get
	 3. 보관용기(넘겨줄데이터 - 쿼리스트링 : name) - q
	</Pre>
		<form action="		https://www.google.com/search" method="get">
			  <div class="mb-3 mt-3">
			    <label for="search" class="form-label">Google에 물어보세요~! 검색어</label>
			    <input type="search" class="form-control" id="search" placeholder="검색어를 입력해주세요" name="q">
			  </div>
			  <button type="submit" class="btn btn-success">Submit</button>
		</form>

	</div>

</body>
</html>

<!-- jsp0033_tmpt.jsp
1. window -preferences
2. 검색 : jsp
3. Templates - [New] - Name 입력 / ★ Context - New jsp / 탬플릿 붙여넣기
 -->