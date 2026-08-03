package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderModifierSample() {
    Box(Modifier.size(100.rdp).background(0xFFFF0000.toInt()))
    Box(
        Modifier.padding(top = 10.rdp).size(100.rdp)
            .background(0xFF00FF00.toInt())
    )
    Box(
        Modifier
            .padding(top = 10.rdp)
            .fillMaxWidth()
            .height(50.rdp)
            .background(0xFF0000FF.toInt()),
    )
}
