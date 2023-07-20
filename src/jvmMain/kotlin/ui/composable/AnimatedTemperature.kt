package ui.composable

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import ui.viewmodel.WeatherUiState

@Composable
fun AnimatedTemperature(state: WeatherUiState, temperature: Int): State<Int> {
    return animateIntAsState(
        targetValue = if (state.isSelectedTemperatureInCelsius) temperature else (temperature * 1.8).toInt() + 32,
        animationSpec = tween(durationMillis = 3000)
    )
}