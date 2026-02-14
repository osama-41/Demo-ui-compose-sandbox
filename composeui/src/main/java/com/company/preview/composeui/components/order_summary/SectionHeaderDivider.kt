package com.company.preview.composeui.components.order_summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.components.model.SectionHeaderDividerModel
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun SectionHeaderDivider(
    model: SectionHeaderDividerModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = Theme.spacing.borderThin,
            color = Theme.colors.greyOutlined
        )
        Text(
            text = model.title,
            modifier = Modifier.padding(horizontal = Theme.spacing.md),
            style = Theme.typography.bodyMedium,
            color = Theme.colors.mediumGray
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = Theme.spacing.borderThin,
            color = Theme.colors.greyOutlined
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderDivider_Preview1() {
    LtrPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.xl)
        ) {
            SectionHeaderDivider(model = SectionHeaderDividerModel(title = "Tasks list"))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderDivider_RTL_Preview1() {
    RtlPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.xl)
        ) {
            SectionHeaderDivider(model = SectionHeaderDividerModel(title = "قائمة المهام"))
        }
    }
}
