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

> **여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위해 사전에 필요한 준비 사항들을 적어주세요.**

## 시작하기

> **여러분의 제품/서비스를 Microsoft 애저 클라우드에 배포하기 위한 절차를 구체적으로 나열해 주세요.**


1. 위에 과정에서 얻은 url을 가져옵니다.
2. [링크](https://github.com/hackersground-kr/Travling/archive/refs/heads/LKH-ANDROID.zip) 를 클릭하여 해당 파일을 다운로드합니다. 그후 압축을 해제합니다.
3. 안드로이드 스튜디오를 실행합니다.
4. 오른쪽 상단의 Open버튼을 누릅니다.
5. 압축을 해제한 폴더안의 경로안에서 **/Maru** 폴더를 엽니다.
![test](https://github.com/hackersground-kr/Travling/blob/main/images/folder.png?raw=true)

6. 첫 실행이라면 오른 쪽 밑에 로딩바가 없어질떄까지 기다리고 아니라면 오른쪽 위 밑의 사진처럼 생긴 gradle 설치버튼을 누릅니다. (약 10분정도 소요됩니다.)
7. 그후 아래의 사진처럼 생긴 것중 망치모양 버튼을 누릅니다.
![gradle](https://github.com/hackersground-kr/Travling/blob/main/images/gradle.png?raw=true)
8. 모두 눌렀다면 presentation/java/com/traveling/presentation/di/NetworkModule 파일을 엽니다.
9. 그 후 61번쨰 줄의 url을 **1번의 URL**로 변경한다.
![folder](https://github.com/hackersground-kr/Travling/blob/main/images/network.png?raw=true)
10. 그후 상단의 빌드 버튼을 누르고 Build Bundle(s) / APK(s)에 마우스를 갖다대고 Build apk(s)를 누릅니다.
![apk](https://github.com/hackersground-kr/Travling/blob/main/images/buildapk.png?raw=true)
11. 그후 조금 기다렸다가 뜨는 아래사진에서 locate버튼을 누른다. 그리고 안의 presentation-debug.apk파일의 위치를 기억합니다.
![located](https://github.com/hackersground-kr/Travling/blob/main/images/located.png?raw=true)
12. https://appcenter.ms/ 사이트에 접속합니다.
13. 페이지에서 보이는 Sing In 버튼을 클릭합니다.
![main](https://github.com/hackersground-kr/Travling/blob/main/images/main.png?raw=true)
14. Personal, Company or School 이라 적힌 마이크로소프트 계정 로그인을 누릅니다.
![singing](https://github.com/hackersground-kr/Travling/blob/main/images/login.png?raw=true)
15. 마이크로소프트 계정 로그인을 마칩니다.
16. 그후 들어온 화면에서 Add new를 클릭하고 Add new app을 선택합니다.
![addApp](https://github.com/hackersground-kr/Travling/blob/main/images/addApp.png?raw=true)
17. app의 제목에는 eee로 설정하고 OS는 Android를 클릭한다음 Add new app을 누릅니다.
![editApp](https://github.com/hackersground-kr/Travling/blob/main/images/addinput.png?raw=true)
18. 그 후 왼쪽 Distribute을 누른다. New releases를 누르고 11번 과정에서 얻은 파일을 업로드합니다.
![Distribute](https://github.com/hackersground-kr/Travling/blob/main/images/distribute.png?raw=true)
![release](https://github.com/hackersground-kr/Travling/blob/main/images/release.png?raw=true)
![uploadBe](https://github.com/hackersground-kr/Travling/blob/main/images/uploadBefore.png?raw=true)
![uploadAf](https://github.com/hackersground-kr/Travling/blob/main/images/uploadAfter.png?raw=true)
19. 잠시 기다린 후 next를 누릅니다.
20. Destinations에서 자신의 이메일을 입력하고 추가한 뒤 next를 누르고  Distribute을 누릅니다.
![Tester](https://github.com/hackersground-kr/Travling/blob/main/images/tester.png?raw=true)
21. 생성된 파일을 클릭하고 오른쪽 상단의 Download를 클릭하여 다운로드합니다.
![Down](https://github.com/hackersground-kr/Travling/blob/main/images/list.png?raw=true)
![Down](https://github.com/hackersground-kr/Travling/blob/main/images/download.png?raw=true)
23. 다운로드한 파일을 안드로이드 폰에서 실행하여 설치합니다.
