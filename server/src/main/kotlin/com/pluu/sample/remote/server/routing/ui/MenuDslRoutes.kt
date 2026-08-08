package com.pluu.sample.remote.server.routing.ui

import androidx.compose.remote.core.RcProfiles
import androidx.compose.remote.creation.JvmRcPlatformServices
import androidx.compose.remote.creation.RemoteComposeContext
import androidx.compose.remote.creation.modifiers.RecordingModifier
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuDslRoutes() {
    get("/ui/dsl") {
        call.respondBytes(
            dslScreen(),
            ContentType.Application.OctetStream,
            HttpStatusCode.OK,
        )
    }
}

private fun dslScreen(): ByteArray {
    val context = RemoteComposeContext(
        width = 600,
        height = 600,
        contentDescription = "Title",
        apiLevel = 7,
        profiles = RcProfiles.PROFILE_ANDROIDX,
        platform = JvmRcPlatformServices(),
    ) {
        root {
            listOf("A", "B").forEach {
                column(
                    modifier = RecordingModifier()
                        .fillMaxSize()
                        .background(0xFFF7F7F7.toInt())
                        .padding(24f),
                ) {
                    text(
                        it,
                        color = 0xFF202124.toInt(),
                    )
                    text("Sub title")
                }
            }
        }
    }
    return context.buffer()
}
