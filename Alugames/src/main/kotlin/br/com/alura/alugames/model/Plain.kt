package br.com.alura.alugames.model

sealed class Plain(val type:String){
    open fun value(rent: Rent): Double{
       return rent.game.price * rent.time.inDays
    }
}