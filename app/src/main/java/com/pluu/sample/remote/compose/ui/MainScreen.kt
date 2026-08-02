package com.pluu.sample.remote.compose.ui

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.pluu.sample.remote.common.ApiResponse
import com.pluu.sample.remote.compose.NetworkConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun MainScreen(
    client: HttpClient,
    modifier: Modifier = Modifier,
) {
    val navigationStack = remember { mutableStateListOf("/ui/menu") }
    val currentPath = navigationStack.last()
    val context = LocalContext.current

    var apiResponse by remember { mutableStateOf<ApiResponse?>(null) }
    var currentGroupId by remember { mutableIntStateOf(0) }
    var currentTitle by remember { mutableStateOf("Remote Compose Sample") }

    LaunchedEffect(Unit) {
        try {
            val response = client.get("${NetworkConfig.BASE_URL}/api/list")
            apiResponse = response.body()
        } catch (e: Exception) {
            android.util.Log.e("MainScreen", "Failed to fetch API list", e)
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

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(currentTitle) },
                navigationIcon = {
                    if (navigationStack.size > 1) {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                            )
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            // groupId가 1인 경우 (API Sample 그룹) Native Tab 표시
            val apiItems = apiResponse?.api?.sample ?: emptyList()
            val isApiSection = currentGroupId == 1

            if (isApiSection && apiItems.isNotEmpty()) {
                val selectedIndex = apiItems.indexOfFirst { it.path == currentPath }.coerceAtLeast(0)

                ScrollableTabRow(
                    selectedTabIndex = selectedIndex,
                    modifier = Modifier.fillMaxWidth(),
                    edgePadding = 16.dp,
                ) {
                    apiItems.forEachIndexed { index, item ->
                        Tab(
                            selected = selectedIndex == index,
                            onClick = {
                                if (currentPath != item.path) {
                                    if (currentGroupId == 1) {
                                        navigationStack[navigationStack.size - 1] = item.path
                                    } else {
                                        navigationStack.add(item.path)
                                    }
                                }
                            },
                            text = { Text(item.name) },
                        )
                    }
                }
            }

            RemoteComposeScreen(
                client = client,
                path = if (currentPath == "/ui/api_list" && apiItems.isNotEmpty()) apiItems.first().path else currentPath,
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
                onGroupIdReceived = { groupId ->
                    currentGroupId = groupId
                },
                onTitleReceived = { title ->
                    if (title.isNotEmpty()) {
                        currentTitle = title
                    }
                },
                modifier = Modifier.weight(1f),
            )
        }
    }
}
