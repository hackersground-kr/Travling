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
   

## 시작하기

> 여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위한 절차를 구체적으로 나열해 주세요.

> 백엔드 배포 방법 (Step by Step)

- Web App + MySQL
    
    > **웹 앱 (Web App) 생성하기**
    - Step by Step
        1. https://azure.microsoft.com/ko-kr/ 에 접속하여 **구독이 있는 계정**으로 로그인해요
        2. Azure 서비스 탭에서 리소스 만들기를 클릭해요
        3. 웹 앱 만들기를 선택해요
        4. 알맞는 리소스 그룹을 선택하세요 (리소스 그룹에 화살표를 눌러 선택 하세요)
        5. 웹 앱을 원하는 이름으로 정해줘요
            
            예) hackersground
            
        6. 게시 탭에서 코드를 선택해요 
        7. 런타입 스택에서 Node.js 18 LTS를 선택해요
        8. 운영체제는 리눅스를 선택해요
        9. 지역은 Korea Central을 선택해요
        10. 리눅스 플랜은 신규로 설정합니다 (플랜은 우선 가만히 두어요)
        12. 왼쪽 하단에 검토 + 만들기를 클릭합니다. 없으면 찾아서라도 클릭하세요
        13. 유효성 검사에서 통과되면 만들기를 클릭합니다
        14. 배포 완료되는 것을 확인합니다
    
    > **MySQL 유동 서버 생성하기
    (Azure Database for MySQL Flexible Server)**
    - Step by Step
        1. Azure 서비스 탭에서 리소스 만들기를 눌러요
           -> https://portal.azure.com/#create/hub 이겁니다 눌러요.
        2. MySQL 유동 서버 만들기를 선택해요
           -> 못 찾겠음 검색을 하세요.
           -> Azure Database for MySQL Flexible Server 이거 검색 하시면 됩니다.
           -> 젤 처음꺼 들어가세요
           -> 이것도 안되면 그냥 이거 클릭 하세요. [클릭](https://portal.azure.com/#view/Microsoft_Azure_Marketplace/GalleryItemDetailsBladeNopdl/id/Microsoft.MySQLFlexibleServer/selectionMode~/false/resourceGroupId//resourceGroupLocation//dontDiscardJourney~/false/selectedMenuId/home/launchingContext~/%7B%22galleryItemId%22%3A%22Microsoft.MySQLFlexibleServer%22%2C%22source%22%3A%5B%22GalleryFeaturedMenuItemPart%22%2C%22VirtualizedTileDetails%22%5D%2C%22menuItemId%22%3A%22home%22%2C%22subMenuItemId%22%3A%22Search%20results%22%2C%22telemetryId%22%3A%22e98d196f-7bd0-4a3c-ad43-582cde621a7d%22%7D/searchTelemetryId/ded83fe8-949f-4894-a25c-39b5499539c4/isLiteSearchFlowEnabled~/false)
        3. 보기 관리와 함께 있는 만들기를 클릭해요
           -> 플랜 하나밖에 없지만 선택하세요.
        4. 유연한 서버 (Flexible Server)를 선택해요
        5. 알맞는 리소스 그룹을 선택해요
           -> 있을꺼에요 아까 해봤죠 경험을 살려서 다시 해봅시다.
        6. 기억하기 좋은 서버 이름을 지어요
            
            예) hackersground-db
            
        7. 지역을 Korea Central로 선택해요
        8. MySQL 버전 8.0을 선택해요
        9. 인증 방법은 MySQL 인증만을 클릭해요
            -> 하단으로 내리다 보면 있습니다.
            -> 인증방법이라는 HTML radio 칸 처럼 된거 그거 클릭하세요.
        10. 관리자 사용자 이름을 원하는 것으로 정해요
            
            예) hackers01
            
        11. 암호는 조건에 맞추어 정해요
            -> 조건 꼭 맞춰 주세요.
        12. 아래 워크로드 유형 등을 건너뛰어요
        13. 다음 네트워킹을 누르세요
            -> 하단에 있어요 잘 찾아보세요.
        14. 네트워킹에서
            
            Azure 내의 모든 Azure 서비스의 이 서버에 대한 퍼블릭 액세스 허용
            
            를 선택해요
            -> 퍼블릭 액세스(허용된 IP 주소) 라는거 클릭 하세요
            
        15. 현재 클라이언트 IP 주소 추가를 클릭해요
        16. 검토 + 만들기를 클릭해요
            -> 왼쪽 하단에 있습니다. 아까도 해봤죠
        17. 유효성 검사에 성공한다면 만들기를 클릭해요
        18. 배포가 완료되는 것을 확인합니다.
        19. 만약 배포가 안되었다면 다시 한번 해보세요!
            -> 만약 그래도 배포가 안되었다면 구글을 한번 써봅시다.
            -> 배포오류 메시지를 구글에 검색창에 검색을 한 뒤 알맞은 자료를 골라 정독을 하세요.
            -> 안에 내용에 맞추어 오류를 고치세요
    
