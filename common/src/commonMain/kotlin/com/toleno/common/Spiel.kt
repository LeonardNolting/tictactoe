package com.toleno.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Spiel() {
	var zellen: Zellen by remember { mutableStateOf(List(9) { null }) }
	var spielerAmZug: Spieler by remember { mutableStateOf(Spieler.X) }
	var gewinner: Spieler? by remember { mutableStateOf(null) }

	Feld(zellen, enabled = gewinner == null, onClick = { index ->
		zellen = zellen.toMutableList().apply { this[index] = spielerAmZug }
		spielerAmZug = spielerAmZug.gegenteil
		gewinner = kombinationen.testen(zellen)
	})

	Text("Am Zug: $spielerAmZug")
	Text("Gewinner: ${gewinner ?: "-"}")

	Button(onClick = {
		zellen = List(9) { null }
		spielerAmZug = Spieler.X
		gewinner = null
	}) {
		Text("Neustarten")
	}
}