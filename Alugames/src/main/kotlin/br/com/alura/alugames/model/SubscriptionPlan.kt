package br.com.alura.alugames.model

import jdk.jfr.Percentage

class SubscriptionPlan(
    type: String,
    val monthlyPrice: Double,
    val quantityGames: Int,
    val discountPercentage: Double): Plain(type){

    override fun value(rent: Rent): Double {
        val totalGamesOfMonth = rent.gamer.rentedGamesInTheMonth(rent.time.startDate.monthValue).size+1

        return if(totalGamesOfMonth <= quantityGames){
            0.0
        }else{
            var originalPrice = super.value(rent)
            if(rent.gamer.average > 8){
                originalPrice -= super.value(rent) * discountPercentage
            }
            originalPrice
        }
    }
}