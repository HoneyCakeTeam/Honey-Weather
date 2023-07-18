package ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Color.White
    ),
    h2 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color.White
    ),
    h3 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.White,
    ),
    body1 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.White
    ),
    body2 = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = Robot,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.White
    ),
)