package com.company.preview.composeui.components.order_summary

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun ActiveOrderSummaryCard(
    completed: Int,
    total: Int,
    timeText: String,
    @DrawableRes timerIconRes: Int,
    progressSubtitleText: String,
    progressCenterText: String,
    timerLabelText: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    val shape = RoundedCornerShape(Theme.spacing.radiusCard)

    val clickableModifier =
        if (onClick != null) {
            Modifier.clickable(
                onClick = onClick,
                role = Role.Button,
            )
        } else {
            Modifier
        }

    Row(
        modifier = modifier
            .clip(shape)
            .background(Theme.colors.white)
            .border(
                Theme.spacing.borderThin,
                Theme.colors.greyOutlined,
                shape
            )
            .then(clickableModifier)
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
            iconRes = timerIconRes,
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

@Preview
@Composable
fun ActiveOrderSummaryCardPreview_EN() {
    LtrPreview {
        ActiveOrderSummaryCard(
            completed = 1,
            total = 3,
            timeText = "00:44",
            timerIconRes = Theme.icons.timerFlash,
            progressSubtitleText = "Tasks",
            progressCenterText = "1 of 3",
            timerLabelText = "Order timer",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ActiveOrderSummaryCardPreview_RTL() {
    RtlPreview {
        ActiveOrderSummaryCard(
            completed = 1,
            total = 3,
            timeText = "٠٠:٤٤",
            timerIconRes = Theme.icons.timerFlash,
            progressSubtitleText = "المهام",
            progressCenterText = "١ من ٣",
            timerLabelText = "مؤقت الطلب",
            onClick = {}
        )
    }
}