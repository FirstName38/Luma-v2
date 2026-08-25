package com.luma.focus.wallpapers

enum class Wallpaper {
    FOREST,
    RAIN,
    OCEAN,
    NIGHT_SKY,
    LIBRARY,
    CAFE,
    STUDY_DESK,
    MINIMAL_ABSTRACT,
    CUTE_CARTOON,
    SOFT_NATURE,
    DEEP_FOCUS,
    SEASONAL
}

data class WallpaperData(
    val id: Wallpaper,
    val name: String,
    val description: String,
    val emoji: String
)

val WALLPAPERS = listOf(
    WallpaperData(
        Wallpaper.FOREST,
        "Forest",
        "Calm forest with trees and natural sounds",
        "🌲"
    ),
    WallpaperData(
        Wallpaper.RAIN,
        "Rain",
        "Rainy window with cozy vibes",
        "🌧️"
    ),
    WallpaperData(
        Wallpaper.OCEAN,
        "Ocean",
        "Peaceful ocean waves",
        "🌊"
    ),
    WallpaperData(
        Wallpaper.NIGHT_SKY,
        "Night Sky",
        "Starry night for deep focus",
        "🌙"
    ),
    WallpaperData(
        Wallpaper.LIBRARY,
        "Library",
        "Quiet study library",
        "📚"
    ),
    WallpaperData(
        Wallpaper.CAFE,
        "Café",
        "Cozy coffee shop ambiance",
        "☕"
    )
)
