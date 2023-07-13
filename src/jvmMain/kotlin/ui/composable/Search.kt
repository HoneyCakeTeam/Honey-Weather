package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.CardColor
import ui.theme.Typography

@Composable
fun search() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(300.dp),
        modifier = Modifier.padding(start = 16.dp, top = 16.dp).background(
            CardColor, shape = RoundedCornerShape(24)
        )
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,

                )
            Text(
                text = "Search something here",
                style = Typography.h3,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}