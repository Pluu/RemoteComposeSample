# Android Remote Compose Sample Implementation Plan

This plan outlines the steps to create a sample project with a Ktor server providing remote UI definitions and an Android app rendering them using Jetpack Compose.

## Proposed Changes

### [Component Name] Shared/Common Logic
Create a `common` module to share UI models between the server and the Android app.

#### [NEW] [RemoteUIModel.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/common/src/main/kotlin/com/pluu/sample/remote/common/RemoteUIModel.kt)
Define serializable data classes for UI components (e.g., `Text`, `Button`, `Column`, `Row`).

### [Component Name] Ktor Server
Create a `server` module to host the remote UI definitions.

#### [NEW] [ServerMain.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/server/src/main/kotlin/com/pluu/sample/remote/server/ServerMain.kt)
Implement a Ktor server with endpoints:
- `/ui/schemes`: Returns a list of app schemes.
- `/ui/custom`: Returns custom UI cases.

### [Component Name] Android App
Update the `:app` module to fetch and render the remote UI.

#### [MODIFY] [MainActivity.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/app/src/main/java/com/pluu/sample/remote/compose/MainActivity.kt)
Implement the UI for:
- Fetching and rendering Remote Compose UI.
- App scheme execution and search functionality.
- Displaying local custom UI cases.

#### [NEW] [RemoteComposeRenderer.kt](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/app/src/main/java/com/pluu/sample/remote/compose/RemoteComposeRenderer.kt)
A set of composables that interpret the `RemoteUIModel` and render corresponding Compose components.

### Build Configuration
#### [MODIFY] [libs.versions.toml](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/gradle/libs.versions.toml)
Add Ktor, Kotlinx Serialization, and other necessary dependencies.

#### [MODIFY] [settings.gradle.kts](file:///Users/pluu/AndroidStudioProjects/RemoteComposSample/settings.gradle.kts)
Include the new `:common` and `:server` modules.

## Verification Plan

### Automated Tests
- Unit tests for the `RemoteComposeRenderer` to ensure correct mapping of models to composables.

### Manual Verification
1. Run the Ktor server locally.
2. Launch the Android app on an emulator/device.
3. Verify that the remote UI is fetched and rendered correctly.
4. Test the app scheme search and execution features.
5. Verify the "local custom UI case" is displayed.
