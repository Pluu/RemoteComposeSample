package com.pluu.sample.remote.server

import androidx.compose.remote.core.RcPlatformServices
import androidx.compose.remote.creation.RemoteComposeWriter
import io.ktor.http.ContentType
import io.ktor.server.application.call
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

fun Routing.binaryUiApi() {
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
