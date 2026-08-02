package com.pluu.sample.remote.server.utils

import androidx.compose.remote.creation.dsl.RcSp
import androidx.compose.remote.creation.dsl.rsp

class DensityScope(
    val density: Float,
    val fontScale: Float,
)

context(ds: DensityScope)
val Int.dp: Float
    get() = this * ds.density

context(ds: DensityScope)
val Float.dp: Float
    get() = this * ds.density

context(ds: DensityScope)
val Int.sp: RcSp
    get() = (this * ds.density * ds.fontScale).rsp

context(ds: DensityScope)
val Float.sp: RcSp
    get() = (this * ds.density * ds.fontScale).rsp
