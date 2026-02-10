package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.company.preview.composeui.R

@Immutable
data class AppIcons(
     val taskPickup: Int,
     val location: Int,
     val start: Int
     val timerFlash: Int,
)

private val defaultIcons= AppIcons(
    taskPickup = R.drawable.ic_task_pick,
    location = R.drawable.ic_location,
    start =R.drawable.ic_start,
   timerFlash = R.drawable.ic_timer_flash
)
val localIcons = staticCompositionLocalOf { defaultIcons }
