📌  Track002-web basic [README2.md]

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TAG-users</title>
    <style>  
      *{margin:0; padding:0; }
      body {font-family : 'Segoe UI', sans-serif; background:linear-gradient(135deg, #fef3f9, #eadcf5);}
      h1 {text-align:center; color:#e1306c; margin-bottom:40px;}
      .card {width:250px; margin:30px auto; border-radius:20px; box-shadow:0 4px 12px rgba(0,0,0,0.1);  padding:20px; transition: all 0.3s ease; text-align:center;}
      .card:hover {transform:translateY(-5px); box-shadow:0 12px 24px rgba(0,0,0,0.2)}
      .jack {background:linear-gradient(to bottom, #8ccf76, #f0f9ff);}
      .june {background:linear-gradient(to bottom, #a7e6ff, #eefff8);}
      .mina {background:linear-gradient(to bottom, #f2fd8e,#f5f3ff);}
      .card img {width: 90px; height: 90px; object-fit: cover; border-radius: 50%; border: 3px solid #e1306c;}
      .card h2 {margin-top: 10px; margin-bottom: 5px; font-size: 18px; color: #333;}
      .card p {font-size:14px; color:#444; margin-bottom:10px;}
      .card a {font-size:13px; color:#e1306c; text-decoration:none;}
      .card h3 {margin-top:20px; font-size:16px; color:#333;}
      .card ul,.card ol,.card dl {text-align:left; padding-left:20px; color:#333; margin:0 auto;}
      .card dt {font-weight:bold;}
      .card dd {margin-bottom:10px;}
    </style>
</head>
<body>
   <div>
       <h1>사용자 프로필 카드</h1> 
       <div class="card jack">
          <p><img src="./img/one2.png" alt="Jack 프로필사진"/></p>  
          <h2>Jack</h2>
          <p>백엔드 개발자 | Node.js & DB전문가</p>
          <p>팔로워 : 3200명</p>
          <p><a href="#" title="">깃허브 보기</a></p>
          <h3>Jack이 좋아하는 기술</h3>
          <ul>
            <li>Node js</li> <li>MongoDB</li> <li>Docker</li>
          </ul>
       </div>
       <div class="card june">
          <p><img src="./img/one4.png" alt="June 프로필사진"/></p>  
          <h2>June</h2>
          <p>프론트엔드 디자이너 | React & UI/UX</p>
          <p>팔로워 : 2,100명</p>
          <p><a href="#" title="">깃허브 보기</a></p>
          <h3>프론트엔드 학습 추천 순서</h3>
          <ol>
            <li>HTML & CSS</li> <li>JavaScript</li> <li>React</li>
          </ol>
       </div><!--end div2 -->
       <div class="card mina">
          <p><img src="./img/one6.png" alt="Mina 프로필사진"/></p>  
          <h2>Mina</h2>
          <p>AI 연구원 + Python & 머신러닝</p>
          <p>팔로워 : 1,500명</p>
          <p><a href="#" title="깃허브 보기 바로가기링크">깃허브 보기</a></p>
          <h3>Mina의 역할</h3>
          <dl>
            <dt>직무</dt>     <dd>AI 연구원</dd>
            <dt>주요기술</dt>  <dd>Python, 머신러닝</dd>
            <dt>관심분야</dt>  <dd>자연어 처리, 딥러닝</dd>
          </dl>
       </div><!--end div3 -->
   </div><!-- end div -->
</body>
</html> 
 