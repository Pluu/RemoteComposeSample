package com.pluu.sample.remote.server.utils

import androidx.compose.remote.creation.dsl.RcSp
import androidx.compose.remote.creation.dsl.rsp

class DensityScope(
    val density: Float,
    val fontScale: Float,
)

fun Int.dp(ds: DensityScope): Float = this * ds.density

fun Float.dp(ds: DensityScope): Float = this * ds.density

fun Int.sp(ds: DensityScope): RcSp = (this * ds.density * ds.fontScale).rsp

fun Float.sp(ds: DensityScope): RcSp = (this * ds.density * ds.fontScale).rsp
