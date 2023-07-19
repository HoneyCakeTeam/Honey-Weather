package data.repository

import data.source.WeatherService
import domain.entity.WeatherEntity
import domain.mapper.toEntity


class WeatherRepoImpl(
    private val weatherService: WeatherService
) : WeatherRepo {
    override suspend fun fetchData(latitude: String, longitude: String): WeatherEntity {
        try {
            return weatherService.getWeatherData(latitude, longitude).toEntity()
        } catch (e: Exception) {
            throw Exception("error occurred while fetching weather data.")
        }
    }
}
