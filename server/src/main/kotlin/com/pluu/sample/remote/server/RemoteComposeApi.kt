package com.pluu.sample.remote.server

import androidx.compose.remote.core.RcPlatformServices
import androidx.compose.remote.creation.RemoteComposeWriter
import com.pluu.sample.remote.common.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.remoteComposeApi() {
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

    get("/ui/remote") {
        val writer = RemoteComposeWriter(400, 600, "", RcPlatformServices.None)
        writer.apply {
            header(400, 600, "Remote UI", 1.0f, 0xFFFFFFFFL)

            // Header
            val headerColor = 0xFF6200EE.toInt()
            rcPaint.setColor(headerColor).commit()
            drawRect(0f, 0f, 400f, 80f)

            rcPaint.setColor(0xFFFFFFFF.toInt()).setTextSize(24f).commit()
            drawTextAnchored(
                "Remote Compose Header",
                20f, 50f,
                1f, 1f, 0
            )

            // Content
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(18f).commit()
            drawTextAnchored(
                "This UI is generated on the server",
                20f, 120f,
                1f, 1f, 0
            )

            rcPaint.setColor(0xFFFF5722.toInt()).commit()
            drawCircle(
                200f, 300f,
                100f
            )

            rcPaint.setColor(0xFFFFFFFF.toInt()).setTextSize(16f).commit()
            drawTextAnchored(
                "Native Rendering",
                200f, 300f,
                0f, 0f, 0
            )
        }
        call.respondBytes(writer.encodeToByteArray(), ContentType.Application.OctetStream)
    }
}
