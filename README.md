# Remote Compose Sample

이 프로젝트는 AndroidX의 **Remote Compose** 기능을 실험하고 테스트하기 위한 샘플 프로젝트입니다. 
서버에서 정의된 UI 구성을 안드로이드 앱에서 동적으로 렌더링하는 시나리오를 포함하고 있습니다.

## 프로젝트 구조

이 프로젝트는 다음과 같은 멀티 모듈로 구성되어 있습니다.

- **[:server](server/)**: Ktor 기반의 백엔드 서버입니다. JSON 기반의 UI 정의와 Remote Compose 바이너리 데이터를 제공합니다.
- **[:app](app/)**: Jetpack Compose를 사용하는 안드로이드 애플리케이션입니다. 서버로부터 UI 정보를 받아와 화면에 표시합니다.
- **[:common](common/)**: 서버와 앱 간에 공유되는 데이터 모델 및 유틸리티를 포함합니다.

## 주요 기능

- **Dynamic UI Rendering**: 서버에서 제공하는 JSON 설정을 바탕으로 앱의 UI를 동적으로 구성합니다.
- **Remote Compose Binary**: `androidx.compose.remote` 라이브러리를 활용하여 서버에서 생성된 UI 바이너리를 앱에서 네이티브로 렌더링합니다.
- **Ktor Integration**: Ktor 서버와 클라이언트를 사용하여 비동기 네트워크 통신을 처리합니다.

## 시작하기

### 1. 서버 실행
서버를 먼저 실행해야 앱에서 데이터를 정상적으로 받아올 수 있습니다.

```bash
./gradlew :server:run
```
서버는 기본적으로 `http://localhost:8080`에서 동작합니다.

### 2. 안드로이드 앱 실행
안드로이드 스튜디오에서 `:app` 모듈을 선택하고 실행합니다. 
에뮬레이터에서 실행 시 서버 주소는 `http://10.0.2.2:8080`으로 설정되어 있어야 합니다.

## 기술 스택

- **언어**: Kotlin
- **UI 프레임워크**: Jetpack Compose
- **서버 프레임워크**: Ktor (Netty)
- **네트워크**: Ktor Client, OkHttp
- **직렬화**: Kotlinx Serialization
- **라이브러리**: AndroidX Remote Compose

## 참고 문서
- [Server 상세 가이드](server/README.md)
- [Agent 작업 가이드](AGENTS.md)
