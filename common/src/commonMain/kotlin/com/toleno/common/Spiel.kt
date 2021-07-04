package com.toleno.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Spiel() {
	var zellen: Zellen by remember { mutableStateOf(List(9) { null }) }
	var spielerAmZug: Spieler by remember { mutableStateOf(Spieler.X) }
	var gewinner: Spieler? by remember { mutableStateOf(null) }

	Aufbau(
		header = {
			Column {
				Text("Tic Tac Toe")
				Text("Mit Kotlin + Compose für Android und Desktop", style = MaterialTheme.typography.body2)
			}
		},
		onReset = {
			zellen = List(9) { null }
			spielerAmZug = Spieler.X
			gewinner = null
		}
	) { padding ->
		Row(
			Modifier.padding(padding).fillMaxWidth().fillMaxHeight(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center
		) {
			Inhalt(Modifier, zellen, spielerAmZug, gewinner, onClick = { index ->
				zellen = zellen.toMutableList().apply { this[index] = spielerAmZug }
				spielerAmZug = spielerAmZug.gegenteil
				gewinner = kombinationen.testen(zellen)
			})
		}
	}
}