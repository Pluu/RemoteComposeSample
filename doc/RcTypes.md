# RcTypes and Math

This document covers the various type-safe references and math operations available in the Remote Compose DSL.

## Resource References (Value Classes)

- **RcText**: Reference to a remote text resource.
- **RcImage**: Reference to a remote image.
- **RcColor / RcColorValue**: References to remote colors or color expressions.
- **RcFloat**: Reference to a remote float variable or expression (NaN-encoded).
- **RcInteger**: Reference to a remote integer/long variable. Supports arithmetic operators.
- **RcTextStyle**: Reference to a text style.
- **RcBitmapFont**: Reference to a bitmap font.
- **RcShader**: Reference to a custom shader.

## Units

Extension properties are provided for unit-safe dimension creation:
- **Int.rdp / Float.rdp**: Create `RcDp` (Density-independent Pixels).
- **Int.rpx / Float.rpx**: Create `RcPx` (Raw Pixels).
- **Int.rsp / Float.rsp**: Create `RcSp` (Scalable Pixels).

## Math Operations

`RcFloat` and `RcInteger` support standard operators (`+`, `-`, `*`, `/`, `%`).

### Top-Level Math Functions

- `min(a, b)`, `max(a, b)`, `abs(a)`, `sqrt(a)`, `pow(a, b)`.
- `sin(a)`, `cos(a)`, `tan(a)`, `asin(a)`, `acos(a)`, `atan(a)`, `atan2(y, x)`.
- `ceil(a)`, `floor(a)`, `round(a)`, `sign(a)`.
- `exp(a)`, `log(a)`, `log2(a)`, `ln(a)`.
- `lerp(x, y, t)`: Linear interpolation.
- `clamp(min, max, value)`: Clamps a value.
- `smoothStep(value, min, max)`: Smooth interpolation.
- `pingPong(max, x)`: Values that bounce back and forth.

### Array Operations

- `arrayMax(array)`, `arrayMin(array)`, `arraySum(array)`, `arrayAvg(array)`, `arrayLength(array)`.
- `arraySpline(array, pos)`: Interpolates from an array treated as a spline.

## Conditionals

`RcFloat` supports infix comparison operators that return an `RcCondition`:
- `eq`, `neq`, `lt`, `lte`, `gt`, `gte`.

Example: `if (a lt b) { ... }` (used in conditional operations).
