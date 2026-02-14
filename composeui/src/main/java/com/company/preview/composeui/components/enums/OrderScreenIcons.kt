package com.company.preview.composeui.components.enums

import androidx.annotation.DrawableRes
import com.company.preview.composeui.R


enum class OrderScreenIcons(@DrawableRes val resId: Int) {
    TimerFlash(R.drawable.ic_timer_flash),
    TaskPickup(R.drawable.ic_task_pick),
    Location(R.drawable.ic_location),
    Start(R.drawable.ic_start)
}
