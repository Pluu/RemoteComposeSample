# RcScope

`RcScope` is the root scope for building RemoteCompose documents. It provides methods to add layout components, UI components, and register resources.

## Top-Level Builders

### `createRcBuffer`
Top-level builder for creating a serialized RemoteCompose document. It also creates a root node.
```kotlin
public fun createRcBuffer(
    profile: RcProfile,
    vararg tags: HTag,
    experimental: Boolean = false,
    content: RcScope.() -> Unit,
): ByteArray
```

### `createRawRcBuffer`
Top-level builder for creating a serialized RemoteCompose document without creating a root node.
```kotlin
public fun createRawRcBuffer(
    profile: RcProfile,
    vararg tags: HTag,
    experimental: Boolean = false,
    content: RcScope.() -> Unit,
): ByteArray
```

## Layout Components

- **Box**: Adds a Box layout to the document.
- **FitBox**: Adds a FitBox layout to the document.
- **StateLayout**: Adds a StateLayout layout to the document.
- **Column**: Adds a Column layout.
- **Row**: Adds a Row layout.
- **Flow**: Adds a Flow layout.
- **CollapsibleColumn / CollapsibleRow**: Layouts that support collapsing priority.
- **Spacer**: Adds a spacer component.
- **Custom**: Adds a platform-specific custom layout manager node.

## UI Components

- **Text**: Adds a Text component (String or `RcText` reference).
- **Image**: Adds an Image component.
- **Icon**: Adds an Icon component.
- **Canvas**: Adds a Canvas component for custom drawing.

## Resource Registration

`RcScope` provides many methods to register resources and get references to them:
- `remoteText`, `remoteNamedText`, `remoteColor`, `remoteBitmap`, `remoteFloat`, `remoteInteger`, `remoteTextStyle`, etc.
- `textLookup`, `textMerge`: Utilities for remote text references.

## Drawing Operations

- `applyPaint { ... }`: Executes a block with the current paint.
- `paint { ... }`: Executes a block with a typed `RcPaintScope`.
- `save() / restore()`: Canvas state management.
- `drawRect`, `drawCircle`, `drawLine`, `drawPath`, `drawBitmap`, etc.
- `createShader / shader`: Shader registration and compilation.

## System & Sensors

- `density`, `fontSize`, `apiLevel`: System metrics.
- `windowWidth`, `windowHeight`: Window dimensions.
- `accelerometerX/Y/Z`, `gyroscopeX/Y/Z`: Sensor values.
- `animationTime()`, `touchTime()`: Timing information.
