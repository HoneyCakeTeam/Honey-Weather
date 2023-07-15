package ui.viewmodel

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
import org.xml.sax.ErrorHandler

class WeatherViewModel : KoinComponent {
    private val getTodayWeatherItemsUseCase: GetTodayWeatherItemsUseCase by inject()
    private val getRemainWeatherItemsUseCase: GetRemainWeatherItemsUseCase by inject()

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

                val todayWeatherData = getTodayWeatherItemsUseCase("40", "11")
                val restOfWeakWeatherData = getRemainWeatherItemsUseCase("40", "11")
                println(todayWeatherData)
                println(restOfWeakWeatherData)
                _weatherUiState.update {
                    it.copy(
                        todayWeatherItems = todayWeatherData,
                        remainWeatherItems = restOfWeakWeatherData
                    )
                }
                println(weatherUiState.value.remainWeatherItems)
                println(weatherUiState.value.todayWeatherItems)
            } catch (e: Exception) {
                println("Error occurred: ${e.message}")
                onGetWeatherError(e.message)
            } finally {
                _weatherUiState.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun onGetWeatherError(error: String?) {
        _weatherUiState.update { it.copy(isLoading = false, isError = true) }
    }
}