package domain.mapper

import data.model.*
import domain.entity.*

fun WeatherDto.toEntity(): WeatherEntity {
    val forecastItems = list.map { it.toForecastItemEntity() }
    val city = city.toEntity()
    return WeatherEntity(forecastItems, city)
}

fun ForecastItemDto.toForecastItemEntity(): ForecastItemEntity {
    val weatherDescription = main.toWeatherDescriptionEntity()
    val weatherEntities = weather.map { it.toWeatherEntity() }
    return ForecastItemEntity(weatherDescription, weatherEntities, dt_txt)
}

fun MainDto.toWeatherDescriptionEntity(): WeatherDescriptionEntity {
    return WeatherDescriptionEntity(temp, temp_min, temp_max, pressure, sea_level, humidity, grnd_level)
}

fun Weather.toWeatherEntity(): WeatherConditionEntity {
    return WeatherConditionEntity(main, description, icon)
}

fun CityDto.toEntity(): CityEntity {
    return CityEntity(name, sunrise, sunset)
}


