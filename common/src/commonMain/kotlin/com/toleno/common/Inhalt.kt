package com.toleno.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Inhalt(modifier: Modifier = Modifier, zellen: Zellen, spielerAmZug: Spieler, gewinner: Spieler?, onClick: (index: Int) -> Unit) {
	// Box
	Row(modifier.border(2.dp, Color.DarkGray, RoundedCornerShape(16.dp)).padding(16.dp).height(IntrinsicSize.Min)) {
		// Spielfeld
		Column {
			Feld(zellen, enabled = gewinner == null, onClick = onClick)
		}

		// Anzeigen
		Column(Modifier.padding(start = 12.dp).padding(24.dp).fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
			Anzeige(key = "Am Zug: ", value = spielerAmZug.toString())
			Anzeige(key = "Gewinner: ", value = gewinner?.toString() ?: "-")
		}
	}
}

@Composable
fun Anzeige(modifier: Modifier = Modifier, key: String, value: String) {
	Row(modifier.padding(12.dp).widthIn(min = 120.dp), horizontalArrangement = Arrangement.SpaceBetween) {
		val style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
		Text(key, style = style)
		Text(value, style = style)
	}
}