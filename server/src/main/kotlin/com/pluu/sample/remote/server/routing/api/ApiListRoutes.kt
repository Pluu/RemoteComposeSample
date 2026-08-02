package com.pluu.sample.remote.server.routing.api

import com.pluu.sample.remote.common.ApiItem
import com.pluu.sample.remote.common.ApiList
import com.pluu.sample.remote.common.ApiResponse
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.apiListRoutes() {
    get("/api/list") {
        val response =
            ApiResponse(
                api =
                    ApiList(
                        sample =
                            listOf(
                                ApiItem("Modifier", "/api/doc/Modifier"),
                                ApiItem("RcScope", "/api/doc/RcScope"),
                                ApiItem("RcTypes", "/api/doc/RcTypes"),
                                ApiItem("Layout", "/api/doc/Layout"),
                                ApiItem("DrawScope", "/api/doc/DrawScope"),
                                ApiItem("Text", "/api/doc/Text"),
                                ApiItem("Button", "/api/doc/Button"),
                                ApiItem("Image", "/api/doc/Image"),
                                ApiItem("Icon", "/api/doc/Icon"),
                                ApiItem("Checkbox", "/api/doc/Checkbox"),
                                ApiItem("Switch", "/api/doc/Switch"),
                                ApiItem("RcDrawing", "/api/doc/RcDrawing"),
                                ApiItem("RcInteractivity", "/api/doc/RcInteractivity"),
                                ApiItem("Animation", "/api/doc/Animation"),
                                ApiItem("Gestures", "/api/doc/Gestures"),
                            ),
                        custom = emptyList(),
                    ),
            )
        call.respond(response)
    }
}
