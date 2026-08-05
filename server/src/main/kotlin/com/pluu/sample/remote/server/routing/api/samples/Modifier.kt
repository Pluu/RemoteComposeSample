package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderModifierSample() {
    RcText("기본 크기 및 배경색 (100rdp, Red)", Modifier.padding(top = 8.rdp))
    Box(Modifier.size(100.rdp).background(0xFFFF0000.toInt()))
    
    RcText("패딩 추가 (Top 10rdp, Green)", Modifier.padding(top = 16.rdp))
    Box(
        Modifier.padding(top = 10.rdp).size(100.rdp)
            .background(0xFF00FF00.toInt())
    )
    
    RcText("가로 가득 채우기 및 높이 (fillMaxWidth, 50rdp, Blue)", Modifier.padding(top = 16.rdp))
    Box(
        Modifier
            .padding(top = 10.rdp)
            .fillMaxWidth()
            .height(50.rdp)
            .background(0xFF0000FF.toInt()),
    )
}
