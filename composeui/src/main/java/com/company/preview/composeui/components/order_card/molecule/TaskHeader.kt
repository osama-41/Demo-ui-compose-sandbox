package com.company.preview.composeui.components.order_card.molecule

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.components.order_card.atom.OrderTimer
import com.company.preview.composeui.components.order_card.atom.StatusIndicator
import com.company.preview.composeui.components.order_card.atom.TaskTypeIcon
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskHeader(
    title: String,
    progressText: String,
    timer: String,
    progress: Float,
    @DrawableRes taskIconRes: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TaskTypeIcon(iconRes = taskIconRes)

            Spacer(modifier = Modifier.Companion.width(Theme.spacing.md))

            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = title,
                        style = Theme.typography.titleMedium,
                        color = Theme.colors.primary
                    )
                    Spacer(modifier = Modifier.width(Theme.spacing.xs))
                    Text(
                        text = progressText,
                        style = Theme.typography.bodyMedium,
                        color = Theme.colors.secondaryText
                    )
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.Companion.width(IntrinsicSize.Max)
        ) {
            OrderTimer(
                time = timer,
                modifier = Modifier.Companion.wrapContentWidth(unbounded = true)
            )
            Spacer(modifier = Modifier.Companion.height(Theme.spacing.xs))
            StatusIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskHeaderPreview_Ltr() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {

                TaskHeader(
                    title = "Pick up",
                    progressText = "(1/3)",
                    timer = "01:16",
                    progress = 0.35f,
                    taskIconRes = Theme.icons.taskPickup
                )
                TaskHeader(
                    title = "Pick up",
                    progressText = "(2/3)",
                    timer = "01:1616:61",
                    progress = 0.65f,
                    taskIconRes = Theme.icons.taskPickup
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskHeaderPreview_Rtl() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {

                TaskHeader(
                    title = "التقاط",
                    progressText = "(١/٣)",
                    timer = "٠١:١٦",
                    progress = 0.35f,
                    taskIconRes = Theme.icons.taskPickup
                )
                TaskHeader(
                    title = "التقاط",
                    progressText = "(٢/٣)",
                    timer = "٠١:١٦١٦:٦١",
                    progress = 0.65f,
                    taskIconRes = Theme.icons.taskPickup
                )
            }
        }
    }
}