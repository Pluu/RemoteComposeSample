package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.background
import androidx.compose.remote.creation.dsl.fillMaxWidth
import androidx.compose.remote.creation.dsl.height
import androidx.compose.remote.creation.dsl.verticalCollapsiblePriority
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp
import com.pluu.sample.remote.server.utils.rsp

context(ds: DensityScope)
fun RcScope.renderCollapsibleColumnSample() {
    RcText("CollapsibleColumn", fontWeight = RcFontWeight.Bold)
    // CollapsibleColumn hides items based on priority when space is limited
    Column(
        Modifier
            .height(80.rdp)
            .background(0xFFE0E0E0.toInt())
            .fillMaxWidth()
    ) {
        RcText("(Fixed Parent Height: 80rdp)", fontSize = 12.rsp)
        CollapsibleColumn(Modifier.fillMaxWidth()) {
            RcText(
                "Priority 1 (High)",
                Modifier
                    .verticalCollapsiblePriority(1f)
                    .background(0xFFFFCCCC.toInt())
            )
            RcText(
                "Priority 2",
                Modifier
                    .verticalCollapsiblePriority(2f)
                    .background(0xFFCCFFCC.toInt())
            )
            RcText(
                "Priority 3",
                Modifier
                    .verticalCollapsiblePriority(3f)
                    .background(0xFFCCCCFF.toInt())
            )
            RcText(
                "Priority 4 (Low)",
                Modifier
                    .verticalCollapsiblePriority(4f)
                    .background(0xFFDDDDDD.toInt())
            )
        }
    }
}
