package ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomChip(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.padding(end = 8.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) White else Transparent,
        border = if (isSelected) BorderStroke(
            width = 0.dp,
            color = Transparent
        ) else BorderStroke(
            width = 2.dp,
            color = LightGray
        )
    ) {
        Row(
            modifier = Modifier.clickable { onClick() }
        ) {
            Text(
                text = "°$text",
                style = MaterialTheme.typography.body2,
                color = if (isSelected) Black else White,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}