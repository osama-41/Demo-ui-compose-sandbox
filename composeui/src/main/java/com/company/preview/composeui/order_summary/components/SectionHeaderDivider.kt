package com.company.preview.composeui.order_summary.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.company.preview.composeui.order_summary.theme.SectionHeaderDividerTheme

@Composable
fun SectionHeaderDivider(
    title: String,
    modifier: Modifier = Modifier
) {
    val theme = SectionHeaderDividerTheme

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = SectionHeaderDividerTheme.Sizes.lineThickness,
            color = SectionHeaderDividerTheme.Colors.line()
        )

        Text(
            text = title,
            modifier = Modifier.padding(horizontal = SectionHeaderDividerTheme.Spacing.titleHorizontalPadding),
            style = SectionHeaderDividerTheme.Typography.title(),
            color = SectionHeaderDividerTheme.Colors.title()
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = SectionHeaderDividerTheme.Sizes.lineThickness,
            color = SectionHeaderDividerTheme.Colors.line()
        )
    }
}
