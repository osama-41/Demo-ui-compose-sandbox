package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors (
    val primary: Color,
    val onPrimary: Color,
    val background: Color,
    val surface: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val success: Color,
    val disabled: Color,
    val outline: Color
)
private val lightColors= AppColors(
    primary = Color(0xFF27272A),
    onPrimary = Color(0xFFFFFFFF),
    background = Color(0xFFF4F4F5),
    surface = Color(0xFFFFFFFF),
    textPrimary = Color(0xFF111111),
    textSecondary = Color(0xFF6B6B6B),
    success = Color(0xFF16A34A),
    disabled = Color(0xFFBDBDBD),
    outline = Color(0xFFE6E6E6)
)
val localColors= staticCompositionLocalOf { lightColors }