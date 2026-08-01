package com.pluu.sample.remote.server.ui

import androidx.compose.remote.creation.RemoteComposeWriter
import com.pluu.sample.remote.server.respondBinaryUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuApi() {
    get("/ui/menu") {
        call.respondBinaryUI(title = "Main Menu") {
            drawMenuTitle("Main Menu")
            
            drawMenuItem(0, "JSON UI Samples", "Test various JSON-based UIs", "/ui/json-menu", 100f)
            drawMenuItem(1, "Server Items List", "Scrollable list from server", "/ui/items", 220f)
            drawMenuItem(2, "Remote Compose Sample", "Original binary sample", "/ui/remote", 340f)
        }
    }

    get("/ui/json-menu") {
        call.respondBinaryUI(title = "JSON UI Samples") {
            drawMenuTitle("JSON Samples")
            
            drawMenuItem(0, "App Schemes", "Test App Scheme execution", "/ui/schemes", 100f)
            drawMenuItem(1, "Custom UI Case", "Complex UI with various components", "/ui/custom", 220f)
            
            drawBackButton(3, 500f)
        }
    }
}

private fun RemoteComposeWriter.drawMenuTitle(text: String) {
    rcPaint.setColor(0xFF000000.toInt()).setTextSize(24f).commit()
    drawTextAnchored(text, 20f, 40f, -1f, 0f, 0)
}

private fun RemoteComposeWriter.drawMenuItem(
    id: Int,
    title: String,
    description: String,
    url: String,
    y: Float
) {
    // Background
    rcPaint.setColor(0xFFF0F0F0.toInt()).commit()
    drawRect(10f, y, 390f, y + 100f)
    
    // Text
    rcPaint.setColor(0xFF000000.toInt()).setTextSize(18f).commit()
    drawTextAnchored(title, 20f, y + 30f, -1f, 0f, 0)
    
    rcPaint.setColor(0xFF666666.toInt()).setTextSize(14f).commit()
    drawTextAnchored(description, 20f, y + 60f, -1f, 0f, 0)
    
    // Click Area
    addClickArea(id, "{\"action\":\"navigate\",\"url\":\"$url\"}", 10f, y, 380f, 100f, title)
}

private fun RemoteComposeWriter.drawBackButton(id: Int, y: Float) {
    rcPaint.setColor(0xFF6200EE.toInt()).commit()
    drawRect(10f, y, 390f, y + 50f)
    
    rcPaint.setColor(0xFFFFFFFF.toInt()).setTextSize(16f).commit()
    drawTextAnchored("Back", 200f, y + 25f, 0f, 0f, 0)
    
    addClickArea(id, "{\"action\":\"back\"}", 10f, y, 380f, 50f, "Back")
}
