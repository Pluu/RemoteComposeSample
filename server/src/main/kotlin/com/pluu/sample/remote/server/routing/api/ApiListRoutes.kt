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
                                ApiItem(SampleNames.ANIMATION, "/api/doc/${SampleNames.ANIMATION}"),
                                ApiItem(SampleNames.BUTTON, "/api/doc/${SampleNames.BUTTON}"),
                                ApiItem(SampleNames.CANVAS, "/api/doc/${SampleNames.CANVAS}"),
                                ApiItem(SampleNames.CHECKBOX, "/api/doc/${SampleNames.CHECKBOX}"),
                                ApiItem(SampleNames.COLLAPSIBLE_COLUMN, "/api/doc/${SampleNames.COLLAPSIBLE_COLUMN}"),
                                ApiItem(SampleNames.COLUMN, "/api/doc/${SampleNames.COLUMN}"),
                                ApiItem(SampleNames.FITBOX, "/api/doc/${SampleNames.FITBOX}"),
                                ApiItem(SampleNames.FLOW, "/api/doc/${SampleNames.FLOW}"),
                                ApiItem(SampleNames.GESTURES, "/api/doc/${SampleNames.GESTURES}"),
                                ApiItem(SampleNames.ICON, "/api/doc/${SampleNames.ICON}"),
                                ApiItem(SampleNames.IMAGE, "/api/doc/${SampleNames.IMAGE}"),
                                ApiItem(SampleNames.MODIFIER, "/api/doc/${SampleNames.MODIFIER}"),
                                ApiItem(SampleNames.RCINTERACTIVITY, "/api/doc/${SampleNames.RCINTERACTIVITY}"),
                                ApiItem(SampleNames.RCSCOPE, "/api/doc/${SampleNames.RCSCOPE}"),
                                ApiItem(SampleNames.RCTYPES, "/api/doc/${SampleNames.RCTYPES}"),
                                ApiItem(SampleNames.ROW, "/api/doc/${SampleNames.ROW}"),
                                ApiItem(SampleNames.STATELAYOUT, "/api/doc/${SampleNames.STATELAYOUT}"),
                                ApiItem(SampleNames.SWITCH, "/api/doc/${SampleNames.SWITCH}"),
                                ApiItem(SampleNames.TEXT, "/api/doc/${SampleNames.TEXT}"),
                            ),
                        custom = emptyList(),
                    ),
            )
        call.respond(response)
    }
}
