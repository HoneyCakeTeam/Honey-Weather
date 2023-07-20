package ui.composable

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.Typography
import ui.utils.convertFromUnixToDate
import ui.viewmodel.WeatherUiState

@Composable
fun BodyContent(
    state: WeatherUiState,
    onClickTemperatureType: () -> Unit
) {
    val temperature = state.todayWeather.weatherDescriptions
    val animatedTemperature = animatedTemperature(state, temperature.temperature)

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        MainCard(
            state = state,
            onClickTemperatureType = onClickTemperatureType,
            animatedTemperature = animatedTemperature.value
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(text = "Today Highlights", style = Typography.h1)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TodayHighlightsCard(
                modifier = Modifier.weight(1F),
                "Wind",
                "Today Wind Speed",
                "${state.todayWeather.wind.speed} km/h"
            )
            TodayHighlightsCard(
                modifier = Modifier.weight(1F),
                "Max and Min Temperature",
                "Max : ${animatedTemperature(state, temperature.minTemperature).value}°",
                "Min : ${animatedTemperature(state, temperature.maxTemperature).value}°",
            )
            TodayHighlightsCard(
                modifier = Modifier.weight(1F),
                "Sunrise and Sunset",
                "Sunrise : ${convertFromUnixToDate(state.todayWeatherItems.city.sunriseTime)}",
                "Sunset : ${convertFromUnixToDate(state.todayWeatherItems.city.sunsetTime)}"
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TodayHighlightsCard(
                modifier = Modifier.weight(1F),
                "Pressure",
                "Today Pressure",
                "${state.todayWeather.weatherDescriptions.pressure} hpa"
            )
            TodayHighlightsCard(
                modifier = Modifier.weight(1F),
                "Humidity",
                "Today Humidity",
                "${state.todayWeather.weatherDescriptions.humidity} %"
            )
            TodayHighlightsCard(
                modifier = Modifier.weight(1F),
                "Visibility",
                "Today Visibility",
                "${state.todayWeather.visibility / 1000} km"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Copyright @2023 The Chance - Honey Cake Team",
            style = Typography.body2,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun animatedTemperature(state: WeatherUiState, temperature: Int): State<Int> {
    return animateIntAsState(
        targetValue = if (state.isSelectedTemperatureInCelsius) temperature else temperature + 32,
        animationSpec = tween(durationMillis = 3000)
    )
}