package com.toleno.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun App() {
	MaterialTheme {
		Column {
			Text("Tic Tac Toe", style = MaterialTheme.typography.h1)
			Spiel()
		}
	}
}