import br.com.alura.alugames.service.SearchSharkApi

fun main(){
    val listGamers = SearchSharkApi().findGamers()

    listGamers.forEach {
        println(it)
    }
}