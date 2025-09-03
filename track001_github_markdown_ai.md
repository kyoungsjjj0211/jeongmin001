## Track001 -  github
---
### 1. git  vs  github
- git - 로컬에 파일의 변경이력 ( 내컴퓨터에 타임머신)
- github - 클라우드올려서 협업 (친구들과 공유작업공간)

---
### 2. 기본명령어
   `git init`  저장소 생성   (빈 상자 만들기 )
   `git add .`  변경된 파일추가 ( 상자에 그림넣기)
   `git commit -m "설명" `  저장 ( 그림에 이름붙여저장)
---
### 3. [실습1] github 회원가입 및 로그인
 -  https://github.com/

---
### 4. [실습2] github 저장소
-  오른쪽상단 - [+] - [New Repository]

---
### 5. [실습3] git
- git-scm.com
- 다운로드 - [설치] 
   - ■ (New!) Add a Git Bash Profile to Windows Termial

---
### 6. [실습4] git 
#### 6-1.  Gitbash   이름, 이메일 설정정보 
```bash
git  config  --global  user.name  "Sally An"
git  config  --global user.email   "sally03915@gmail.com"
git  config  --list
```
#### 6-2.  git init    로컬상자만들기 ★
```bash
vs code - https://code.visualstudio.com/
본인폴더 - [workspace] 폴더만들기
폴더로이동 - 터미널열기  ( ctrl + ` )
git init 
```
#### 6-3.  git add .  파일만들고 / 상자에 파일넣기  ★
#### 6-4.  git status  상태확인
#### 6-5.  git commit  -m "first commit"  
   뭘저장했는지 이름붙이고 저장  ★
#### 6-6.  git  remote  add  origin   `깃허브주소(원격저장소-공유작업)`
```bash
git  remote  add  origin  https://github.com/sally03915/fullstack_20250825.git
```
#### 6-7.  git  remote  -v  연결확인
#### 6-8.  git  push origin master   원격저장소에 올리기

---
###  7. [실습5] git 수정후 (ctrl + s) 다시 올리기
```bash
파일수정
git  add  .
git commit -m "git 수정후 다시올리기"
git push origin master
```
### 8. 트러블슈팅
##### 8-1. 문제코드
```bash
TJ-BU-703-P03@DESKTOP-5CVIKGS MINGW64 /c/KIMYOUNGMIN/workspace (master)
$ git commit -m "git 수정 후 다시올리기"
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)       
        modified:   day001.md

no changes added to commit (use "git add" and/or "git commit -a")
```
##### 8-2. 🔧 해결 방법
- 아래방법을 했는데도 처리안됨.
- 너무나도 단순한 이유였음!  **저장안함**......

✅ 방법 1: 특정 파일만 추가
```bash
git add day001.md
git commit -m "git 수정 후 다시올리기"
```

✅ 방법 2: 모든 변경된 파일 추가
```bash
git add .
git commit -m "git 수정 후 다시올리기"
```

✅ 방법 3: 변경된 파일 자동 추가 후 커밋
```bash
git commit -am "git 수정 후 다시올리기"
```
> Q.현재수정된 파일 올리기





 
### 9.  pull & push  - 최신상황 반영하고 올리기
나도 수정했거든?
**[개념설명]**
- [git:로컬] - push - [github:클라우드]
- [github:클라우드] - pull - [git:로컬]

1. [git-로컬]day002.md 파일만들기 - 제목쓰기
2. [git-로컬]day002.md 파일 올리기 (github)
```bash
git add .     
git commit  -m  "day002.md"
git push origin master
```
3. [github]  github에서 day002.md 파일 수정 (깃허브에서바꾸고싶은내용)
4. [git-로컬] day002.md 파일수정 후 commit (로컬에서 바꿔서 서로 다르게 만들기)
```bash
git add .
git commit -m "day002.md local 파일수정"
```
5. [git-로컬] `git pull origin master` 충돌
```bash
git pull origin master
```
6. 두개 파일중 원하는 파일을 선택해서 파일 수정한다.   
7. 오류수정후 파일상태저장해서 다시 올리기
```bash
git add .
git commit -m "day002.md 오류해결완료"
git pull  origin master
git push  origin master
```


### 트러블슈팅 (1)
```bash
TJ-BU-703-강사PC@DESKTOP-2Q95R1R MINGW64 /d/hyojung/workspace (master)
$ git pull  origin master 
remote: Enumerating objects: 5, done.
remote: Counting objects: 100% (5/5), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)     
Unpacking objects: 100% (3/3), 1.03 KiB | 15.00 KiB/s, done.
From https://github.com/sally03915/fullstack_20250825
 * branch            master     -> FETCH_HEAD
   031d931..5ac68d8  master     -> origin/master
Auto-merging day002.md
CONFLICT (content): Merge conflict in day002.md
t the result.
```
 
- 해결방안: 
1) 두개파일비교해서 local파일수정
2) git add .     
3) git commit  -m "test"  
4) git pull origin master
5) git push orign  master
 

### 트러블슈팅 (2)
```bash
TJ-BU-703-강사PC@DESKTOP-2Q95R1R MINGW64 /d/hyojung/workspace (master|MERGING) $ git pull origin master error: You have not concluded your merge (MERGE_HEAD exists). hint: Please, commit your changes before merging. fatal: Exiting because of unfinished merge.
```
git에서 merge 안된상태에서 git pull 시도
> 병합을 시작했지만 아직완료되지 않음.

- 해결방안: 
1) 두개파일비교해서 local파일수정
2) git add .     
3) git commit  -m "test"  
4) git pull origin master
5) git push orign  master


###10. .gitignore
```bash
PS D:\hyojung\workspace> git add . warning: in the working copy of 'track003_java/.gitignore', LF will be replaced by CRLF the next time Git touches it warning: in the working copy of 'track003_java/java2025/.gitignore', LF will be replaced by CRLF the next time Git touches it PS D:\hyojung\workspace>
```
> 단순한 줄바꿈(Line Ending) 관련 안내. 
> Git이 .gitignore 파일을 처리할 때 줄바꿈 형식을 자동으로 바꾼다는 뜻



### 11. 기본  markdown 문법 
📁 `track001_github/`  
├── `me2.png` : 프로필 이미지  
├── `markdown.md` : `**마크다운 문법 정리 파일**` 
├── `README.md` : `**프로젝트 소개 및 기술스택 요약**`   

```
# 제목 (제일 큰 제목 - h1)
## 중간 제목
### 작은 제목
#### step4
##### step5
###### step6

<!-- 주석 : 제목 h1~h6 -->
---
🍟🍔  이모지 `윈도우 + .(점)`

---

- 🍟🍔 햄버거세트
- 🍕  피자
- 🌭 핫도그

1. 주문한다
2. 만든다.
3. 커피를먹는다.

---
*기울이기*
**굵은글씨**
~~취소선~~    `~~`

> 말풍선

***`강조`***

```
여러줄 긴코드블록
여러줄을 쓸때 이렇게
```

```java
public class Hello{
    public static void main(String []args){
        System.out.println("Hello");
    }
}
```

[🔗링크걸기](https://github.com/sally03915/fullstack_20250825)

![프로필](./me.png)

---
|이름|나이|
|-|-|
|sally|7살|
|alpha|3살|
```



