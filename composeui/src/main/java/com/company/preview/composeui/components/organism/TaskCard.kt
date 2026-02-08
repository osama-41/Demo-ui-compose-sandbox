package com.company.preview.composeui.components.organism

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.components.atom.AppButton
import com.company.preview.composeui.components.molecule.OrderInfoRow
import com.company.preview.composeui.components.molecule.TaskHeader
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
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
    val shape = RoundedCornerShape(Theme.spacing.radiusCard)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = Theme.spacing.elevationCard,
                shape = shape
            )
            .clip(shape)
            .background(Theme.colors.surface)
            .border(width = Theme.spacing.cardBorderSize, color = Theme.colors.black, shape = shape)
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

        AppButton(
            text = startText,
            onClick = onStartClick,
            modifier = Modifier.fillMaxWidth(),
            radius = Theme.spacing.radiusMd,
            contentDescription = "Location icon",
            containerColor = Theme.colors.white,
            contentColor = Theme.colors.black,
            border = BorderStroke(1.dp, Theme.colors.greyOutlined),
            defaultElevation = Theme.spacing.elevationNone,
            iconRes = Theme.icons.location,

        )

        Spacer(modifier = Modifier.height(Theme.spacing.md))

        AppButton(
            text = locationText,
            onClick = onLocationClick,
            modifier = Modifier.fillMaxWidth(),
            contentDescription = "Start icon",
            containerColor = Theme.colors.primary,
            contentColor = Theme.colors.white,
            iconRes = Theme.icons.start
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TaskCard_Ltr() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = Theme.colors.white
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
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

                TaskCard (
                    taskTitle = "Pick up",
                    progressText = "(2/3)",
                    timer = "01:1616:16",
                    progress = 0.65f,
                    orderText = "Order #3205323",
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
}


@Preview(showBackground = true)
@Composable
fun TaskCard_Rtl() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = Theme.colors.white
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TaskCard(
                    taskTitle = "التقاط",
                    progressText = "(١/٣)",
                    timer = "٠١:١٦",
                    progress = 0.35f,
                    orderText = "طلب #٠٥٣٢٣",
                    storeName = "متجر نينجا",
                    locationText = "موقع الالتقاط",
                    startText = "ابدأ الالتقاط",
                    taskIconRes = Theme.icons.taskPickup,
                    onLocationClick = {},
                    onStartClick = {}
                )

                TaskCard(
                    taskTitle = "التقاط",
                    progressText = "(٢/٣)",
                    timer = "٠١:١٦١٦:١٦",
                    progress = 0.65f,
                    orderText = "طلب #٣٢٠٥٣٢٣",
                    storeName = "متجر نينجا",
                    locationText = "موقع الالتقاط",
                    startText = "ابدأ الالتقاط",
                    taskIconRes = Theme.icons.taskPickup,
                    onLocationClick = {},
                    onStartClick = {}
                )
            }
        }
    }
}
