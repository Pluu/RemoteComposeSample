package com.pluu.sample.remote.server.ui.json

import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import com.pluu.sample.remote.server.respondRemoteUI
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.itemsApi() {
    get("/ui/items") {
        val items = (1..20).map { i ->
            RemoteUIComponent.Row(
                children = listOf(
                    RemoteUIComponent.Text(
                        text = "Item #$i",
                        style = UIStyle(fontSize = 18, padding = 16)
                    ),
                    RemoteUIComponent.Button(
                        text = "View",
                        action = UIAction.ShowToast("Clicked Item #$i"),
                        style = UIStyle(padding = 8)
                    )
                ),
                style = UIStyle(padding = 4)
            )
        }
        val root = RemoteUIComponent.Column(children = items)
        call.respondRemoteUI(title = "Server Item List", root = root)
    }
}
