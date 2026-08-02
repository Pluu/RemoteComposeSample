package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcPaintStyle
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.graphicsLayer
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.onDoubleClick
import androidx.compose.remote.creation.dsl.onLongClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rdp
import androidx.compose.remote.creation.dsl.rsp
import androidx.compose.remote.creation.dsl.size

fun RcScope.renderSampleContent(name: String) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16f),
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
                                    hostAction("{\"action\":\"toast\",\"message\":\"Toggled!\"}")
                                },
                    )
                    Text("  Toggle Component Sample", Modifier.padding(start = 8f))
                }
            }

            "RcScope" -> {
                Global {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(100.rdp)
                            .background(0xFFEEEEEE.toInt()),
                        vertical = RcVerticalPositioning.Center,
                        horizontal = RcHorizontalPositioning.Center,
                    ) {
                        Text("Inside Global and Box nesting", fontSize = 18.rsp)
                    }
                }
            }

            "RcTypes" -> {
                val f = remoteFloat(3.14159f)
                val c = remoteColor(0xFFFF0000.toInt())

                Text("Remote Integer (Constant): 42")
                Text("Remote Float: " + f.format(1, 4))
                Row(vertical = RcVerticalPositioning.Center) {
                    Text("Remote Color: ")
                    Box(Modifier.size(24.rdp).background(c))
                }
            }

            "DrawScope", "RcDrawing" -> {
                Text("Canvas Drawing Example", fontWeight = RcFontWeight.Bold)
                Canvas(Modifier.size(200.rdp).background(0xFFF0F0F0.toInt())) {
                    paint {
                        color(0xFFFF0000.toInt())
                    }
                    drawRect(10f, 10f, 90f, 90f)

                    paint {
                        color(0xFF0000FF.toInt())
                    }
                    drawCircle(150f, 150f, 40f)

                    paint {
                        color(0xFF00FF00.toInt())
                        strokeWidth(5f)
                        style(RcPaintStyle.Stroke)
                    }
                    drawLine(10f, 150f, 100f, 190f)
                }
            }

            "RcInteractivity", "Gestures" -> {
                Column(Modifier.fillMaxWidth().padding(8f)) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(60.rdp)
                            .background(0xFFE0E0E0.toInt())
                            .onClick {
                                hostAction("{\"action\":\"toast\",\"message\":\"Single Click!\"}")
                            },
                        vertical = RcVerticalPositioning.Center,
                        horizontal = RcHorizontalPositioning.Center,
                    ) {
                        Text("Single Click")
                    }

                    Box(
                        Modifier
                            .padding(top = 8f)
                            .fillMaxWidth()
                            .height(60.rdp)
                            .background(0xFFD0D0D0.toInt())
                            .onLongClick {
                                hostAction("{\"action\":\"toast\",\"message\":\"Long Click!\"}")
                            },
                        vertical = RcVerticalPositioning.Center,
                        horizontal = RcHorizontalPositioning.Center,
                    ) {
                        Text("Long Click")
                    }

                    Box(
                        Modifier
                            .padding(top = 8f)
                            .fillMaxWidth()
                            .height(60.rdp)
                            .background(0xFFC0C0C0.toInt())
                            .onDoubleClick {
                                hostAction("{\"action\":\"toast\",\"message\":\"Double Click!\"}")
                            },
                        vertical = RcVerticalPositioning.Center,
                        horizontal = RcHorizontalPositioning.Center,
                    ) {
                        Text("Double Click")
                    }
                }
            }

            "Animation" -> {
                val time = animationTime()
                Text("Animation using animationTime()")
                Box(
                    Modifier
                        .padding(top = 16f)
                        .size(100.rdp)
                        .graphicsLayer {
                            rotationZ(time * 45f) // Rotate 45 degrees per second
                        }.background(0xFF6200EE.toInt()),
                )
            }

            else -> {
                Text("Detail implementation for $name coming soon...", fontSize = 16.rsp)
            }
        }
    }
}
