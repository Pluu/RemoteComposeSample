package com.pluu.sample.remote.compose

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JsonUiScreen(
    client: HttpClient,
    onBinaryUiClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var uiResponse by remember { mutableStateOf<RemoteUIResponse?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        // App Scheme Search
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search App Schemes") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = {
                    scope.launch {
                        isLoading = true
                        try {
                            uiResponse = client.get("${NetworkConfig.BASE_URL}/ui/schemes") {
                                parameter("q", searchQuery)
                            }.body()
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                        } finally {
                            isLoading = false
                        }
                    }
                }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    scope.launch {
                        isLoading = true
                        try {
                            uiResponse = client.get("${NetworkConfig.BASE_URL}/ui/schemes").body()
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                        } finally {
                            isLoading = false
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Get Schemes")
            }

            Button(
                onClick = {
                    scope.launch {
                        isLoading = true
                        try {
                            uiResponse = client.get("${NetworkConfig.BASE_URL}/ui/custom").body()
                        } catch (e: Exception) {
                            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                        } finally {
                            isLoading = false
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Get Custom UI")
            }
        }

        Button(
            onClick = onBinaryUiClick,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Get Remote Compose UI (Binary)")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally))
        }

        uiResponse?.let { response ->
            Text(text = response.title, style = MaterialTheme.typography.headlineSmall)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            RemoteUI(
                component = response.root,
                onAction = { action ->
                    when (action) {
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
            )
        }
    }
}
