package domain.entity

data class ForecastItemEntity(
    val weatherDescription: WeatherDescriptionEntity,
    val weather: List<WeatherConditionEntity>,
    val dateTime: String
)
