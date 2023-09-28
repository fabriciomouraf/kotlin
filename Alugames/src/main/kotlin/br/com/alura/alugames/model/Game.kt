package br.com.alura.alugames.model

data class Game(val title:String, val cape:String, val price:Double) {
    var description:String? = null

    override fun toString(): String {
        return "Game(title='$title', cape='$cape', description='$description', price='$price')"
    }
}