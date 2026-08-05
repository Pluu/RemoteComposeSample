package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.onClick
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderButtonSample() {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(48.rdp)
                .background(0xFF6200EE)
                .onClick {
                    hostAction("{\"action\":\"toast\",\"message\":\"버튼 클릭됨!\"}")
                },
        vertical = RcVerticalPositioning.Center,
        horizontal = RcHorizontalPositioning.Center,
    ) {
        RcText("클릭하세요", color = 0xFFFFFFFF.toInt())
    }
}
