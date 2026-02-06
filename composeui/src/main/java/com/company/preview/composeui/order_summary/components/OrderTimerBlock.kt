package com.company.preview.composeui.order_summary.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.company.preview.composeui.order_summary.theme.OrderTimerBlockTheme

@Composable
fun OrderTimerBlock(
    timeText: String,
    labelText: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier
) {
    val theme = OrderTimerBlockTheme

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = timeText,
            style = OrderTimerBlockTheme.Typography.time(),
            color = OrderTimerBlockTheme.Colors.time()
        )

        Spacer(modifier = Modifier.height(OrderTimerBlockTheme.Spacing.betweenTimeAndLabelRow))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(OrderTimerBlockTheme.Sizes.icon),
                tint = OrderTimerBlockTheme.Colors.icon()
            )
            Spacer(modifier = Modifier.width(OrderTimerBlockTheme.Spacing.betweenIconAndLabel))
            Text(
                text = labelText,
                style = OrderTimerBlockTheme.Typography.label(),
                color = OrderTimerBlockTheme.Colors.label()
            )
        }
    }
}
