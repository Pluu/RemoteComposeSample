package com.pluu.sample.remote.compose.ui.json

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.pluu.sample.remote.common.RemoteUIResponse
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.compose.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JsonUiScreen(
    client: HttpClient,
    path: String,
    onBackClick: () -> Unit,
    onAction: (UIAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var uiResponse by remember { mutableStateOf<RemoteUIResponse?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val fetchData: (String) -> Unit = { query ->
        scope.launch {
            isLoading = true
            try {
                uiResponse = client.get("${NetworkConfig.BASE_URL}$path") {
                    if (query.isNotEmpty()) {
                        parameter("q", query)
                    }
                }.body()
            } catch (e: Exception) {
                // Error handled via isLoading and uiResponse being null for now, 
                // but we could add errorMessage state if needed.
            } finally {
                isLoading = false
            }
        }
    }

    LaunchedEffect(path) {
        fetchData("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (path == "/ui/schemes") {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search App Schemes") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { fetchData(searchQuery) }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        uiResponse?.let { response ->
            Text(text = response.title, style = MaterialTheme.typography.headlineSmall)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            Column(modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())) {
                RemoteUI(
                    component = response.root,
                    onAction = onAction
                )
            }
        }
    }
}
