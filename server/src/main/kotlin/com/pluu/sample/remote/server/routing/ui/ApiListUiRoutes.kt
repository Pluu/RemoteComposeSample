package com.pluu.sample.remote.server.routing.ui

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.RcRowHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.createRcBuffer
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.heightIn
import androidx.compose.remote.creation.dsl.horizontalScroll
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rdp
import androidx.compose.remote.creation.dsl.rsp
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.routing.api.renderSampleContent
import com.pluu.sample.remote.server.utils.getHeaderTags
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.apiListUiRoutes(rcProfile: RcProfile) {
    get("/ui/api_list") {
        val samples =
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

        val selectedSample = call.parameters["selected"] ?: samples.first()

        val bytes =
            createRcBuffer(rcProfile, *getHeaderTags(call)) {
                Column(Modifier.fillMaxSize().padding(16f)) {
                    // Header
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
                            text = "API Samples",
                            fontSize = 32.rsp,
                            fontWeight = RcFontWeight.Bold,
                        )
                    }

                    // Horizontal Tab Bar
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 16f, bottom = 8f)
                                .horizontalScroll(),
                        horizontal = RcRowHorizontalPositioning.Start,
                    ) {
                        samples.forEach { name ->
                            val isSelected = name == selectedSample
                            Column(
                                modifier =
                                    Modifier
                                        .padding(end = 16f)
                                        .onClick {
                                            hostAction("/ui/api_list?selected=$name")
                                        },
                                horizontal = androidx.compose.remote.creation.dsl.RcHorizontalPositioning.Center,
                            ) {
                                Text(
                                    text = name,
                                    fontSize = 18.rsp,
                                    fontWeight = if (isSelected) RcFontWeight.Bold else RcFontWeight.Normal,
                                )
                                if (isSelected) {
                                    Box(
                                        Modifier
                                            .padding(top = 4f)
                                            .size(width = 24.rdp, height = 2.rdp)
                                            .background(0xFF6200EE.toInt()),
                                    )
                                }
                            }
                        }
                    }

                    // Selected Sample Content
                    renderSampleContent(selectedSample)
                }
            }
        call.respondBytes(bytes)
    }
}
