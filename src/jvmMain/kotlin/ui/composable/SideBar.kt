package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.BackgroundColor
import ui.theme.DarkBlue
import ui.viewmodel.WeatherUiState

@Composable
fun SideBar(state: WeatherUiState) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(350.dp)
            .background(BackgroundColor)
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        WeekHeader()
        Spacer(modifier = Modifier.height(24.dp))
        TodayHourlyWeather(state.todayWeatherItems?.forecastItems ?: emptyList())
        Spacer(modifier = Modifier.height(8.dp))
        WeaklyWeatherRecycle(state.remainWeatherItems?.forecastItems ?: emptyList())
    }
}