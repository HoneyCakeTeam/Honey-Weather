package di

import data.source.WeatherService
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import org.koin.dsl.module


const val BASE_URL = "https://api.openweathermap.org/data/2.5/forecast"
const val API_KEY = "305a0a3806867ca5ad56e6fe87050bc9"

val networkModule = module {
    single { httpClient() }
    single { WeatherService(get()) }
}

private fun httpClient(): HttpClient {
    return HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        install(Logging) {
            level = LogLevel.BODY
        }
        defaultRequest {
            url(BASE_URL)
            parameter("appid", API_KEY)
        }
    }
}
