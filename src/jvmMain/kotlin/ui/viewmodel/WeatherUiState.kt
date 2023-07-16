package ui.viewmodel

import domain.entity.*
import util.convertToTimeFormat
import util.convertToUserFriendlyDate

data class WeatherUiState(
    val error: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val todayWeather:ForecastItemUiState? = null,
    val todayWeatherItems: WeatherItemUiState? = null,
    val remainWeatherItems: WeatherItemUiState? = null,
)

data class WeatherItemUiState(
    val forecastItems: List<ForecastItemUiState>,
    val city: String
)

data class ForecastItemUiState(
    val weatherCondition: WeatherDescriptionUiState,
    val weatherDescriptions: List<WeatherConditionUiState>,
    val date: String,
    val time: String

    )

data class WeatherConditionUiState(
    val mainCondition: String,
    val description: String,
    val icon: String
)

data class WeatherDescriptionUiState(
    val temperature: Int,
    val minTemperature: Int,
    val maxTemperature: Int,
    val pressure: Int,
    val seaLevelPressure: Int,
    val humidity: Int,
    val groundLevelPressure: Int
)

data class CityUiState(
    val name: String,
    val sunriseTime: Long,
    val sunsetTime: Long
)

fun WeatherEntity.toUiState(): WeatherItemUiState {
    return WeatherItemUiState(
        forecastItems = forecastItems.map { it.toForecastItemUiState() },
        city = city.name
    )
}

fun ForecastItemEntity.toForecastItemUiState(): ForecastItemUiState {
    return ForecastItemUiState(
        weatherCondition = weatherDescription.toWeatherDescriptionUiState(),
        weatherDescriptions = weather.map { it.toWeatherConditionUiState() },
        date = convertToUserFriendlyDate(dateTime),
        time = convertToTimeFormat(dateTime)
    )
}

fun WeatherConditionEntity.toWeatherConditionUiState(): WeatherConditionUiState {
    return WeatherConditionUiState(
        mainCondition = mainCondition,
        description = description,
        icon = icon
    )
}

fun WeatherDescriptionEntity.toWeatherDescriptionUiState(): WeatherDescriptionUiState {
    return WeatherDescriptionUiState(
        temperature = (temperature-273.15).toInt(),
        minTemperature = (minTemperature-273.15).toInt(),
        maxTemperature = (maxTemperature-273.15).toInt(),
        pressure = pressure,
        seaLevelPressure = seaLevelPressure,
        humidity = humidity,
        groundLevelPressure = groundLevelPressure
    )
}

fun CityEntity.toCityUiState(): CityUiState {
    return CityUiState(
        name = name,
        sunriseTime = sunrise,
        sunsetTime = sunset
    )
}
