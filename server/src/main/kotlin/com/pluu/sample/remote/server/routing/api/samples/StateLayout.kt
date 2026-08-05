package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderStateLayoutSample() {
    // StateLayout은 stateIndex에 따라 컨텐츠를 표시합니다.
    val state = remoteInteger(0)
    Column(Modifier.fillMaxWidth().background(0xFFF0F0F0.toInt()).padding(8.rdp)) {
        Row(Modifier.fillMaxWidth()) {
            RcText(
                "[상태 0 보기]",
                Modifier
                    .padding(4.rdp)
                    .background(0xFFCCCCCC.toInt())
                    .onClick { setValue(state, 0) }
            )
            RcText(
                "[상태 1 보기]",
                Modifier
                    .padding(4.rdp)
                    .background(0xFFCCCCCC.toInt())
                    .onClick { setValue(state, 1) }
            )
        }
        StateLayout(state, Modifier.background(0xFFFFEECC.toInt()).fillMaxWidth().padding(8.rdp)) {
            // 인덱스 0
            RcText("상태 0의 컨텐츠")
            // 인덱스 1
            RcText("상태 1의 컨텐츠")
        }
    }
}
