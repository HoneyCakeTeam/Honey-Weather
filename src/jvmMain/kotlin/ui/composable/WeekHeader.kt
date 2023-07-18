package ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Black60
import ui.theme.Black87
import ui.theme.Typography

@Composable
fun WeekHeader() {

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            imageVector = Icons.Outlined.ArrowLeft,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = White
        )

        Text(text = "This Week", color = White, style = Typography.h2.copy(fontSize = 20.sp))

        Icon(
            imageVector = Icons.Outlined.ArrowRight,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = White
        )
    }
}