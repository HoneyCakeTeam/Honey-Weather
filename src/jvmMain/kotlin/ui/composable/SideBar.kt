package ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.viewmodel.WeatherUiState

@Composable
fun SideBar(state: WeatherUiState) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(350.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {

        Spacer(modifier = Modifier.height(24.dp))
        WeekHeader()
        Spacer(modifier = Modifier.height(24.dp))
        CustomHorizontalDivider()
        Spacer(modifier = Modifier.height(24.dp))
        TodayHourlyWeather(state.todayWeatherItems.forecastItems)
        Spacer(modifier = Modifier.height(8.dp))
        WeaklyWeatherRecycle(state.remainWeatherItems.forecastItems)
    }
}