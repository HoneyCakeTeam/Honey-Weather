import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.theme.Typography

@Composable
@Preview
fun App() {

    MaterialTheme {
        Column {
            Text(text = "TEXT1", style = Typography.h1.copy(color = Color.Cyan))
            Text(text = "TEXT2", style = Typography.h2)
            Text(text = "TEXT3", style = Typography.h3)
            Text(text = "TEXT4")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
