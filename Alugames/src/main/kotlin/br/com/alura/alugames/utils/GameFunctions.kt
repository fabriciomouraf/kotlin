package br.com.alura.alugames.utils

import br.com.alura.alugames.model.Game
import br.com.alura.alugames.model.GameApiShark

fun GameApiShark.buildGame(): Game{
    return Game(this.titulo, this.capa)
}