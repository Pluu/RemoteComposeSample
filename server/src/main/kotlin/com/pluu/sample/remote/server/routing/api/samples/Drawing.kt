package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcPaintStyle
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderDrawingSample() {
    RcText("Canvas Drawing Example", fontWeight = RcFontWeight.Bold)
    Canvas(Modifier.size(200.rdp).background(0xFFF0F0F0.toInt())) {
        paint {
            color(0xFFFF0000.toInt())
        }
        drawRect(10.rdp, 10.rdp, 90.rdp, 90.rdp)

        paint {
            color(0xFF0000FF.toInt())
        }
        drawCircle(150.rdp, 150.rdp, 40.rdp)

        paint {
            color(0xFF00FF00.toInt())
            strokeWidth(5.rdp)
            style(RcPaintStyle.Stroke)
        }
        drawLine(10.rdp, 150.rdp, 100.rdp, 190.rdp)
    }
}
