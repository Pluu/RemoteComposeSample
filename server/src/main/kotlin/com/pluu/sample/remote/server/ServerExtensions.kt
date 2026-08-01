package com.pluu.sample.remote.server

import androidx.compose.remote.core.RcPlatformServices
import androidx.compose.remote.creation.RemoteComposeWriter
import io.ktor.http.ContentType
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respondBytes

/**
 * Extension for responding with a Remote Compose binary document.
 */
suspend fun ApplicationCall.respondBinaryUI(
    title: String,
    width: Int = 400,
    height: Int = 800,
    builder: RemoteComposeWriter.() -> Unit
) {
    val writer = RemoteComposeWriter(width, height, title, RcPlatformServices.None)
    writer.apply {
        header(width, height, title, 1.0f, 0xFFFFFFFFL)
        builder()
    }
    this.respondBytes(writer.encodeToByteArray(), ContentType.Application.OctetStream)
}
