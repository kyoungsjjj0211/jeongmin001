## Part001. linux

## Ubuntu 24.04 컨테이너 실행 방법
1. **이미지 다운로드**
   ```bash
   docker pull ubuntu:24.04
   ```

2. **컨테이너 실행**
   ```bash 
   docker run -it --name myubuntu ubuntu:24.04 bash
   ```
   → 실행하면 컨테이너 내부의 쉘(`bash`) 
    - -it : i(표준입력), t(터미널)
    - --name myubuntu 컨테이너이름
    - ubuntu:24.04
    - bash


3. **컨테이너 내부에서 패키지 업데이트**
   ```bash
   apt update && apt upgrade -y
   ```

4. **컨테이너 종료 후 다시 실행하기**
   - 실행 중인 컨테이너 확인:
     ```bash
     docker ps -a
     ```
   - 컨테이너 재실행:
     ```bash
     docker start -ai <컨테이너_ID>
     docker start -ai myubuntu 
     ```
    - 실행 중인 컨테이너에 접속:
     ```bash
    docker exec -it myubuntu bash
    ```

## 2. linux 사용자
1. # root사용자
1. $ 일반사용자

## 3. 기본명령어
```bash
# 날짜
date 
# 출력
echo hello 
# 명령어 위치 확인
which date
# 명령어 설명서
man 
```
```bash
apt update
apt install man-db
unminimaize
```

```bash
help echo → 쉘 내장 명령어
man  date → 실행파일
q → 빠져나오기
type echo
type date
```
Q1. hi 출력  // echo hi
Q2. date 사용방법 확인 // type date 확인 후 man date

```
↑
↓
root@9043d6a325b8:/# date "+Y-%m-%d"      ← + 포맷형식
Y-02-03
root@9043d6a325b8:/# date "+%Y-%m-%d"
2026-02-03
root@9043d6a325b8:/#
```

## 4. 파일

### 파일 및 디렉토리 생성
- touch 파일명 : 빈 파일 생성
- mkdir 디렉토리명 : 새 디렉토리 생성
- mkdir -p 경로/하위디렉토리 : 중첩 디렉토리 생성

### 파일 확인 및 경로 이동
- ls : 현재 디렉토리 목록 보기
- ls -l : 상세 정보 포함 목록
- pwd : 현재 경로 출력
- cd 디렉토리명 : 디렉토리 이동
- cd .. : 상위 디렉토리로 이동

### 삭제 및 복사
- rm 파일명 : 파일 삭제
- rm -r 디렉토리명 : 디렉토리 삭제
- cp 원본 대상 : 파일 복사
- mv 원본 대상 : 파일 이동 또는 이름 변경

Q1. testdir 폴더만들기 // mkdir testdir
Q2. 폴더안에 file1.txt 파일만들기 // cd testdir -> touch file1.txt
Q3. 파일확인 디렉토리인지, 폴더인지까지 구분 // ls -l

### 파일에 적기 암기사항 (1) > 덮기 , >> 이어쓰기
 - echo "first" > file1.txt
 - cat file1.txt
 - echo "second" >> file1.txt

 Q1.file1.txt에 입력
   apple
   banana
   coconut

root@9043d6a325b8:/home/ubuntu/testdir# echo "second" > file1.txt
root@9043d6a325b8:/home/ubuntu/testdir# echo "first" >> file1.txt
root@9043d6a325b8:/home/ubuntu/testdir# echo "apple" >> file1.txt
root@9043d6a325b8:/home/ubuntu/testdir# echo "banana" >> file1.txt
root@9043d6a325b8:/home/ubuntu/testdir# echo "coconut" >> file1.txt
root@9043d6a325b8:/home/ubuntu/testdir# cat file1.txt
second
first
apple
banana
coconut


### 파일에 적기 (2) 여러줄쓰기, 파일편집

### 여러줄
cat > file2.txt 
첫 번째 줄 
두 번째 줄 
Ctrl+D # 입력 종료

