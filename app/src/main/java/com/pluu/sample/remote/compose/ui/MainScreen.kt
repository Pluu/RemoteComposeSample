package com.pluu.sample.remote.compose.ui

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import io.ktor.client.HttpClient

@Composable
fun MainScreen(client: HttpClient, modifier: Modifier = Modifier) {
    val navigationStack = remember { mutableStateListOf("/ui/menu") }
    val currentPath = navigationStack.last()
    val context = LocalContext.current

    val onBack: () -> Unit = {
        if (navigationStack.size > 1) {
            navigationStack.removeAt(navigationStack.size - 1)
        }
    }

    BackHandler(enabled = navigationStack.size > 1) {
        onBack()
    }

    RemoteComposeScreen(
        client = client,
        path = currentPath,
        onNavigate = { url -> navigationStack.add(url) },
        onBack = onBack,
        onOpenUrl = { url ->
            try {
                val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                context.startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(context, "Could not open URL", Toast.LENGTH_SHORT).show()
            }
        },
        onShowToast = { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        },
        modifier = modifier.fillMaxSize()
    )
}
