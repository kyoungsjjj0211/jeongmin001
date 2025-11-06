<%@page import="java.util.List"%>
<%@page import="com.company.jeongmin.Dao_Dto.FoodDto"%>
<%@page import="com.company.jeongmin.Dao_Dto.FoodDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAO test</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled and JavaScript CSS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container my-5">
    <h3 class="card-header">DAO TEST</h3>
    <pre class="alert alert-success">
    1. insert
    </pre>
    <%--
        FoodDao dao = new FoodDao();
        FoodDto dto = new FoodDto();
        dto.setName("김치찌개");
        dto.setCategoryId(1);
        dto.setKcal(450);
        dto.setProtein(20.5);
        dto.setCarb(15.2);
        dto.setFat(18.0);
        dto.setRecipe("김치와 돼지고기를 넣고 끓입니다.");
        dto.setImageUrl("images/kimchi_stew.jpg");
        out.println(dao.insert(dto));
    --%>

    <pre class="alert alert-success">
    2. select all 테스트
    </pre>
    <%--

    FoodDao dao = new FoodDao();
    List<FoodDto> list = dao.selectAll();
    for (FoodDto item : list) {
        out.println(item.toString());
    }
    --%>

    <pre class="alert alert-success">
    <!-- 2. select by id 테스트 -->
    </pre>
    <%
        FoodDto select = FoodDao.select(1);
    	FoodDto result = new FoodDto();			// foodId = 1
        out.println(select != null ? select.toString() : "데이터 없음");
    %>


    <pre class="alert alert-success">
    3. update 테스트
    </pre>
    <%--
    	FoodDao updateDao = new FoodDao();
        FoodDto updateDto = new FoodDto();
        updateDto.setName("김치찌개 - 수정");
        updateDto.setCategoryId(1); 
        updateDto.setKcal(480);
        updateDto.setProtein(22.0);
        updateDto.setCarb(16.0);
        updateDto.setFat(19.0);
      	updateDto.setRecipe("김치와 돼지고기를 넣고 더 진하게 끓입니다.");
        updateDto.setImageUrl("images/kimchi_stew_updated.jpg");
        updateDto.setFoodId(5); // 수정할 대상
        out.println(   updateDao.update(updateDto) );
    --%>

    <pre class="alert alert-success">
    4. delete 테스트
    </pre>
    <%
    	FoodDto dto = new FoodDto();
    	FoodDao dao = new FoodDao();
    	dto.setFoodId(5);
        out.println(dao.delete(dto)); // foodId = 1 삭제
    %>
</div>
</body>
</html>
