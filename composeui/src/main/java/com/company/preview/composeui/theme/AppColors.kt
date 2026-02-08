package com.company.preview.composeui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColors(
    val primary: Color,
    val white: Color,
    val surface: Color,
    val onSurface: Color,
    val greyOutlined: Color,
    val trackGray: Color,
    val labelGray: Color,
    val mediumGray: Color,
    val completedGreen: Color,
)
val DefaultAppColors = AppColors(
    primary = Color(0xFF111111),
    white = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF111111),
    greyOutlined = Color(0xFFE5E5EA),
    labelGray = Color(0xFF707079),
    trackGray = Color(0xFFD4D4D8),
    mediumGray = Color(0xFFA1A1AA),
    completedGreen = Color(0xFF22C55E),
)
val LocalColors = staticCompositionLocalOf { DefaultAppColors }