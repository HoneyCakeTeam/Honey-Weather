import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ui.theme.DarkBlue

@Composable
fun CloseConfirmationDialog(
    isAskingToClose: Boolean,
    onCloseRequest: () -> Unit,
    onConfirmClose: () -> Unit
) {
    if (isAskingToClose) {
        Dialog(
            onCloseRequest = onCloseRequest,
            title = "Are you sure to close the app 🙂?",
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp)
            ) {
                Box(modifier = Modifier.weight(4F)) {
                    Image(
                        painterResource("image/smiling_face.png"),
                        contentDescription = "Dialogue Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }
                Row(
                    modifier = Modifier.fillMaxSize().weight(3F),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    OutlinedButton(
                        border = BorderStroke(
                            width = 1.dp,
                            color = DarkBlue
                        ),
                        onClick = onCloseRequest,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Cancel", color = DarkBlue)
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(DarkBlue),
                        onClick = onConfirmClose,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Exit", color = Color.White)
                    }
                }
            }
        }
    }
}
