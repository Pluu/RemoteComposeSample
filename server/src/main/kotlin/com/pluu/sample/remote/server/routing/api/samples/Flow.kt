package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.RcScope
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText

context(ds: DensityScope)
fun RcScope.renderFlowSample() {
//    Flow(
//        Modifier
//            .background(0xFFCCCCFF.toInt())
//            .padding(8.rdp)
//            .fillMaxWidth(),
//        maxItemsInEachRow = 3
//    ) {
//        repeat(7) { i ->
//            RcText("항목 $i", Modifier.padding(4.rdp).background(0xFFFFFFFF.toInt()))
//        }
//    }
    RcText("[현재 에러] Flow")
}
