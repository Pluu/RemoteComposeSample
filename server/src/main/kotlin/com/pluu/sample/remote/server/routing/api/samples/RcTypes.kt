package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderRcTypesSample() {
    val f = remoteFloat(3.14159f)
    val c = remoteColor(0xFFFF0000.toInt())

    RcText("Remote Integer (Constant): 42")
    RcText("Remote Float: " + f.format(1, 4))
    Row(vertical = RcVerticalPositioning.Center) {
        RcText("Remote Color: ")
        Box(Modifier.size(24.rdp).background(c))
    }
}
