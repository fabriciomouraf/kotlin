package br.com.alura.alugames.model

class SubscriptionPlan(
    type: String,
    val monthlyPrice: Double,
    val quantityGames: Int): Plain(type){

    override fun value(rent: Rent): Double {
        return super.value(rent)
    }
}