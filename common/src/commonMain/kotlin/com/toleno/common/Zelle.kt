package com.toleno.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun Zelle(spieler: Spieler?, onClick: () -> Unit, enabled: Boolean) {
	val shape = RoundedCornerShape(8.dp)
	Button(
		modifier = Modifier
			.size(100.dp)
			.padding(8.dp)
			.border(2.dp, Color.DarkGray, shape),
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color(238, 238, 221),
			disabledBackgroundColor = Color(238, 238, 238)
		),
		contentPadding = PaddingValues(0.dp),

		enabled = enabled,
		onClick = onClick
	) {
		if (spieler != null) Text(
			spieler.buchstabe.toString(),
			style = TextStyle(fontSize = 40.sp, color = Color(148, 148, 61))
		)
	}
}