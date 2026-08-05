package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
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
    // CollapsibleColumn은 공간이 부족할 때 우선순위에 따라 항목을 숨깁니다.
    Column(
        Modifier
            .height(80.rdp)
            .background(0xFFE0E0E0.toInt())
            .fillMaxWidth()
    ) {
        RcText("(고정된 부모 높이: 80rdp)", fontSize = 12.rsp)
        CollapsibleColumn(Modifier.fillMaxWidth()) {
            RcText(
                "우선순위 1 (높음)",
                Modifier
                    .verticalCollapsiblePriority(1f)
                    .background(0xFFFFCCCC.toInt())
            )
            RcText(
                "우선순위 2",
                Modifier
                    .verticalCollapsiblePriority(2f)
                    .background(0xFFCCFFCC.toInt())
            )
            RcText(
                "우선순위 3",
                Modifier
                    .verticalCollapsiblePriority(3f)
                    .background(0xFFCCCCFF.toInt())
            )
            RcText(
                "우선순위 4 (낮음)",
                Modifier
                    .verticalCollapsiblePriority(4f)
                    .background(0xFFDDDDDD.toInt())
            )
        }
    }
}
