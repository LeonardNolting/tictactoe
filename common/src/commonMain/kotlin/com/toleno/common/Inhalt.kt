package com.toleno.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Inhalt(
	modifier: Modifier = Modifier,
	zellen: Zellen,
	spielerAmZug: Spieler,
	ergebnisse: List<Spieler?>,
	onClick: (index: Int) -> Unit
) {
	val ergebnis = ergebnisse.last()
	// Box
	Row(
		modifier
			.border(2.dp, Color.DarkGray, RoundedCornerShape(16.dp))
			.padding(16.dp)
			.height(IntrinsicSize.Min)
	) {
		// Spielfeld
		Column {
			Feld(zellen, enabled = ergebnis == null, onClick = onClick)
		}

		// Anzeigen
		Column(
			Modifier.padding(start = 12.dp).padding(24.dp).fillMaxHeight(),
			verticalArrangement = Arrangement.SpaceBetween
		) {
			Anzeige(text = "Runde ${ergebnisse.size}")
			Anzeige(key = "Am Zug", value = spielerAmZug)
			Anzeige(key = "Gewinner", value = ergebnis ?: "-")
			Anzeige(key = "Gewinne X", value = ergebnisse.count { it == Spieler.X })
			Anzeige(key = "Gewinne O", value = ergebnisse.count { it == Spieler.O })
		}
	}
}