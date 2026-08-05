package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderRcScopeSample() {
    Column(Modifier.padding(8.rdp)) {
        val dynamicText = remoteText("remoteText를 통한 동적 텍스트")
        RcText(dynamicText)

        RcText("중첩된 박스", Modifier.padding(top = 16.rdp))
        Box(Modifier.size(100.rdp).background(0xFFE0E0E0.toInt()).padding(10.rdp)) {
            Box(Modifier.size(80.rdp).background(0xFFBDBDBD.toInt()).padding(10.rdp)) {
                Box(Modifier.size(60.rdp).background(0xFF757575.toInt()))
            }
        }
    }
}
