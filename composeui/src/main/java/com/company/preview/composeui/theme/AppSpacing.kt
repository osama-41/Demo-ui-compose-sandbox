package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppSpacing(
    val borderSize: Dp=1.dp,
    val buttonHeight:Dp=56.dp,
    val iconSize:Dp=20.dp,
    val indicatorWidth:Dp=44.dp,
    val indicatorHeight:Dp=6.dp,
    val xs: Dp=4.dp,
    val sm: Dp=8.dp,
    val md: Dp=12.dp,
    val lg: Dp=16.dp,
    val xl: Dp=24.dp,
    val xxl: Dp=32.dp
)

val localSpacing = staticCompositionLocalOf { AppSpacing() }