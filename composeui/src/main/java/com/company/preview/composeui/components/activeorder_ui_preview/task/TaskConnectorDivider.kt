package com.company.preview.composeui.components.activeorder_ui_preview.task


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskConnectorDivider(
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier
            .padding(start = Theme.spacing.xl)
            .width(Theme.spacing.taskDriverWidth)
            .height(Theme.spacing.taskDriverHeight)
            .background(Theme.colors.greyOutlined)
    )
}

@Preview(showBackground = true, name = "TaskConnectorDivider - EN")
@Composable
private fun TaskConnectorDividerPreviewEn() {
    LtrPreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.white)
                .padding(vertical = Theme.spacing.md)
        ) {
            TaskConnectorDivider()
        }
    }
}

@Preview(showBackground = true, name = "TaskConnectorDivider - AR")
@Composable
private fun TaskConnectorDividerPreviewAr() {
    RtlPreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.white)
                .padding(vertical = Theme.spacing.md)
        ) {
            TaskConnectorDivider()
        }
    }
}