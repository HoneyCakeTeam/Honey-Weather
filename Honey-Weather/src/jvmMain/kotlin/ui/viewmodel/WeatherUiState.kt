package ui.viewmodel

import data.model.WeatherDto

data class WeatherUiState(
    val todayWeatherItems: WeatherDto? = null,
    val remainWeatherItems: WeatherDto? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
