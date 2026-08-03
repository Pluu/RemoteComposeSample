package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcScope
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rsp

context(ds: DensityScope)
fun RcScope.renderTextSample() {
    RcText("Normal Text")
    RcText("Bold Text", fontSize = 20.rsp, fontWeight = RcFontWeight.Bold)
    RcText("Large Text", fontSize = 32.rsp)
    RcText("Custom Color", color = 0xFFFF0000.toInt())
}
