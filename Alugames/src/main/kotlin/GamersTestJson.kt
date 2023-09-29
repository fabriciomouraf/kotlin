import br.com.alura.alugames.model.Time
import br.com.alura.alugames.service.SearchSharkApi
import java.time.LocalDate

fun main(){
    val gamer = SearchSharkApi().findGamers()[3]
    val game1 = SearchSharkApi().findGame()[0]
    val game2 = SearchSharkApi().findGame()[4]
    val game3 = SearchSharkApi().findGame()[9]

    gamer.toHire(game1, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    gamer.toHire(game2, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    gamer.toHire(game3, Time(LocalDate.now(), LocalDate.now().plusDays(7)))

    println(gamer.rentedGames)
}