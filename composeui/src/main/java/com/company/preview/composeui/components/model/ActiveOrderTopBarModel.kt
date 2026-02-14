package com.company.preview.composeui.components.model

import androidx.compose.runtime.Immutable

@Immutable
data class ActiveOrderTopBarModel(
    val title: String,
    val isSupportVisible: Boolean,
)