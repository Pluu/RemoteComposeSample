package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderFitBoxSample() {
    RcText("FitBox", fontWeight = RcFontWeight.Bold)
    // FitBox scales its content to fit its bounds
    FitBox(
        Modifier
            .background(0xFFCCEECC.toInt())
            .size(200.rdp, 100.rdp)
    ) {
        RcText("Scaled to Fit content in 200x100", Modifier.padding(8.rdp))
    }
}
