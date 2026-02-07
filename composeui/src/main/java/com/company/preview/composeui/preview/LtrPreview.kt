package com.company.preview.composeui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.components.organism.TaskCard
import com.company.preview.composeui.theme.Theme

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun OrderTaskCardPreview_LTR() {
    ThemedPreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.white)
                .padding(Theme.spacing.lg)
        ) {
            TaskCard (
                taskTitle = "Pick up",
                progressText = "(1/3)",
                timer = "01:16",
                progress = 0.35f,
                orderText = "Order #05323",
                storeName = "Ninja Grocery",
                locationText = "Pick-up Location",
                startText = "Start Pickup",
                taskIconRes = Theme.icons.taskPickup,
                onLocationClick = {},
                onStartClick = {}
            )
        }
    }
}

