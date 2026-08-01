package com.pluu.sample.remote.server.ui

import com.pluu.sample.remote.server.respondBinaryUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.remoteApi() {
    get("/ui/remote") {
        call.respondBinaryUI(title = "Remote UI") {
            // Header
            val headerColor = 0xFF6200EE.toInt()
            rcPaint.setColor(headerColor).commit()
            drawRect(0f, 0f, 400f, 80f)

            rcPaint.setColor(0xFFFFFFFF.toInt()).setTextSize(24f).commit()
            drawTextAnchored(
                "Remote Compose Header",
                20f, 50f,
                -1f, 0f, 0
            )

            // Content
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(18f).commit()
            drawTextAnchored(
                "This UI is generated on the server",
                20f, 120f,
                -1f, 0f, 0
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
            
            // Interaction
            addClickArea(1, "{\"action\":\"toast\",\"message\":\"Binary UI Interaction!\"}", 100f, 200f, 200f, 200f, "Circle Area")
        }
    }
}
