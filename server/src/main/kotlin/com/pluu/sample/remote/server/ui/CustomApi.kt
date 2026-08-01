package com.pluu.sample.remote.server.ui

import com.pluu.sample.remote.server.respondBinaryUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.customApi() {
    get("/ui/custom") {
        call.respondBinaryUI(title = "Custom UI Case") {
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(24f).commit()
            drawTextAnchored("Remote Compose Custom UI", 20f, 40f, -1f, 0f, 0)
            
            // Buttons Row
            rcPaint.setColor(0xFFE0E0E0.toInt()).commit()
            drawRect(10f, 100f, 195f, 150f)
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(16f).commit()
            drawTextAnchored("Action A", 102.5f, 125f, 0f, 0f, 0)
            addClickArea(100, "{\"action\":\"toast\",\"message\":\"Clicked A\"}", 10f, 100f, 185f, 50f, "Action A")

            rcPaint.setColor(0xFFE0E0E0.toInt()).commit()
            drawRect(205f, 100f, 390f, 150f)
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(16f).commit()
            drawTextAnchored("Action B", 297.5f, 125f, 0f, 0f, 0)
            addClickArea(101, "{\"action\":\"toast\",\"message\":\"Clicked B\"}", 205f, 100f, 185f, 50f, "Action B")

            // Label
            rcPaint.setColor(0xFF333333.toInt()).setTextSize(14f).commit()
            drawTextAnchored("This is a static view", 20f, 200f, -1f, 0f, 0)
        }
    }
}
