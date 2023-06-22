# `트래블링` - `마루`

해커그라운드 해커톤에 참여하는 `트래블링` 팀의 `마루`입니다.

## 참고 문서

> 아래 두 링크는 해커톤에서 앱을 개발하면서 참고할 만한 문서들입니다. 이 문서들에서 언급한 서비스 이외에도 더 많은 서비스들이 PaaS, SaaS, 서버리스 형태로 제공되니 참고하세요.

- [순한맛](./REFERENCES_BASIC.md)
- [매운맛](./REFERENCES_ADVANCED.md)

## 제품/서비스 소개

<!-- 아래 링크는 지우지 마세요 -->
[제품/서비스 소개 보기](TOPIC.md)
<!-- 위 링크는 지우지 마세요 -->

## 오픈 소스 라이센스

<!-- 아래 링크는 지우지 마세요 -->
[오픈소스 라이센스 보기](./LICENSE)
<!-- 위 링크는 지우지 마세요 -->

## 설치 방법

> **아래 제공하는 설치 방법을 통해 심사위원단이 여러분의 제품/서비스를 실제 Microsoft 애저 클라우드에 배포하고 설치할 수 있어야 합니다. 만약 아래 설치 방법대로 따라해서 배포 및 설치가 되지 않을 경우 본선에 진출할 수 없습니다.**

### 사전 준비 사항

> 준비물 (requirement)
> 
1. Microsoft Azure 구독이 있는 계정
2. Github 계정
3. 인터넷이 연결된 PC 또는 랩탑
4. vscode 설치
5. vscode Extension Azure 설치
6. 구글
   

### 사전 준비 사항

> 준비물 (requirement)
> 
1. Microsoft Azure 구독이 있는 계정
2. Github 계정
3. 인터넷이 연결된 PC 또는 랩탑
4. vscode 설치
5. vscode Extension Azure 설치

## 시작하기

> 여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위한 절차를 구체적으로 나열해 주세요.
> 

