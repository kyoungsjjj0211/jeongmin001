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
<h3 class="card-header"></h3>

	</div>

</body>
</html>

<!--  
 
 ▶ view
 	1. list.jsp
 	2. write.jsp
 	3.detail.jsp
 	4.edit.jsp
 	5.delete.jsp

▶ controller
	1. frontcontroller
		1-1. @WebServlet 개발용 *.do  , *.member, *.hj
		1-2. web.xml 배포용
		[com.thejoa703.controller] - MbtiController
		ㄴ index.jsp
			ㄴ [전체글보기] /mbitBoard/lis.do         ■ MbtiList 	/ 		 mbtiBoard/list.jsp  
			ㄴ [글쓰기폼] /mbtiBoard/writeView.do    □          	/ 		 mbtiBoard/write.jsp
			ㄴ [글쓰기기능] /mbtiBoard/write.do		  ■ MbtiInsert  / 알림창 + mbtiBoard/list.jsp
			ㄴ [상세보기] /mbtiBoard/write.do		  ■ MbtiDetail  /        mbtiBoard/detail.jsp
			ㄴ [글수정폼] /mbtiBoard/editView.do     ■ MbtiUpdateView /      mbtiBoard/edit.jsp
			ㄴ [글수정기능] /mbtiBoard/edit.do 	 	  ■ MbtiUpdate  / 알림창 + mbtiBoard/detail.jsp
			ㄴ [글삭제폼] /mbtiBoard/deleteView.do   □             /         mbtiBoard/delete.jsp
			ㄴ [글삭제기능] /mbtiBoard/delete.do	  ■ MbtiDelete  / 알림창 + list.do
			
		1-1. frontcontroller web.xml [com.thejoa703.controller] - MbtiController
		1-2. view 연결확인
			
			
	2. service
		[com.thejoa703.service]
		MbtiService <<interface>>
		      △.... MbtiList            데이터 x/selectAll()
		      △.... MbtiInsert          데이터 o/selectAll(PostDto dto)
		      △.... MbtiDetail          데이터 o/select (int id), update_hit(int id)
		      △.... MbtiUpdateView      데이터 o/select (int id)
		      △.... MbtiUpdate          데이터 o/update(PostDto dto)
		      △.... MbtiDelete			데이터 o/update(PostDto dto)
		      
		      
		      
-->