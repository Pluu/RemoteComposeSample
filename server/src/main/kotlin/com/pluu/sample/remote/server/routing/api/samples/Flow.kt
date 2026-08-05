package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderFlowSample() {
    RcText("Flow", fontWeight = RcFontWeight.Bold)
    Flow(
        Modifier
            .background(0xFFCCCCFF.toInt())
            .padding(8.rdp)
            .fillMaxWidth(),
        maxItemsInEachRow = 3
    ) {
        repeat(7) { i ->
            RcText("Item $i", Modifier.padding(4.rdp).background(0xFFFFFFFF.toInt()))
        }
    }
}
