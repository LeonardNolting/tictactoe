package com.toleno.common

enum class Spieler(val buchstabe: Char) {
	X('X'),
	O('O');

	val gegenteil get() = if (this == X) O else X
}