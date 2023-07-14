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

class WeatherViewModel:KoinComponent {
    private val getTodayWeatherItemsUseCase: GetTodayWeatherItemsUseCase by inject()
    private val getRemainWeatherItemsUseCase: GetRemainWeatherItemsUseCase by inject()
    private val _weatherUiState = MutableStateFlow(WeatherUiState())
    val weatherUiState=_weatherUiState.asStateFlow()
    init {
        getWeather()
    }

    private fun getWeather() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _weatherUiState.update { it.copy(isLoading = true) }
                val data=getTodayWeatherItemsUseCase("40","11")
                val data2=getRemainWeatherItemsUseCase("40","11")
                println(data)
                println(data2)
                _weatherUiState.update { it.copy(
                    todayWeatherItems=data,
                    remainWeatherItems=data2
                ) }
                println(weatherUiState.value.remainWeatherItems)
                println(weatherUiState.value.todayWeatherItems)
            } catch (e: Exception) {
                println("Error occurred: ${e.message}")
                _weatherUiState.update { it.copy(error = e.message ?: "") }
            }finally {
                _weatherUiState.update { it.copy(isLoading = false) }
            }
        }
    }
}