> 백엔드 배포 방법 (Step by Step)
> 
- Web App + MySQL
    
    > **웹 앱 (Web App) 생성하기**
    > 
    - Step by Step
        1. https://azure.microsoft.com/ko-kr/ 에 접속하여 **구독이 있는 계정**으로 로그인해요
        2. Azure 서비스 탭에서 리소스 만들기를 클릭해요
        3. 웹 앱 만들기를 선택해요
        4. 알맞는 리소스 그룹을 선택해요 (만들어요)
        5. 웹 앱을 원하는 이름으로 정해줘요
            
            예) hackersground
            
        6. 게시 탭에서 코드를 선택해요 
        7. 런타입 스택에서 Node.js 18 LTS를 선택해요
        8. 운영체제는 리눅스를 선택해요
        9. 지역은 Korea Central을 선택해요
        10. 리눅스 플랜은 신규로 설정합니다 (플랜은 우선 가만히 두어요)
        11. 배포와 네트워킹, 모니터링 등 건너뛰어 검토 + 만들기를 클릭합니다
        12. 유효성 검사에서 통과되면 만들기를 클릭합니다
        13. 배포 완료되는 것을 확인합니다
    
    > **MySQL 유동 서버 생성하기
    (Azure Database for MySQL Flexible Server)**
    > 
    - Step by Step
        1. Azure 서비스 탭에서 리소스 만들기를 눌러요
        2. MySQL 유동 서버 만들기를 선택해요
        3. 보기 관리와 함께 있는 만들기를 클릭해요
        4. 유연한 서버 (Flexible Server)를 선택해요
        5. 알맞는 리소스 그룹을 선택해요 (만들어요)
        6. 기억하기 좋은 서버 이름을 지어요
            
            예) hackersground-db
            
        7. 지역을 Korea Central로 선택해요
        8. MySQL 버전 8.0을 선택해요
        9. 인증 방법은 MySQL 인증만을 클릭해요
        10. 관리자 사용자 이름을 원하는 것으로 정해요
            
            예) hackers01
            
        11. 암호는 조건에 맞추어 정해요
        12. 아래 워크로드 유형 등을 건너뛰어요
        13. 네트워킹에서
            
            Azure 내의 모든 Azure 서비스의 이 서버에 대한 퍼블릭 액세스 허용
            
            를 선택해요
            
        14. 현재 클라이언트 IP 주소 추가를 클릭해요
        15. 보안과 태그 등 탭을 건너뛰어서 검토 + 만들기를 클릭해요
        16. 유효성 검사에 성공한다면 만들기를 클릭해요
        17. 배포가 완료되는 것을 확인합니다.
        18. DB 개요에 들어간 후, 왼쪽 탭 중 데이터베이스 탭을 클릭해요
        19. 추가 버튼을 눌러서 이름에 food를 입력하고 저장해요
    
    > **MySQL에 테이블 불러오기**
    > 
    - Step by Step
        1. [여기를 클릭](https://github.com/hackersground-kr/Travling/releases/download/1.0.1/database_json.zip)하여 데이터 베이스 추출 파일을 받아요
        2. 압축을 풀고 여기를 클릭해 MySQL Workbench 8.0.3 버전을 설치해요
            
            → Mac이면 맥 관련된거 까시고 인텔이면 인텔 관련된거 설치하세요
            
        3. MySQL Workbench를 열고, MySQL Connections 옆의 + 를 클릭해요
        4. Connection Name에는 원하는 이름을 적어요
        5. Hostname에 (DB 서버 이름).mysql.database.azure.com을 적어요
        6. Username에 DB 서버를 만들 때 사용했던 사용자 이름을 적어요
        7. Password는 Store in keychain을 누른 후,
            
            DB 서버를 만들 때 사용했던 비밀번호를 입력해요
            
        8. Ok를 누른 후, DB 서버를 클릭하여 접속을 확인해요
        9. food DB의 Tables에서 오른쪽 클릭하여 Create Table을 눌러요
        10. Name은 dm으로 설정해요.
        11. <click to edit> 을 클릭 후 id를 입력하고, PK NM AI 체크를 표시해요
        12. 아래의 <click to edit>을 눌러 새로운 칼럼을 추가하고 danger를 추가해요
        13. danger의 데이터 타입을 INT로 설정해요
        14. 이러한 방법으로 데이터 타입이 TEXT인 칼럼 
            
            → 뒤에 () 는 지우세요
            
            foodname, foodcontent, foodtype을 생성해요
            
        15. 아래의 Apply 버튼을 누르고 다시 누르고, Close를 눌러요
        16. 생성된 dm 테이블을 오른쪽 클릭하여 Table Data Import Wizard를 눌러요
        17. Browse를 클릭하여 압축 푼 데이터베이스 폴더에서 user_dm.json을 선택해요
        18. Use existing table을 누르고 food.dm을 클릭해요
        19. Next를 누르고 다시 Next를 누르고 다시 눌러야 해요
        20. Next를 누르고 Finish를 눌러요
        21. 요소를 불러온 dm 테이블을 오른쪽 클릭하여 Table Data Import Wizard를 눌러요
        22. Browse를 누르고 압춘 푼 데이터 베이스 폴더에서 user_hbp.json을 선택해요
        23. Create new table을 누르고 food DB를 선택후 hbp를 입력해요
        24. Next를 눌러요 Next를 눌러요 Next를 눌러요 Next를 눌러요 Finish를 눌러요
        25. 위 방식으로 user_mi.json를 데이터 베이스에 저장해요
    
    > **웹 앱 (Web App) 에 백엔드 코드 업로드하기
    (백엔드 배포하기)**
    > 
    - Step by Step
        1. [여기를 클릭](https://github.com/hackersground-kr/Travling/releases/download/1.0.1/Maru-Backend.zip)하여 백엔드 소스코드를 다운받아요
        2. .env 파일의 빈 변수들에
            1. MYSQL_HOST에 (DB 서버 이름).mysql.database.azure.com
            2. MYSQL_USER에 DB 유저 네임을
            3. MYSQL_PASS에 DB 비밀번호를 입력해요
        3. VS Code 앱을 실행해요
        4. 확장(Extension) 에서 Azure Tools를 검색 후 설치해요
        5. Azure Tools에서 웹 앱, DB 서버가 있는 계정으로 로그인을 해요
        6. VS Code의 작업 표시줄에서 Azure 탭을 클릭해요
        7. 구독 폴더를 열어 App Services 폴더 또한 연 후,
            
            생성한 웹 앱을 오른쪽 마우스를 클릭 해 Deploy to Web App을 클릭해요
            
            이후 표시되는 팝업창은 모두 Yes로 표시해주어요
            

1. 위에 과정에서 얻은 url을 가져온다.
2. [링크](https://github.com/hackersground-kr/Travling/archive/refs/heads/LKH-ANDROID.zip) 를 클릭하여 해당 파일을 다운한다. 그후 압축을 해제한다.
3. 안드로이드 스튜디오를 실행한다.
4. 오른쪽 상단의 Open버튼을 누른다.
5. 그후 압축을 해제한 폴더안의 경로안에서 **/Maru-Android/Maru** 폴더를 연다.

 5.5 여기서 sdk 오류로인해  설치에 실패했다면, **local.properties** 파일을 수정한다. (자신의 sdk가 설치된 곳)

1. 오른쪽 위 밑의 사진처럼 생긴 gradle 설치버튼을 누른다.
    
2. 그후 아래의 사진처럼 생긴 것중 망치모양 버튼을 누른다.

1. 모두 눌렀다면 presentation/java/com/traveling/presentation/di/NetworkModule 파일을 더블클릭한다.
2. 그 후 61번쨰 줄의 url을 **1번의 URL**로 변경한다.

1. 그후 상단의 빌드 버튼을 누르고 Build Bundle(s) / APK(s)에 마우스를 갖다대고 Build apk(s)를 누른다.
    
    1-1. 그후 조금 기다렸다가 뜨는 아래사진에서 locate버튼을 누른다. 그리고 안의 presentation-debug.apk파일의 위치를 기억한다.
    
    1. https://appcenter.ms/ 사이트에 접속한다. 
    2. 페이지에서 보이는 Sing In 버튼을 클릭한다.
    3. Personal, Company or School 이라 적힌 마이크로소프트 계정 로그인을 누른다.
    4. 마이크로소프트 계정 로그인을 마친다.
    5. 그후 들어온 화면에서 Add new를 클릭하고 Add new app을 선택한다.
    6. app의 제목에는 eee로 설정하고 OS는 Android를 클릭한다음 Add new app을 누른다.
    7. 그 후 왼쪽 Distribute을 누른다. New releases를 누르고 11번 과정에서 얻은 파일을 업로드한다.
    8. 잠시 기다린 후 next를 2번 연속 누른다.
    9. Destinations에서 자신의 이메일을 입력하고 추가한 뒤 next를 누르고  Distribute을 누른다.
    10. 생성된 파일을 클릭하고 오른쪽 상단의 Download를 클릭하여 다운로드한다.
    11. 다운로드한 파일을 안드로이드 폰에서 실행하여 설치한다.
