package com.pluu.sample.remote.server.utils

import androidx.compose.remote.core.operations.Header
import androidx.compose.remote.creation.RemoteComposeWriter.HTag
import io.ktor.server.application.ApplicationCall

fun getHeaderTags(
    call: ApplicationCall,
    groupId: Int = 0,
    title: String = "",
): Array<HTag> {
    val width = call.request.queryParameters["width"]?.toIntOrNull() ?: 400
    val height = call.request.queryParameters["height"]?.toIntOrNull() ?: 800
    val density = call.request.queryParameters["density"]?.toFloatOrNull() ?: 1f
    val fontScale = call.request.queryParameters["fontScale"]?.toFloatOrNull() ?: 1f

    return arrayOf(
        HTag(Header.DOC_WIDTH, (width * density).toInt()),
        HTag(Header.DOC_HEIGHT, (height * density).toInt()),
        HTag(Header.DOC_DENSITY_AT_GENERATION, density),
        HTag(Header.DOC_DENSITY_BEHAVIOR, 1), // 1: PIXELS behavior (we scale on server)
        HTag(Header.DOC_SOURCE, groupId),
        HTag(Header.DOC_CONTENT_DESCRIPTION, title),
    )
}

fun ApplicationCall.toDensityScope(): DensityScope {
    val density = request.queryParameters["density"]?.toFloatOrNull() ?: 1f
    val fontScale = request.queryParameters["fontScale"]?.toFloatOrNull() ?: 1f
    return DensityScope(density, fontScale)
}
