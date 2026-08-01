# Drawing and Graphics

Remote Compose DSL provides dedicated scopes for advanced drawing and shader management.

## RcPaintScope

Used within `paint { ... }` or `applyPaint { ... }` to configure drawing properties.

### Color & Alpha
- `color(value: Int / Long / RcColor)`
- `alpha(value: Float / RcFloat)`

### Style & Stroke
- `style(RcPaintStyle)`: Fill, Stroke, or FillAndStroke.
- `strokeWidth(value)`, `strokeCap(value)`, `strokeJoin(value)`, `strokeMiter(value)`.

### Effects
- `antiAlias(Boolean)`, `filterBitmap(Boolean)`.
- `blendMode(RcBlendMode)`.
- `colorFilter(color, mode)`, `clearColorFilter()`.
- `pathEffect(data)`: For dashed or other path effects.

### Text & Typeface
- `textSize(value)`
- `typeface(fontType, weight, italic)`
- `typeface(name: String)`: e.g., "Roboto".

### Shaders & Gradients
- `shader(RcShader)`: Sets a custom shader.
- `textureShader(image, tileX, tileY)`: Sets a texture shader.
- `linearGradient(...)`, `radialGradient(...)`, `sweepGradient(...)`.

---

## RcShaderScope

Used within `createShader(agsl) { ... }` to set uniforms for AGSL shaders.

- `uniform(name, value: Float / Int / Boolean)`
- `uniform(name, x, y, [z], [w])`: Vector uniforms.
- `uniform(name, floatArray)`
- `uniform(name, RcImage)`: Sampler uniform.

---

## RcPath

Used for vector path creation and manipulation.

### Enums
- **RcPathType**: Spline, Loop, Monotonic, Linear, Polar.
- **RcPathCombineOp**: Difference, Intersect, ReverseDifference, Union, Xor.
- **RcPathFillType**: Winding, EvenOdd.

### Operations
- `RcPath.combine(other, operation)`: Combines two paths.
- `RcPath.tween(other, progress)`: Interpolates between paths.
