# Package androidx.compose.remote.creation.compose.layout

This package provides remote equivalents of standard Jetpack Compose layout components, allowing you to define UI on a server that can be rendered natively on a client using Remote Compose.

## Composables

### [RemoteBox](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteBox.kt)
A layout composable that positions its children relative to its own edges.

```kotlin
@Composable
public fun RemoteBox(
    modifier: RemoteModifier = RemoteModifier,
    contentAlignment: RemoteAlignment = RemoteAlignment.TopStart,
    content: @Composable () -> Unit
)
```

### [RemoteColumn](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteColumn.kt)
A layout composable that positions its children in a vertical sequence.

```kotlin
@Composable
public fun RemoteColumn(
    modifier: RemoteModifier = RemoteModifier,
    verticalArrangement: RemoteArrangement.Vertical = RemoteArrangement.Top,
    horizontalAlignment: RemoteAlignment.Horizontal = RemoteAlignment.Start,
    content: @Composable RemoteColumnScope.() -> Unit
)
```

### [RemoteRow](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteRow.kt)
A layout composable that positions its children in a horizontal sequence.

```kotlin
@Composable
public fun RemoteRow(
    modifier: RemoteModifier = RemoteModifier,
    horizontalArrangement: RemoteArrangement.Horizontal = RemoteArrangement.Start,
    verticalAlignment: RemoteAlignment.Vertical = RemoteAlignment.Top,
    content: @Composable RemoteRowScope.() -> Unit
)
```

### [RemoteText](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteText.kt)
A remote composable that displays text.

```kotlin
@Composable
public fun RemoteText(
    text: RemoteString,
    modifier: RemoteModifier = RemoteModifier,
    color: RemoteColor? = null,
    fontSize: RemoteTextUnit? = null,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: RemoteFontFamily? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: RemoteTextStyle = RemoteTextStyle.Default,
    fontVariationSettings: FontVariation.Settings? = null
)
```

### [RemoteImage](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteImage.kt)
A composable that lays out and draws a given `RemoteImageBitmap`.

```kotlin
@Composable
public fun RemoteImage(
    remoteBitmap: RemoteImageBitmap,
    contentDescription: RemoteString?,
    modifier: RemoteModifier = RemoteModifier,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: RemoteFloat = DefaultAlpha.rf
)
```

### [RemoteSpacer](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteSpacer.kt)
A spacer that takes up space as defined by the provided `modifier`.

```kotlin
@Composable
public fun RemoteSpacer(modifier: RemoteModifier = RemoteModifier)
```

### [RemoteFlowRow](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteFlowRow.kt) (Internal)
A layout composable that places its children in a horizontal flow.

```kotlin
@Composable
public fun RemoteFlowRow(
    modifier: RemoteModifier = RemoteModifier,
    horizontalArrangement: RemoteArrangement.Horizontal = RemoteArrangement.Start,
    verticalArrangement: RemoteArrangement.Vertical = RemoteArrangement.Top,
    maxItemsInEachRow: Int = Int.MAX_VALUE,
    maxLines: Int = Int.MAX_VALUE,
    content: @Composable () -> Unit
)
```

### [FitBox](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/FitBox.kt) (Internal)
A Box layout that captures layout information for RemoteCompose.

```kotlin
@Composable
public fun FitBox(
    modifier: RemoteModifier = RemoteModifier,
    horizontalAlignment: RemoteAlignment.Horizontal = RemoteAlignment.CenterHorizontally,
    verticalArrangement: RemoteArrangement.Vertical = RemoteArrangement.Center,
    content: @Composable () -> Unit = {}
)
```

### [RemoteCollapsibleColumn](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteCollapsibleColumn.kt) (Internal)
A collapsible column layout.

```kotlin
@Composable
public fun RemoteCollapsibleColumn(
    modifier: RemoteModifier = RemoteModifier,
    horizontalAlignment: RemoteAlignment.Horizontal = RemoteAlignment.Start,
    verticalArrangement: RemoteArrangement.Vertical = RemoteArrangement.Top,
    content: @Composable RemoteCollapsibleColumnScope.() -> Unit
)
```

### [RemoteCollapsibleRow](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteCollapsibleRow.kt) (Internal)
A collapsible row layout.

```kotlin
@Composable
public fun RemoteCollapsibleRow(
    modifier: RemoteModifier = RemoteModifier,
    horizontalArrangement: RemoteArrangement.Horizontal = RemoteArrangement.Start,
    verticalAlignment: RemoteAlignment.Vertical = RemoteAlignment.Top,
    content: @Composable RemoteCollapsibleRowScope.() -> Unit
)
```

### [RemoteStateLayout](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteStateLayout.kt)
A layout that manages and displays multiple states.

```kotlin
@Composable
public fun <T : Enum<T>> RemoteStateLayout(
    currentState: RemoteEnum<T>,
    modifier: RemoteModifier = RemoteModifier,
    content: @Composable (T) -> Unit
)
```

### [RemoteCanvas](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteCanvas.kt)
A Composable that provides a `RemoteDrawScope` for drawing operations.

```kotlin
@Composable
public fun RemoteCanvas(
    modifier: RemoteModifier = RemoteModifier,
    content: RemoteDrawScope.() -> Unit
)
```

## Helper Classes & Interfaces

### [RemoteAlignment](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteAlignment.kt)
A remote equivalent of `androidx.compose.ui.Alignment`.
Common values: `TopStart`, `TopCenter`, `TopEnd`, `CenterStart`, `Center`, `CenterEnd`, `BottomStart`, `BottomCenter`, `BottomEnd`.

### [RemoteArrangement](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteArrangement.kt)
A mirror of `androidx.compose.foundation.layout.Arrangement`.
Common values: `Start`, `End`, `Top`, `Bottom`, `Center`, `SpaceEvenly`, `SpaceBetween`, `SpaceAround`.
Methods: `spacedBy(space: RemoteDp)`, `spacedBy(space: RemoteFloat)`.

### [RemoteColumnScope](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteColumn.kt)
Receiver scope for `RemoteColumn`.
Provides `RemoteModifier.weight(weight: RemoteFloat)`.

### [RemoteRowScope](file:///Users/pluu/.gradle/caches/modules-2/files-2.1/androidx.compose.remote/remote-creation-compose/1.0.0-alpha16/6583869e84470861d624ef648bb2a33e9b1e7f25/remote-creation-compose-1.0.0-alpha16-sources.jar!/androidx/compose/remote/creation/compose/layout/RemoteRow.kt)
Receiver scope for `RemoteRow`.
Provides `RemoteModifier.weight(weight: RemoteFloat)`.
