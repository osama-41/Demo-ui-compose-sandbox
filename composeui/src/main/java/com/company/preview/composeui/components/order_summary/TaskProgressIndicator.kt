package com.company.preview.composeui.components.order_summary

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

@Composable
fun TaskProgressIndicator(
    completed: Int,
    total: Int,
    subtitleText: String,
    modifier: Modifier = Modifier
) {
    val safeTotal = max(total, 1)
    val safeCompleted = completed.coerceIn(0, safeTotal)

    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

    val numberFormat = remember(isRtl) {
        if (isRtl) NumberFormat.getInstance(Locale("ar"))
        else NumberFormat.getInstance(Locale.ENGLISH)
    }

    val centerText = remember(safeCompleted, safeTotal, isRtl) {
        val c = numberFormat.format(safeCompleted)
        val t = numberFormat.format(safeTotal)
        if (isRtl) "$c من $t" else "$c of $t"
    }

    Box(
        modifier = modifier.size(Theme.spacing.ringSizeLg),
        contentAlignment = Alignment.Center
    ) {
        SegmentedRing(
            completed = safeCompleted,
            total = safeTotal
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = centerText,
                style = Theme.typography.titleSmallExtraBold,
                textAlign = TextAlign.Center,
                color = Theme.colors.primary,
                lineHeight = Theme.typography.titleSmallExtraBold.fontSize
            )
            Spacer(Modifier.height(Theme.spacing.xxs))
            Text(
                text = subtitleText,
                style = Theme.typography.labelSmallCompactLineHeight,
                textAlign = TextAlign.Center,
                color = Theme.colors.labelGray
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
    val ringSize = Theme.spacing.ringSizeLg
    val baseStroke = Theme.spacing.ringStroke

    val trackColor = Theme.colors.trackGray
    val currentColor = Theme.colors.primary
    val completedColor = Theme.colors.completedGreen

    Canvas(modifier = modifier.size(ringSize)) {
        val safeTotal = max(total, 1)
        val currentIndex = (completed - 1).coerceIn(0, safeTotal - 1)
        val segmentAngle = 360f / safeTotal

        for (i in 0 until safeTotal) {
            val color = when {
                completed <= 0 -> trackColor
                i < currentIndex -> completedColor
                i == currentIndex -> currentColor
                else -> trackColor
            }

            if (safeTotal >= 19) {
                val radialHeight = baseStroke.toPx() * 0.5f
                val angularWidth = when {
                    safeTotal >= 25 -> baseStroke.toPx() * 0.65f
                    else -> baseStroke.toPx() * 0.85f
                }

                val angleRad = Math.toRadians((-90f + i * segmentAngle).toDouble())
                val cosA = cos(angleRad).toFloat()
                val sinA = sin(angleRad).toFloat()

                val center = Offset(size.width / 2, size.height / 2)
                val outerRadius = size.minDimension / 2 - angularWidth / 2
                val innerRadius = outerRadius - radialHeight

                val start = center + Offset(cosA * innerRadius, sinA * innerRadius)
                val end = center + Offset(cosA * outerRadius, sinA * outerRadius)

                drawLine(
                    color = color,
                    start = start,
                    end = end,
                    strokeWidth = angularWidth,
                    cap = StrokeCap.Round
                )
            } else {
                val strokePx = baseStroke.toPx() * 1f
                val stroke = Stroke(width = strokePx, cap = StrokeCap.Round)

                val inset = stroke.width / 2f
                val arcSize = Size(size.width - inset * 2, size.height - inset * 2)
                val topLeft = Offset(inset, inset)

                val radiusPx = arcSize.minDimension / 2f
                val capExtDeg = (strokePx / (2 * radiusPx)) * (180f / Math.PI.toFloat())

                val targetRatio = 0.95f
                val sweepDeg = (segmentAngle * targetRatio - 2 * capExtDeg).coerceAtLeast(0.1f)
                val startAngle = -90f + i * segmentAngle + (segmentAngle - sweepDeg) / 2f

                drawArc(
                    color = color,
                    startAngle = startAngle,
                    sweepAngle = sweepDeg,
                    useCenter = false,
                    topLeft = topLeft,
                    size = arcSize,
                    style = stroke
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TaskProgressIndicator_PhotoCases_Preview() {
    val locale = Locale.ENGLISH
    LtrPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.xxl),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TaskProgressIndicator(12, 30, "Tasks")
            TaskProgressIndicator(4, 7, "Tasks")
            TaskProgressIndicator(0, 10, "Tasks")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskProgressIndicator_PhotoCases_Preview_Rtl() {
    val locale = Locale("ar")
    RtlPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.xxl),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TaskProgressIndicator(12, 30, "Tasks")
            TaskProgressIndicator(4, 7,  "Tasks")
            TaskProgressIndicator(0, 10, "Tasks")
        }
    }
}