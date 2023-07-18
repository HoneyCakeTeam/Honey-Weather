package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import getWeatherIconResource
import ui.theme.Black60
import ui.theme.Black87
import ui.theme.CardBackgroundColor
import ui.theme.Typography
import ui.viewmodel.ForecastItemUiState

@Composable
fun TodayHourlyWeather(todayWeatherItems: List<ForecastItemUiState>) {
    Text(
        text = "Today",
        color = Black60,
        style = Typography.h3,
        modifier = Modifier.padding(horizontal = 32.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(todayWeatherItems) { forecastItem ->
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .background(color = CardBackgroundColor, shape = RoundedCornerShape(16.dp))
                    .padding(all = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = forecastItem.time,
                        style = Typography.body2,
                        color = Black87
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(getWeatherIconResource(forecastItem.weatherCondition.icon)),
                        contentDescription = "weather pic",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${forecastItem.weatherDescriptions.temperature}°",
                        style = Typography.body1.copy(color = Black87)
                    )
                }
            }
        }
    }
}
