package com.company.preview.composeui.order_summary.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.R
import com.company.preview.composeui.order_summary.components.ActiveOrderSummaryCard
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview

@Preview
@Composable
fun ActiveOrderSummaryCardPreview_EN() {
    ThemedPreview {
        ActiveOrderSummaryCard(
            completed = 1,
            total = 3,
            timeText = "00:44",
            timerIconRes = R.drawable.timer_icon,
            progressSubtitleText = "Tasks",
            progressCenterText = "1 of 3",
            timerLabelText = "Order timer",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ActiveOrderSummaryCardPreview_RTL() {
    RtlPreview {
        ActiveOrderSummaryCard(
            completed = 1,
            total = 3,
            timeText = "٠٠:٤٤",
            timerIconRes = R.drawable.timer_icon,
            progressSubtitleText = "المهام",
            progressCenterText = "١ من ٣",
            timerLabelText = "مؤقت الطلب",
            onClick = {}
        )
    }
}