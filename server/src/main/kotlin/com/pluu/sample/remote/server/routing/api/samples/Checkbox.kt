package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderCheckboxSample() {
    Column(Modifier.padding(8.rdp)) {
        RcText("Checkbox Sample (Simulated)")
        Row(vertical = RcVerticalPositioning.Center, modifier = Modifier.padding(top = 8.rdp)) {
            Box(
                Modifier.size(24.rdp).background(0xFF000000.toInt()).padding(2.rdp)
            ) {
                Box(Modifier.size(20.rdp).background(0xFF00FF00.toInt()))
            }
            RcText("Checked", Modifier.padding(start = 8.rdp))
        }
    }
}
