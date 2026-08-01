package com.pluu.sample.remote.compose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.remote.player.compose.impl.RemoteComposePlayer
import androidx.compose.remote.player.core.RemoteDocument
import androidx.compose.remote.core.CoreDocument
import com.pluu.sample.remote.compose.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.readRawBytes
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import io.ktor.client.request.parameter

@SuppressLint("RestrictedApi")
@Composable
fun RemoteComposeScreen(
    client: HttpClient,
    path: String,
    onNavigate: (String) -> Unit,
    onBack: () -> Unit,
    onOpenUrl: (String) -> Unit,
    onShowToast: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var bytes by remember(path) { mutableStateOf<ByteArray?>(null) }
    var isLoading by remember(path) { mutableStateOf(true) }
    var errorMessage by remember(path) { mutableStateOf<String?>(null) }

    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    LaunchedEffect(path, configuration, density) {
        isLoading = true
        try {
            val response = client.get("${NetworkConfig.BASE_URL}$path") {
                parameter("width", configuration.screenWidthDp)
                parameter("height", configuration.screenHeightDp)
                parameter("density", density.density)
            }
            bytes = response.readRawBytes()
        } catch (e: Exception) {
            errorMessage = e.message
        } finally {
            isLoading = false
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (errorMessage != null) {
            Text(
                text = "Error: $errorMessage",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.align(Alignment.Center).padding(16.dp)
            )
        } else if (bytes != null) {
            val remoteDocument = remember(bytes) { RemoteDocument(bytes!!) }
            
            DisposableEffect(remoteDocument) {
                val listener = CoreDocument.IdActionCallback { _, metadata ->
                    metadata?.let {
                        handleAction(it, onNavigate, onBack, onOpenUrl, onShowToast)
                    }
                }
                remoteDocument.document.addIdActionListener(listener)
                onDispose {
                    remoteDocument.document.clearActionCallbacks()
                }
            }

            RemoteComposePlayer(
                document = remoteDocument,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

private fun handleAction(
    metadata: String,
    onNavigate: (String) -> Unit,
    onBack: () -> Unit,
    onOpenUrl: (String) -> Unit,
    onShowToast: (String) -> Unit
) {
    try {
        val json = Json.parseToJsonElement(metadata).jsonObject
        when (json["action"]?.jsonPrimitive?.content) {
            "navigate" -> {
                val url = json["url"]?.jsonPrimitive?.content
                if (url != null) onNavigate(url)
            }
            "back" -> onBack()
            "open" -> {
                val url = json["url"]?.jsonPrimitive?.content
                if (url != null) onOpenUrl(url)
            }
            "toast" -> {
                val message = json["message"]?.jsonPrimitive?.content
                if (message != null) onShowToast(message)
            }
        }
    } catch (e: Exception) {
        // Ignore parsing errors
    }
}
