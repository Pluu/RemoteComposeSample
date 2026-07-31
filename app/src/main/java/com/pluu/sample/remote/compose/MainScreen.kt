package com.pluu.sample.remote.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient

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
