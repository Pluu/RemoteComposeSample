package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.onClick
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderToggleSample() {
    Row(vertical = RcVerticalPositioning.Center) {
        Box(
            modifier =
                Modifier
                    .size(24.rdp)
                    .background(0xFFCCCCCC.toInt())
                    .onClick {
                        hostAction("{\"action\":\"toast\",\"message\":\"Toggled!\"}")
                    },
        )
        RcText("  Toggle Component Sample", Modifier.padding(start = 8.rdp))
    }
}
