package com.pluu.sample.remote.server.routing.ui

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

fun Route.customListUiRoutes(rcProfile: RcProfile) {
    get("/ui/custom_list") {
        val bytes =
            createRcBuffer(rcProfile, *getHeaderTags(call)) {
                Column(Modifier.fillMaxSize().padding(16f)) {
                    Text(
                        text = "Custom Samples",
                        modifier = Modifier.padding(0f, 0f, 0f, 24f),
                        fontSize = 24.rsp,
                        fontWeight = RcFontWeight.Bold,
                    )
                    Text("Coming Soon...", fontSize = 16.rsp)
                }
            }
        call.respondBytes(bytes)
    }
}
