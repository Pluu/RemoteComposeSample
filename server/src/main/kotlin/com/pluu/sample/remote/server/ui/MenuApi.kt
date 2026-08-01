package com.pluu.sample.remote.server.ui

import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuApi() {
    get("/ui/menu") {
        val root = RemoteUIComponent.Column(
            children = listOf(
                createMenuItem("JSON UI Samples", "JSON_MENU", "Test various JSON-based UIs"),
                createMenuItem("Server Items List", "ITEMS", "Scrollable list from server"),
                createMenuItem("Remote Compose (Binary)", "BINARY", "Native rendering from server binary")
            )
        )
        call.respond(RemoteUIResponse(title = "Main Menu", root = root))
    }

    get("/ui/json-menu") {
        val root = RemoteUIComponent.Column(
            children = listOf(
                createMenuItem("App Schemes", "SCHEMES", "Test App Scheme execution"),
                createMenuItem("Custom UI Case", "CUSTOM", "Complex UI with various components")
            )
        )
        call.respond(RemoteUIResponse(title = "JSON UI Samples", root = root))
    }
}

private fun createMenuItem(title: String, screen: String, description: String): RemoteUIComponent {
    return RemoteUIComponent.Column(
        children = listOf(
            RemoteUIComponent.Text(text = title, style = UIStyle(fontSize = 18, padding = 4)),
            RemoteUIComponent.Text(text = description, style = UIStyle(fontSize = 14, padding = 4)),
            RemoteUIComponent.Button(text = "Open", action = UIAction.Navigate(screen), style = UIStyle(padding = 8))
        ),
        style = UIStyle(padding = 16)
    )
}
