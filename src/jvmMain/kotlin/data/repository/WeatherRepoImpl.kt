package data.repository

import WeatherService
import data.model.WeatherDto
import domain.entity.WeatherEntity
import domain.mapper.toEntity


class WeatherRepoImpl(
    private val weatherService: WeatherService
) : WeatherRepo {
    override suspend fun fetchData(lat: String, lon: String): WeatherEntity {
        try {
            return weatherService.getWeatherData(lat, lon).toEntity()
        } catch (e: Exception) {
            throw Exception("error occurred while fetching weather data.")
        }
    }
}
