package com.pluu.sample.remote.server.routing.api.samples

import androidx.compose.remote.creation.dsl.Modifier
import androidx.compose.remote.creation.dsl.RcScope
import androidx.compose.remote.creation.dsl.size
import com.pluu.sample.remote.server.utils.DensityScope
import com.pluu.sample.remote.server.utils.RcText
import com.pluu.sample.remote.server.utils.rdp

context(ds: DensityScope)
fun RcScope.renderImageSample() {
    RcText("Image from URL")
    Image(
        image =
            remoteBitmapUrl(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/500px-Google_%22G%22_logo.svg.png",
            ),
        modifier = Modifier.size(200.rdp),
    )
}
