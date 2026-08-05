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
    Box(
        Modifier
            .padding(top = 16.rdp)
            .fillMaxWidth()
            .height(100.rdp)
            .background(0xFFE0E0E0.toInt())
            .onTouchDown {
                hostAction("{\"action\":\"toast\",\"message\":\"터치 다운!\"}")
            }
            .onTouchUp {
                hostAction("{\"action\":\"toast\",\"message\":\"터치 업!\"}")
            }
            .onTouchCancel {
                hostAction("{\"action\":\"toast\",\"message\":\"터치 취소!\"}")
            },
        vertical = RcVerticalPositioning.Center,
        horizontal = RcHorizontalPositioning.Center,
    ) {
        RcText("터치하세요 (Down/Up/Cancel)")
    }
}
