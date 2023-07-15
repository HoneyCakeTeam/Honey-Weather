package data.repository

import data.model.WeatherDto
import domain.entity.WeatherEntity

interface WeatherRepo {
    suspend fun fetchData(lat: String, lon: String): WeatherEntity
}
