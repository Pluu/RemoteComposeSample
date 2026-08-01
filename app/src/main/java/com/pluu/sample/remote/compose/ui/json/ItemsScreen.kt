package com.pluu.sample.remote.compose.ui.json

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.compose.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

@Composable
fun ItemsScreen(
    client: HttpClient,
    onAction: (UIAction) -> Unit,
    modifier: Modifier = Modifier
) {
    var uiResponse by remember { mutableStateOf<RemoteUIResponse?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            uiResponse = client.get("${NetworkConfig.BASE_URL}/ui/items").body()
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
        } else {
            uiResponse?.let { response ->
                Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    RemoteUI(
                        component = response.root,
                        onAction = onAction
                    )
                }
            }
        }
    }
}
