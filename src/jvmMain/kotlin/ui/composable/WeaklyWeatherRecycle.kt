package ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Black37
import ui.theme.Black60
import ui.theme.Black87
import ui.theme.Typography


@Composable
fun WeaklyWeatherRecycle()  {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 32.dp),
    ){
        items (20){ position ->


            Row(modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column() {
                    Text(text = "Tomorrow", style = Typography.h3)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "12 Apr", color = Black37, fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "16", style = Typography.h2)
                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource("image/smiling_face.png"),
                    contentDescription = "weather pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                )

            }



        }
    }
}