package domain.entity

data class WeatherEntity(
    val forecastItems: List<ForecastItemEntity>,
    val city: CityEntity
)
