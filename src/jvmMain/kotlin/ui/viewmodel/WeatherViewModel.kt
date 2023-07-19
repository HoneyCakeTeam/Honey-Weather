package ui.viewmodel

import domain.entity.WeatherEntity
import domain.usecase.GetWeatherDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import ui.utils.LocationManager

class WeatherViewModel(
    private val getWeatherItems: GetWeatherDataUseCase,
) : KoinComponent {
    private val _weatherUiState = MutableStateFlow(WeatherUiState())
    val weatherUiState = _weatherUiState.asStateFlow()

    init {
        getWeather()
    }

    private fun getWeather() {
        _weatherUiState.update { it.copy(isLoading = true) }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val location = LocationManager.getLocation()
                val weatherData = getWeatherItems("${location.latitude}", "${location.longitude}")

                onGetWeatherSuccess(weatherData.todayWeather, weatherData.remainWeather)
            } catch (e: Exception) {
                onGetWeatherError(e.message)
            } finally {
                _weatherUiState.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun onGetWeatherSuccess(todayWeatherData: WeatherEntity, restOfWeakWeatherData: WeatherEntity) {
        _weatherUiState.update {
            it.copy(
                todayWeatherItems = todayWeatherData.toUiState(),
                remainWeatherItems = restOfWeakWeatherData.toUiState(),
                todayWeather = todayWeatherData.forecastItems.first().toForecastItemUiState(),
            )
        }
    }

    private fun onGetWeatherError(error: String?) {
        _weatherUiState.update { it.copy(isLoading = false, isError = true) }
    }
}
