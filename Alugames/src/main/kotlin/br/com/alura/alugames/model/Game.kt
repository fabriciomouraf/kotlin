package br.com.alura.alugames.model

data class Game(val title:String, val cape:String, val price:Double): Recommend {
    var description:String? = null
    private val grades: MutableList<Int> = mutableListOf()

    override val average: Double
        get() = grades.average();

    override fun toString(): String {
        return "Game(title='$title', cape='$cape', description='$description', price='$price')"
    }

    override fun recommend(grade: Int) {
        grades.add(grade);
    }
}