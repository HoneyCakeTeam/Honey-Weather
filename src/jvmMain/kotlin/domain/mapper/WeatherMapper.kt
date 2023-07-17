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
    val windEntity = wind.toWindEntity()
    return ForecastItemEntity(weatherDescription, weatherEntities, visibility, windEntity, dt_txt)
}

fun MainDto.toWeatherDescriptionEntity(): WeatherDescriptionEntity {
    return WeatherDescriptionEntity(temp, temp_min, temp_max, pressure, sea_level, humidity, grnd_level)
}

fun Weather.toWeatherEntity(): WeatherConditionEntity {
    return WeatherConditionEntity(main, description, icon)
}

fun WindDto.toWindEntity(): WindEntity {
    return WindEntity(speed, deg, gust)
}

fun CityDto.toEntity(): CityEntity {
    return CityEntity(name, timezone, sunrise, sunset)
}


