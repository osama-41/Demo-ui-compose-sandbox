package com.company.preview.composeui.components.model

import androidx.compose.runtime.Immutable
import com.company.preview.composeui.components.enums.OrderScreenIcons

    @Immutable
    data class ActiveOrderTaskCompactCardModel(
        val title: String,
        val current: Int,
        val total: Int,
        val icon: OrderScreenIcons,
        val orderNumber: String? = null
)