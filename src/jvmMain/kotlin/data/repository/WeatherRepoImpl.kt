package data.repository

import WeatherService
import data.model.WeatherDto


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
