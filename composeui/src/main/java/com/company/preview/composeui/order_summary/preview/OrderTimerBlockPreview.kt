package com.company.preview.composeui.order_summary.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.R
import com.company.preview.composeui.order_summary.components.OrderTimerBlock
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview

@Preview
@Composable
fun OrderTimerBlockPreview_EN() {
    ThemedPreview {
        OrderTimerBlock(
            timeText = "00:44",
            labelText = "Order timer",
            iconRes = R.drawable.timer_icon,
        )
    }
}

@Preview
@Composable
fun OrderTimerBlockPreview_RTL() {
    RtlPreview {
        OrderTimerBlock(
            timeText = "٠٠:٤٤",
            labelText = "مؤقت الطلب",
            iconRes = R.drawable.timer_icon,
        )
    }
}
