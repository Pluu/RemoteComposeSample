package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.RcProfile
import com.pluu.sample.remote.server.utils.createRcBuffer
import com.pluu.sample.remote.server.utils.getHeaderTags
import com.pluu.sample.remote.server.utils.toDensityScope
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
            val ds = call.toDensityScope()
            val bytes =
                createRcBuffer(
                    profile = rcProfile,
                    tags = getHeaderTags(call, groupId = 1, title = "$name Sample"),
                    densityScope = ds,
                ) {
                    // 순수 컨텐츠 영역만 렌더링 (헤더 제거)
                    renderSampleContent(name)
                }
            call.respondBytes(bytes)
        }
    }
}
