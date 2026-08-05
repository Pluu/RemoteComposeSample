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
fun RcScope.renderColumnSample() {
    RcText("Column", fontWeight = RcFontWeight.Bold)
    Column(
        Modifier
            .background(0xFFEEEEEE.toInt())
            .padding(8.rdp)
            .fillMaxWidth()
    ) {
        RcText("Item 1")
        RcText("Item 2")
        RcText("Item 3")
    }
}
