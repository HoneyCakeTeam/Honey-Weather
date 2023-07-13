package ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Black60
import ui.theme.Black87
import ui.theme.Typography

@Composable
fun WeekHeader() {

    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {

        Icon(
            imageVector = Icons.Outlined.ArrowLeft,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
        )

        Text(text = "This Week", color = Black87, style = Typography.h2.copy(fontSize = 20.sp))

        Icon(
            imageVector = Icons.Outlined.ArrowRight,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize),
        )
//        Icon(
//            painter = painterResource("icon/smiling_face.png"),
//            contentDescription = null,
//            modifier = Modifier.size(16.dp).padding(top = 4.dp),
//        )

    }
}