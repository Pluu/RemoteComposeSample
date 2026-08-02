package com.pluu.sample.remote.server.routing.ui

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

fun Route.apiListUiRoutes(rcProfile: RcProfile) {
    get("/ui/api_list") {
        val samples =
            listOf(
                "Modifier" to "/api/doc/Modifier",
                "RcScope" to "/api/doc/RcScope",
                "RcTypes" to "/api/doc/RcTypes",
                "Layout" to "/api/doc/Layout",
                "DrawScope" to "/api/doc/DrawScope",
                "Text" to "/api/doc/Text",
                "Button" to "/api/doc/Button",
                "Image" to "/api/doc/Image",
                "Icon" to "/api/doc/Icon",
                "Checkbox" to "/api/doc/Checkbox",
                "Switch" to "/api/doc/Switch",
                "RcDrawing" to "/api/doc/RcDrawing",
                "RcInteractivity" to "/api/doc/RcInteractivity",
                "Animation" to "/api/doc/Animation",
                "Gestures" to "/api/doc/Gestures",
            )

        val tabGroups =
            mapOf(
                "Core" to listOf("Modifier", "RcScope", "RcTypes", "Layout", "DrawScope"),
                "Components" to listOf("Text", "Button", "Image", "Icon", "Checkbox", "Switch"),
                "Advanced" to listOf("RcDrawing", "RcInteractivity", "Animation", "Gestures"),
            )

        val currentTab = call.parameters["tab"] ?: tabGroups.keys.first()

        val filteredSamples =
            samples.filter { (name, _) ->
                tabGroups[currentTab]?.contains(name) == true
            }

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
                            text = "API Samples",
                            fontSize = 32.rsp,
                            fontWeight = RcFontWeight.Bold,
                        )
                    }

                    // Tab Bar
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 16f, bottom = 16f),
                        horizontal = RcRowHorizontalPositioning.Start,
                    ) {
                        tabGroups.keys.forEach { tab ->
                            val isSelected = tab == currentTab
                            Box(
                                modifier =
                                    Modifier
                                        .padding(end = 12f)
                                        .onClick {
                                            hostAction("/ui/api_list?tab=$tab")
                                        },
                            ) {
                                Text(
                                    text = if (isSelected) "● $tab" else tab,
                                    fontSize = 18.rsp,
                                    fontWeight = if (isSelected) RcFontWeight.Bold else RcFontWeight.Normal,
                                )
                            }
                        }
                    }

                    filteredSamples.forEach { (name, path) ->
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(0f, 12f, 0f, 12f)
                                .onClick {
                                    hostAction(path)
                                },
                        ) {
                            Text(
                                text = name,
                                fontSize = 24.rsp,
                            )
                        }
                    }
                }
            }
        call.respondBytes(bytes)
    }
}
