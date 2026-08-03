package com.pluu.sample.remote.server.routing.ui

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.createRcBuffer
import com.pluu.sample.remote.server.utils.getHeaderTags
import com.pluu.sample.remote.server.utils.toDensityScope
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.customListUiRoutes(rcProfile: RcProfile) {
    get("/ui/custom_list") {
        val bytes =
            createRcBuffer(
                profile = rcProfile,
                tags = getHeaderTags(call, title = "Custom Samples"),
                densityScope = call.toDensityScope(),
            ) {
                Column(Modifier.fillMaxSize().padding(16f)) {
                    RcText("Coming Soon...")
                }
            }
        call.respondBytes(bytes)
    }
}
