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
import com.pluu.sample.remote.server.utils.dp
import com.pluu.sample.remote.server.utils.getHeaderTags
import com.pluu.sample.remote.server.utils.sp
import com.pluu.sample.remote.server.utils.toDensityScope
import io.ktor.server.response.respondBytes
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.menuRoutes(rcProfile: RcProfile) {
    get("/ui/menu") {
        val densityScope = call.toDensityScope()
        val bytes =
            createRcBuffer(rcProfile, *getHeaderTags(call)) {
                Column(Modifier.fillMaxSize().padding(16.dp(densityScope))) {
                    Text(
                        text = "Remote Compose Sample",
                        fontSize = 32.sp(densityScope),
                        fontWeight = RcFontWeight.Bold,
                    )

                    listOf(
                        "API" to "/ui/api_list",
                        "Custom" to "/ui/custom_list",
                        "Classic" to "/ui/classic_list",
                    ).forEach { (name, path) ->
                        Column(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .heightIn(min = 32.dp(densityScope), max = 64.dp(densityScope))
                                    .onClick {
                                        hostAction("{\"action\":\"navigate\",\"url\":\"$path\"}")
                                    },
                            horizontal = RcHorizontalPositioning.Start,
                            vertical = RcColumnVerticalPositioning.Center,
                        ) {
                            Text(
                                text = name,
                                fontSize = 24.sp(densityScope),
                            )
                        }
                    }
                }
            }
        call.respondBytes(bytes)
    }
}
