package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppElevation(
    val none: Dp=0.dp,
    val sm: Dp=1.dp,
    val md: Dp=3.dp,
    val card: Dp=4.dp
)
val localElevation= staticCompositionLocalOf { AppElevation() }