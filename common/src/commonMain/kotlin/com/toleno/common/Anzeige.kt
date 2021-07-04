package com.toleno.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Anzeige(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
	Box(
		modifier.padding(12.dp)
	) {
		ProvideTextStyle(TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
			content()
		}
	}
}

@Composable
fun Anzeige(modifier: Modifier = Modifier, text: String) {
	Anzeige(modifier) {
		Text(text)
	}
}

@Composable
fun Anzeige(modifier: Modifier = Modifier, key: String, value: Any) {
	Anzeige(modifier) {
		Row(modifier.widthIn(min = 160.dp), horizontalArrangement = Arrangement.SpaceBetween) {
			Text("$key: ")
			Text(value.toString())
		}
	}
}