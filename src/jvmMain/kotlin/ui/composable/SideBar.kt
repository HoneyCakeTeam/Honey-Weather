package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.BackgroundColor
import ui.theme.DarkBlue

@Composable
fun SideBar() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(350.dp)
            .background(BackgroundColor)
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {

    }
}