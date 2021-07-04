package com.toleno.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

typealias Zellen = List<Spieler?>

@Composable
internal fun Feld(zellen: Zellen, onClick: (zelle: Int) -> Unit, enabled: Boolean) {
	Column {
		repeat(3) { zeile ->
			Row(horizontalArrangement = Arrangement.Center) {
				repeat(3) { spalte ->
					val zelle = zeile * 3 + spalte
					Zelle(
						zellen[zelle],
						onClick = { onClick(zelle) },
						enabled && zellen[zelle] == null
					)
				}
			}
		}
	}
}