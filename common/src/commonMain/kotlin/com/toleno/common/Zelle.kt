package com.toleno.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun Zelle(spieler: Spieler?, onClick: () -> Unit, enabled: Boolean) {
	Button(modifier = Modifier.size(100.dp),enabled = enabled, onClick = onClick) {
		Text((spieler?.buchstabe ?: '?').toString())
	}
}