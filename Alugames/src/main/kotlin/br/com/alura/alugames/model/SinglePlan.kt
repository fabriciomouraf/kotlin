package br.com.alura.alugames.model

class SinglePlan(type:String): Plain(type) {

    override fun value(rent: Rent): Double {
        var originalPrice: Double = super.value(rent)
        if(rent.gamer.average > 8){
            originalPrice -= super.value(rent) * 0.1
        }
        return originalPrice
    }
}