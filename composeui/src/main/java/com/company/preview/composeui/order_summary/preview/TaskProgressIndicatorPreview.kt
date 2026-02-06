package com.company.preview.composeui.order_summary.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.order_summary.components.TaskProgressIndicator
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview

@Preview
@Composable
fun TaskProgressIndicatorPreview_EN() {
    ThemedPreview {
        TaskProgressIndicator(
            completed = 1,
            total = 3,
            centerText = "",
            subtitleText = ""
        )
    }
}

@Preview
@Composable
fun TaskProgressIndicatorPreview_RTL() {
    RtlPreview {
        TaskProgressIndicator(
            completed = 1,
            total = 3,
            centerText = "",
            subtitleText = ""
        )
    }
}
