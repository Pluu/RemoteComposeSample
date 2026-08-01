package com.pluu.sample.remote.compose.ui

import android.content.Intent
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.compose.ui.binary.RemoteComposeScreen
import com.pluu.sample.remote.compose.ui.json.ItemsScreen
import com.pluu.sample.remote.compose.ui.json.JsonUiScreen
import io.ktor.client.HttpClient

@Composable
fun MainScreen(client: HttpClient, modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf(Screen.Menu) }
    val context = LocalContext.current

    val onAction: (UIAction) -> Unit = { action ->
        when (action) {
            is UIAction.Navigate -> {
                currentScreen = Screen.entries.find { it.name == action.screen } ?: Screen.Menu
            }
            is UIAction.OpenScheme -> {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, action.url.toUri())
                    context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(context, "Could not open scheme", Toast.LENGTH_SHORT).show()
                }
            }
            is UIAction.ShowToast -> {
                Toast.makeText(context, action.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (currentScreen) {
            Screen.Menu -> {
                MenuScreen(
                    client = client,
                    path = "/ui/menu",
                    onAction = onAction
                )
            }
            Screen.JSON_MENU -> {
                Text(text = "JSON UI Samples", style = MaterialTheme.typography.headlineSmall)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                MenuScreen(
                    client = client,
                    path = "/ui/json-menu",
                    onAction = onAction
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { currentScreen = Screen.Menu },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back to Main Menu")
                }
            }
            Screen.SCHEMES -> {
                JsonUiScreen(
                    client = client,
                    path = "/ui/schemes",
                    onBackClick = { currentScreen = Screen.JSON_MENU }
                )
            }
            Screen.CUSTOM -> {
                JsonUiScreen(
                    client = client,
                    path = "/ui/custom",
                    onBackClick = { currentScreen = Screen.JSON_MENU }
                )
            }
            Screen.BINARY -> {
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
            Screen.ITEMS -> {
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
        }
    }
}

enum class Screen {
    Menu, JSON_MENU, SCHEMES, CUSTOM, BINARY, ITEMS
}
