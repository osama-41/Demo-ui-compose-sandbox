package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppRadius(
    val xs: Dp=6.dp,
    val sm: Dp=10.dp,
    val md: Dp=12.dp,
    val card: Dp=16.dp,
    val pill: Dp=999.dp
)
val localRadius= staticCompositionLocalOf { AppRadius() }
