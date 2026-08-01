package com.pluu.sample.remote.server.routing.ui

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcColumnVerticalPositioning
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.createRcBuffer
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.heightIn
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.rdp
import androidx.compose.remote.creation.dsl.rsp
import com.pluu.sample.remote.server.utils.getHeaderTags
import io.ktor.server.application.call
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuRoutes(rcProfile: RcProfile) {
    get("/ui/menu") {
        val bytes =
            createRcBuffer(rcProfile, *getHeaderTags(call)) {
                Column(Modifier.fillMaxSize().padding(16f)) {
                    Text(
                        text = "Remote Compose Sample",
                        fontSize = 32.rsp,
                        fontWeight = RcFontWeight.Bold,
                    )

                    listOf(
                        "API" to "/ui/api_list",
                        "Custom" to "/ui/custom_list",
                    ).forEach { (name, path) ->
                        Column(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .heightIn(min = 32.rdp, max = 64.rdp)
                                    .padding(0f, 12f, 0f, 12f)
                                    .onClick {
                                        hostAction("{\"action\":\"navigate\",\"url\":\"$path\"}")
                                    },
                            horizontal = RcHorizontalPositioning.Start,
                            vertical = RcColumnVerticalPositioning.Center,
                        ) {
                            Text(
                                text = name,
                                fontSize = 24.rsp,
                            )
                        }
                    }
                }
            }
        call.respondBytes(bytes)
    }
}
