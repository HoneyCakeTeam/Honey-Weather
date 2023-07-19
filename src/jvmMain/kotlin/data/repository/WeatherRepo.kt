package data.repository

import domain.entity.WeatherEntity

interface WeatherRepo {
    suspend fun fetchData(latitude: String, longitude: String): WeatherEntity
}
