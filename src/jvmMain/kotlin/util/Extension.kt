package util

import domain.entity.ForecastItemEntity
import domain.entity.WeatherEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun WeatherEntity.filterWeatherItems(filterCondition: (ForecastItemEntity) -> Boolean): List<ForecastItemEntity> {
    return forecastItems.filter(filterCondition)
}
fun ForecastItemEntity.getForecastDate(): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val forecastDateTime = LocalDateTime.parse(dateTime, formatter)
    return forecastDateTime.toLocalDate()
}



