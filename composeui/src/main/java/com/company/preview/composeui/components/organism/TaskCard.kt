package com.company.preview.composeui.components.organism

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.components.atom.LocationButton
import com.company.preview.composeui.components.atom.PrimaryButton
import com.company.preview.composeui.components.molecule.OrderInfoRow
import com.company.preview.composeui.components.molecule.TaskHeader
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskCard(
    taskTitle: String,
    progressText: String,
    timer: String,
    progress: Float,
    orderText: String,
    storeName: String,
    locationText: String,
    startText: String,
    @DrawableRes taskIconRes: Int,
    modifier: Modifier = Modifier,
    onLocationClick: () -> Unit,
    onStartClick: () -> Unit,
){
    val shape = RoundedCornerShape(Theme.radius.card)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = Theme.elevation.card,
                shape = shape
            )
            .clip(shape)
            .background(Theme.colors.background)
            .border(width = Theme.spacing.borderSize, color = Theme.colors.textPrimary, shape = shape)
            .padding(Theme.spacing.lg)
    ) {
        TaskHeader(
            title = taskTitle,
            progressText = progressText,
            timer = timer,
            progress = progress,
            taskIconRes = taskIconRes,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Theme.spacing.md))

        OrderInfoRow(
            orderText = orderText,
            storeName = storeName,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Theme.spacing.lg))

        LocationButton(
            text = locationText,
            onClick = onLocationClick,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Theme.spacing.md))

        PrimaryButton(
            text = startText,
            iconRes = Theme.icons.start,
            onClick = onStartClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun OrderTaskCardPreview_LTR() {
    ThemedPreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.background)
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
@Preview(showBackground = true, widthDp = 360)
@Composable
private fun OrderTaskCardPreview_RTL() {
    RtlPreview {
    ThemedPreview {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.background)
                .padding(Theme.spacing.lg)
        ) {
            TaskCard (
                taskTitle = "التقاط",
                progressText = "(١/٣)",
                timer = "٠١:١٦",
                progress = 0.35f,
                orderText = "طلب #05323",
                storeName = "متجر نينجا",
                locationText = "موقع الالتقاط",
                startText = "ابدأ الالتقاط",
                taskIconRes = Theme.icons.taskPickup,
                onLocationClick = {},
                onStartClick = {}
            )
        }}
    }
}