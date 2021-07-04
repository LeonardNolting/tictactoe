package com.toleno.common

/**
 * 3 Zellen, die zum Sieg des Spielers führen, der alle setzt
 */
typealias Kombination = Triple<Int, Int, Int>

infix fun Int.und(other: Int) = Pair(this, other)
infix fun Pair<Int, Int>.und(third: Int) = Triple(first, second, third)

val kombinationen: List<Kombination> = listOf(
	0 und 1 und 2, // Zeile 1
	3 und 4 und 5, // Zeile 2
	6 und 7 und 8, // Zeile 3

	0 und 3 und 6, // Spalte 1
	1 und 4 und 7, // Spalte 2
	2 und 5 und 8, // Spalte 3

	0 und 4 und 8, // Diagonale 1
	2 und 4 und 6, // Diagonale 2
)

/**
 * @return Spieler, der alle Zellen dieser Kombination gesetzt hat, oder null
 */
fun Kombination.testen(zellen: Zellen) =
	if (zellen[first] == zellen[second] && zellen[first] == zellen[third]) zellen[first]
	else null

/**
 * @return Spieler, der alle Zellen einer dieser Kombinationen gesetzt hat, oder null
 */
fun List<Kombination>.testen(zellen: Zellen) =
	mapNotNull { kombination -> kombination.testen(zellen) }.firstOrNull()