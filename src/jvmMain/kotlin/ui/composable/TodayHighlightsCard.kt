package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.theme.Typography
import ui.utils.getWeatherIconResource


@Composable
fun TodayHighlightsCard(
    modifier: Modifier = Modifier,
    header: String,
    subHeader: String,
    value: String,
    imagePath: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(all = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxSize().weight(1F),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = header, style = Typography.caption)
                Text(text = subHeader, style = Typography.h2)
                Text(text = value, style = Typography.h2)
            }
            Column(
                modifier = Modifier.fillMaxSize().weight(1F),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(resourcePath = imagePath),
                    contentDescription = "Weather icon",
                    modifier = Modifier.size(84.dp)
                )
            }
        }
    }
}