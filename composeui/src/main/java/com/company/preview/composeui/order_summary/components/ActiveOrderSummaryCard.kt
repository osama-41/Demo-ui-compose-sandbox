package com.company.preview.composeui.order_summary.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import com.company.preview.composeui.order_summary.theme.ActiveOrderSummaryCardTheme
import com.company.preview.composeui.order_summary.theme.OrderSummaryLayoutTheme


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
    val clickableModifier =
        if (onClick != null) {
            Modifier.clickable(
                onClick = onClick,
                role = Role.Button,
            )
        } else {
            Modifier
        }
    val centerText = "\u200E${completed} of ${total}\u200E"

    Row(
        modifier = modifier
            .clip(ActiveOrderSummaryCardTheme.Shapes.card)
            .background(ActiveOrderSummaryCardTheme.Colors.background())
            .border(ActiveOrderSummaryCardTheme.Sizes.borderWidth, ActiveOrderSummaryCardTheme.Colors.border(), ActiveOrderSummaryCardTheme.Shapes.card)
            .then(clickableModifier)
            .padding(
                horizontal = ActiveOrderSummaryCardTheme.Padding.horizontal,
                vertical = ActiveOrderSummaryCardTheme.Padding.vertical
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(OrderSummaryLayoutTheme.Spacing.betweenSections)
    ) {
        TaskProgressIndicator(
            completed = completed,
            total = total,
            subtitleText = progressSubtitleText,
            centerText = progressCenterText,
            modifier = Modifier.weight(1f)
        )

        CardVerticalDivider(
            modifier = Modifier
                .width(ActiveOrderSummaryCardTheme.Sizes.dividerWidth)
                .height(ActiveOrderSummaryCardTheme.Sizes.dividerHeight)
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
    val theme = ActiveOrderSummaryCardTheme
    val dividerColor = ActiveOrderSummaryCardTheme.Colors.divider()

    Canvas(modifier = modifier) {
        drawRect(color = dividerColor)
    }
}
