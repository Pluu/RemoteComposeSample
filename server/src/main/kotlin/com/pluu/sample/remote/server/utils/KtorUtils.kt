package com.pluu.sample.remote.server.utils

import androidx.compose.remote.core.operations.Header
import androidx.compose.remote.creation.RemoteComposeWriter.HTag
import io.ktor.server.application.ApplicationCall

fun getHeaderTags(call: ApplicationCall): Array<HTag> {
    val width = call.request.queryParameters["width"]?.toIntOrNull() ?: 400
    val height = call.request.queryParameters["height"]?.toIntOrNull() ?: 800
    val density = call.request.queryParameters["density"]?.toFloatOrNull() ?: 1f

    return arrayOf(
        HTag(Header.DOC_WIDTH, width),
        HTag(Header.DOC_HEIGHT, height),
        HTag(Header.DOC_DENSITY_AT_GENERATION, density),
    )
}
