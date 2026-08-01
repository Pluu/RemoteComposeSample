package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.createRcBuffer
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rsp
import com.pluu.sample.remote.server.utils.getHeaderTags
import io.ktor.server.application.call
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.docRoutes(rcProfile: RcProfile) {
    // Dummy endpoints for the docs
    listOf("Modifier", "RcDrawing", "RcInteractivity", "RcScope", "RcTypes").forEach { name ->
        get("/api/doc/$name") {
            val bytes =
                createRcBuffer(rcProfile, *getHeaderTags(call)) {
                    Box(Modifier.fillMaxSize().padding(16f)) {
                        Text(
                            text = "Sample for $name",
                            fontSize = 20.rsp,
                            fontWeight = RcFontWeight.Medium,
                        )
                    }
                }
            call.respondBytes(bytes)
        }
    }
}
