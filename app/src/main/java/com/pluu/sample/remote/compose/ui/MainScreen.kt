package com.pluu.sample.remote.compose.ui

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
import com.pluu.sample.remote.compose.ui.binary.RemoteComposeScreen
import com.pluu.sample.remote.compose.ui.json.ItemsScreen
import com.pluu.sample.remote.compose.ui.json.JsonUiScreen
import io.ktor.client.HttpClient

@Composable
fun MainScreen(client: HttpClient, modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf(Screen.Menu) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (currentScreen) {
            Screen.Menu -> {
                MenuScreen(onMenuClick = { currentScreen = it })
            }
            Screen.Binary -> {
                Text(text = "Remote Compose Binary UI", style = MaterialTheme.typography.headlineSmall)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                RemoteComposeScreen(client = client, modifier = Modifier.height(400.dp))
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { currentScreen = Screen.Menu },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back to Menu")
                }
            }
            Screen.Items -> {
                Text(text = "Server Items List", style = MaterialTheme.typography.headlineSmall)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                
                Box(modifier = Modifier.height(400.dp)) {
                    ItemsScreen(client = client)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { currentScreen = Screen.Menu },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back to Menu")
                }
            }
            Screen.Json -> {
                Box(modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())) {
                    JsonUiScreen(
                        client = client,
                        onBackClick = { currentScreen = Screen.Menu }
                    )
                }
            }
        }
    }
}

enum class Screen {
    Menu, Json, Binary, Items
}
