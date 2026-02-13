package com.company.preview.composeui.components.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.company.preview.composeui.components.enums.OrderScreenIcons


data class AppButtonModel(
    val text: String,
    val enabled: Boolean = true,

    val height: Dp,
    val radius: Dp,
    val contentPadding: PaddingValues,

    val containerColor: Color,
    val contentColor: Color,

    val border: BorderStroke? = null,
    val elevation: AppButtonElevationModel,

    val icon: OrderScreenIcons? = null,
    val iconSize: Dp,
    val iconTint: Color,
    val contentDescription: String? = null,
    val textStyle: TextStyle
)
data class AppButtonElevationModel(
    val defaultElevation: Dp = Dp.Unspecified,
    val pressedElevation: Dp = Dp.Unspecified,
    val disabledElevation: Dp = Dp.Unspecified
)
