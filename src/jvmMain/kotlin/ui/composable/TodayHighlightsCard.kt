package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.theme.CardBackgroundColor
import ui.theme.Typography


@Composable
fun TodayHighlightsCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color =  Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(all = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Rain Chance", style = Typography.h2)
            Text(text = "Today Rain Chance", style = Typography.caption)
            Text(text = "24%", style = Typography.h2)
        }
    }
}