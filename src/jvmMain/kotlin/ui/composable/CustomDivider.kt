package ui.composable

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider() {
    Divider(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
    )
}