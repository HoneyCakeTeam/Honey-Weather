package ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Black87
    ),

    h2 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = Black60
    ),

    h3 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Black37,
    )
)