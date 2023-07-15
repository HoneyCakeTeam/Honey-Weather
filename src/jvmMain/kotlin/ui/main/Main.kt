package ui.main

import CloseConfirmationDialog
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import di.appModules
import org.koin.core.context.startKoin


fun main() = application {
    val windowState = rememberWindowState()
    var isOpen by remember { mutableStateOf(true) }
    var isAskingToClose by remember { mutableStateOf(false) }

    startKoin {
        modules(appModules)
    }
    /*install(Koin) {
        slf4jLogger()
        modules(appModules)
    }*/

    if (isOpen) {
        Window(
            onCloseRequest = { isAskingToClose = true },
            state = windowState,
            title = "Honey Weather"
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                CloseConfirmationDialog(
                    isAskingToClose = isAskingToClose,
                    onCloseRequest = { isAskingToClose = false },
                    onConfirmClose = { isOpen = false }
                )
                MainScreen()
            }
        }
    }
}
