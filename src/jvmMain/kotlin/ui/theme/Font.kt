package ui.theme


import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import java.io.File

val Robot = FontFamily(
    Font(File("font/Roboto-Bold.ttf"), FontWeight.Bold),
    Font(File("font/Roboto-Regular.ttf"), FontWeight.Normal),
    Font(File("font/Roboto-Medium.ttf"), FontWeight.Medium)
)

