package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.routing.api.samples.renderAnimationSample
import com.pluu.sample.remote.server.routing.api.samples.renderButtonSample
import com.pluu.sample.remote.server.routing.api.samples.renderDrawingSample
import com.pluu.sample.remote.server.routing.api.samples.renderImageSample
import com.pluu.sample.remote.server.routing.api.samples.renderInteractivitySample
import com.pluu.sample.remote.server.routing.api.samples.renderLayoutSample
import com.pluu.sample.remote.server.routing.api.samples.renderModifierSample
import com.pluu.sample.remote.server.routing.api.samples.renderRcScopeSample
import com.pluu.sample.remote.server.routing.api.samples.renderRcTypesSample
import com.pluu.sample.remote.server.routing.api.samples.renderTextSample
import com.pluu.sample.remote.server.routing.api.samples.renderToggleSample
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderSampleContent(name: String) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.rdp),
    ) {
        when (name) {
            "Text" -> renderTextSample()
            "Button" -> renderButtonSample()
            "Modifier" -> renderModifierSample()
            "Layout" -> renderLayoutSample()
            "Icon", "Image" -> renderImageSample()
            "Checkbox", "Switch" -> renderToggleSample()
            "RcScope" -> renderRcScopeSample()
            "RcTypes" -> renderRcTypesSample()
            "DrawScope", "RcDrawing" -> renderDrawingSample()
            "RcInteractivity", "Gestures" -> renderInteractivitySample()
            "Animation" -> renderAnimationSample()
            else -> {
                RcText("Detail implementation for $name coming soon...")
            }
        }
    }
}
