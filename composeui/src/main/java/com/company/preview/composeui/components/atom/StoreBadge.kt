package com.company.preview.composeui.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview
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
            .clip(RoundedCornerShape(Theme.radius.xs))
            .background(Theme.colors.outline)
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = Theme.typography.titleMedium,
            color = Theme.colors.textPrimary
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun StoreBadgePreview_LTR() {
    ThemedPreview {
        StoreBadge(text = "Ninja Grocery")
    }
}
@Preview(showBackground = true)
@Composable
private fun StoreBadgePreview_RTL() {
    RtlPreview {
        StoreBadge(text = "متجر نينجا")
    }
}