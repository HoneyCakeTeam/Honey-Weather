package ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomHorizontalDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp),
        color = Color.LightGray
    )
}