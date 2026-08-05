package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
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
    RcText("StateLayout", fontWeight = RcFontWeight.Bold)
    // StateLayout shows content based on stateIndex
    val state = remoteInteger(0)
    Column(Modifier.fillMaxWidth().background(0xFFF0F0F0.toInt()).padding(8.rdp)) {
        Row(Modifier.fillMaxWidth()) {
            RcText(
                "[Show 0]",
                Modifier
                    .padding(4.rdp)
                    .background(0xFFCCCCCC.toInt())
                    .onClick { setValue(state, 0) }
            )
            RcText(
                "[Show 1]",
                Modifier
                    .padding(4.rdp)
                    .background(0xFFCCCCCC.toInt())
                    .onClick { setValue(state, 1) }
            )
        }
        StateLayout(state, Modifier.background(0xFFFFEECC.toInt()).fillMaxWidth().padding(8.rdp)) {
            // Index 0
            RcText("Content for State 0")
            // Index 1
            RcText("Content for State 1")
        }
    }
}
