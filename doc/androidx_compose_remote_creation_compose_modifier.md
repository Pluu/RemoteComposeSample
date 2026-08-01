# Package androidx.compose.remote.creation.compose.modifier

This package provides the remote equivalent of Jetpack Compose `Modifier`, allowing decoration and augmentation of remote composables.

## [RemoteModifier](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/RemoteModifier.kt)

An ordered, immutable collection of modifier elements for Remote Compose.

### Usage
Start with the `RemoteModifier` companion object and chain extensions:
`RemoteModifier.padding(16.rdp).background(RemoteColor.Red)`

## Common Modifiers

- **[padding](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/PaddingModifier.kt)**: Adds space around the content.
- **[background](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/BackgroundModifier.kt)**: Draws a color or gradient behind the content.
- **[clickable](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/ClickableModifier.kt)**: Configure a component to receive click events.
- **[size](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/SizeModifier.kt)**: Specifies the width and height.
- **[fillMaxSize](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/SizeModifier.kt)**: Fills the maximum available space.
- **[offset](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/OffsetModifier.kt)**: Shifts the content.
- **[clip](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/ClipModifier.kt)**: Clips the content to a shape.
- **[border](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/BorderModifier.kt)**: Draws a border around the content.
- **[alpha](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/AlphaModifier.kt)**: Modifies the opacity of the content.
- **[rotate](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/RotateModifier.kt)**: Rotates the content.
- **[scale](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/modifier/ScaleModifier.kt)**: Scales the content.
