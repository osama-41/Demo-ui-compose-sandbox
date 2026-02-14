package com.company.preview.composeui.components.model

import androidx.compose.runtime.Immutable

@Immutable
data class ActiveOrderTaskStackModel(
    val first: ActiveOrderTaskCompactCardModel,
    val second: ActiveOrderTaskCompactCardModel
)
