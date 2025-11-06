<!-- src/main/webapp/WEB-INF/jsp/home.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <!-- ✅ 기본 설정 -->
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>🍽 오늘의 메뉴 추천</title>

  <!-- ✅ 외부 라이브러리 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet" />

  <!-- ✅ 파티클 배경 효과 -->
  <script src="https://cdn.jsdelivr.net/npm/tsparticles@2.12.0/tsparticles.bundle.min.js"></script>

  <!-- ✅ 커스텀 스타일 -->
  <style>
    body {
      background: linear-gradient(to bottom, #a8e0ff, #ffffff);
      font-family: 'Jua', sans-serif;
      overflow-x: hidden;
    }

    #tsparticles {
      position: fixed;
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      z-index: -1;
    }

    .main-title {
      font-size: 3rem;
      color: #0078d4;
      animation: fadeInDown 1.2s;
    }

    .card {
      border-radius: 1rem;
      transition: transform 0.4s, box-shadow 0.4s;
    }

    .card:hover {
      transform: translateY(-10px) scale(1.02);
      box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
    }

    footer {
      margin-top: 5rem;
      color: #777;
    }
  </style>
</head>

<body>
  <!-- ✅ 파티클 효과 배경 -->
  <div id="tsparticles"></div>

  <!-- ✅ 메인 컨테이너 -->
  <div class="container py-5 animate__animated animate__fadeIn">

    <!-- 🔹 제목 영역 -->
    <h1 class="text-center main-title mb-5">🍽 오늘의 메뉴 추천</h1>

    <!-- 🔹 추천 요청 폼 -->
    <!-- 사용자가 기분(mood)을 선택하고 추천 메뉴를 요청 -->
    <form action="/recommend" method="post" class="text-center mb-5 animate__animated animate__fadeInUp">
      <select name="mood" class="form-select w-50 mx-auto mb-3">
        <option value="기분 좋아요">기분 좋아요</option>
        <option value="피곤해요">피곤해요</option>
        <option value="배고파요">배고파요</option>
        <option value="우울해요">우울해요</option>
      </select>
      <button type="submit" class="btn btn-primary px-4 py-2">추천받기</button>
    </form>

    <!-- 🔹 추천 결과 영역 -->
    <!-- Controller에서 모델로 전달된 'mood'와 'recommendations'를 표시 -->
    <c:if test="${not empty mood}">
      <h2 class="text-center mb-4 animate__animated animate__fadeInDown">
        ${mood}에 어울리는 추천 메뉴 🍱
      </h2>
    </c:if>

    <div class="row justify-content-center animate__animated animate__zoomIn">
      <c:forEach var="menu" items="${recommendations}">
        <div class="col-md-4 mb-4">
          <div class="card shadow-sm">
            <img src="${menu.imageUrl}" class="card-img-top" alt="${menu.title}" />
            <div class="card-body text-center">
              <h5 class="card-title fw-bold">${menu.title}</h5>
              <p class="card-text text-muted">${menu.description}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>

    <!-- 🔹 푸터 -->
    <footer class="text-center small">© 2025 Team MenuMate | Made with 💙</footer>
  </div>

  <!-- ✅ 파티클 효과 설정 -->
  <script>
    tsParticles.load("tsparticles", {
      background: { color: { value: "transparent" } },
      fpsLimit: 60,
      interactivity: {
        events: {
          onHover: { enable: true, mode: "repulse" },
          resize: true
        },
        modes: {
          repulse: { distance: 100, duration: 0.4 }
        }
      },
      particles: {
        color: { value: ["#309ed3", "#395693"] },
        links: { color: "#309ed3", distance: 150, enable: true, opacity: 0.3, width: 1 },
        move: { enable: true, speed: 1, outModes: { default: "bounce" } },
        number: { density: { enable: true, area: 800 }, value: 80 },
        opacity: { value: 0.5 },
        shape: { type: "circle" },
        size: { value: { min: 1, max: 3 } }
      },
      detectRetina: true
    });
  </script>
</body>
</html>