package com.pluu.sample.remote.server.routing.ui

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.ripple
import com.pluu.sample.remote.server.utils.createRcBuffer
import com.pluu.sample.remote.server.utils.dp
import com.pluu.sample.remote.server.utils.getHeaderTags
import com.pluu.sample.remote.server.utils.rsp
import com.pluu.sample.remote.server.utils.toDensityScope
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuRoutes(rcProfile: RcProfile) {
    get("/ui/menu") {
        val ds = call.toDensityScope()
        val bytes =
            createRcBuffer(
                profile = rcProfile,
                tags = getHeaderTags(call, title = "Remote Compose Sample"),
                densityScope = ds,
            ) {
                Column(Modifier.fillMaxSize()) {
                    listOf(
                        "API" to "/ui/api_list",
                        "Custom" to "/ui/custom_list",
                        "Classic" to "/ui/classic_list",
                    ).forEach { (name, path) ->
                        Box(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .ripple()
                                    .padding(8.dp)
                                    .onClick {
                                        hostAction("{\"action\":\"navigate\",\"url\":\"$path\"}")
                                    },
                            horizontal = RcHorizontalPositioning.Start,
                            vertical = RcVerticalPositioning.Center,
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
