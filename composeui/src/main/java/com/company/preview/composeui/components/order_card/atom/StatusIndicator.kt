package com.company.preview.composeui.components.order_card.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun StatusIndicator(
    progress: Float,
    modifier: Modifier= Modifier,
    height: Dp=Theme.spacing.indicatorHeight
){
    val clamped=progress.coerceIn(0f,1f)

    Box(
        modifier = modifier
            .height(height)
            .clip(RoundedCornerShape(Theme.spacing.radiusPill))
            .background(Theme.colors.onPrimary)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth(clamped)
                .fillMaxHeight()
                .clip(RoundedCornerShape(Theme.spacing.radiusPill))
                .background(Theme.colors.greenSuccess)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusIndicatorPreview_25_Ltr() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {

                StatusIndicator(progress = 0f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 0.25f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 0.50f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 0.75f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 1f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun StatusIndicatorPreview_25_Rtl() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {

                StatusIndicator(progress = 0f, modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 0.25f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 0.50f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 0.75f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
                StatusIndicator(progress = 1f,modifier = Modifier.width(Theme.spacing.indicatorWidth))
            }
        }
    }
}