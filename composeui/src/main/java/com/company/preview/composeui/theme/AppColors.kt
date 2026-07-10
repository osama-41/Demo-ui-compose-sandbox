package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class AppColors (
    val primary: Color,
    val onPrimary: Color,
    val white: Color,
    val black: Color,
    val surface: Color,
    val secondaryText: Color,
    val greyOutlined: Color,
    val greenSuccess:Color,
    val mediumGray: Color,
    val completedGreen: Color,
    val background: Color,
    val priceHighlight: Color,
    val accent: Color,
    val cardBorder: Color
    val neutralSurface: Color,
    val neutralText: Color
)

private val lightColors = AppColors(
    primary = Color(0xFF27272A),
    onPrimary = Color(0xFFD2D0D0),
    white = Color(0xFFFFFFFF),
    surface = Color(0xFFF4F4F5),
    black = Color(0xFF111111),
    secondaryText = Color(0xFF6B6B6B),
    greyOutlined = Color(0xFFDCDBDB),
    greenSuccess = Color(0xFF16A34A),
    mediumGray = Color(0xFFA1A1AA),
    completedGreen = Color(0xFF22C55E),
    background = Color(0xFFFAFAFA),
    priceHighlight = Color(0xFFFF3D57),
    accent = Color(0xFF12C7C7),
    cardBorder = Color(0xFFEDEDED)
    neutralSurface = Color(0xFFF5F6F8),
    neutralText = Color(0xFF8D8D8D)
)


val localColors= staticCompositionLocalOf { lightColors }
