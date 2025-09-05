## 🚀 김정민 | 실전형 풀스택 개발자 포트폴리오

완벽보다 완성을.
기획부터 배포까지, 사용자 흐름을 설계하고 끝까지 책임지는 개발자입니다.

단순한 기능 구현을 넘어,

**탄탄한 컴퓨터 공학 지식(CS 기반)**과

실전 중심의 협업 프로젝트 경험을 바탕으로
비즈니스에 바로 적용 가능한 개발 역량을 증명해왔습니다.
- 사용자 중심의 UI/UX 설계부터
- 백엔드 구조 설계 및 API 통신,
- 클라우드 기반 배포까지
전 과정을 직접 주도하며, 문제를 해결하는 개발자입니다.

<br/>
<br/> 


<!--   

 ---
1. 이미지 (캐리커쳐)
2. 이름 , 이메일, 깃허브주소, 포트폴리오  4*2의 테이블형식으로 -->
## 📌Contact  & Links 
<img src="/track001_github/me2.png"      
     alt="프로필"  width="50" />

| | |
|-|-|
|NAME| 김정민|
|EMAIL| kyoungsjjj0513@gmail.com|
|GITHUB| https://github.com/kyoungsjjj0211

<br/>
<br/> 

---
<!-- track001 github -->
## 📌Golds 
- Github의 **`핵심기능`** 이해하고 실습
- markdown을 활용한 **`문서화능력향상`**
- 협업을 위한 github **`워크플로워 익히기`**
- ai도구와 함께하는 **`개발환경체험`**

---
<!-- cs와 연결지어서  -->

## 📌 기술스택 기반 CS 역량

| 기술스택         | 연결된 CS 역량 및 실무 활용 능력 |
|------------------|----------------------------------|
| **Git & GitHub** | 분산형 저장소 개념을 이해하고, 협업 시 브랜치 전략 및 충돌 해결 능력 보유. <span style="color:#e67e22"><strong>실무에서의 `CI/CD` 흐름과 연계 가능</strong></span>. |
| **Markdown**     | 문서화 능력과 정보 구조화 역량. <span style="color:#3498db"><strong>README, 위키, 기술 문서 작성 시 가독성과 유지보수성을 고려한 문서 설계 가능</strong></span>. |
| **VS Code**      | IDE의 동작 원리와 확장성에 대한 이해를 바탕으로 생산성 향상. <span style="color:#2ecc71"><strong>디버깅, 플러그인 활용, 코드 자동화 등 실무 효율 극대화</strong></span>. |
| **HTML5**        | 웹의 구조적 설계와 DOM 트리 이해. <span style="color:#9b59b6"><strong>시맨틱 태그를 활용한 접근성 및 SEO 최적화 역량 보유</strong></span>. |
| **CSS3**         | 렌더링 엔진의 작동 방식과 박스 모델, 레이아웃 알고리즘에 대한 이해. <span style="color:#f39c12"><strong>반응형 디자인 및 UI/UX 구현 능력</strong></span>. |
| **AI 프롬프트**  | 자연어 처리와 모델 응답 구조에 대한 이해를 바탕으로, <span style="color:#e74c3c"><strong>효율적인 프롬프트 엔지니어링 및 반복 작업 자동화 능력 보유</strong></span>. |
 
<br/>
<br/>
<br/>

 
<!-- 📌  JAVA, HTML+CSS+JS/JQUERY .... -->
<!--  ## 포트폴리오  
<br/>
<br/>
<br/>
-->
---
<!--  정리해놓은 day1, day2,  -->
## 📌 트러블슈팅

### 🐞 트러블슈팅 (1)

```bash
$ git commit -m "git 수정 후 다시올리기"
...
no changes added to commit (use "git add" and/or "git commit -a")
```

- **문제점**  
  수정한 파일이 있지만 `git add`를 하지 않아 커밋 대상에 포함되지 않음.
  
- **해결방안**  
  ```bash
  git add day001.md
  git commit -m "day001.md 수정사항 반영"
  ```

- **느낌점**  
  커밋은 했는데 아무것도 반영되지 않았을 때 당황스러웠다. 정말 황당하게도 **저장을 하지 않아서 발생한문제** 기본적인 Git 흐름을 다시 점검하는 계기가 되었고, 커밋 전 `git status` 확인 습관을 들여야겠다고 꼭 저장하는 습관 다시한번 확인하기를 느꼈다.  

---

### 🔀 트러블슈팅 (2)

```bash
$ git pull origin master
...
CONFLICT (content): Merge conflict in day002.md
```

- **문제점**  
  원격 저장소와 로컬 파일 간 충돌 발생. 자동 병합 실패.

- **해결방안**  
  1. 충돌 파일(`day002.md`)을 열어 충돌 부분 수정  
  2. 수정 후 커밋  
     ```bash
     git add day002.md
     git commit -m "충돌 해결: day002.md"
     ```

- **느낌점**  
  충돌 메시지를 처음 봤을 땐 막막했지만, 직접 해결해보니 Git의 병합 원리를 이해하게 되었다. 협업 시 충돌을 줄이기 위해 커밋 주기와 Pull 타이밍을 조율하는 것이 중요하다는 걸 체감했다.

---

### ⛔ 트러블슈팅 (3)

```bash
$ git pull origin master
error: You have not concluded your merge (MERGE_HEAD exists).
```

- **문제점**  
  이전 병합이 완료되지 않은 상태에서 다시 Pull을 시도함. Git이 병합 중이라는 상태를 유지하고 있음.

- **해결방안**  
  병합을 먼저 마무리해야 함.  
  ```bash
  git status  # 병합 중인 파일 확인
  git add .
  git commit -m "병합 완료"
  ```

- **느낌점**  
  Git은 상태 기반으로 동작한다는 걸 실감했다. 병합 중이라는 상태를 명확히 인식하고, 단계별로 처리해야 오류를 피할 수 있다. Git의 내부 동작을 더 깊이 이해하게 된 계기였다.
 


<br/>
<br/>
<br/> 

---
## 📌 참고문헌
- [Git 공식 문서](https://git-scm.com/doc)  
- [Markdown 가이드](https://www.markdownguide.org/basic-syntax/)  
- [VS Code 공식 사이트](https://code.visualstudio.com/)  
- [AI 프롬프트 작성 팁](https://learn.microsoft.com/en-us/azure/ai-foundry/openai/concepts/prompt-engineering?tabs=chat)