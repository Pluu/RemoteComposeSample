package com.pluu.sample.remote.server

import androidx.compose.remote.core.RcPlatformServices
import androidx.compose.remote.creation.RemoteComposeWriter
import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.RemoteUIResponse
import io.ktor.http.ContentType
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import io.ktor.server.response.respondBytes

/**
 * Extension for responding with a standardized Remote UI JSON response.
 */
suspend fun ApplicationCall.respondRemoteUI(
    title: String,
    root: RemoteUIComponent
) {
    this.respond(RemoteUIResponse(title = title, root = root))
}

/**
 * Extension for responding with a Remote Compose binary document.
 */
suspend fun ApplicationCall.respondBinaryUI(
    title: String,
    width: Int = 400,
    height: Int = 600,
    contentDescription: String = title,
    builder: RemoteComposeWriter.() -> Unit
) {
    val writer = RemoteComposeWriter(width, height, contentDescription, RcPlatformServices.None)
    writer.builder()
    this.respondBytes(writer.encodeToByteArray(), ContentType.Application.OctetStream)
}