### vi 에디터
1. sudo vi 파일명 실행  
2. vi 안에서 Esc 눌러 명령 모드로 전환   
3. i 눌러 입력 모드로 전환 → 새 설정 붙여넣기  
4. Esc → :wq → 저장 후 종료   

Q. file2.txt vi에디터이용해서 vi file1.txt -> i눌러서 insert확인후 편집 -> esc눌러서 isert사라진거 확인후 :wq엔터로 빠져나가기

one-1
two-2
three-3 
편집하기

```
apt update
apt install vim
y
5
68
```

> 정리문제
Q1. 파일만들기   mylinux.txt / mkdir "파일 이름"  / -> touch mylinux.txt
Q2. 파일안에 답채우기 -> vi mylinux.txt 
-    출력 // echo
-    사용서 // man
-    파일생성 // touch
-    디렉토리만들기 // mkdir
-    목록보기 // ls
-    상위이동 // cd ../
-    파일,폴더삭제 // rm  /rm -r
-    file1.txt 을 back.txt으로 파일복사  // cp file1.txt back.txt
-    back.txt를 test.txt로 이름변경 // mv back.txt tst.txt
Q3. vi이용해서 맨위에 작성자본인이름 추가 // vi mylinux.txt -> i > 김정민 > esc :wq enter
Q5. mylinux.txt 백업해서 ubuntu에 backup.txt로 // mv mylinux.txt ubuntu/backup.txt
Q6. 상위로 이동 testdir 삭제 // cd .. rm -r testdir

```
apt update
apt install locales
locale-gen ko_KR.UTF-8
update-locale LANG=ko_KR.UTF-8
```

### 5. 유저

# 사용자 정보 확인
whoami
id
who
users
groups

# 사용자 추가 및 삭제
sudo adduser sally
sudo passwd sally
sudo deluser sally

# 권한 구조 및 변경
ls -l
sudo chown sally:sally hello.txt
chmod 755 hello.txt
umask

```
apt update
apt install adduser
adduser sally
```
```
d rwx r-x --- 2 sally sally 4096 Feb  3 15:04 .
→ d 디렉토리 소유자 (읽기:4/쓰기:2/실행:1) 그룹 (읽기:4/쓰기:-/실행:1) 다른사람 (읽기:-/쓰기:-/실행:-)
d rwx r-x r-x 1 root  root  4096 Feb  3 14:59 ..
→ d 디렉토리 소유자 (읽기:4/쓰기:2/실행:1) 그룹 (읽기:4/쓰기:-/실행:1) 다른사람 (읽기:-/쓰기:-/실행:-)
```
```
- rw- --- --- 1 sally sally   34 Feb  3 15:04 .bash_history
- rw- r-- r-- 1 sally sally  220 Feb  3 14:59 .bash_logout

- rw- r-- r-- 1 sally sally 3771 Feb  3 14:59 .bashrc
- rw- r-- r-- 1 sally sally  807 Feb  3 14:59 .profile
```

Q1. alpha:유저만들기 비번:1234
Q2. alpha로 로그인 / alpha home 디렉토리 찾아가기
Q3. alpha로 접속해서 /home/sally찾아가는거 가능한지 확인 > 못함

```
chmod 755 /home/sally
ls -l
```
Q4. alpha로 다시 접속했을때 /home/sally 접속가능
Q5. /home/sally 다른사람 (읽기:-/쓰기:-/실행:-) 권한주기



## 6. 쉘스크립트
1. 프로세스 상태확인
```
ps -ef
```
-e : 모든 프로세스
-f : 출력정보 자세히

2. 실시간 모니터링
```
top
ctrl+c 나가기
```
3. ip주소 확인
```
ifconfig
```

```
apt update
apt install net-tools
```

4. Hello World 쉘스크립트작성
```
vi hello.sh

#!/bin/bash
echo "Hello World"
```
-rw- r-- r-- 1 root   root     31 Feb  3 16:36 hello.sh

```
ls -al
chmod +x hello.sh
```

-rwx r-x r-x 1 root   root     31 Feb  3 16:36 hello.sh

5. 쉘스크립트 실행
```
./hello.sh
```

