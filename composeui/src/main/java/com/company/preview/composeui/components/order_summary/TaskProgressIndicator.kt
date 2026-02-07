package com.company.preview.composeui.components.order_summary

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.max

private const val SEGMENT_GAP_ANGLE: Float = 20f
private val SEGMENT_STROKE_CAP: StrokeCap = StrokeCap.Round

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

    // Arabic-Indic digits formatting when RTL
    val numberFormat = remember(isRtl) {
        if (isRtl) NumberFormat.getInstance(Locale("ar")) else NumberFormat.getInstance(Locale.ENGLISH)
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
                style = Theme.typography.titleSmallBold.copy(
                    textDirection = if (isRtl) TextDirection.Rtl else TextDirection.Ltr
                ),
                textAlign = TextAlign.Center,
                color = Theme.colors.primary
            )

            Text(
                text = subtitleText,
                style = Theme.typography.labelSmallCompact.copy(
                    textDirection = if (isRtl) TextDirection.Rtl else TextDirection.Ltr
                ),
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
    // Read tokens BEFORE Canvas (Canvas draw lambda is not composable)
    val ringSize = Theme.spacing.ringSizeLg
    val strokeWidth = Theme.spacing.ringStroke
    val trackColor = Theme.colors.trackGray
    val progressColor = Theme.colors.primary

    Canvas(modifier = modifier.size(ringSize)) {
        val stroke = Stroke(
            width = strokeWidth.toPx(),
            cap = SEGMENT_STROKE_CAP
        )

        val inset = stroke.width / 2f
        val arcSize = Size(size.width - inset * 2, size.height - inset * 2)
        val topLeft = Offset(inset, inset)

        val gap = SEGMENT_GAP_ANGLE
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

@Preview
@Composable
fun TaskProgressIndicatorPreview_EN() {
    LtrPreview {
        TaskProgressIndicator(
            completed = 2,
            total = 12,
            subtitleText = "Tasks"
        )
    }
}

@Preview
@Composable
fun TaskProgressIndicatorPreview_RTL() {
    RtlPreview {
        TaskProgressIndicator(
            completed = 2,
            total = 12,
            subtitleText = "المهام"
        )
    }
}
