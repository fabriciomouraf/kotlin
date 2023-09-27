package br.com.alura.alugames.model

data class Game(val title:String, val cape:String) {
    var description:String? = null

    override fun toString(): String {
        return "Game(title='$title', cape='$cape', description='$description')"
    }
}