package ui.viewmodel


import domain.entity.WeatherEntity

data class WeatherUiState(
    val error: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val todayWeatherItems: WeatherEntity? = null,
    val remainWeatherItems: WeatherEntity? = null,
)
