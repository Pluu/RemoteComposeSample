package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.createRcBuffer
import com.pluu.sample.remote.server.utils.getHeaderTags
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.docRoutes(rcProfile: RcProfile) {
    val allSamples =
        listOf(
            "Modifier",
            "RcScope",
            "RcTypes",
            "Layout",
            "DrawScope",
            "Text",
            "Button",
            "Image",
            "Icon",
            "Checkbox",
            "Switch",
            "RcDrawing",
            "RcInteractivity",
            "Animation",
            "Gestures",
        )

    allSamples.forEach { name ->
        get("/api/doc/$name") {
            val bytes =
                createRcBuffer(rcProfile, *getHeaderTags(call)) {
                    // 순수 컨텐츠 영역만 렌더링 (헤더 제거)
                    renderSampleContent(name)
                }
            call.respondBytes(bytes)
        }
    }
}
