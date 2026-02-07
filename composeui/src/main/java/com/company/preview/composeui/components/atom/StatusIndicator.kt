package com.company.preview.composeui.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.preview.ThemedPreview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.company.preview.composeui.theme.Theme
import kotlin.math.roundToInt

@Composable
fun StatusIndicator(
    progress: Float,
    modifier: Modifier= Modifier,
    width: Dp=Theme.spacing.indicatorWidth,
    height: Dp=Theme.spacing.indicatorHeight
){
    val clamped=progress.coerceIn(0f,1f)
    val fillWidth=(width.value*clamped).roundToInt().dp

    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(Theme.spacing.radiusPill))
            .background(Theme.colors.secondary)
    ){
        Box(
            modifier = modifier
                .width(fillWidth)
                .fillMaxHeight()
                .clip(RoundedCornerShape(Theme.spacing.radiusPill))
                .background(Theme.colors.greenSuccess)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusIndicatorPreview_25() {
    ThemedPreview {
        StatusIndicator(progress = 0.30f)
    }
}