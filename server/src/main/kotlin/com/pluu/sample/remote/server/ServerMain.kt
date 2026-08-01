package com.pluu.sample.remote.server

import androidx.compose.remote.core.RcProfiles
import androidx.compose.remote.creation.JvmRcPlatformServices
import androidx.compose.remote.creation.RemoteComposeWriter
import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.createRcBuffer
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rsp
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.profile.Profile
import androidx.compose.remote.creation.profile.RemoteComposeWriterFactory
import com.pluu.sample.remote.common.ApiItem
import com.pluu.sample.remote.common.ApiList
import com.pluu.sample.remote.common.ApiResponse
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

fun main() {
    val profile = Profile(
        6,
        RcProfiles.PROFILE_BASELINE,
        JvmRcPlatformServices()
    ) { _, p, _ ->
        RemoteComposeWriter(p)
    }
    val rcProfile = RcProfile(profile)
    
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        routing {
            get("/api/list") {
                val response = ApiResponse(
                    api = ApiList(
                        sample = listOf(
                            ApiItem("Modifier", "/api/doc/Modifier"),
                            ApiItem("RcDrawing", "/api/doc/RcDrawing"),
                            ApiItem("RcInteractivity", "/api/doc/RcInteractivity"),
                            ApiItem("RcScope", "/api/doc/RcScope"),
                            ApiItem("RcTypes", "/api/doc/RcTypes")
                        ),
                        custom = emptyList()
                    )
                )
                call.respond(response)
            }

            get("/ui/menu") {
                val bytes = createRcBuffer(rcProfile) {
                    Column(Modifier.fillMaxSize().padding(16f)) {
                        Text(
                            text = "Remote Compose Sample",
                            modifier = Modifier.padding(0f, 0f, 0f, 24f),
                            fontSize = 24.rsp,
                            fontWeight = RcFontWeight.Bold
                        )
                        
                        listOf(
                            "API" to "/ui/api_list",
                            "Custom" to "/ui/custom_list"
                        ).forEach { (name, path) ->
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(0f, 8f, 0f, 8f)
                                    .onClick {
                                        hostAction("{\"action\":\"navigate\",\"url\":\"$path\"}")
                                    }
                            ) {
                                Text(
                                    text = name,
                                    fontSize = 18.rsp
                                )
                            }
                        }
                    }
                }
                call.respondBytes(bytes)
            }

            get("/ui/api_list") {
                val bytes = createRcBuffer(rcProfile) {
                    Column(Modifier.fillMaxSize().padding(16f)) {
                        Text(
                            text = "API Samples",
                            modifier = Modifier.padding(0f, 0f, 0f, 24f),
                            fontSize = 24.rsp,
                            fontWeight = RcFontWeight.Bold
                        )
                        
                        listOf(
                            "Modifier" to "/api/doc/Modifier",
                            "RcDrawing" to "/api/doc/RcDrawing",
                            "RcInteractivity" to "/api/doc/RcInteractivity",
                            "RcScope" to "/api/doc/RcScope",
                            "RcTypes" to "/api/doc/RcTypes"
                        ).forEach { (name, path) ->
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(0f, 8f, 0f, 8f)
                                    .onClick {
                                        hostAction("{\"action\":\"navigate\",\"url\":\"$path\"}")
                                    }
                            ) {
                                Text(
                                    text = name,
                                    fontSize = 18.rsp
                                )
                            }
                        }
                    }
                }
                call.respondBytes(bytes)
            }

            get("/ui/custom_list") {
                val bytes = createRcBuffer(rcProfile) {
                    Column(Modifier.fillMaxSize().padding(16f)) {
                        Text(
                            text = "Custom Samples",
                            modifier = Modifier.padding(0f, 0f, 0f, 24f),
                            fontSize = 24.rsp,
                            fontWeight = RcFontWeight.Bold
                        )
                        Text("Coming Soon...", fontSize = 16.rsp)
                    }
                }
                call.respondBytes(bytes)
            }

            // Dummy endpoints for the docs
            listOf("Modifier", "RcDrawing", "RcInteractivity", "RcScope", "RcTypes").forEach { name ->
                get("/api/doc/$name") {
                    val bytes = createRcBuffer(rcProfile) {
                        Box(Modifier.fillMaxSize().padding(16f)) {
                            Text(
                                text = "Sample for $name",
                                fontSize = 20.rsp,
                                fontWeight = RcFontWeight.Medium
                            )
                        }
                    }
                    call.respondBytes(bytes)
                }
            }
        }
    }.start(wait = true)
}
