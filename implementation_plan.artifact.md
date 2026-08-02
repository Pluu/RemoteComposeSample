# 하이브리드 UI 구성 (Native Navigation + Remote Content) 구현 계획

상단 네비게이션 및 탭 영역은 앱의 **Native Jetpack Compose**로 구현하고, 하단의 실제 상세 샘플 영역만 **RemoteCompose**를 활용하여 서버에서 동적으로 UI를 내려받는 하이브리드 구조로 개편합니다.

## User Review Required

> [!IMPORTANT]
> 서버에서 제공하던 `/ui/api_list` (Remote UI 기반 목록) 대신 앱 내의 Native UI를 사용하게 되므로, 기존의 서버 측 목록 UI 코드는 제거되거나 사용되지 않습니다.

## Proposed Changes

### [Server] 데이터 API 및 컨텐츠 UI 최적화

#### [MODIFY] [ApiListRoutes.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/server/src/main/kotlin/com/pluu/sample/remote/server/routing/api/ApiListRoutes.kt)
- 앱에서 탭을 구성할 수 있도록 샘플 목록 데이터 제공 확인

#### [MODIFY] [DocRoutes.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/server/src/main/kotlin/com/pluu/sample/remote/server/routing/api/DocRoutes.kt)
- 각 샘플 UI에서 중복되는 상단 헤더(뒤로가기 버튼, 타이틀) 제거
- 순수 컨텐츠 영역만 렌더링하도록 수정

#### [MODIFY] [DocCommon.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/server/src/main/kotlin/com/pluu/sample/remote/server/routing/api/DocCommon.kt)
- 컨텐츠 렌더링 시 불필요한 패딩이나 헤더 관련 로직 정리

---

### [App] Native UI 기반 하이브리드 연동

#### [MODIFY] [MainScreen.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/app/src/main/java/com/pluu/sample/remote/compose/ui/MainScreen.kt)
- 서버의 `/api/list` 데이터를 로드하여 상단에 Native `ScrollableTabRow` 구현
- 탭 선택 시 하단의 `RemoteComposeScreen`에 선택된 경로 전달
- 전체적인 화면 레이아웃을 Native와 Remote가 자연스럽게 이어지도록 조정

---

## Verification Plan

### Automated Tests
- `./gradlew :server:assemble` 빌드 확인
- `./gradlew :app:assembleDebug` 빌드 확인

### Manual Verification
- 앱 실행 후 `API Samples` 메뉴 진입 시 상단 탭이 네이티브로 즉각 반응하는지 확인
- 탭 전환 시 하단 리모트 컨텐츠가 정상적으로 로드되는지 확인
- 뒤로가기 동작 시 네이티브 네비게이션 스택이 올바르게 동작하는지 확인
