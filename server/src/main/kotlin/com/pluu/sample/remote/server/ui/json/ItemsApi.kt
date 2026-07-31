package com.pluu.sample.remote.server.ui.json

import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle
import io.ktor.server.application.call
import io.ktor.server.response.respond
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
        call.respond(RemoteUIResponse(title = "Server Item List", root = root))
    }
}
