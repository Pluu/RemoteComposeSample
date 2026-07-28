package com.pluu.sample.remote.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pluu.sample.remote.common.RemoteUIComponent
import com.pluu.sample.remote.common.UIAction
import com.pluu.sample.remote.common.UIStyle

@Composable
fun RemoteUI(
    component: RemoteUIComponent,
    onAction: (UIAction) -> Unit
) {
    when (component) {
        is RemoteUIComponent.Text -> {
            Text(
                text = component.text,
                fontSize = component.style.fontSize.sp,
                modifier = Modifier.applyStyle(component.style),
                color = component.style.color?.let { Color(android.graphics.Color.parseColor(it)) } ?: Color.Unspecified
            )
        }
        is RemoteUIComponent.Button -> {
            Button(
                onClick = { onAction(component.action) },
                modifier = Modifier.applyStyle(component.style)
            ) {
                Text(text = component.text)
            }
        }
        is RemoteUIComponent.Column -> {
            Column(modifier = Modifier.applyStyle(component.style)) {
                component.children.forEach { child ->
                    RemoteUI(child, onAction)
                }
            }
        }
        is RemoteUIComponent.Row -> {
            Row(modifier = Modifier.applyStyle(component.style)) {
                component.children.forEach { child ->
                    RemoteUI(child, onAction)
                }
            }
        }
        is RemoteUIComponent.TextField -> {
            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(component.label) },
                modifier = Modifier.applyStyle(component.style)
            )
        }
    }
}

private fun Modifier.applyStyle(style: UIStyle): Modifier {
    return this.padding(style.padding.dp)
}
