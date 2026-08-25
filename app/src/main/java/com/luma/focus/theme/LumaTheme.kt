package com.luma.focus.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LumaLightColorScheme = lightColorScheme(
    primary = Color(0xFFD4956E),      // Warm peach
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFDCC4),
    onPrimaryContainer = Color(0xFF5C2F1A),
    secondary = Color(0xFF9B8B7E),   // Soft charcoal
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE8D7C9),
    onSecondaryContainer = Color(0xFF3A3230),
    tertiary = Color(0xFFB89B9B),    // Muted rose
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFDCDC),
    onTertiaryContainer = Color(0xFF4D3939),
    error = Color(0xFFD32F2F),
    onError = Color(0xFFFFFFFF),
    background = Color(0xFFFAF8F5),  // Warm cream
    onBackground = Color(0xFF1C1B19),
    surface = Color(0xFFFAF8F5),
    onSurface = Color(0xFF1C1B19),
    surfaceVariant = Color(0xFFE8DDD3),
    onSurfaceVariant = Color(0xFF5C5754)
)

private val LumaDarkColorScheme = darkColorScheme(
    primary = Color(0xFFE8B59F),
    onPrimary = Color(0xFF3C1E0A),
    primaryContainer = Color(0xFF5C3D2A),
    onPrimaryContainer = Color(0xFFFFDCC4),
    secondary = Color(0xFFC9B8AC),
    onSecondary = Color(0xFF252120),
    secondaryContainer = Color(0xFF3F3530),
    onSecondaryContainer = Color(0xFFE8D7C9),
    tertiary = Color(0xFFDCC2C2),
    onTertiary = Color(0xFF3A2626),
    tertiaryContainer = Color(0xFF523E3E),
    onTertiaryContainer = Color(0xFFFFDCDC),
    error = Color(0xFFFF7043),
    onError = Color(0xFF460000),
    background = Color(0xFF1C1B19),
    onBackground = Color(0xFFE7E1DB),
    surface = Color(0xFF1C1B19),
    onSurface = Color(0xFFE7E1DB),
    surfaceVariant = Color(0xFF5C5754),
    onSurfaceVariant = Color(0xFFC9C0B8)
)

@Composable
fun LumaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) LumaDarkColorScheme else LumaLightColorScheme
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = lumaTypography,
        shapes = lumaShapes,
        content = content
    )
}
