package com.pluu.sample.remote.server.utils

import androidx.compose.remote.creation.dsl.RcFloat
import androidx.compose.remote.creation.dsl.RcSp
import androidx.compose.remote.creation.dsl.rsp

class DensityScope(
    val density: Float,
    val fontScale: Float,
)

context(scope: DensityScope)
val Int.dp: Float
    get() = this * scope.density

context(scope: DensityScope)
val Float.dp: Float
    get() = this * scope.density

context(scope: DensityScope)
val Int.sp: RcSp
    get() = (this * scope.density).rsp

context(scope: DensityScope)
val Float.sp: RcSp
    get() = (this * scope.density).rsp
