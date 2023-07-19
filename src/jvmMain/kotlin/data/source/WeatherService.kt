package data.source

import data.model.WeatherDto
import io.ktor.client.*
import io.ktor.client.request.*

class WeatherService(private val httpClient: HttpClient) {

    suspend fun getWeatherData(latitude: String, longitude: String): WeatherDto {
        return httpClient.get {
            parameter("lat", latitude)
            parameter("lon", longitude)
        }
    }
}