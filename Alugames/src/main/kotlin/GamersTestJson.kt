import br.com.alura.alugames.service.SearchSharkApi

fun main(){
    val listGamers = SearchSharkApi().findGamers()
    val game = SearchSharkApi().findGame("146")

    println(game)
    listGamers.forEach {
        println(it)
    }
}