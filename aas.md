<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>오늘의 메뉴 알리미 🍽️</title>
    <style>
        body {
            margin: 0;
            font-family: 'Pretendard', sans-serif;
            background: #fafafa;
        }

        /* 상단 네비게이션바 */
        nav {
            background: #ff7043;
            color: white;
            padding: 15px 60px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        nav .menu a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-weight: 600;
        }

        nav .menu a:hover {
            text-decoration: underline;
        }

        /* 메인 배너 */
        .hero {
            background: url('img/food_banner.jpg') center/cover no-repeat;
            height: 400px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            color: white;
            text-shadow: 1px 1px 3px rgba(0,0,0,0.5);
        }

        .hero h1 {
            font-size: 48px;
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 20px;
            margin-bottom: 25px;
        }

        .hero button {
            padding: 15px 40px;
            background: #ff7043;
            border: none;
            color: white;
            font-size: 18px;
            border-radius: 30px;
            cursor: pointer;
            transition: 0.3s;
        }

        .hero button:hover {
            background: #ff5722;
        }

        /* 주요 기능 카드 */
        .feature-section {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            padding: 50px 0;
        }

        .card {
            background: white;
            border-radius: 12px;
            width: 250px;
            margin: 20px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
            transition: transform 0.3s;
            text-align: center;
            padding: 30px 20px;
        }

        .card:hover {
            transform: translateY(-8px);
        }

        .card h3 {
            color: #ff7043;
        }

        .card p {
            font-size: 14px;
            color: #555;
        }

        footer {
            background: #f2f2f2;
            text-align: center;
            padding: 20px;
            font-size: 14px;
            color: #777;
        }
    </style>
</head>
<body>

    <!-- 상단 네비게이션 -->
    <nav>
        <div class="logo"><b>🍽 오늘의 메뉴 알리미</b></div>
        <div class="menu">
            <a href="index.jsp">홈</a>
            <a href="recommend.jsp">추천받기</a>
            <a href="ingredient.jsp">냉장고 재료</a>
            <a href="community.jsp">커뮤니티</a>
            <a href="stats.jsp">통계</a>
            <a href="login.jsp">로그인</a>
        </div>
    </nav>

    <!-- 메인 배너 -->
    <section class="hero">
        <h1>오늘 뭐 먹지?</h1>
        <p>기분, 재료, 영양소까지 고려한 나만의 맞춤 메뉴 추천!</p>
        <button onclick="location.href='recommend.jsp'">추천 시작하기 🍳</button>
    </section>

    <!-- 주요 기능 카드 -->
    <section class="feature-section">
        <div class="card">
            <h3>🎯 맞춤 추천</h3>
            <p>기분, 날씨, 시간대 기반으로<br>AI가 메뉴를 추천합니다.</p>
        </div>
        <div class="card">
            <h3>🥕 재료 기반 추천</h3>
            <p>냉장고 속 재료로<br>만들 수 있는 요리를 찾아드려요.</p>
        </div>
        <div class="card">
            <h3>👩‍🍳 커뮤니티</h3>
            <p>나만의 레시피를 공유하고<br>다른 사람의 요리를 구경해보세요!</p>
        </div>
        <div class="card">
            <h3>📊 영양 통계</h3>
            <p>내 섭취 영양소를 분석하고<br>건강한 식습관을 관리하세요.</p>
        </div>
    </section>

    <!-- 푸터 -->
    <footer>
        © 2025 오늘의 메뉴 알리미 Team. All rights reserved.
    </footer>

</body>
</html>
