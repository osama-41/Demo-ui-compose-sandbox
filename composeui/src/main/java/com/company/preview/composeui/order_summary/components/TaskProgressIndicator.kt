package com.company.preview.composeui.order_summary.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import com.company.preview.composeui.order_summary.theme.TaskProgressIndicatorTheme
import kotlin.math.max

@Composable
fun TaskProgressIndicator(
    completed: Int,
    total: Int,
    subtitleText: String,
    centerText: String,
    modifier: Modifier = Modifier
) {
    val theme = TaskProgressIndicatorTheme

    val safeTotal = max(total, 1)
    val safeCompleted = completed.coerceIn(0, safeTotal)


    Box(
        modifier = modifier.size(TaskProgressIndicatorTheme.Sizes.ring),
        contentAlignment = Alignment.Center
    ) {
        SegmentedRing(
            completed = safeCompleted,
            total = safeTotal
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = centerText,
                style = TaskProgressIndicatorTheme.Typography.centerTitle(),
                color = TaskProgressIndicatorTheme.Colors.centerTitle()
            )
            Spacer(modifier = Modifier.size(TaskProgressIndicatorTheme.Spacing.textInsideRing))
            Text(
                text = subtitleText,
                style = TaskProgressIndicatorTheme.Typography.centerSubtitle(),
                color = TaskProgressIndicatorTheme.Colors.centerSubtitle()
            )
        }
    }
}

@Composable
private fun SegmentedRing(
    completed: Int,
    total: Int,
    modifier: Modifier = Modifier
) {
    val theme = TaskProgressIndicatorTheme

    val trackColor = TaskProgressIndicatorTheme.Colors.track()
    val progressColor = TaskProgressIndicatorTheme.Colors.progress()

    Canvas(modifier = modifier.size(TaskProgressIndicatorTheme.Sizes.ring)) {
        val stroke = Stroke(
            width = TaskProgressIndicatorTheme.Sizes.strokeWidth.toPx(),
            cap = TaskProgressIndicatorTheme.Ring.strokeCap
        )

        val inset = stroke.width / 2f
        val arcSize = Size(size.width - inset * 2, size.height - inset * 2)
        val topLeft = Offset(inset, inset)

        val gap = TaskProgressIndicatorTheme.Ring.segmentGapAngle
        val safeTotal = max(total, 1)
        val segmentSweep = (360f - (gap * safeTotal)) / safeTotal

        val baseStart = -90f + (gap / 2f)

        for (i in 0 until safeTotal) {
            val start = baseStart + i * (segmentSweep + gap)
            val color = if (i < completed) progressColor else trackColor

            drawArc(
                color = color,
                startAngle = start,
                sweepAngle = segmentSweep,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = stroke
            )
        }
    }
}
