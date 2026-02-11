package com.company.preview.composeui.components.order_card.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun StoreBadge(
    text: String,
    modifier: Modifier= Modifier,
    padding: PaddingValues=PaddingValues(
        vertical = Theme.spacing.xs,
        horizontal = Theme.spacing.sm
    )
){

    Row(
        modifier = modifier
            .defaultMinSize(Theme.spacing.xl)
            .clip(RoundedCornerShape(Theme.spacing.radiusXs))
            .background(Theme.colors.secondary)
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = Theme.typography.titleMedium,
            color = Theme.colors.primary
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun StoreBadgePreview_LTR() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {
                StoreBadge(text = "Ninja Grocery")

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun StoreBadgePreview_Rtl() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {
                StoreBadge(text = "متجر نينجا")

            }
        }
    }
}