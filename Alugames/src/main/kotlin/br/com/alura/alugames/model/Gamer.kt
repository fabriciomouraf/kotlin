package br.com.alura.alugames.model

import java.lang.IllegalArgumentException
import java.util.Scanner
import kotlin.random.Random

data class Gamer (var name:String, var email:String) {
    var birthDate: String? = null
    var username:String? = null
        set(value) {
            field = value
            if(tagName.isNullOrBlank()){
                createTagName()
            }
        }
    var tagName:String? = null
        private set

    val games:MutableList<Game?> = mutableListOf()

    init {
        validateName()
        this.email = validateEmail()
    }

    constructor(name: String, email: String, birthDate:String, username:String):
            this(name, email){
                this.birthDate = birthDate
                this.username = username
            }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthDate=$birthDate, username=$username, tagName=$tagName)"
    }

    private fun createTagName(){
        val number = Random.nextInt(10000)
        val tag = String.format("%05d", number)

        tagName = "$username#$tag"
    }

    private fun validateEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
        if(regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Email not valid")
        }
    }

    private fun validateName(){
        if(name.isNullOrBlank()){
            throw IllegalArgumentException("Name not valid")
        }
    }

    companion object Factory{
        fun createGamer(input:Scanner):Gamer{
            println("Welcome, for the next stage create a gamer profile")
            println("Type your name:")
            val name = input.nextLine()
            println("Type your email:")
            val email = input.nextLine()

            println("Do you want to have a complete registration? Y/N")
            val option = input.nextLine()
            if(option.equals("y", true)){
                println("Type your birthdate:")
                val birthDate = input.nextLine()
                println("Type your username:")
                val username = input.nextLine()
                return Gamer(name,  email, birthDate, username)
            }else{
                return Gamer(name, email)
            }
        }
    }
}