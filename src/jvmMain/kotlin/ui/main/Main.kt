package ui.main

import CloseConfirmationDialog
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    var isOpen by remember { mutableStateOf(true) }
    var isAskingToClose by remember { mutableStateOf(false) }

    if (isOpen) {
        Window(onCloseRequest = { isAskingToClose = true }, title = "Honey Weather") {
            CloseConfirmationDialog(
                isAskingToClose = isAskingToClose,
                onCloseRequest = { isAskingToClose = false },
                onConfirmClose = { isOpen = false }
            )
            MainScreen()
        }
    }
}
