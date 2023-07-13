package ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.composable.MainCard
import ui.composable.SearchBar

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize().weight(1F).padding(16.dp)) {
            SearchBar(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            MainCard()
        }
    }
}