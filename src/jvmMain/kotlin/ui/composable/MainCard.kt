package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material.icons.outlined.WindPower
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Typography
import ui.theme.Whit87
import ui.viewmodel.WeatherUiState

@Composable
fun MainCard(state: WeatherUiState) {

    Box {
        Column {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxWidth().background(Color.Transparent).padding(start = 32.dp)
            ) {
                Text(
                    text = "${state.todayWeather.weatherDescriptions.temperature}°",
                    style = Typography.h1.copy(fontSize = 100.sp),
                    modifier = Modifier.padding(top = 100.dp),
                    color = Color.White
                )
                Text(
                    text = "Today ${state.todayWeather.date}",
                    style = Typography.h3.copy(Whit87),
                    modifier = Modifier.padding(),
                    color = Color.White
                )
                Row(
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "Location Icon",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Text(
                        text = state.todayWeatherItems.city.name,
                        style = Typography.h2,
                        color = Color.White
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                    verticalAlignment = CenterVertically
                ) {
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.WindPower, contentDescription = null, tint = Color.White)
                        Text(text = "${state.todayWeather.weatherDescriptions.pressure} hpa", color = Color.White)
                    }
                    Text(text = "|", color = Color.White)
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.WaterDrop, contentDescription = null, tint = Color.White)
                        Text(text = "${state.todayWeather.weatherDescriptions.humidity}%", color = Color.White)
                    }
                    Text(text = "|", color = Color.White)
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.Speed, contentDescription = null, tint = Color.White)
                        Text(text = "${state.todayWeather.weatherDescriptions.groundLevelPressure} km/h", color = Color.White)
                    }
                }
            }
        }
    }
}