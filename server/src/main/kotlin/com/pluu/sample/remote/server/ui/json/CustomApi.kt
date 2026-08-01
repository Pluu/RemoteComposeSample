package com.pluu.sample.remote.server.ui.json

import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import com.pluu.sample.remote.server.respondRemoteUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.customApi() {
    get("/ui/custom") {
        val root = RemoteUIComponent.Column(
            children = listOf(
                RemoteUIComponent.Text(
                    text = "Remote Compose Custom UI",
                    style = UIStyle(fontSize = 24, padding = 16)
                ),
                RemoteUIComponent.Row(
                    children = listOf(
                        RemoteUIComponent.Button(
                            text = "Action A",
                            action = UIAction.ShowToast("Clicked A"),
                            style = UIStyle(padding = 4)
                        ),
                        RemoteUIComponent.Button(
                            text = "Action B",
                            action = UIAction.ShowToast("Clicked B"),
                            style = UIStyle(padding = 4)
                        )
                    )
                ),
                RemoteUIComponent.TextField(
                    label = "Enter something",
                    key = "input_1",
                    style = UIStyle(padding = 8)
                )
            )
        )
        call.respondRemoteUI(title = "Custom UI Case", root = root)
    }
}
