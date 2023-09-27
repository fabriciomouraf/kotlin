import br.com.alura.alugames.model.Gamer

fun main(){
    val gamer1 = Gamer("Fabricio Moura", "fabricio@email.com")
    println(gamer1)
    val gamer2 = Gamer("Bianca", "bianca@email.com", "22/04/2000", "bpsx")
    println(gamer2)

    gamer2.let {
        it.birthDate = "06/06/2002"
        it.username = "bpsxg2"
    }.also {
        println(gamer2)
    }
    println(gamer2)
}