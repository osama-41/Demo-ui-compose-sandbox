package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class AppColors (
    val primary: Color,
    val secondary: Color,
    val white: Color,
    val black: Color,
    val surface: Color,
    val secondaryText: Color,
    val greyOutlined: Color,
    val disabled: Color,
    val greenSuccess:Color,
    val trackGray: Color,
    val labelGray: Color,
    val mediumGray: Color,
    val completedGreen: Color,
)

// Osama
val DefaultAppColors = AppColors(
    primary = Color(0xFF111111),
    white = Color(0xFFFFFFFF),
    greyOutlined = Color(0xFFE5E5EA),
    labelGray = Color(0xFF707079),
    trackGray = Color(0xFFD4D4D8),
    mediumGray = Color(0xFFA1A1AA),
    completedGreen = Color(0xFF22C55E),
)
val LocalColors = staticCompositionLocalOf { DefaultAppColors }

//Lutfi
private val lightColors = AppColors(
    primary = Color(0xFF27272A),
    secondary = Color(0xFFD2D0D0),
    white = Color(0xFFFFFFFF),
    surface = Color(0xFFF4F4F5),
    black = Color(0xFF111111),
    secondaryText = Color(0xFF6B6B6B),
    greyOutlined = Color(0xFFDCDBDB),
    greenSuccess = Color(0xFF16A34A),
    disabled = Color(0xFFBDBDBD),
    )

val localColors= staticCompositionLocalOf { lightColors }
