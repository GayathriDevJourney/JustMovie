package org.gvb.justmovie

interface TileStyle {
    val platform: String
    val size: TileSize
    val itemsPerRow: Int
}

enum class TileSize {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE
}

expect fun getTileStyle(): TileStyle
