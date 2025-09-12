### 💮나의 포트폴리오
나의 배운 순서

```
### GIT

git과 github의 차이점
git은 로컬 이며 파일의 변경 이력을 저장 (내컴퓨터)
github는 클라우드에 협업을 위한 공유 작업 공간 (가상드라이브)
터미널을 확인하는 방법 : git bash
로컬을 생성하는 방법 : git init
상태를 확인하는 방법 : git status
폴더를 이동할때 : cd
git 사용법 : add. ,  commit -m "",  push origin master , pull origin master ,  
현재 경로를 확인하는방법 remote -v
어느 대상으로 올라가 있는지  확인 git branch / master, user
```

```
### html +css 
1. 웹의 작업순서
   1) html 구조
   2) css 꾸미기
   3) js/jquery / react 동작
   4) jsp + oracle  서버전송 + 데이터저장

2. html 파일템플릿
- ! + enter
- html : 문서의 시작과 끝
- head : 문서 정보
- body : 사용자에게 보이는 내용
- 다소문자 / 시작태그와~ 끝나는태그

### HTML 문법
1. 웹페이지의 구성요소를 알려주는 표시언어
2. h1~h6  제목
   - h1 : 로고, 상호명
   - h2 : 주메뉴
   - h3~h6 : 중요도 상세메뉴 (소제목)
3. p, pre : 문단
   - p : 일반문단
   - pre : 줄바꿈과 공백을 유지하는 서식텍스트
4. img  : 이미지
   - src : 경로  , alt : 대체용어 
5. a : 링크
   - href : 다른페이지나 파일로 연결 , target="_blank" 새창열기
6. 리스트태그 : ul , ol, dl
   - ul  : 순서없는리스트
   - ol  : 순서있는리스트
   - dl  : 설명리스트  
7. 그룹핑 : div

### CSS
1. 여백 - margin / padding
   1. margin : 바깥쪽여백
   2. padding : 안쪽여백

2. 글자스타일
   1.글자색상
      color:red
   2.글자크기
      font-size:16px
   3.정렬
      text-align:center /left /right/justify 문단의 정렬을 체크해주는 부분인데 left(왼쪽정렬) , right(오른쪽정렬) , center(중앙) , justify(수평정렬)
   4.밑줄
      text-decoration:none; 깃허브
   5. 글꼴
      font-family:sans-serif;
   6. 굵게
      font-weight:bold;

3. 배경꾸미기
      background-color: gold;
      background:black;
      background:linear-gradient(to right, pink, orange) background:linear-gradient(45deg, pink, orange)
      background: red url(./img/five.png) repeat center / 20px 20px
                  색상 경로 반복여부 중앙배치 가로사이즈 세로사이즈  

4. 박스디자인
   1. 가로 : width:300px
   2. 선 : border:3px solid red
   3. 둥근모서리 : borer-radius : 20px
   4. 그림자효과 : box-shadow: 0 4px 12px rgba(0,0,0,0.5)
```
```

### GTIHUB  협업
1. html + css + js/jquery 
2. spring + mybatis + jstl  
3. node + react
4. spring boot + thymeleaf + jpa + mybatis + react  
5. flutter + spring boot + jpa + mybatis + react
```
```
### CSS 내부적용 ID VS CLASS
1. id? 유일한 값
2. id 특징
- html 문서에서 한번만 사용가능
- 중복불가
- css에서 #id명
- 우선순위가 id와 class모두 있을때 id가 더 높음

3.class? 여러개 선택시
4. class 의 특징
- 재사용가능 : 여러요소에 class 지정
- 하나의 요소에 여러개의 class 사용가능
- css에서 .class명
- 반복스타일에 적합
```

```
### CSS 배치요소

1) box model  
- 콘텐츠가 자리하는 영역을 의미하며, 박스의 구성 요소는 
   content(내용)  ,  padding , border , margin 로 이루어진다.

2) block 요소  
- width/height 설정이 (O/X): O  
- 앞뒤 줄바꿈이 (O/X): O  
- 대표 태그: div , p , h3

3) inline 요소  
- width/height 설정이 (O/X): X  
- 앞뒤 줄바꿈이 (O/X): X  
- 대표 태그: a, strong , span


2. 배치 (1) - float
    - 좌우배치 (왼쪽 또는 오른쪽 배치)
    - clear:both 끊기 : 다음요소의 흐름 정리

3. 배치 (2) - positinon
    - 절대/고정위치
    - 부모 relative 위치기준 / 자식 absolute 이동
    - fixed 브라우저 기준

4. 배치 (3) - display
    - 요소의 속성바꾸기

5. 배치(4) - display  
- 요소의 기본 속성을 바꾸려면 `display` 속성을 사용한다.  
- block 요소를 inline처럼 보이게 하려면 `inline`,  
  inline 요소를 block처럼 보이게 하려면 `block` 값을 사용한다.  
- 여러 요소를 가로로 정렬하고 싶다면 `flex`를 사용한다.  
  → 부모 요소에 `display: flex`를 주면 자식 요소들이 한 줄에 나란히 배치된다.
```

```

```
