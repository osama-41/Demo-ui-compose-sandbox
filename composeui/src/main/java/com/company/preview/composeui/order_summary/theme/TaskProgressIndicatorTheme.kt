package com.company.preview.composeui.order_summary.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal object TaskProgressIndicatorTheme {

    object Sizes {
        val ring: Dp = 64.dp
        val strokeWidth: Dp = 6.dp
    }

    object Spacing {
        val textInsideRing: Dp = 1.dp
    }

    object Ring {
        val segmentGapAngle: Float = 20f
        val strokeCap: StrokeCap = StrokeCap.Round
    }

    object Typography {
        @Composable
        fun centerTitle(): TextStyle =
            MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)

        @Composable
        fun centerSubtitle(): TextStyle =
            MaterialTheme.typography.labelSmall.copy(
                fontSize = 9.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Medium
            )
    }

    object Colors {
        @Composable fun track(): Color = Color(0xFFD4D4D8)
        @Composable fun progress(): Color = MaterialTheme.colorScheme.onSurface
        @Composable fun centerTitle(): Color = MaterialTheme.colorScheme.onSurface
        @Composable fun centerSubtitle(): Color = Color(0xFF707079)
    }
}
