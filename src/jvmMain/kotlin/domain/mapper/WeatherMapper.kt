package domain.mapper

import data.model.*
import domain.entity.*

fun WeatherDto.toEntity(): WeatherEntity {
    val forecastItems = list?.map { it.toForecastItemEntity() }
    val city = city?.toEntity() ?: throw IllegalStateException("City information is missing.")
    return WeatherEntity(
        forecastItems = forecastItems ?: emptyList(),
        city = city
    )
}

fun ForecastItemDto.toForecastItemEntity(): ForecastItemEntity {
    val weatherDescription =
        main?.toWeatherDescriptionEntity() ?: throw IllegalStateException("Weather Description is missing.")
    val weatherEntities = weather?.map { it.toWeatherEntity() }
    val windEntity = wind?.toWindEntity() ?: throw IllegalStateException("Wind information is missing.")
    return ForecastItemEntity(
        weatherDescription = weatherDescription,
        weather = weatherEntities ?: emptyList(),
        visibility = visibility ?: 0,
        wind = windEntity,
        dateTime = dt_txt ?: "Empty Date"
    )
}

fun MainDto.toWeatherDescriptionEntity(): WeatherDescriptionEntity {
    return WeatherDescriptionEntity(
        temperature = temp ?: 0.0,
        minTemperature = temp_min ?: 0.0,
        maxTemperature = temp_max ?: 0.0,
        pressure = pressure ?: 0,
        seaLevelPressure = sea_level ?: 0,
        humidity = humidity ?: 0,
        groundLevelPressure = grnd_level ?: 0
    )
}

fun Weather.toWeatherEntity(): WeatherConditionEntity {
    return WeatherConditionEntity(
        mainCondition = main ?: "No Main Condition",
        description = description ?: "Empty Description",
        icon = icon ?: "No Icon"
    )
}

fun WindDto.toWindEntity(): WindEntity {
    return WindEntity(
        speed = speed ?: 0.0,
        deg = deg ?: 0,
        gust = gust ?: 0.0
    )
}

fun CityDto.toEntity(): CityEntity {
    return CityEntity(
        name = name ?: "unknown",
        timezone = timezone ?: 0,
        sunrise = sunrise ?: 0L,
        sunset = sunset ?: 0L
    )
}