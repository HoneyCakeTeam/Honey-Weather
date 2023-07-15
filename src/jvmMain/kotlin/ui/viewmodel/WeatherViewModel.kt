package ui.viewmodel


import domain.entity.WeatherEntity
import domain.usecase.GetRemainWeatherItemsUseCase
import domain.usecase.GetTodayWeatherItemsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherViewModel(
    private val getTodayWeatherItems: GetTodayWeatherItemsUseCase,
    private val getRemainWeatherItems: GetRemainWeatherItemsUseCase
): KoinComponent {
    private val _weatherUiState = MutableStateFlow(WeatherUiState())
    val weatherUiState = _weatherUiState.asStateFlow()

    init {
        getWeather()
    }

    private fun getWeather() {
        _weatherUiState.update { it.copy(isLoading = true) }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _weatherUiState.update { it.copy(isLoading = true) }
                val todayWeatherData = getTodayWeatherItems("40", "11")
                val restOfWeakWeatherData = getRemainWeatherItems("40", "11")
                onGetWeatherSuccess(todayWeatherData, restOfWeakWeatherData)
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
                todayWeatherItems = todayWeatherData,
                remainWeatherItems = restOfWeakWeatherData
            )
        }
    }

    private fun onGetWeatherError(error: String?) {
        _weatherUiState.update { it.copy(isLoading = false, isError = true) }
    }
}