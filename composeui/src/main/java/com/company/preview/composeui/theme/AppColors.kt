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
    val mediumGray: Color,
    val completedGreen: Color,
    val backGround: Color
)

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
    mediumGray = Color(0xFFA1A1AA),
    completedGreen = Color(0xFF22C55E),
    backGround = Color(0xFFFAFAFA)
    )

val localColors= staticCompositionLocalOf { lightColors }
