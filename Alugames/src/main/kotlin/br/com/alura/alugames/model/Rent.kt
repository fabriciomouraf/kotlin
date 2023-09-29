package br.com.alura.alugames.model

import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val time: Time){
    val price = game.price * time.inDays

    override fun toString(): String {
        return "Rent(gamer=$gamer, game=$game, time=$time, price=$price)"
    }
}