package com.company.preview.composeui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.company.preview.composeui.components.activeorder_ui_preview.task.ActiveOrderTaskStack
import com.company.preview.composeui.components.activeorder_ui_preview.topbar.ActiveOrderTopBar
import com.company.preview.composeui.components.activeorder_ui_preview.topbar.ActiveOrderTopBarUiModel
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.ActiveOrderSummaryModel
import com.company.preview.composeui.components.model.AppButtonElevationModel
import com.company.preview.composeui.components.model.AppButtonModel
import com.company.preview.composeui.components.model.SectionHeaderDividerModel
import com.company.preview.composeui.components.model.TaskCardModel
import com.company.preview.composeui.components.model.TaskHeaderModel
import com.company.preview.composeui.components.order_card.organism.TaskCard
import com.company.preview.composeui.components.order_summary.ActiveOrderSummaryCard
import com.company.preview.composeui.components.order_summary.SectionHeaderDivider
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme
import com.company.preview.composeui.theme.Theme.spacing

@Composable
fun ActiveOrderScreen(
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onSupportClick: (() -> Unit)? = null,
    onLocationClick: (() -> Unit)? = null,
    onStartClick: (() -> Unit)? = null,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ActiveOrderTopBar(
                uiModel = ActiveOrderTopBarUiModel(
                    title = "Active Order",
                    isSupportVisible = true
                ),
                onBackClick = onBackClick,
                onSupportClick = onSupportClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = spacing.lg),
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.sm))

            ActiveOrderSummaryCard(
                model = ActiveOrderSummaryModel(
                    completed = 1,
                    total = 3,
                    timeText = "00:44",
                    icon = OrderScreenIcons.TimerFlash,
                    progressSubtitleText = "Tasks",
                    timerLabelText = "Order timer",
                ),
                modifier = Modifier.fillMaxWidth()
            )

            SectionHeaderDivider(
                model = SectionHeaderDividerModel(title = "Tasks list"),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = spacing.xs)
            )

            TaskCard(
                model = TaskCardModel(
                    header = TaskHeaderModel(
                        icon = OrderScreenIcons.TaskPickup,
                        title = "Pick up",
                        progressText = "(1/3)",
                        timerText = "01:16",
                        progress = 0.35f
                    ),
                    orderNumber = "Order #05323",
                    storeName = "Ninja Grocery",
                    locationButton = AppButtonModel(
                        text = "Pick-up Location",
                        textStyle = Theme.typography.button,
                        enabled = true,
                        height = spacing.buttonHeight,
                        radius = spacing.radiusMd,
                        contentPadding = PaddingValues(
                            horizontal = spacing.lg,
                            vertical = spacing.md
                        ),
                        containerColor = Theme.colors.white,
                        contentColor = Theme.colors.black,
                        border = BorderStroke(
                            spacing.buttonBorderSize,
                            Theme.colors.greyOutlined
                        ),
                        elevation = AppButtonElevationModel(
                            defaultElevation = Dp.Unspecified,
                            pressedElevation = Dp.Unspecified,
                            disabledElevation = Dp.Unspecified
                        ),
                        icon = OrderScreenIcons.Location,
                        iconSize = spacing.buttonIconSize,
                        iconTint = Theme.colors.black,
                        contentDescription = "Location icon"
                    ),
                    startButton = AppButtonModel(
                        text = "Start Pickup",
                        textStyle = Theme.typography.button,
                        enabled = true,
                        height = spacing.buttonHeight,
                        radius = spacing.radiusMd,
                        contentPadding = PaddingValues(
                            horizontal = spacing.lg,
                            vertical = spacing.md
                        ),
                        containerColor = Theme.colors.primary,
                        contentColor = Theme.colors.white,
                        border = null,
                        elevation = AppButtonElevationModel(
                            defaultElevation = Dp.Unspecified,
                            pressedElevation = Dp.Unspecified,
                            disabledElevation = Dp.Unspecified
                        ),
                        icon = OrderScreenIcons.Start,
                        iconSize = spacing.buttonIconSize,
                        iconTint = Theme.colors.white,
                        contentDescription = "Start icon"
                    )
                ),
                onLocationClick = { onLocationClick?.invoke() },
                onStartClick = { onStartClick?.invoke() },
                modifier = Modifier.fillMaxWidth()
            )


            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ActiveOrderTaskStack(
                    deliveryTitle = "Delivery",
                    deliveryOrderNumber = "#Orders-8036-5323",
                    deliveryCurrent = 2,
                    deliveryTotal = 3,
                    backToStoreTitle = "Back to Store",
                    backToStoreCurrent = 3,
                    backToStoreTotal = 3
                )
            }

            Spacer(modifier = Modifier.height(spacing.lg))
        }
    }
}

@Preview(showBackground = true, name = "ActiveOrderScreen - LTR")
@Composable
private fun ActiveOrderScreenPreview_Ltr() {
    LtrPreview {
        ActiveOrderScreen()
    }
}
