package org.gvb.justmovie

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "JustMovie",
    ) {
        App()
    }
}