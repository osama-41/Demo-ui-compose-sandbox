package com.company.preview.composeui.order_summary.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal object SectionHeaderDividerTheme {

    object Sizes {
        val lineThickness: Dp = 1.dp
    }

    object Spacing {
        val titleHorizontalPadding: Dp = 12.dp
    }

    object Typography {
        @Composable fun title(): TextStyle = MaterialTheme.typography.bodyMedium
    }

    object Colors {
        @Composable fun line(): Color = MaterialTheme.colorScheme.outlineVariant
        @Composable fun title(): Color = Color(0xFF707079)
    }
}
