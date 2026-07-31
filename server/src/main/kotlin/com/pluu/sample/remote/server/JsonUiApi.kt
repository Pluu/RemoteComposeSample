package com.pluu.sample.remote.server

import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

fun Routing.jsonUiApi() {
    get("/ui/schemes") {
        val query = call.parameters["q"]?.lowercase() ?: ""
        val schemes = listOf(
            "https://www.google.com" to "Google",
            "https://github.com" to "GitHub",
            "tel:01012345678" to "Call Me",
            "mailto:test@example.com" to "Send Email",
            "geo:37.5665,126.9780" to "Seoul Map"
        ).filter { it.second.lowercase().contains(query) }

        val root = RemoteUIComponent.Column(
            children = schemes.map { (url, label) ->
                RemoteUIComponent.Button(
                    text = "Open $label",
                    action = UIAction.OpenScheme(url),
                    style = UIStyle(padding = 8)
                )
            }
        )
        call.respond(RemoteUIResponse(title = "App Schemes", root = root))
    }

    get("/ui/custom") {
        val root = RemoteUIComponent.Column(
            children = listOf(
                RemoteUIComponent.Text(
                    text = "Remote Compose Custom UI",
                    style = UIStyle(fontSize = 24, padding = 16)
                ),
                RemoteUIComponent.Row(
                    children = listOf(
                        RemoteUIComponent.Button(
                            text = "Action A",
                            action = UIAction.ShowToast("Clicked A"),
                            style = UIStyle(padding = 4)
                        ),
                        RemoteUIComponent.Button(
                            text = "Action B",
                            action = UIAction.ShowToast("Clicked B"),
                            style = UIStyle(padding = 4)
                        )
                    )
                ),
                RemoteUIComponent.TextField(
                    label = "Enter something",
                    key = "input_1",
                    style = UIStyle(padding = 8)
                )
            )
        )
        call.respond(RemoteUIResponse(title = "Custom UI Case", root = root))
    }

    get("/ui/items") {
        val items = (1..20).map { i ->
            RemoteUIComponent.Row(
                children = listOf(
                    RemoteUIComponent.Text(
                        text = "Item #$i",
                        style = UIStyle(fontSize = 18, padding = 16)
                    ),
                    RemoteUIComponent.Button(
                        text = "View",
                        action = UIAction.ShowToast("Clicked Item #$i"),
                        style = UIStyle(padding = 8)
                    )
                ),
                style = UIStyle(padding = 4)
            )
        }
        val root = RemoteUIComponent.Column(children = items)
        call.respond(RemoteUIResponse(title = "Server Item List", root = root))
    }
}