## Part002. aws
■1. > aws 회원가입
: https://aws.amazon.com/ko/

■2.


■3.
**실행 항목**
- [x] EC2 인스턴스 생성  
- [x] OS 선택 (Ubuntu 권장)  
- [x] 보안 그룹 설정 (22, 80, 443)  
- [x] 키페어 다운로드 및 저장  
- [ ] SSH 접속 테스트 완료  

1. 퍼블릭 IPV4 주소
   16.176.20.130
   
   ssh -i "thejoa703.pem"ubuntu@ec2-16-176-20-130.ap-southeast-2.compute.amazonaws.com

   ```접속오류 
   PS D:\jeongmin\jeongmin001\track009_Linux+gitAction+cird> ssh -i "thejoa703.pem"ubuntu@ec2-16-176-20-130.ap-southeast-2.compute.amazonaws.com
Bad permissions. Try removing permissions for user: NT AUTHORITY\\Authenticated Users (S-1-5-11) on file D:/jeongmin/jeongmin001/track009_Linux+gitAction+cird/thejoa703.pem.
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@         WARNING: UNPROTECTED PRIVATE KEY FILE!          @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Permissions for 'thejoa703.pem' are too open.
It is required that your private key files are NOT accessible by others.
This private key will be ignored.
Load key "thejoa703.pem": bad permissions
ubuntu@ec2-16-176-20-130.ap-southeast-2.compute.amazonaws.com: Permission denied (publickey).

   ```
   ```
   icacls "D:\jeongmin\jeongmin001\track009_Linux+gitAction+cird\thejoa703.pem" /reset
   icacls "D:\jeongmin\jeongmin001\track009_Linux+gitAction+cird\thejoa703.pem" /inheritance:r
   icacls "D:\jeongmin\jeongmin001\track009_Linux+gitAction+cird\thejoa703.pem" /grant:r "%USERNAME%:R"
   icacls "D:\jeongmin\jeongmin001\track009_Linux+gitAction+cird\thejoa703.pem" /grant:r "$env:TJ-BU-703-004PC":R
   ```
   

■4. EC2에서 nginx
 - 웹서버연결
 - back와 front 연결설정

1. nginx설치
```
sudo apt update
sudo apt update install nginx -y
```
2. nginx 설정파일 수정
```
vi /etc/nginx/sites-available/default
```
```
server {
   listen 80;
   server_name  16.176.20.130;

   # 프론트엔드 (Next.js SSR서버)
    location / {
        proxy_pass http://localhost:3000;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
        proxy_set_header Cookie $http_cookie; 
    }

   # 백엔드 - 유저인증 (/auth)
      location / auth {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie; 
    }

    # 백엔드 - 일반 api (/api)
      location /api {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie; 
    }

    # 백엔드 - 소셜 로그인 (/oauth2)
      location /oauth2 {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie; 
    }

    # 백엔드 - 카카오/구글 리다이렉트 처리
      location /login/oauth2 {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
    #프론트엔드에서 처리해야하는 콜백
      location /oauth2/bacllback {
        proxy_pass http://localhost:3000;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie; 
    }

    # 정적 파일 경로
    location / uploads/ {
      alias /home/ubuntu/app/back/build/libs/uploads;
      autoindex off;
    }
}
```
설명 )
  location / {
        proxy_pass http://localhost:3000;    ← 포트번호 3000번호
        proxy_http_version 1.1;     ← 통신시 http
        proxy_set_header Upgrade $http_upgrade;   ← 헤더그대로 전달
        proxy_set_header Connection "upgrade";   ← 헤더그대로 전달
        proxy_set_header Host $host;    ← host 백엔드로 전송
        proxy_cache_bypass $http_upgrade;   ← 연결시 캐시 사용안함.
        proxy_set_header Cookie $http_cookie; ← 쿠키백엔드 서버로 전달
    }

```
3. nginx 실행 및 테스트
```
nginx -t
systemctrl
sudo nginx -t           
sudo systemctl restart nginx
``````````````````````````````````````````````````
## Part003. ci/cd

