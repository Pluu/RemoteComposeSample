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
fun RcScope.renderAnimationSample() {
    Column(Modifier.padding(8.rdp)) {
        RcText("애니메이션 샘플")
        RcText("동적 속성을 위해 animationTime()을 사용합니다")

        // animationTime()은 애니메이션 시작 후 경과된 시간(초)을 반환합니다.
        val time = animationTime()
        val angle = time * remoteFloat(60f) // 초당 60도
        
        RcText("회전하는 박스 (Canvas 시뮬레이션)", Modifier.padding(top = 16.rdp))
        Canvas(Modifier.size(100.rdp).background(0xFFEEEEEE.toInt())) {
            rotate(angle, 50.rdp.rf, 50.rdp.rf)
            drawRect(25.rdp, 25.rdp, 75.rdp, 75.rdp)
        }
    }
}
