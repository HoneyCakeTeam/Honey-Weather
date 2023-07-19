package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.utils.getWeatherIconResource
import ui.theme.*
import ui.viewmodel.ForecastItemUiState
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun WeaklyWeatherRecycle(remainWeatherItems: List<ForecastItemUiState>) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Remain Days", style = Typography.h3, modifier = Modifier.padding(horizontal = 16.dp))
    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(remainWeatherItems.size) { position ->
            val forecastItem = remainWeatherItems[position]

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(all = 8.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = formatDate(), style = Typography.h3)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = forecastItem.time,
                            style = Typography.body2
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${forecastItem.weatherDescriptions.temperature}°",
                        style = Typography.h2
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = painterResource(getWeatherIconResource(forecastItem.weatherCondition.icon)),
                        contentDescription = "weather pic",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    }
}

private val formatDate: () -> String = {
    val currentDate = System.currentTimeMillis()
    val dateObject = Date(currentDate)

    // Format the date as the day of the week (e.g., Monday, Tuesday, etc.)
    val dayOfWeekFormat = SimpleDateFormat("EEEE", Locale.getDefault())

    dayOfWeekFormat.format(dateObject)
}

