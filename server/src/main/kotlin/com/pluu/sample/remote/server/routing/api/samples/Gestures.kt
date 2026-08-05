package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.onTouchCancel
import androidx.compose.remote.creation.dsl.onTouchDown
import androidx.compose.remote.creation.dsl.onTouchUp
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderGesturesSample() {
    Column(Modifier.fillMaxWidth().padding(8.rdp)) {
        RcText("Touch Gestures Sample")
        Box(
            Modifier
                .padding(top = 16.rdp)
                .fillMaxWidth()
                .height(100.rdp)
                .background(0xFFE0E0E0.toInt())
                .onTouchDown {
                    hostAction("{\"action\":\"toast\",\"message\":\"Touch Down!\"}")
                }
                .onTouchUp {
                    hostAction("{\"action\":\"toast\",\"message\":\"Touch Up!\"}")
                }
                .onTouchCancel {
                    hostAction("{\"action\":\"toast\",\"message\":\"Touch Cancel!\"}")
                },
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("Touch Me (Down/Up/Cancel)")
        }
    }
}
