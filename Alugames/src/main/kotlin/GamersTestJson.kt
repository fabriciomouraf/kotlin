import br.com.alura.alugames.model.Time
import br.com.alura.alugames.service.SearchSharkApi
import java.time.LocalDate

fun main(){
    val gamer = SearchSharkApi().findGamers()[3]
    val game = SearchSharkApi().findGame()[0]

    val rent = gamer.rent(game, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    println("Rent: ${rent.gamer} in the game ${rent.game} and price: ${rent.price}")
}