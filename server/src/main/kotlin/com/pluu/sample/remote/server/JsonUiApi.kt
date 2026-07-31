package com.pluu.sample.remote.server

import com.pluu.sample.remote.common.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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
}
