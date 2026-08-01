package com.pluu.sample.remote.server.ui

import com.pluu.sample.remote.server.respondBinaryUI
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

        call.respondBinaryUI(title = "App Schemes") {
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(24f).commit()
            drawTextAnchored("App Schemes", 20f, 40f, -1f, 0f, 0)
            
            schemes.forEachIndexed { index, (url, label) ->
                val y = 100f + (index * 60f)
                rcPaint.setColor(0xFF6200EE.toInt()).commit()
                drawRect(10f, y, 390f, y + 50f)
                
                rcPaint.setColor(0xFFFFFFFF.toInt()).setTextSize(16f).commit()
                drawTextAnchored("Open $label", 200f, y + 25f, 0f, 0f, 0)
                
                addClickArea(index, "{\"action\":\"open\",\"url\":\"$url\"}", 10f, y, 380f, 50f, label)
            }
        }
    }
}
