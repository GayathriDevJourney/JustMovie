package org.gvb.justmovie

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.gvb.justmovie.data.ScreenName
import org.gvb.justmovie.screen.MovieDetailScreen
import org.gvb.justmovie.screen.MovieListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Scaffold(topBar = {
            TopAppBar(title = { Text("Just Movie") })
        }) {
            AnimatedVisibility(visible = true) {
                NavHostLayout(navController)
            }
        }
    }
}

@Composable
fun NavHostLayout(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenName.MovieList.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = ScreenName.MovieList.name) {
            MovieListScreen(animatedVisibilityScope = this, onClick = { movie ->
                navController.navigate(ScreenName.MovieDetails.name)
            })
        }
        composable(route = ScreenName.MovieDetails.name) {
            MovieDetailScreen(
                animatedVisibilityScope = this,
                goBack = { navController.popBackStack() })
        }
    }
}

