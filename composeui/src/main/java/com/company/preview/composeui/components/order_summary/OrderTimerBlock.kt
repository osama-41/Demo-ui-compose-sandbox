package com.company.preview.composeui.components.order_summary

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun OrderTimerBlock(
    timeText: String,
    labelText: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = timeText,
            style = Theme.typography.titleLargeBold,
            color = Theme.colors.primary
        )

        Spacer(modifier = Modifier.height(Theme.spacing.xs))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(Theme.spacing.lg),
                tint = Theme.colors.mediumGray
            )

            Spacer(modifier = Modifier.width(Theme.spacing.xs))

            Text(
                text = labelText,
                style = Theme.typography.titleSmall,
                color = Theme.colors.secondaryText
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderTimerBlock_AllCases_Preview() {
    LtrPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OrderTimerBlock(
                timeText = "1:55:12",
                labelText = "Order timer",
                iconRes = Theme.icons.timerFlash,
            )
            OrderTimerBlock(
                timeText = "44:23",
                labelText = "Order timer",
                iconRes = Theme.icons.timerFlash,
            )
            OrderTimerBlock(
                timeText = "7:32",
                labelText = "Order timer",
                iconRes = Theme.icons.timerFlash,
            )
            OrderTimerBlock(
                timeText = "0:44",
                labelText = "Order timer",
                iconRes = Theme.icons.timerFlash,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderTimerBlock_RTL_Preview() {
    RtlPreview {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OrderTimerBlock(
                timeText = "١:٥٥:١٢",
                labelText = "مؤقت الطلب",
                iconRes = Theme.icons.timerFlash,
            )
            OrderTimerBlock(
                timeText = "٤٤:٢٣",
                labelText = "مؤقت الطلب",
                iconRes = Theme.icons.timerFlash,
            )
            OrderTimerBlock(
                timeText = "٧:٣٢",
                labelText = "مؤقت الطلب",
                iconRes = Theme.icons.timerFlash,
            )
            OrderTimerBlock(
                timeText = "٠:٤٤",
                labelText = "مؤقت الطلب",
                iconRes = Theme.icons.timerFlash,
            )
        }
    }
}
