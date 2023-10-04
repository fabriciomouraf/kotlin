package br.com.alura.alugames.model

open class Plain(val type:String){
    open fun value(rent: Rent): Double{
       return rent.game.price * rent.time.inDays
    }
}