package com.company.preview.composeui.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.components.order_summary.ActiveOrderSummaryCard
import com.company.preview.composeui.components.order_summary.SectionHeaderDivider
import com.company.preview.composeui.theme.AppTheme
import com.company.preview.composeui.theme.Theme

@Composable
fun LtrPreview(content: @Composable () -> Unit) {
    AppTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            content()
        }
    }
}

@Preview
@Composable
private fun OrderSummaryPreview_EN() {
    LtrPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg)
        ) {
            ActiveOrderSummaryCard(
                completed = 1,
                total = 3,
                timeText = "00:44",
                timerIconRes = Theme.icons.timerFlash,
                progressSubtitleText = "Tasks",
                progressCenterText = "1 of 3",
                timerLabelText = "Order timer",
                onClick = {}
            )

            Spacer(modifier = Modifier.height(Theme.spacing.xl))

            SectionHeaderDivider(title = "Tasks list")
        }
    }
}
