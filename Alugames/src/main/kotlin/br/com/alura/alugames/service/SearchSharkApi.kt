package br.com.alura.alugames.service

import br.com.alura.alugames.model.*
import br.com.alura.alugames.utils.buildGame
import br.com.alura.alugames.utils.buildGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.RuntimeException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SearchSharkApi {
    fun findGame():List<Game> {
        val baseUrl = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = buildRequest(baseUrl)

        val gson = Gson()
        val gsonType = object : TypeToken<List<GameApiShark>>(){}.type
        val listGameApi: List<GameApiShark> = gson.fromJson(json, gsonType)
        return listGameApi.map { gameApi -> gameApi.buildGame()}
    }

    fun findGamers():List<Gamer> {
        val baseUrl = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = buildRequest(baseUrl)

        val gson = Gson()
        val gsonType = object : TypeToken<List<GamerApiShark>>(){}.type
        val listGamerApi: List<GamerApiShark> = gson.fromJson(json, gsonType)

        return listGamerApi.map { gamerApi ->  gamerApi.buildGamer()}
    }

    private fun buildRequest(baseUrl: String): String {
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
        return json
    }
}