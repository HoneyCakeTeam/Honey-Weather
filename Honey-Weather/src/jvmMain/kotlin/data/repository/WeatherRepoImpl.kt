package data.repository

import WeatherService
import data.model.WeatherDto
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import java.net.ConnectException

class WeatherRepoImpl(
    private val weatherService: WeatherService
) : WeatherRepo {
    override suspend fun fetchData(lat: String, lon: String): WeatherDto {
        try {
            return weatherService.getWeatherData(lat, lon)
        } catch (e: Exception) {
            throw Exception("error occurred while fetching weather data.")
        }
    }
}
