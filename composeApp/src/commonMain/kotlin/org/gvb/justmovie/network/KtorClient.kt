package org.gvb.justmovie.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.logging.KtorSimpleLogger

class KtorClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getData(): MovieResponse {
        val response =
            client.request("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1") {
                method = HttpMethod.Get
                headers.append(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MTI5OTQxNGM3MGYyY2FkZjlmZWVhNzNlMzA4YmI2YSIsIm5iZiI6MTcyNzE2MDc3OC41MTg0NTMsInN1YiI6IjY0ODk5YWQwZTM3NWMwMDBlMjUxYTcxNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.96m37RBxAI8UdT5niBpP8PN9bIR3wQCmmhbA9JVsqlw"
                )
            }
        KtorSimpleLogger("response").info(response.toString())
        return response.body()
    }
}