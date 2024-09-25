package org.gvb.justmovie

class AndroidTileStyle : TileStyle {
    override val platform: String
        get() = "Java"
    override val size: TileSize
        get() = TileSize.SMALL
    override val itemsPerRow: Int
        get() = 2

}

actual fun getTileStyle(): TileStyle = AndroidTileStyle()