package br.com.alura.alugames.model

data class Plain(val type:String){
    fun value(rent: Rent): Double{
       return rent.game.price * rent.time.inDays
    }
}