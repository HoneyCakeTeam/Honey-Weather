import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

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
                        onClick = onCloseRequest,
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = onConfirmClose,
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Exit")
                    }
                }
            }
        }
    }
}
