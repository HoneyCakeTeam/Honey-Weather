package data.repository

import data.model.WeatherDto

interface WeatherRepo {
    suspend fun fetchData(lat: String, lon: String): WeatherDto
}
