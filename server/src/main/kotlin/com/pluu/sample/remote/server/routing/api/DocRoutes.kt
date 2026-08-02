package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.RcRowHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.createRcBuffer
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.heightIn
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rdp
import androidx.compose.remote.creation.dsl.rsp
import androidx.compose.remote.creation.dsl.size
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
                                text = "Sample for $name",
                                fontSize = 20.rsp,
                                fontWeight = RcFontWeight.Medium,
                            )
                        }

                        // Content
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 16f),
                        ) {
                            when (name) {
                                "Text" -> {
                                    Text("Normal Text", fontSize = 16.rsp)
                                    Text("Bold Text", fontSize = 20.rsp, fontWeight = RcFontWeight.Bold)
                                    Text("Large Text", fontSize = 32.rsp)
                                    Text("Custom Color", color = 0xFFFF0000.toInt())
                                }

                                "Button" -> {
                                    Box(
                                        modifier =
                                            Modifier
                                                .fillMaxWidth()
                                                .height(48.rdp)
                                                .background(0xFF6200EE)
                                                .onClick {
                                                    hostAction("{\"action\":\"toast\",\"message\":\"Button Clicked!\"}")
                                                },
                                        vertical = RcVerticalPositioning.Center,
                                        horizontal = RcHorizontalPositioning.Center,
                                    ) {
                                        Text("Click Me", color = 0xFFFFFFFF.toInt())
                                    }
                                }

                                "Modifier" -> {
                                    Box(Modifier.size(100.rdp).background(0xFFFF0000.toInt()))
                                    Box(Modifier.padding(top = 10f).size(100.rdp).background(0xFF00FF00.toInt()))
                                    Box(
                                        Modifier
                                            .padding(top = 10f)
                                            .fillMaxWidth()
                                            .height(50.rdp)
                                            .background(0xFF0000FF.toInt()),
                                    )
                                }

                                "Layout" -> {
                                    Text("Column", fontWeight = RcFontWeight.Bold)
                                    Column(Modifier.background(0xFFEEEEEE.toInt()).padding(8f)) {
                                        Text("Item 1")
                                        Text("Item 2")
                                    }
                                    Text("Row", Modifier.padding(top = 16f), fontWeight = RcFontWeight.Bold)
                                    Row(Modifier.background(0xFFDDDDDD.toInt()).padding(8f)) {
                                        Text("Left ")
                                        Text("Right")
                                    }
                                }

                                "Icon", "Image" -> {
                                    Text("Image from URL")
                                    Image(
                                        image =
                                            remoteBitmapUrl(
                                                "https://raw.githubusercontent.com/pluu/RemoteComposeSample/master/doc/img/sample.png",
                                            ),
                                        modifier = Modifier.size(200.rdp),
                                    )
                                }

                                "Checkbox", "Switch" -> {
                                    Row(vertical = RcVerticalPositioning.Center) {
                                        Box(
                                            modifier =
                                                Modifier
                                                    .size(24.rdp)
                                                    .background(0xFFCCCCCC.toInt())
                                                    .onClick {
                                                        // Simulation: toggle logic would need expressions or host-side state
                                                        hostAction("{\"action\":\"toast\",\"message\":\"Toggled!\"}")
                                                    },
                                        )
                                        Text("  Toggle Component Sample", Modifier.padding(start = 8f))
                                    }
                                }

                                else -> {
                                    Text("Detail implementation for $name coming soon...", fontSize = 16.rsp)
                                }
                            }
                        }
                    }
                }
            call.respondBytes(bytes)
        }
    }
}
