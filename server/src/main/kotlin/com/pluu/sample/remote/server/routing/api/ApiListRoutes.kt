package com.pluu.sample.remote.server.routing.api

import com.pluu.sample.remote.common.ApiItem
import com.pluu.sample.remote.common.ApiList
import com.pluu.sample.remote.common.ApiResponse
import com.pluu.sample.remote.server.routing.api.SampleNames
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
                                ApiItem(SampleNames.MODIFIER, "/api/doc/${SampleNames.MODIFIER}"),
                                ApiItem(SampleNames.RCSCOPE, "/api/doc/${SampleNames.RCSCOPE}"),
                                ApiItem(SampleNames.RCTYPES, "/api/doc/${SampleNames.RCTYPES}"),
                                ApiItem(SampleNames.LAYOUT, "/api/doc/${SampleNames.LAYOUT}"),
                                ApiItem(SampleNames.DRAWSCOPE, "/api/doc/${SampleNames.DRAWSCOPE}"),
                                ApiItem(SampleNames.TEXT, "/api/doc/${SampleNames.TEXT}"),
                                ApiItem(SampleNames.BUTTON, "/api/doc/${SampleNames.BUTTON}"),
                                ApiItem(SampleNames.IMAGE, "/api/doc/${SampleNames.IMAGE}"),
                                ApiItem(SampleNames.ICON, "/api/doc/${SampleNames.ICON}"),
                                ApiItem(SampleNames.CHECKBOX, "/api/doc/${SampleNames.CHECKBOX}"),
                                ApiItem(SampleNames.SWITCH, "/api/doc/${SampleNames.SWITCH}"),
                                ApiItem(SampleNames.RCDRAWING, "/api/doc/${SampleNames.RCDRAWING}"),
                                ApiItem(SampleNames.RCINTERACTIVITY, "/api/doc/${SampleNames.RCINTERACTIVITY}"),
                                ApiItem(SampleNames.ANIMATION, "/api/doc/${SampleNames.ANIMATION}"),
                                ApiItem(SampleNames.GESTURES, "/api/doc/${SampleNames.GESTURES}"),
                            ),
                        custom = emptyList(),
                    ),
            )
        call.respond(response)
    }
}
