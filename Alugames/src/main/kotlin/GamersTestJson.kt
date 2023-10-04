import br.com.alura.alugames.model.SubscriptionPlan
import br.com.alura.alugames.model.Time
import br.com.alura.alugames.service.SearchSharkApi
import java.time.LocalDate

fun main(){
    val gamer1 = SearchSharkApi().findGamers()[3]
    val game1 = SearchSharkApi().findGame()[0]
    val game2 = SearchSharkApi().findGame()[4]
    val game3 = SearchSharkApi().findGame()[9]

    gamer1.toHire(game1, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    gamer1.toHire(game2, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    gamer1.toHire(game3, Time(LocalDate.now(), LocalDate.now().plusDays(7)))

    println(gamer1.rentedGames)

    val gamer2 = SearchSharkApi().findGamers()[5]
    gamer2.plain = SubscriptionPlan("Silver", 9.90, 3)

    gamer2.toHire(game1, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    gamer2.toHire(game2, Time(LocalDate.now(), LocalDate.now().plusDays(7)))
    gamer2.toHire(game3, Time(LocalDate.now(), LocalDate.now().plusDays(7)))

    println(gamer2.rentedGames)
}