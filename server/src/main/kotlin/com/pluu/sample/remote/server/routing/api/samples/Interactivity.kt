package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.ripple
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
                .ripple()
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
                .ripple()
                .background(0xFFD0D0D0.toInt()),
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("[미동작] onLongClick")
        }

        Box(
            Modifier
                .padding(top = 8.rdp)
                .fillMaxWidth()
                .height(60.rdp)
                .ripple()
                .background(0xFFC0C0C0.toInt()),
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("[미동작] onDoubleClick")
        }
    }
}
