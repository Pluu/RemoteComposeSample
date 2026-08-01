package com.pluu.sample.remote.server.routing

import com.pluu.sample.remote.common.ApiItem
import com.pluu.sample.remote.common.ApiList
import com.pluu.sample.remote.common.ApiResponse
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.apiRoutes() {
    get("/api/list") {
        val response =
            ApiResponse(
                api =
                    ApiList(
                        sample =
                            listOf(
                                ApiItem("Modifier", "/api/doc/Modifier"),
                                ApiItem("RcDrawing", "/api/doc/RcDrawing"),
                                ApiItem("RcInteractivity", "/api/doc/RcInteractivity"),
                                ApiItem("RcScope", "/api/doc/RcScope"),
                                ApiItem("RcTypes", "/api/doc/RcTypes"),
                            ),
                        custom = emptyList(),
                    ),
            )
        call.respond(response)
    }
}
