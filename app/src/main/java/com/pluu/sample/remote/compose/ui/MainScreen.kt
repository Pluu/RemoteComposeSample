package com.pluu.sample.remote.compose.ui

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.pluu.sample.remote.common.NavigationType
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.compose.ui.binary.RemoteComposeScreen
import com.pluu.sample.remote.compose.ui.json.ItemsScreen
import com.pluu.sample.remote.compose.ui.json.JsonUiScreen
import io.ktor.client.HttpClient

@Composable
fun MainScreen(client: HttpClient, modifier: Modifier = Modifier) {
    val navigationStack = remember { mutableStateListOf(NavigationItem("/ui/menu", NavigationType.JSON)) }
    val currentNavigation = navigationStack.last()
    val context = LocalContext.current

    val onAction: (UIAction) -> Unit = { action ->
        when (action) {
            is UIAction.Navigate -> {
                navigationStack.add(NavigationItem(action.url, action.type))
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

    val onBack: () -> Unit = {
        if (navigationStack.size > 1) {
            navigationStack.removeAt(navigationStack.size - 1)
        }
    }

    BackHandler(enabled = navigationStack.size > 1) {
        onBack()
    }

    when (currentNavigation.type) {
        NavigationType.JSON -> {
            // Check if it's a menu or a specific JSON screen
            if (currentNavigation.url.contains("menu")) {
                MenuScreen(
                    client = client,
                    path = currentNavigation.url,
                    onAction = onAction,
                    modifier = modifier.padding(16.dp)
                )
            } else if (currentNavigation.url.contains("items")) {
                ItemsScreen(
                    client = client,
                    onAction = onAction,
                    modifier = modifier.padding(16.dp)
                )
            } else {
                JsonUiScreen(
                    client = client,
                    path = currentNavigation.url,
                    onBackClick = onBack,
                    onAction = onAction,
                    modifier = modifier.padding(16.dp)
                )
            }
        }
        NavigationType.BINARY -> {
            RemoteComposeScreen(
                client = client,
                modifier = modifier.fillMaxSize().padding(16.dp)
            )
        }
    }
}

data class NavigationItem(
    val url: String,
    val type: NavigationType
)
