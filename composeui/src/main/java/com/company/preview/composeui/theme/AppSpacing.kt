package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppSpacing(
    val buttonBorderSize: Dp=1.dp,
    val cardBorderSize: Dp = 2.dp,
    val buttonHeight: Dp = 56.dp,
    val iconSize: Dp = 30.dp,
    val indicatorWidth: Dp = 50.dp,
    val indicatorHeight: Dp = 6.dp,

    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 16.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp,
    val x3l:Dp=36.dp,

    val radiusXs: Dp = 6.dp,
    val radiusSm: Dp = 10.dp,
    val radiusMd: Dp = 12.dp,
    val radiusCard: Dp = 16.dp,
    val radiusPill: Dp = 999.dp,

    val elevationNone: Dp = 0.dp,
    val elevationSm: Dp = 1.dp,
    val elevationMd: Dp = 3.dp,
    val elevationCard: Dp = 4.dp

)

val localSpacing = staticCompositionLocalOf { AppSpacing() }