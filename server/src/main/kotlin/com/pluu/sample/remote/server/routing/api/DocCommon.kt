package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.padding
import com.pluu.sample.remote.server.routing.api.samples.renderAnimationSample
import com.pluu.sample.remote.server.routing.api.samples.renderButtonSample
import com.pluu.sample.remote.server.routing.api.samples.renderCanvasSample
import com.pluu.sample.remote.server.routing.api.samples.renderCheckboxSample
import com.pluu.sample.remote.server.routing.api.samples.renderGesturesSample
import com.pluu.sample.remote.server.routing.api.samples.renderImageSample
import com.pluu.sample.remote.server.routing.api.samples.renderInteractivitySample
import com.pluu.sample.remote.server.routing.api.samples.renderLayoutSample
import com.pluu.sample.remote.server.routing.api.samples.renderModifierSample
import com.pluu.sample.remote.server.routing.api.samples.renderRcScopeSample
import com.pluu.sample.remote.server.routing.api.samples.renderRcTypesSample
import com.pluu.sample.remote.server.routing.api.samples.renderSwitchSample
import com.pluu.sample.remote.server.routing.api.samples.renderTextSample
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
            SampleNames.TEXT -> renderTextSample()
            SampleNames.BUTTON -> renderButtonSample()
            SampleNames.MODIFIER -> renderModifierSample()
            SampleNames.LAYOUT -> renderLayoutSample()
            SampleNames.RCTYPES -> renderRcTypesSample()
            SampleNames.CANVAS -> renderCanvasSample()
            SampleNames.IMAGE, SampleNames.ICON -> renderImageSample()
            SampleNames.CHECKBOX -> renderCheckboxSample()
            SampleNames.SWITCH -> renderSwitchSample()
            SampleNames.RCINTERACTIVITY -> renderInteractivitySample()
            SampleNames.GESTURES -> renderGesturesSample()
            SampleNames.ANIMATION -> renderAnimationSample()
            SampleNames.RCSCOPE -> renderRcScopeSample()
            else -> {
                RcText("[미구현] $name")
            }
        }
    }
}
