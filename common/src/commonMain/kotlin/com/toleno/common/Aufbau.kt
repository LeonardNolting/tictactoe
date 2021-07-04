package com.toleno.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Aufbau(modifier: Modifier = Modifier, header: @Composable () -> Unit, onReset: () -> Unit, content: @Composable (PaddingValues) -> Unit) {
	Scaffold(modifier, topBar = {
		TopAppBar(title = header)
	}, floatingActionButton = {
		ExtendedFloatingActionButton(onClick = onReset, text = {
			Text("Neustarten")
		}, icon = {
			Icon(Icons.Default.Refresh, contentDescription = null)
		})
	}, content = content)
}