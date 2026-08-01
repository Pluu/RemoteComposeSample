package com.pluu.sample.remote.server.ui

import com.pluu.sample.remote.server.respondBinaryUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.itemsApi() {
    get("/ui/items") {
        call.respondBinaryUI(title = "Server Item List", height = 2000) {
            rcPaint.setColor(0xFF000000.toInt()).setTextSize(24f).commit()
            drawTextAnchored("Server Item List", 20f, 40f, -1f, 0f, 0)
            
            (1..20).forEach { i ->
                val y = 100f + (i - 1) * 80f
                rcPaint.setColor(0xFFF5F5F5.toInt()).commit()
                drawRect(10f, y, 390f, y + 70f)
                
                rcPaint.setColor(0xFF000000.toInt()).setTextSize(18f).commit()
                drawTextAnchored("Item #$i", 30f, y + 35f, -1f, 0f, 0)
                
                rcPaint.setColor(0xFF6200EE.toInt()).commit()
                drawRect(300f, y + 10f, 380f, y + 60f)
                rcPaint.setColor(0xFFFFFFFF.toInt()).setTextSize(14f).commit()
                drawTextAnchored("View", 340f, y + 35f, 0f, 0f, 0)
                
                addClickArea(i, "{\"action\":\"toast\",\"message\":\"Clicked Item #$i\"}", 300f, y + 10f, 80f, 50f, "View Item $i")
            }
        }
    }
}
