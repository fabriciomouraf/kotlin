package br.com.alura.alugames.model

data class Info(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}