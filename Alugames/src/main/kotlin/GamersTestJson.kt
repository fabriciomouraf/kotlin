import br.com.alura.alugames.service.SearchSharkApi

fun main(){
    val gamer = SearchSharkApi().findGamers()[3]
    val game = SearchSharkApi().findGame()[0]

    val rent = gamer.rent(game)
    println("Rent: ${rent.gamer} in the game ${rent.game}")
}