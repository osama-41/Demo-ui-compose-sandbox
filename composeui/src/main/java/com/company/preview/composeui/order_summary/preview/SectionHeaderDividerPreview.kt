package com.company.preview.composeui.order_summary.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.order_summary.components.SectionHeaderDivider
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview

@Preview
@Composable
fun SectionHeaderDividerPreview_EN() {
    ThemedPreview {
        SectionHeaderDivider(title = "Tasks list")
    }
}

@Preview
@Composable
fun SectionHeaderDividerPreview_RTL() {
    RtlPreview {
        SectionHeaderDivider(title = "قائمة المهام")
    }
}
