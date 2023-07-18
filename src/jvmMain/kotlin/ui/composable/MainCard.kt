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
import ui.viewmodel.WeatherUiState

@Composable
fun MainCard(state: WeatherUiState) {
    Card(
        modifier = Modifier.height(400.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)),
        elevation = 0.dp
    ) {
        Box {

            Column() {

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.fillMaxWidth().background(Color.Transparent).padding(start = 32.dp)
                ) {
                    Text(
                        text = "12°", style = Typography.h1.copy(fontSize = 100.sp),
                        modifier = Modifier.padding(top = 100.dp),
                        color = Color.White
                    )
                    Text(
                        text = "Today 00:32 PM",
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
                            contentDescription = "content description",
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                            tint = Color.White
                        )
                        Text(
                            text = state.todayWeatherItems.city.name,
                            style = Typography.h2,
                            color = Color.White
                        )
                    }
                    Text(
                        text = "Today ${state.todayWeather.date}",
                        style = Typography.h3.copy(Black87),
                        modifier = Modifier.align(CenterVertically)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${state.todayWeather.weatherDescriptions.temperature}°",
                        style = Typography.h1.copy(fontSize = 100.sp),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = state.todayWeather.weatherCondition.description,
                        style = Typography.h2.copy(Black87),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                }
                Spacer(modifier = Modifier.weight(1F))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = CenterVertically
                ) {
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.WindPower, contentDescription = null)
                        Text(text = "${state.todayWeather.weatherDescriptions.pressure} hpa")
                    }
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.WaterDrop, contentDescription = null)
                        Text(text = "${state.todayWeather.weatherDescriptions.humidity}%")
                    }
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.Speed, contentDescription = null)
                        Text(text = "${state.todayWeather.weatherDescriptions.groundLevelPressure} km/h")
                    }
                }
            }
        }
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
                            Text(text = "728hpa", color = Color.White)
                        }
                        Text(text = "|", color = Color.White)
                        Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(imageVector = Icons.Outlined.WaterDrop, contentDescription = null, tint = Color.White)
                            Text(text = "32%", color = Color.White)
                        }
                        Text(text = "|", color = Color.White)
                        Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(imageVector = Icons.Outlined.Speed, contentDescription = null, tint = Color.White)
                            Text(text = "12km/h", color = Color.White)
                        }
                    }
                }

            }
        }
    }
