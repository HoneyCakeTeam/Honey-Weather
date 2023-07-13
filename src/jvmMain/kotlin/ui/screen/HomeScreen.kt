package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.composable.BodyContent
import ui.composable.CustomDivider
import ui.composable.SideBar
import ui.theme.BackgroundColor

@Composable
fun HomeScreen() {

    Box(modifier = Modifier.fillMaxSize().background(color = BackgroundColor)) {
        Row {
            SideBar()
            CustomDivider()
            BodyContent()
        }
    }
}