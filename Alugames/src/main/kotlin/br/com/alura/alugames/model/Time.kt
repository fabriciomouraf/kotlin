package br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class Time(
    val startDate: LocalDate,
    val endDate: LocalDate) {
    val inDays = Period.between(startDate, endDate).days
}