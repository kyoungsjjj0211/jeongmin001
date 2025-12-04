<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    /* 카드 이미지 높이를 카드의 60%로 설정 */
    .recipe-img {
        height: 60%;
        object-fit: cover;
    }
    .card {
        display: flex;
        flex-direction: column;
    }
    .card-body {
        flex: 1;
    }
    /* 카테고리 라벨 */
    .category-label {
        position: absolute;
        top: 10px;
        right: 10px;
        background-color: #fff;
        color: #333;
        padding: 5px 10px;
        border-radius: 5px;
        font-size: 0.9rem;
        box-shadow: 0 0 5px rgba(0,0,0,0.1);
    }
   /* 요리 정보 줄 */
   .recipe-info {
       text-align: left;
       margin-top: 20px;     /* 위쪽 여백 */
   }
   
   .recipe-info span {
       margin: 0 4px;        /* 각 항목 사이 간격 */
       display: inline-block;
   }

    /* 난이도 박스 */
    .difficulty-box {
        display: inline-block;
        padding: 5px 10px;
        border-radius: 5px;
        font-weight: bold;
        text-align: center;
    }
    .difficulty-easy {
        background-color: #d4edda; /* 연한 초록 */
        color: #155724;
    }
    .difficulty-medium {
        background-color: #fff3cd; /* 연한 노랑 */
        color: #856404;
    }
    .difficulty-hard {
        background-color: #f8d7da; /* 연한 빨강 */
        color: #721c24;
    }
    
    /* 설명 부분 전용 스타일 */
   .recipe-description {
    margin-top: 10px;      /* 위쪽 여백 */
}
</style>

<div class="container mt-5">
    <h3>레시피 목록</h3>

    <!-- 성공 메시지 -->
    <c:if test="${not empty result}">
        <div class="alert alert-success mt-4">${result}</div>
    </c:if>

    <!-- 카드 레이아웃 -->
    <div class="row">
        <c:forEach var="recipe" items="${list}" varStatus="status">
            <c:if test="${status.index < 8}">
                <div class="col-md-3 mb-4">
                    <div class="card h-100 shadow-sm position-relative" style="cursor:pointer;" 
                         data-bs-toggle="modal" data-bs-target="#recipeModal${recipe.recipeId}">
                         
                        <!-- 카테고리 라벨 -->
                        <div class="category-label">
                            ${recipe.categoryName}
                        </div>

                        <!-- 이미지 -->
                        <c:choose>
                            <c:when test="${fn:startsWith(recipe.image, 'http')}">
                                <img src="${recipe.image}" alt="${recipe.title}" class="card-img-top recipe-img">
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/upload/${recipe.image}" alt="${recipe.title}" class="card-img-top recipe-img">
                            </c:otherwise>
                        </c:choose>

                        <div class="card-body">
                            <h5 class="card-title text-center">${recipe.title}</h5>
                            <!-- 설명 -->
                            <p class="card-text text-muted text-truncate recipe-description">
                                <c:choose>
                                    <c:when test="${fn:length(recipe.description) > 50}">
                                        ${fn:substring(recipe.description, 0, 50)}...
                                    </c:when>              
                                    <c:otherwise>
                                        ${recipe.description}
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <!-- 요리 정보 -->
                            <p class="recipe-info">
                         <span>⏱${recipe.cookTime}분</span>
                         <span>🙍‍♂️${recipe.servings}인분</span>
                         <span>👁️‍🗨️${recipe.views}</span>
                         <span>👩‍🍳${recipe.nickname}</span>
                     </p>

                            <!-- 난이도 박스 -->
                            <div class="mt-2">
                                <c:choose>
                                    <c:when test="${recipe.difficulty eq '쉬움'}">
                                        <span class="difficulty-box difficulty-easy">${recipe.difficulty}</span>
                                    </c:when>
                                    <c:when test="${recipe.difficulty eq '보통'}">
                                        <span class="difficulty-box difficulty-medium">${recipe.difficulty}</span>
                                    </c:when>
                                    <c:when test="${recipe.difficulty eq '어려움'}">
                                        <span class="difficulty-box difficulty-hard">${recipe.difficulty}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="difficulty-box">${recipe.difficulty}</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 모달 -->
                <div class="modal fade" id="recipeModal${recipe.recipeId}" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">${recipe.title}</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
                            </div>
                            <div class="modal-body">
                                <p><strong>카테고리:</strong> ${recipe.categoryName}</p>
                                <p><strong>작성자:</strong> ${recipe.nickname}</p>
                                <p><strong>재료:</strong> ${recipe.ingredients}</p>
                                <p><strong>조리 시간:</strong> ${recipe.cookTime} 분</p>
                                <p><strong>인분:</strong> ${recipe.servings} 인분</p>
                                <hr>
                                <p><strong>레시피 설명:</strong></p>
                                <p>${recipe.description}</p>
                                <c:choose>
                                    <c:when test="${fn:startsWith(recipe.image, 'http')}">
                                        <img src="${recipe.image}" alt="${recipe.title}" class="img-fluid mt-3"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${pageContext.request.contextPath}/upload/${recipe.image}" alt="${recipe.title}" class="img-fluid mt-3"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>  
    </div>

    <!-- 페이징 영역 -->
    <div class="mt-4">
        <ul class="pagination justify-content-center">
            <c:if test="${paging.current > 1}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=1">&laquo;</a>
                </li>
            </c:if>
            <c:if test="${paging.current > 1}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=${paging.current - 1}">&lsaquo;</a>
                </li>
            </c:if>
            <c:if test="${paging.start > 10}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=${paging.start - 10}">이전</a>
                </li>
            </c:if>
            <c:forEach var="i" begin="${paging.start}" end="${paging.end}">
                <li class="page-item <c:if test='${i == paging.current}'>active</c:if>">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=${i}">${i}</a>
                </li>
            </c:forEach>
            <c:if test="${paging.pagetotal > paging.end}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=${paging.end + 1}">다음</a>
                </li>
            </c:if>
            <c:if test="${paging.current < paging.pagetotal}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=${paging.current + 1}">&rsaquo;</a>
                </li>
            </c:if>
            <c:if test="${paging.current < paging.pagetotal}">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/recipe/list?pstartno=${paging.pagetotal}">&raquo;</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>

<%@ include file="../inc/footer.jsp"%>
