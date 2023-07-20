package ui.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Typography
import ui.theme.Whit87
import ui.utils.isNight
import ui.viewmodel.WeatherUiState

@Composable
fun MainCard(
    state: WeatherUiState,
    onClickTemperatureType: () -> Unit,
    animatedTemperature: Int
) {
    val animateOffset = remember { Animatable(0f) }


    LaunchedEffect(true) {
        while (true) {
            animateOffset.animateTo(
                50f,
                animationSpec = infiniteRepeatable(tween(4000), RepeatMode.Reverse)
            )
        }
    }

    Box {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.background(Color.Transparent).padding(start = 32.dp)
                ) {
                    Text(
                        text = "$animatedTemperature°",
                        style = Typography.h1.copy(fontSize = 100.sp),
                        modifier = Modifier.padding(top = 100.dp),
                        color = White
                    )
                    Text(
                        text = "Today ${state.todayWeather.date}",
                        style = Typography.h3.copy(Whit87),
                        modifier = Modifier.padding(),
                        color = White
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
                            tint = White
                        )
                        Text(
                            text = state.todayWeatherItems.city.name,
                            style = Typography.h2.copy(White),
                        )
                        Text(
                            text = ", ${state.todayWeatherItems.city.country}",
                            style = Typography.caption.copy(White),
                            modifier = Modifier.align(Alignment.Bottom)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                    verticalAlignment = CenterVertically
                ) {
                    val rainProbability = calculateRainProbability(state.todayWeather.clouds.allClouds)
                    val weatherDescription = state.todayWeather.weatherDescriptions
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Outlined.WaterDrop, contentDescription = null, tint = White)
                        Text(text = rainProbability, color = White)
                    }
                    Text(text = "|", color = White)
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            painter = painterResource("image/sea_level.png"),
                            contentDescription = null,
                            tint = White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(
                            text = "${weatherDescription.seaLevelPressure} hpa",
                            color = White
                        )
                    }
                    Text(text = "|", color = White)
                    Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            painter = painterResource("image/pressure.png"),
                            contentDescription = null,
                            tint = White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(
                            text = "${weatherDescription.groundLevelPressure} hpa",
                            color = White
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(end = 16.dp, top = 16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.padding(end = 16.dp, top = 16.dp).align(End),
                    horizontalArrangement = Arrangement.End
                ) {
                    CustomChip(
                        text = "C",
                        isSelected = state.isSelectedTemperatureInCelsius,
                        onClick = onClickTemperatureType
                    )
                    CustomChip(
                        text = "F",
                        isSelected = !state.isSelectedTemperatureInCelsius,
                        onClick = onClickTemperatureType
                    )
                }
                Image(
                    painter = painterResource(getImageAccordingToTemperature()),
                    contentDescription = "Weather Picture",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(256.dp)
                        .padding(end = 32.dp)
                        .align(End)
                        .offset { IntOffset(0, animateOffset.value.toInt()) }
                )
            }
        }
    }
}

private val getImageAccordingToTemperature = {
    val imagePath = when {
        !isNight() -> "image/sun_icon.jpg"
        else -> "image/moon.png"
    }

    imagePath
}

fun calculateRainProbability(cloudCoverPercentage: Int): String {
    return when (cloudCoverPercentage) {
        in 0..10 -> "No rains"
        in 11..30 -> "Light rains"
        in 31..70 -> "Moderate rains"
        in 71..90 -> "Heavy rains"
        in 91..100 -> "Very heavy rains"
        else -> "Unknown"
    }
}