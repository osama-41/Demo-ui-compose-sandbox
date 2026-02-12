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
import com.company.preview.composeui.components.icons_enum.OrderScreenIcons
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme
import java.util.Locale

@Composable
fun ActiveOrderSummaryCard(
    completed: Int,
    total: Int,
    timeText: String,
    icon: OrderScreenIcons,
    progressSubtitleText: String,
    timerLabelText: String,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(Theme.spacing.radiusCard)

    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val locale = if (isRtl) Locale("ar") else Locale.ENGLISH

    val progressCenterText = formatTaskProgressText(
        completed = completed,
        total = total,
        locale = locale,
        isRtl = isRtl
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
            completed = completed,
            total = total,
            centerText = progressCenterText,
            subtitleText = progressSubtitleText,
            modifier = Modifier.weight(1f)
        )

        CardVerticalDivider(
            modifier = Modifier
                .width(Theme.spacing.dividerWidthThin)
                .height(Theme.spacing.dividerHeightSm)
        )

        OrderTimerBlock(
            timeText = timeText,
            labelText = timerLabelText,
            icon = icon,
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
fun ActiveOrderSummaryCardPreview_EN() {
    LtrPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
        ) {
            ActiveOrderSummaryCard(
                completed = 12,
                total = 30,
                timeText = "1:55:12",
                icon = OrderScreenIcons.TimerFlash,
                progressSubtitleText = "Tasks",
                timerLabelText = "Order timer",
            )
            ActiveOrderSummaryCard(
                completed = 4,
                total = 7,
                timeText = "44:23",
                icon = OrderScreenIcons.TimerFlash,
                progressSubtitleText = "Tasks",
                timerLabelText = "Order timer",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActiveOrderSummaryCardPreview_RTL() {
    RtlPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
        ) {
            ActiveOrderSummaryCard(
                completed = 12,
                total = 30,
                timeText = "١:٥٥:١٢",
                icon = OrderScreenIcons.TimerFlash,
                progressSubtitleText = "المهام",
                timerLabelText = "مؤقت الطلب",
            )
            ActiveOrderSummaryCard(
                completed = 4,
                total = 7,
                timeText = "٤٤:٢٣",
                icon = OrderScreenIcons.TimerFlash,                progressSubtitleText = "المهام",
                timerLabelText = "مؤقت الطلب",
            )
        }
    }
}
