package org.gvb.justmovie.network

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val dates: DatesModel? = null,
    val page: Int = 0,
    val results: List<Movie> = emptyList(),
    val total_pages: Int = 0,
    val total_results: Int = 0,
)

@Serializable
data class DatesModel(
    val maximum: String,
    val minimum: String
)

@Serializable
data class Movie(
    val id: Int = 0,
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: Array<Int> = emptyArray(),
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Float = 0.0F,
    val vote_count: Int = 0
)