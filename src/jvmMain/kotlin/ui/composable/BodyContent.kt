package ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.Typography
import ui.utils.convertFromUnixToDate
import ui.viewmodel.WeatherUiState

@Composable
fun BodyContent(
    state: WeatherUiState
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        MainCard(state)
        Spacer(modifier = Modifier.weight(1f))
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
            TodayHighlightsCard(modifier = Modifier.weight(1F),
                "Max and Min Temperature",
                "Max : ${state.todayWeather.weatherDescriptions.maxTemperature}°",
                "Min : ${state.todayWeather.weatherDescriptions.minTemperature}°",
            )
            TodayHighlightsCard(modifier = Modifier.weight(1F),
                "SunRise and SunSet",
                "SunRise : ${convertFromUnixToDate(state.todayWeatherItems.city.sunriseTime)}",
                "SunSet : ${convertFromUnixToDate(state.todayWeatherItems.city.sunsetTime)}"
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TodayHighlightsCard(modifier = Modifier.weight(1F),
                "Pressure",
                "Today Pressure",
                "${state.todayWeather.weatherDescriptions.pressure} hpa"
            )
            TodayHighlightsCard(modifier = Modifier.weight(1F),
                "Humidity",
                "Today Humidaty",
                "${state.todayWeather.weatherDescriptions.humidity} %"
            )
            TodayHighlightsCard(modifier = Modifier.weight(1F),
                "Visibility",
                "Today Visibility",
                "${state.todayWeather.visibility}"
            )

        }
    }
}