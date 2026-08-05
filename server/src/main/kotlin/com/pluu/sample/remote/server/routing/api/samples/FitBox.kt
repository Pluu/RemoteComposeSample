package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderFitBoxSample() {
    // FitBox는 자식의 컨텐츠를 부모의 범위에 맞춰 스케일링합니다.
    FitBox(
        Modifier
            .background(0xFFCCEECC.toInt())
            .size(200.rdp, 100.rdp)
    ) {
        RcText("200x100 크기에 맞춰진 컨텐츠", Modifier.padding(8.rdp))
    }
}
