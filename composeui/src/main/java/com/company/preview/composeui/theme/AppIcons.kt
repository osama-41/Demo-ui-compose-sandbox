package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.company.preview.composeui.R

@Immutable
data class AppIcons(
    val timerFlash: Int,
)
val DefaultIcons = AppIcons(
    timerFlash = R.drawable.ic_timer_flash,
)
val localIcons = staticCompositionLocalOf { DefaultIcons }