> **웹 앱 (Web App) 에 백엔드 코드 업로드하기**
> 
- Step by Step
    1. VScode를 실행하세요.
    2. [여기를 클릭](https://github.com/hackersground-kr/Travling/releases/download/1.0.1/Maru-Backend.zip)하여 백엔드 소스코드를 다운받아요
    3. 소스코드의 압축을 해제하세요
    4. VScode로 압축이 해제된 폴더를 찾아서 열어주세요
    6. 폴더안 .env 파일의 빈 변수들에
        1. MYSQL_HOST에 (DB 서버 이름).mysql.database.azure.com
        2. MYSQL_USER에 DB 유저 네임을
        3. MYSQL_PASS에 DB 비밀번호를 입력해요
        4. 그다음 왼쪽 상단의 파일 -> 저장을 클릭해요
    8. 왼쪽의 목록중 확장(Extension) 에서 Azure Tools를 검색 후 설치해요
    9. 설치 한뒤 뜨는 창은 꺼줍니다.
    10. 왼쪽의 Azure 로고를 클릭해서 안의 내용중 Sign in to Azure 를 클릭하여 웹 앱, DB 서버가 있는 계정으로 로그인을 해요
    11. VS Code의 작업 표시줄에서 Azure 탭을 클릭해요
    12. 열쇠모양 옆 화살표를 클릭한 뒤 App Services 폴더 또한 마찬가지로 연 후,
        
        생성한 웹 앱의 제목을 오른쪽 마우스를 클릭 해 Deploy to Web App을 클릭해요
        그다음 뜨는 창에서 Maru-Backend를 클릭해요
    13. https://portal.azure.com/#home 에 들어가서 보이는 처음 웹앱 생성하기에서 정한 이름의 프로젝트를 클릭합니다.
    14. 오른쪽 기본도메인이라 적힌 url을 복사합니다. 잘 보관하세요
  




## 안드로이드


1. 위에 과정에서 얻은 url을 가져온다.
2. [링크](https://github.com/hackersground-kr/Travling/archive/refs/heads/LKH-ANDROID.zip) 를 클릭하여 해당 파일을 다운한다. 그후 압축을 해제한다.
3. 안드로이드 스튜디오를 실행한다.
4. 오른쪽 상단의 Open버튼을 누른다.
5. 그후 압축을 해제한 폴더안의 경로안에서 **/Maru-Android/Maru** 폴더를 연다.

 5.5 여기서 sdk 오류로인해  설치에 실패했다면, **local.properties** 파일을 수정한다. (자신의 sdk가 설치된 곳)

1. 오른쪽 위 밑의 사진처럼 생긴 gradle 설치버튼을 누른다.
2. 그후 상단의 것중 망치모양 버튼을 누른다.

1. 모두 눌렀다면 presentation/java/com/traveling/presentation/di/NetworkModule 파일을 더블클릭한다.
2. 그 후 61번쨰 줄의 url을 **1번의 URL**로 변경한다.


1. 그후 상단의 빌드 버튼을 누르고 Build Bundle(s) / APK(s)에 마우스를 갖다대고 Build apk(s)를 누른다.
    
    
    1. 그후 조금 기다렸다가 뜨는 오른쪽 아래에서 locate버튼을 누른다. 그리고 안의 presentation-debug.apk파일의 위치를 기억한다.
    
    
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
