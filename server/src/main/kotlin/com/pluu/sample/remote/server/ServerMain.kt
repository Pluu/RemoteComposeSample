package com.pluu.sample.remote.server

import androidx.compose.remote.core.CoreDocument
import androidx.compose.remote.core.RcProfiles
import androidx.compose.remote.creation.JvmRcPlatformServices
import androidx.compose.remote.creation.RemoteComposeWriter
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.profile.Profile
import com.pluu.sample.remote.server.routing.api.apiListRoutes
import com.pluu.sample.remote.server.routing.api.docRoutes
import com.pluu.sample.remote.server.routing.ui.customListUiRoutes
import com.pluu.sample.remote.server.routing.ui.menuRoutes
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

fun main() {
    val profile =
        Profile(
            CoreDocument.DOCUMENT_API_LEVEL,
            RcProfiles.PROFILE_ANDROIDX,
            JvmRcPlatformServices(),
        ) { displayInfo, p, callback ->
            RemoteComposeWriter(
                displayInfo,
                null,
                p,
                callback
            )
        }
    val rcProfile = RcProfile(profile)

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                },
            )
        }
        routing {
            menuRoutes(rcProfile)
            apiListRoutes()
            docRoutes(rcProfile)
            customListUiRoutes(rcProfile)
        }
    }.start(wait = true)
}
