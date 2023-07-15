package ui.viewmodel

import data.model.WeatherDto

data class WeatherUiState(
    val error: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val todayWeatherItems: WeatherDto? = null,
    val remainWeatherItems: WeatherDto? = null,
)
