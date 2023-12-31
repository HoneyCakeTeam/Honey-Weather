package domain.entity

data class ForecastItemEntity(
    val weatherDescription: WeatherDescriptionEntity,
    val weather: List<WeatherConditionEntity>,
    val clouds: CloudsEntity,
    val visibility: Int,
    val wind: WindEntity,
    val dateTime: String
)
