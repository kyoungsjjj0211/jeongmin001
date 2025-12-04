<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
    
<h2>${dto.title}</h2>

<img src="${pageContext.request.contextPath}/upload/${dto.imageurl}" style="width:250px; margin-bottom:20px;" />

<p><b>계절:</b> ${dto.season}</p>
<p><b>온도:</b> ${dto.temperature}</p>
<p><b>칼로리(100g):</b> ${dto.calories100g}</p>

<hr>

<h3>효능</h3>
<p>${dto.efficacy}</p>

<h3>구입 가이드</h3>
<p>${dto.buyguide}</p>

<h3>손질 방법</h3>
<p>${dto.trimguide}</p>

<h3>보관 방법</h3>
<p>${dto.storeguide}</p>

<%@ include file="../inc/footer.jsp" %>