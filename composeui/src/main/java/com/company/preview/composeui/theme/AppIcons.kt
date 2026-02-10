package com.company.preview.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.company.preview.composeui.R

@Immutable
data class AppIcons(
     val taskPickup: Int,
     val location: Int,
     val start: Int,
     val timerFlash: Int,
     val accountCircle: Int,
     val arrowBack: Int,
     val headSet: Int,
     val store: Int
)

private val defaultIcons= AppIcons(
    taskPickup = R.drawable.ic_task_pick,
    location = R.drawable.ic_location,
    start =R.drawable.ic_start,
    timerFlash = R.drawable.ic_timer_flash,
    accountCircle = R.drawable.ic_account_circle,
    arrowBack = R.drawable.ic_arrow_back,
    headSet = R.drawable.ic_headset,
    store = R.drawable.ic_store
)
val localIcons = staticCompositionLocalOf { defaultIcons }
