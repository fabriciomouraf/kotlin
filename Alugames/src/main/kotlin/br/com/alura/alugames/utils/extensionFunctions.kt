package br.com.alura.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformAge(): Int{
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val birthDate = LocalDate.parse(this, formatter)
    val currentDate = LocalDate.now()
    return Period.between(birthDate, currentDate).years
}