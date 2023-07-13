package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.BackgroundColor

@Composable
fun BodyContent() {
    Column(modifier = Modifier.fillMaxHeight().padding(16.dp).background(BackgroundColor)) {
        SearchBar(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        MainCard()
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(3) {
                TodayHighlightsCard(modifier = Modifier.weight(1F))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(3) {
                TodayHighlightsCard(modifier = Modifier.weight(1F))
            }
        }
    }
}