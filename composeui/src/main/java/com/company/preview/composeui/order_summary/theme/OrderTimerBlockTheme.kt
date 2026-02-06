package com.company.preview.composeui.order_summary.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object OrderTimerBlockTheme {

    object Sizes {
        val icon: Dp = 16.dp
    }

    object Spacing {
        val betweenTimeAndLabelRow: Dp = 4.dp
        val betweenIconAndLabel: Dp = 6.dp
    }

    object Typography {
        @Composable
        fun time(): TextStyle =
            MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)

        @Composable
        fun label(): TextStyle =
            MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
    }

    object Colors {
        @Composable fun time(): Color = MaterialTheme.colorScheme.onSurface
        @Composable fun label(): Color = Color(0xFF707079)
        @Composable fun icon(): Color = label()
    }

}
