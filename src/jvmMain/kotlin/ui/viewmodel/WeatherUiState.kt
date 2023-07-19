package ui.viewmodel

import domain.entity.*
import ui.utils.convertFromUnixToDate
import ui.utils.convertToTimeFormat
import ui.utils.convertToUserFriendlyDate
import java.text.SimpleDateFormat
import java.util.*

data class WeatherUiState(
    val error: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val todayWeather: ForecastItemUiState = ForecastItemUiState(),
    val todayWeatherItems: WeatherItemUiState = WeatherItemUiState(),
    val remainWeatherItems: WeatherItemUiState = WeatherItemUiState()
)

data class WeatherItemUiState(
    val forecastItems: List<ForecastItemUiState> = emptyList(),
    val city: CityUiState = CityUiState()
)

data class ForecastItemUiState(
    val weatherDescriptions: WeatherDescriptionUiState = WeatherDescriptionUiState(),
    val weatherCondition: WeatherConditionUiState= WeatherConditionUiState(),
    val visibility: Int = 0,
    val wind: WindUiState = WindUiState(),
    val date: String = "",
    val time: String = ""
)

data class WeatherConditionUiState(
    val mainCondition: String = "",
    val description: String = "",
    val icon: String = ""
)

data class WeatherDescriptionUiState(
    val temperature: Int = 0,
    val minTemperature: Int = 0,
    val maxTemperature: Int = 0,
    val pressure: Int = 0,
    val seaLevelPressure: Int = 0,
    val humidity: Int = 0,
    val groundLevelPressure: Int = 0
)

data class CityUiState(
    val name: String = "",
    val sunriseTime: Long = 0L,
    val sunsetTime: Long = 0L
)

data class WindUiState(
    val speed: Double = 0.0,
    val deg: Int = 0,
    val gust: Double = 0.0
)

fun WeatherEntity.toUiState(): WeatherItemUiState {
    return WeatherItemUiState(
        forecastItems = forecastItems.map { it.toForecastItemUiState() },
        city = city.toCityUiState()
    )
}

fun ForecastItemEntity.toForecastItemUiState(): ForecastItemUiState {
    return ForecastItemUiState(
        weatherDescriptions = weatherDescription.toWeatherDescriptionUiState(),
        weatherCondition = weather.first().toWeatherConditionUiState(),
        visibility = visibility,
        wind = wind.toWindUiState(),
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
        temperature = (temperature - 273.15).toInt(),
        minTemperature = (minTemperature - 273.15).toInt(),
        maxTemperature = (maxTemperature - 273.15).toInt(),
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

fun WindEntity.toWindUiState(): WindUiState {
    return WindUiState(
        speed = speed,
        deg = degree,
        gust = gust
    )
}

