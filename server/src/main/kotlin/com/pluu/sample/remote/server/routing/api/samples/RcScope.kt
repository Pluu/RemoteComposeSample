package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcHorizontalPositioning
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcVerticalPositioning
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp
import com.pluu.sample.remote.server.utils.rsp

context(ds: DensityScope)
fun RcScope.renderRcScopeSample() {
    Global {
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.rdp)
                .background(0xFFEEEEEE.toInt()),
            vertical = RcVerticalPositioning.Center,
            horizontal = RcHorizontalPositioning.Center,
        ) {
            RcText("Inside Global and Box nesting", fontSize = 18.rsp)
        }
    }
}
