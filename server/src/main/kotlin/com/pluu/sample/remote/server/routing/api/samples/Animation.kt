package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.graphicsLayer
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderAnimationSample() {
    val time = animationTime()
    RcText("Animation using animationTime()")
    Box(
        Modifier
            .padding(top = 16.rdp)
            .size(100.rdp)
            .graphicsLayer {
                rotationZ(time * 45f) // Rotate 45 degrees per second
            }.background(0xFF6200EE.toInt()),
    )
}
