package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.*
import ui.viewmodel.ForecastItemUiState


@Composable
fun WeaklyWeatherRecycle(remainWeatherItems: List<ForecastItemUiState>) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(remainWeatherItems.size) { position ->

            val forecastItem = remainWeatherItems[position]

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = CardBackgroundColor, shape = RoundedCornerShape(16.dp))
                    .padding(all = 8.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column() {
                        Text(text = forecastItem.date, style = Typography.h3)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = forecastItem.time,
                            color = Black37,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${forecastItem.weatherCondition.temperature}°",
                        style = Typography.h2
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource("image/smiling_face.png"),
                        contentDescription = "weather pic",
                        modifier = Modifier
                            .size(32.dp)
                    )
                }
            }
        }
    }
}
