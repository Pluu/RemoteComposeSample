# Remote Compose Sample Server

이 프로젝트는 AndroidX Remote Compose 기능을 테스트하기 위한 Ktor 기반 백엔드 서버입니다.

## 주요 기능

- **JSON UI 정의**: 앱에서 직접 파싱하여 렌더링하는 커스텀 UI 모델(JSON)을 제공합니다.
- **Remote Compose Binary 생성**: `androidx.compose.remote` 라이브러리를 사용하여 서버에서 바이너리 형태의 UI 문서를 생성하고 스트리밍합니다.

## 기술 스택

- **Kotlin**
- **Ktor**: 웹 프레임워크 (Netty 엔진 사용)
- **AndroidX Remote Compose (Creation JVM)**: 서버 측 바이너리 UI 생성 라이브러리
- **Kotlinx Serialization**: JSON 직렬화/역직렬화

## API 엔드포인트

### 1. JSON 기반 UI
- `GET /ui/schemes`: 앱 스킴 실행 테스트를 위한 버튼 UI 목록을 반환합니다. (`q` 파라미터로 검색 가능)
- `GET /ui/custom`: 텍스트, 로우, 버튼, 텍스트 필드 등이 포함된 복합 UI 구성을 반환합니다.

### 2. Remote Compose 바이너리
- `GET /ui/remote`: `RemoteComposeWriter`로 생성된 바이너리 문서(`application/octet-stream`)를 반환합니다. 앱의 `RemoteComposePlayer`에서 네이티브로 렌더링됩니다.

## 실행 방법

IDE에서 `ServerMain.kt`를 직접 실행하거나 터미널에서 다음 명령어를 사용합니다.

```bash
./gradlew :server:run
```

서버는 기본적으로 모든 인터페이스(`0.0.0.0`)의 `8080` 포트에서 동작합니다.
Android 에뮬레이터에서 접속할 경우 `http://10.0.2.2:8080` 주소를 사용하세요.
