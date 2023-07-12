package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Typography

@Composable
fun mainCard() {

    Card(
        modifier = Modifier.height(300.dp).width(500.dp).padding(top = 16.dp, start = 16.dp), elevation = 0.dp
    ) {
        Box() {
            Image(
                painterResource("image/image.jpg"),
                contentDescription = null,
                modifier = Modifier.height(300.dp).width(500.dp).alpha(0.5f),
                contentScale = ContentScale.Crop
            )
            Column() {
                Row() {
                    Row {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                        )
                        Text(
                            text = "Gotham",
                            style = Typography.h2,
                            modifier = Modifier.padding(start = 4.dp, top = 16.dp).align(
                                Alignment.CenterVertically,
                            )
                        )
                    }
                    Text(
                        text = "Today00:32PM",
                        style = Typography.h3,
                        modifier = Modifier.padding(top = 16.dp, start = 200.dp).align(Alignment.CenterVertically)
                    )
                }

                Text(
                    text = "12", style = Typography.h1.copy(fontSize = 100.sp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Mostly Clear", style = Typography.h3,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(150.dp),
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp)
                ) {
                    Row() {
//                    Icon(imageVector = Icons.Outlined.Winds, contentDescription = null)
                        Text(text = "728hpa")

                    }
                    Row() {
//                    Icon(imageVector = Icons.Outlined.Moisture, contentDescription = null)
                        Text(text = "32%")

                    }
                    Row() {
//                    Icon(imageVector = Icons.Outlined.Winds, contentDescription = null)
                        Text(text = "12km/h")

                    }
                }

            }
        }
    }
}