package org.gvb.justmovie

class JVMTileStyle : TileStyle {
    override val platform: String
        get() = "Java"
    override val size: TileSize
        get() = TileSize.LARGE
    override val itemsPerRow: Int
        get() = 6

}

actual fun getTileStyle(): TileStyle = JVMTileStyle()
