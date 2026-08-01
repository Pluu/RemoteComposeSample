package com.pluu.sample.remote.server

import com.pluu.sample.remote.server.ui.customApi
import com.pluu.sample.remote.server.ui.itemsApi
import com.pluu.sample.remote.server.ui.menuApi
import com.pluu.sample.remote.server.ui.menuSampleApi
import com.pluu.sample.remote.server.ui.remoteApi
import com.pluu.sample.remote.server.ui.schemesApi
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        routing {
        }
    }.start(wait = true)
}
