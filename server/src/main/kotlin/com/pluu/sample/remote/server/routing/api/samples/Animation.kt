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
        RcText("Animation Sample")
        RcText("Uses animationTime() for dynamic properties")

        // animationTime() returns seconds since the start of the animation.
        val time = animationTime()
        val angle = time * remoteFloat(60f) // 60 degrees per second
        
        RcText("Rotating Box (Simulated via Canvas)", Modifier.padding(top = 16.rdp))
        Canvas(Modifier.size(100.rdp).background(0xFFEEEEEE.toInt())) {
            rotate(angle, 50.rdp.rf, 50.rdp.rf)
            drawRect(25.rdp, 25.rdp, 75.rdp, 75.rdp)
        }
    }
}
