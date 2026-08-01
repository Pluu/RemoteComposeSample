package com.pluu.sample.remote.server

import androidx.compose.remote.core.RcPlatformServices
import androidx.compose.remote.core.operations.RootContentBehavior
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
    // Force API Level 6 to support ROOT_CONTENT_BEHAVIOR (65)
    // which seems to be missing in Level 7+ of this alpha version.
    val writer = RemoteComposeWriter(RcPlatformServices.None, 6)
    writer.apply {
        header(width, height, title, 1f, 0)
        setRootContentBehavior(
            RootContentBehavior.NONE,
            RootContentBehavior.ALIGNMENT_TOP or RootContentBehavior.ALIGNMENT_START,
            RootContentBehavior.SIZING_SCALE,
            RootContentBehavior.SCALE_FILL_WIDTH
        )
        builder()
    }
    this.respondBytes(writer.encodeToByteArray(), ContentType.Application.OctetStream)
}
