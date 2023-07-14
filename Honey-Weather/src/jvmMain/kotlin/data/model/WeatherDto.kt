package data.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<ForecastItem>,
    val city: City
)
