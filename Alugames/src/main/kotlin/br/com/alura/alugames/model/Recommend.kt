package br.com.alura.alugames.model

interface Recommend {
    val average: Double

    fun recommend(grade: Int)
}