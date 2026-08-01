package com.pluu.sample.remote.common

import kotlinx.serialization.Serializable

@Serializable
sealed class RemoteUIComponent {
    @Serializable
    data class Text(val text: String, val style: UIStyle = UIStyle()) : RemoteUIComponent()

    @Serializable
    data class Button(val text: String, val action: UIAction, val style: UIStyle = UIStyle()) : RemoteUIComponent()

    @Serializable
    data class Column(val children: List<RemoteUIComponent>, val style: UIStyle = UIStyle()) : RemoteUIComponent()

    @Serializable
    data class Row(val children: List<RemoteUIComponent>, val style: UIStyle = UIStyle()) : RemoteUIComponent()

    @Serializable
    data class TextField(val label: String, val key: String, val style: UIStyle = UIStyle()) : RemoteUIComponent()
}

@Serializable
data class UIStyle(
    val padding: Int = 0,
    val fontSize: Int = 14,
    val color: String? = null
)

@Serializable
sealed class UIAction {
    @Serializable
    data class OpenScheme(val url: String) : UIAction()
    
    @Serializable
    data class ShowToast(val message: String) : UIAction()

    @Serializable
    data class Navigate(
        val url: String,
        val type: NavigationType = NavigationType.JSON
    ) : UIAction()
}

@Serializable
enum class NavigationType {
    JSON, BINARY
}

@Serializable
data class RemoteUIResponse(
    val title: String,
    val root: RemoteUIComponent
)
