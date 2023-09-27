package br.com.alura.alugames.service

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.GamerApiShark
import br.com.alura.alugames.model.Info
import br.com.alura.alugames.utils.buildGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.RuntimeException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SearchSharkApi {

    fun findGame(id:String):Info {
        val baseUrl = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val responseStatus = response.statusCode()
        val json = response.body()

        if(responseStatus == 404 || json.isEmpty()){
            throw RuntimeException("Event not found in api")
        }

        val gson = Gson()
        return gson.fromJson(json, Info::class.java)
    }

    fun findGamers():List<Gamer> {
        val baseUrl = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val responseStatus = response.statusCode()
        val json = response.body()

        if(responseStatus == 404 || json.isEmpty()){
            throw RuntimeException("Event not found in api")
        }

        val gson = Gson()
        val gsonType = object : TypeToken<List<GamerApiShark>>(){}.type
        val listGamerApi: List<GamerApiShark> = gson.fromJson(json, gsonType)

        return listGamerApi.map { gamerApi ->  gamerApi.buildGamer()}
    }

}