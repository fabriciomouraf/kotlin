package br.com.alura.alugames.model

class SubscriptionPlan(
    type: String,
    val monthlyPrice: Double,
    val quantityGames: Int): Plain(type){

    override fun value(rent: Rent): Double {
        val totalGamesOfMonth = rent.gamer.gamesOfTheMonth(rent.time.startDate.monthValue).size+1

        return if(totalGamesOfMonth <= quantityGames){
            0.0
        }else{
            super.value(rent)
        }
    }
}