package br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val startDate: LocalDate,
    val endDate: LocalDate){
    val price = game.price * Period.between(startDate, endDate).days
}
