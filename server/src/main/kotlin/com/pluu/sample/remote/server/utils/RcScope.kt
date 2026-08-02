package com.pluu.sample.remote.server.utils

import androidx.compose.remote.creation.RemoteComposeWriter.HTag
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.createRcBuffer

fun createRcBuffer(
    profile: RcProfile,
    vararg tags: HTag,
    densityScope: DensityScope,
    content: context(DensityScope) RcScope.() -> Unit,
): ByteArray =
    createRcBuffer(profile, *tags) {
        context(densityScope) {
            content()
        }
    }
