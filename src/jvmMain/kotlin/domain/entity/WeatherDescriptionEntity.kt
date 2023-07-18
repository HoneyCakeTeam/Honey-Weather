package domain.entity

data class WeatherDescriptionEntity(
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val pressure: Int,
    val seaLevelPressure: Int,
    val humidity: Int,
    val groundLevelPressure: Int
)

