package org.gvb.justmovie.screen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.gvb.justmovie.getPlatform
import org.gvb.justmovie.getTileStyle
import org.gvb.justmovie.network.KtorClient
import org.gvb.justmovie.network.MovieResponse

@Composable
fun MovieListScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClick: (movie: String) -> Unit = {}
) {
    val jsonData = remember { mutableStateOf<MovieResponse?>(null) }
    LaunchedEffect("") {
        val data = KtorClient().getMovieData()
        println("data $data")
        jsonData.value = data
    }
    Column {
//        Text("This is a movie list screen ${getPlatform().name}")
        MovieListGrid(jsonData.value, onClick)
    }
}

@Composable
fun MovieList(jsonData: MovieResponse?, onClick: (movie: String) -> Unit) {
    val tileStyle = getTileStyle()
    jsonData?.results?.let { movieResult ->
        LazyColumn {
            items(movieResult) { movie ->
                Text(movie.title, modifier = Modifier.clickable { onClick(movie.title) })
            }
        }
    }
}

@Composable
fun MovieListGrid(jsonData: MovieResponse?, onClick: (movie: String) -> Unit) {
    val tileStyle = getTileStyle()
    jsonData?.results?.let { movieResult ->
        Box(
            modifier = Modifier.fillMaxSize().background(Color.LightGray)
        ) {
            val listState = rememberLazyGridState()
            LazyVerticalGrid(
                state = listState, columns = GridCells.Fixed(tileStyle.itemsPerRow)
            ) {
                items(movieResult) { movie ->
                    Card(
                        backgroundColor = Color.Green,
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        AsyncImage(
                            modifier = Modifier.wrapContentSize().clickable { onClick(movie.title) },
                            model = "https://image.tmdb.org/t/p/w500/${movie.poster_path}",
                            contentDescription = "Translated description of what the image contains"
                        )
//                        Text(
//                            movie.title,
//                            modifier = Modifier.padding(10.dp).clickable { onClick(movie.title) })
                    }
                }
            }
        }
    }
}
