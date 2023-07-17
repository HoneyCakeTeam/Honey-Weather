package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Black87
import ui.theme.Typography
import ui.viewmodel.WeatherUiState

@Composable
fun MainCard(state: WeatherUiState) {
    Card(
        modifier = Modifier.height(400.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)),
        elevation = 0.dp
    ) {
        Box {
            Image(
                painterResource("image/image.jpg"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().alpha(0.2F).blur(1.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 28.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically
                ) {
                    Row(
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(vertical = 6.dp, horizontal = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "content description",
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                        )
                        Text(
                            text = state.todayWeatherItems?.city?.name ?: "N/A",
                            style = Typography.h2,
                        )
                    }
                    Text(
                        text = "Today ${state.todayWeather?.date ?: "N/A"}",
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
                        text = "${state.todayWeather?.weatherCondition?.temperature ?: "N/A"}°",
                        style = Typography.h1.copy(fontSize = 100.sp),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = state.todayWeather?.weatherDescriptions?.get(0)?.description ?: "N/A",
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
                        Text(text = "${state.todayWeather?.weatherCondition?.pressure ?: "N/A"} hpa")
                    }
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.WaterDrop, contentDescription = null)
                        Text(text = "${state.todayWeather?.weatherCondition?.humidity ?: "N/A"}%")
                    }
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.Speed, contentDescription = null)
                        Text(text = "${state.todayWeather?.weatherCondition?.groundLevelPressure ?: "N/A"} km/h")
                    }
                }
            }
        }
    }
}
