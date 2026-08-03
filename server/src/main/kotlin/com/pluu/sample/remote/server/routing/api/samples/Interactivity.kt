package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.onDoubleClick
import androidx.compose.remote.creation.dsl.onLongClick
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderInteractivitySample() {
    Column(Modifier.fillMaxWidth().padding(8.rdp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(60.rdp)
                .background(0xFFE0E0E0.toInt())
                .onClick {
                    hostAction("{\"action\":\"toast\",\"message\":\"Single Click!\"}")
                },
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("Single Click")
        }

        Box(
            Modifier
                .padding(top = 8.rdp)
                .fillMaxWidth()
                .height(60.rdp)
                .background(0xFFD0D0D0.toInt())
                .onLongClick {
                    hostAction("{\"action\":\"toast\",\"message\":\"Long Click!\"}")
                },
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("Long Click")
        }

        Box(
            Modifier
                .padding(top = 8.rdp)
                .fillMaxWidth()
                .height(60.rdp)
                .background(0xFFC0C0C0.toInt())
                .onDoubleClick {
                    hostAction("{\"action\":\"toast\",\"message\":\"Double Click!\"}")
                },
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("Double Click")
        }
    }
}
