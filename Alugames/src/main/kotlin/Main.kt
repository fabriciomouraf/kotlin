import br.com.alura.alugames.model.Game
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.service.SearchGameSharkApi
import br.com.alura.alugames.utils.transformAge
import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val gamer = Gamer.createGamer(input)

    println("Your gamer age is: " + gamer.birthDate?.transformAge())

    do{
        println("Type game id for search: ")
        val idValue = input.nextLine()

        var myGame: Game? = null
        val result = runCatching {
            val myInfoGame = SearchGameSharkApi().find(idValue)

            myGame = Game(
                myInfoGame.info.title,
                myInfoGame.info.thumb
            )
        }

        result.onFailure {
            println("Game not exists, please try with other id")
        }

        result.onSuccess {
            println("You desire add a description for the game? Y/N")
            val option = input.nextLine()
            if(option.equals("y", true)){
                println("Type game description:")
                val customDescription = input.nextLine()
                myGame?.description = customDescription
            }else{
                myGame?.description = myGame?.title
            }
            gamer.games.add(myGame)
        }

        println("You desire add one more game? Y/N")
        val response = input.nextLine()
    }while (response.equals("y", true))

    println("Thank you, your game list is: ")
    println(gamer.games)

    println("Your list in alphabetical order is:")
    gamer.games.sortBy { it?.title }
    println(gamer.games)

    println("Only title in your games: ")
    gamer.games.forEach {
        println("Titulo: " + it?.title)
    }

    println("Type word for filter in your list:")
    val filter = input.nextLine()
    val filterGames = gamer.games.filter {
        it?.title?.contains(filter, true) ?: false
    }
    println(filterGames)

    println("Type number index for delete:")
    val index = input.nextInt()
    gamer.games.removeAt(index)
    println(gamer.games)

}