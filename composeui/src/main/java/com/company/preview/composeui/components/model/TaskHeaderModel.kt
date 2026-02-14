package com.company.preview.composeui.components.model

import com.company.preview.composeui.components.enums.OrderScreenIcons

data class TaskHeaderModel(
    val icon: OrderScreenIcons,
    val title: String,
    val progressText: String,
    val timerText: String,
    val progress: Float,
)
