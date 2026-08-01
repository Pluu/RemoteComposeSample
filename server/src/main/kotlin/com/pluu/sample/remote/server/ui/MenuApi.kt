package com.pluu.sample.remote.server.ui

import com.pluu.sample.remote.common.NavigationType
import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import com.pluu.sample.remote.server.respondRemoteUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuApi() {
    get("/ui/menu") {
        val root = RemoteUIComponent.Column(
            children = listOf(
                createMenuItem("JSON UI Samples", "/ui/json-menu", "Test various JSON-based UIs"),
                createMenuItem("Server Items List", "/ui/items", "Scrollable list from server"),
                createMenuItem("Remote Compose (Binary)", "/ui/remote", "Native rendering from server binary", NavigationType.BINARY)
            )
        )
        call.respondRemoteUI(title = "Main Menu", root = root)
    }

    get("/ui/json-menu") {
        val root = RemoteUIComponent.Column(
            children = listOf(
                createMenuItem("App Schemes", "/ui/schemes", "Test App Scheme execution"),
                createMenuItem("Custom UI Case", "/ui/custom", "Complex UI with various components")
            )
        )
        call.respondRemoteUI(title = "JSON UI Samples", root = root)
    }
}

private fun createMenuItem(
    title: String,
    url: String,
    description: String,
    type: NavigationType = NavigationType.JSON
): RemoteUIComponent {
    return RemoteUIComponent.Column(
        children = listOf(
            RemoteUIComponent.Text(text = title, style = UIStyle(fontSize = 18, padding = 4)),
            RemoteUIComponent.Text(text = description, style = UIStyle(fontSize = 14, padding = 4)),
            RemoteUIComponent.Button(
                text = "Open",
                action = UIAction.Navigate(url = url, type = type),
                style = UIStyle(padding = 8)
            )
        ),
        style = UIStyle(padding = 16)
    )
}
