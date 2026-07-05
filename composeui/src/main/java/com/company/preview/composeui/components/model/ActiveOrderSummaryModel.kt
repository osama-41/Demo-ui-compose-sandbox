package com.company.preview.composeui.components.model

import com.company.preview.composeui.components.enums.OrderScreenIcons

data class ActiveOrderSummaryModel(
    val completed: Int,
    val total: Int,
    val timeText: String,
    val icon: OrderScreenIcons,
    val progressSubtitleText: String,
    val timerLabelText: String,
)
