# Modifier

`Modifier` is an ordered, immutable collection of elements used to augment components.

## Core Interface

```kotlin
public interface Modifier {
    public fun then(other: Modifier): Modifier
    public companion object : Modifier
}
```

## Layout & Size Modifiers

- `padding(all: Float / RcDp / RcPx)`: Adds padding around the component.
- `size(width, height)`, `width(value)`, `height(value)`: Sets component dimensions.
- `fillMaxWidth()`, `fillMaxHeight()`, `fillMaxSize()`: Expands to fill parent space.
- `wrapContentSize()`, `wrapContentWidth()`, `wrapContentHeight()`: Wraps content.
- `offset(x, y)`: Offsets the component.
- `widthIn(min, max)`, `heightIn(min, max)`: Constraints on size.
- `zIndex(value)`: Sets the drawing order.

## Visuals & Graphics Modifiers

- `background(color: Int / Long / RcColor)`: Sets the background color.
- `clip(shape)`: Clips the component to a shape.
- `border(width, roundedCorner, color, shape)`: Adds a border.
- `graphicsLayer { ... }`: Applies transformations like scale, rotation, alpha, and translation.
- `ripple()`: Adds Material Design ripple feedback.
- `drawWithContent { ... }`: Custom drawing on top or below content.

## Scrolling & Animation

- `verticalScroll() / horizontalScroll()`: Enables scrolling.
- `animationSpec(spec)`: Configures animations.
- `marquee(...)`: Adds a marquee effect.

## Actions & Interactivity

- `onClick { ... }`: Handles click events in an `RcActionScope`.
- `onLongClick`, `onDoubleClick`: Other click interactions.
- `onTouchDown`, `onTouchUp`, `onTouchCancel`: Low-level touch events.

## Parent Specific Modifiers

- `horizontalWeight(weight)`, `verticalWeight(weight)`: Weight for Box/Row/Column layouts.
- `fillParentMaxSize()`: Fills parent size.
- `alignByBaseline()`: Aligns by text baseline.
- `horizontalCollapsiblePriority / verticalCollapsiblePriority`: Priority for collapsing layouts.
