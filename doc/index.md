# Remote Compose DSL Documentation

Welcome to the documentation for the Jetpack Compose Remote Creation DSL. This API allows for the creation of serialized RemoteCompose documents using a declarative Kotlin DSL.

## Core APIs

- [RcScope](RcScope.md): The main entry point for building remote documents and adding components.
- [Modifier](Modifier.md): Decorations and behaviors for components (padding, size, clicks, etc.).
- [RcTypes](RcTypes.md): Common data types and units (RcText, RcFloat, RcDp, etc.) and math operations.
- [RcInteractivity](RcInteractivity.md): Interaction handling (Actions), Positioning, and Document Profiles.

## Getting Started

To create a RemoteCompose document, use the top-level builder functions:

```kotlin
val buffer = createRcBuffer(profile) {
    Box(Modifier.fillMaxSize()) {
        Text("Hello Remote!")
    }
}
```
