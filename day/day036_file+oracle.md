## Track001 -  github
 
# ■ 자바
# ■ 깃허브(협업)
# ■ oracle
# ■ 네트워크관리사 - 이론(2) / 실기
 
1. --------------- 
# ■ 자바
# ■ file
# ■ network

2. ---------------
# ■  Github - revert / reset
1. revert - 안전한 취소      - 깃허브 [공용] 
2. reset  - 아예 지워버리기   - [혼자] 브랜치에서

실습(1) revert
1.  본인  브랜치에서 파일작성 - test브랜치에서 새작업하고 원격저장소에 푸쉬
```bash
git branch
git checkout -b test(테스트브랜치명)
파일작성   revert.md
git  add .
git commit -m "revert"
git push origin  test(테스트브랜치명)
```
2.  main 브랜치에서 병합 - test브랜치작업을 main 병합하고 푸시
```bash
git checkout master
git pull origin master
git merge   테스트브랜치명
git push  origin master
```
3.  main 브랜치에서 되돌리기
```bash
git checkout master
git log
git revert  <commit_hash>
git push origin master
```

Q1.  팀장- test3.md   revert vs reset
     main - commit1 - merge
     main - commit2 - merge
     main - commit3 - merge     -merge 3번

     
Q2.  팀원 -  예)  idol.md  본인소개 / commit  /  main에서 merge  -  revert 해서 본인이 남긴지 지우기






3. ---------------
# ■ oracle - select
# ■ group



4. ---------------
-- 자격증 및 정리

Q-1-1. C Class의 네트워크 주소가 192.169.10.0
Q-1-2. 서브넷마스크가 '255.255.255.240' , 최대 사용가능한 호스트 수? 14개

풀이 0) A (0) /B (128) / C(192) / D(240)
풀이 1) 8*4=32bit
     11111111    / 11111111  / 11111111    /표현방법
     0~255(256)  0~255(256)  0~255(256)    0~240(256)
                                           256~240 = 16개 -2
                                           (네트워크아이디 + 브로드캐스트아이디)
* ip단위 : 256~240(마지막)
* cidr                      서브넷 마스크    ip단위로 나뉘는 크기
   /25  (1이 앞에서 25개)    255.255.255.128 128개
   /26  (1이 앞에서 25개)    255.255.255.192 64개
   /27  (1이 앞에서 25개)    255.255.255.224 32개


###


 