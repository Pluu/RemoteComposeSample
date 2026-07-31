package com.pluu.sample.remote.compose

import androidx.compose.foundation.layout.Box
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
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Json) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        when (currentScreen) {
            Screen.Binary -> {
                Text(text = "Remote Compose Binary UI", style = MaterialTheme.typography.headlineSmall)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                RemoteComposeScreen(client = client, modifier = Modifier.height(400.dp))
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { currentScreen = Screen.Json },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back to Json UI")
                }
            }
            Screen.Items -> {
                Text(text = "Server Items List", style = MaterialTheme.typography.headlineSmall)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                
                // Screen separation: ItemsScreen handles its own scrolling
                Box(modifier = Modifier.height(400.dp)) {
                    ItemsScreen(client = client)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { currentScreen = Screen.Json },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back to Json UI")
                }
            }
            Screen.Json -> {
                JsonUiScreen(
                    client = client,
                    onBinaryUiClick = { currentScreen = Screen.Binary },
                    onItemsUiClick = { currentScreen = Screen.Items }
                )
            }
        }
    }
}

enum class Screen {
    Json, Binary, Items
}
