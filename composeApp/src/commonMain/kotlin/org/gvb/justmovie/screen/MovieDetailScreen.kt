package org.gvb.justmovie.screen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieDetailScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    goBack: () -> Unit,
) {
    Column {
        Icon(
            Icons.Rounded.ArrowBack,
            contentDescription = "BackPress",
            modifier = Modifier.clickable {
                goBack()
            }
        )
        Text("This is a movie detail screen")
    }
}
