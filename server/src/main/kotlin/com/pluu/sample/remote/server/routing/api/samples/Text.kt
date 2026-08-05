package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcScope
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rsp

context(ds: DensityScope)
fun RcScope.renderTextSample() {
    RcText("일반 텍스트")
    RcText("굵은 텍스트", fontSize = 20.rsp, fontWeight = RcFontWeight.Bold)
    RcText("큰 텍스트", fontSize = 32.rsp)
    RcText("커스텀 색상", color = 0xFFFF0000.toInt())
}
