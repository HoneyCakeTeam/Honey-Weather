package ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.koin.java.KoinJavaComponent.inject
import ui.composable.BodyContent
import ui.composable.CustomVericalDivider
import ui.composable.LoadingAnimation
import ui.composable.SideBar
import ui.viewmodel.WeatherUiState
import ui.viewmodel.WeatherViewModel

@Composable
fun HomeScreen() {
    val weatherViewModel: WeatherViewModel by inject(WeatherViewModel::class.java)
    val state by weatherViewModel.weatherUiState.collectAsState()

    HomeContent(
        state = state,
        onClickTemperatureType = weatherViewModel::toggleTemperatureType
    )
}

@Composable
fun HomeContent(
    state: WeatherUiState,
    onClickTemperatureType: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource("image/photo_2.jpg"),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().blur(16.dp),
            contentScale = ContentScale.Crop
        )
        AnimatedVisibility(
            visible = !state.isLoading,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideInHorizontally(),
            exit = fadeOut(animationSpec = tween(durationMillis = 1000)) + slideOutHorizontally()
        ) {
            Row {
                SideBar(state)
                CustomVericalDivider()
                BodyContent(state, onClickTemperatureType)
            }
        }
        AnimatedVisibility(
            visible = state.isLoading,
            enter = fadeIn(animationSpec = tween(durationMillis = 500)),
            exit = fadeOut(animationSpec = tween(durationMillis = 500))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LoadingAnimation(circleColor = Color.White)
            }
        }
    }
}