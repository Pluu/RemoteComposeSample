package com.pluu.sample.remote.server.routing.api

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.fillMaxSize
import androidx.compose.remote.creation.dsl.padding
import androidx.compose.remote.creation.dsl.verticalScroll
import com.pluu.sample.remote.server.routing.api.samples.renderAnimationSample
import com.pluu.sample.remote.server.routing.api.samples.renderButtonSample
import com.pluu.sample.remote.server.routing.api.samples.renderCanvasSample
import com.pluu.sample.remote.server.routing.api.samples.renderCheckboxSample
import com.pluu.sample.remote.server.routing.api.samples.renderCollapsibleColumnSample
import com.pluu.sample.remote.server.routing.api.samples.renderColumnSample
import com.pluu.sample.remote.server.routing.api.samples.renderFitBoxSample
import com.pluu.sample.remote.server.routing.api.samples.renderFlowSample
import com.pluu.sample.remote.server.routing.api.samples.renderGesturesSample
import com.pluu.sample.remote.server.routing.api.samples.renderImageSample
import com.pluu.sample.remote.server.routing.api.samples.renderInteractivitySample
import com.pluu.sample.remote.server.routing.api.samples.renderModifierSample
import com.pluu.sample.remote.server.routing.api.samples.renderRcScopeSample
import com.pluu.sample.remote.server.routing.api.samples.renderRcTypesSample
import com.pluu.sample.remote.server.routing.api.samples.renderRowSample
import com.pluu.sample.remote.server.routing.api.samples.renderStateLayoutSample
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
            .verticalScroll()
            .padding(16.rdp),
    ) {
        when (name) {
            SampleNames.ANIMATION -> renderAnimationSample()
            SampleNames.BUTTON -> renderButtonSample()
            SampleNames.CANVAS -> renderCanvasSample()
            SampleNames.CHECKBOX -> renderCheckboxSample()
            SampleNames.COLUMN -> renderColumnSample()
            SampleNames.COLLAPSIBLE_COLUMN -> renderCollapsibleColumnSample()
            SampleNames.FITBOX -> renderFitBoxSample()
            SampleNames.FLOW -> renderFlowSample()
            SampleNames.GESTURES -> renderGesturesSample()
            SampleNames.IMAGE, SampleNames.ICON -> renderImageSample()
            SampleNames.MODIFIER -> renderModifierSample()
            SampleNames.RCINTERACTIVITY -> renderInteractivitySample()
            SampleNames.RCSCOPE -> renderRcScopeSample()
            SampleNames.RCTYPES -> renderRcTypesSample()
            SampleNames.ROW -> renderRowSample()
            SampleNames.STATELAYOUT -> renderStateLayoutSample()
            SampleNames.SWITCH -> renderSwitchSample()
            SampleNames.TEXT -> renderTextSample()
            else -> {
                RcText("[미구현] $name")
            }
        }
    }
}
