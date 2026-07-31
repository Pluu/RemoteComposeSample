package com.pluu.sample.remote.server.ui.json

import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.schemesApi() {
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
}
