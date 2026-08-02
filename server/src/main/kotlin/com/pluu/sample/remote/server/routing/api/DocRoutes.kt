package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.RcRowHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.createRcBuffer
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.heightIn
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rsp
import com.pluu.sample.remote.server.utils.getHeaderTags
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.docRoutes(rcProfile: RcProfile) {
    // Dummy endpoints for the docs
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
    ).forEach { name ->
        get("/api/doc/$name") {
            val bytes =
                createRcBuffer(rcProfile, *getHeaderTags(call)) {
                    Column(Modifier.fillMaxSize().padding(16f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth().heightIn(min = 48f),
                            horizontal = RcRowHorizontalPositioning.Start,
                            vertical = RcVerticalPositioning.Center,
                        ) {
                            Box(
                                modifier =
                                    Modifier
                                        .padding(end = 8f)
                                        .onClick {
                                            hostAction("back")
                                        },
                            ) {
                                Text(text = "←", fontSize = 24.rsp)
                            }
                            Text(
                                text = "Sample for $name",
                                fontSize = 20.rsp,
                                fontWeight = RcFontWeight.Medium,
                            )
                        }
                    }
                }
            call.respondBytes(bytes)
        }
    }
}
