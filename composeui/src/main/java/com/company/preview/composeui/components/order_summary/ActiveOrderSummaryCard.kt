package com.company.preview.composeui.components.order_summary

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.ActiveOrderSummaryModel
import com.company.preview.composeui.components.model.OrderTimerModel
import com.company.preview.composeui.components.model.TaskProgressIndicatorModel
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme
import com.company.preview.composeui.utils.AppLocales

@Composable
fun ActiveOrderSummaryCard(
    model: ActiveOrderSummaryModel,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(Theme.spacing.radiusCard)

    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val locale = AppLocales.getLocale(isRtl)

    val progressCenterText = AppLocales.formatTaskProgress(
        completed = model.completed,
        total = model.total,
        locale = locale
    )

    Row(
        modifier = modifier
            .clip(shape)
            .background(Theme.colors.white)
            .border(
                Theme.spacing.borderThin,
                Theme.colors.greyOutlined,
                shape
            )
            .padding(
                horizontal = Theme.spacing.lg,
                vertical = Theme.spacing.cardPaddingV
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
    ) {
        TaskProgressIndicator(
            model = TaskProgressIndicatorModel(
                completed = model.completed,
                total = model.total,
                centerText = progressCenterText,
                subtitleText = model.progressSubtitleText
            ),
            modifier = Modifier.weight(1f)
        )

        CardVerticalDivider(
            modifier = Modifier
                .width(Theme.spacing.dividerWidthThin)
                .height(Theme.spacing.dividerHeightSm)
        )

        OrderTimerBlock(
            model = OrderTimerModel(
                timeText = model.timeText,
                labelText = model.timerLabelText,
                icon = model.icon
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun CardVerticalDivider(
    modifier: Modifier = Modifier
) {
    val dividerColor = Theme.colors.greyOutlined

    Canvas(modifier = modifier) {
        drawRect(color = dividerColor)
    }
}

@Preview(showBackground = true)
@Composable
fun ActiveOrderSummaryCardPreview_EN1() {
    LtrPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
        ) {
            ActiveOrderSummaryCard(
                model = ActiveOrderSummaryModel(
                    completed = 12,
                    total = 30,
                    timeText = "1:55:12",
                    icon = OrderScreenIcons.TimerFlash,
                    progressSubtitleText = "Tasks",
                    timerLabelText = "Order timer",
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActiveOrderSummaryCardPreview_RTL1() {
    RtlPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
        ) {
            ActiveOrderSummaryCard(
                model = ActiveOrderSummaryModel(
                    completed = 12,
                    total = 30,
                    timeText = "١:٥٥:١٢",
                    icon = OrderScreenIcons.TimerFlash,
                    progressSubtitleText = "المهام",
                    timerLabelText = "مؤقت الطلب",
                )
            )
        }
    }
}
