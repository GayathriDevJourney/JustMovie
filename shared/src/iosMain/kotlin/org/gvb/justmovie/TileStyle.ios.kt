package org.gvb.justmovie

class IOSTileStyle : TileStyle {
    override val platform: String
        get() = "IOS"
    override val size: TileSize
        get() = TileSize.SMALL
    override val itemsPerRow: Int
        get() = 2

}

actual fun getTileStyle(): TileStyle = IOSTileStyle()