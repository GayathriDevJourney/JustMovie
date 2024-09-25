package org.gvb.justmovie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform