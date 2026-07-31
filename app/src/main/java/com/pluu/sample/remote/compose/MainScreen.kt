package com.pluu.sample.remote.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.*

@Composable
fun MainScreen(client: HttpClient, modifier: Modifier = Modifier) {
    var showBinaryUi by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        if (showBinaryUi) {
            Text(text = "Remote Compose Binary UI", style = MaterialTheme.typography.headlineSmall)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            RemoteComposeScreen(client = client, modifier = Modifier.height(400.dp))
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { showBinaryUi = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back to Json UI")
            }
        } else {
            JsonUiScreen(
                client = client,
                onBinaryUiClick = { showBinaryUi = true }
            )
        }
    }
}
