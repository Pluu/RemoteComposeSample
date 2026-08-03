package com.pluu.sample.remote.server.utils

import androidx.compose.remote.creation.RemoteComposeWriter.HTag
import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcFontWeight
import androidx.compose.remote.creation.dsl.RcProfile
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.RcSp
import androidx.compose.remote.creation.dsl.RcTextAlign
import androidx.compose.remote.creation.dsl.RcTextOverflow
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

context(ds: DensityScope)
fun RcScope.RcText(
    text: String,
    modifier: Modifier = Modifier,
    color: Any = 0xFF000000.toInt(),
    fontSize: RcSp = 16.rsp,
    fontWeight: Float = RcFontWeight.Normal,
    textAlign: RcTextAlign = RcTextAlign.Start,
    overflow: RcTextOverflow = RcTextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    content: RcScope.() -> Unit = {}
) = Text(
    text = text,
    modifier = modifier,
    color = color,
    fontSize = fontSize,
    fontWeight = fontWeight,
    textAlign = textAlign,
    overflow = overflow,
    maxLines = maxLines,
    content = content
)
