package com.pluu.sample.remote.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onMenuClick: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val menus = listOf(
        MenuItem("JSON UI Sample", Screen.Json, "Test Schemes and Custom JSON UI"),
        MenuItem("Server Items List", Screen.Items, "Scrollable list from server"),
        MenuItem("Remote Compose (Binary)", Screen.Binary, "Native rendering from server binary")
    )

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(menus) { item ->
            MenuRow(item = item, onClick = { onMenuClick(item.screen) })
            HorizontalDivider()
        }
    }
}

@Composable
private fun MenuRow(item: MenuItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(text = item.title, style = MaterialTheme.typography.titleMedium)
        Text(text = item.description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

private data class MenuItem(
    val title: String,
    val screen: Screen,
    val description: String
)
