package com.company.preview.composeui.order_summary.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object ActiveOrderSummaryCardTheme {

    object Padding {
        val horizontal: Dp = 16.dp
        val vertical: Dp = 14.dp
    }

    object Sizes {
        val borderWidth: Dp = 1.dp
        val dividerWidth: Dp = 1.dp
        val dividerHeight: Dp = 16.dp
    }

    object Shapes {
        val cornerRadius: Dp = 16.dp
        val card = RoundedCornerShape(cornerRadius)
    }

    object Colors {
        @Composable fun background(): Color = Color.White
        @Composable fun border(): Color = MaterialTheme.colorScheme.outlineVariant
        @Composable fun divider(): Color = MaterialTheme.colorScheme.outlineVariant
    }
}
