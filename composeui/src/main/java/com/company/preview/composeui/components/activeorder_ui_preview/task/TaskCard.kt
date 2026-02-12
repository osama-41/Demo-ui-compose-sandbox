package com.company.preview.composeui.components.activeorder_ui_preview.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskCard(
    title: String,
    current: Int,
    total: Int,
    iconResId: Int,
    orderNumber: String? = null,
    modifier: Modifier = Modifier
) {
    val spacing = Theme.spacing

    TaskItemContainer(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            TaskHeaderRow(
                title = title,
                current = current,
                total = total,
                iconResId = iconResId
            )

            if (orderNumber != null) {
                Spacer(modifier = Modifier.height(spacing.xs))

                Text(
                    text = orderNumber,
                    color = Theme.colors.secondaryText,
                    style = Theme.typography.titleMediumBold,
                    modifier = Modifier.padding(start = spacing.xl + spacing.sm)
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "TaskCard - Delivery EN 2/3")
@Composable
private fun TaskCardPreview_Delivery_En_TwoThree() {
    LtrPreview {
        TaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323",
            current = 2,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - Delivery EN Long Order 2/3")
@Composable
private fun TaskCardPreview_Delivery_En_LongOrder_TwoThree() {
    LtrPreview {
        TaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323-1029-5588-7712",
            current = 2,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - Delivery AR ٢/٣")
@Composable
private fun TaskCardPreview_Delivery_Ar_TwoThree() {
    RtlPreview {
        TaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
            current = 2,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - Delivery AR طلب كبير ٢/٣")
@Composable
private fun TaskCardPreview_Delivery_Ar_LongOrder_TwoThree() {
    RtlPreview {
        TaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣-١٠٢٩-٥٥٨٨-٧٧١٢",
            current = 2,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - BackToStore EN 3/3")
@Composable
private fun TaskCardPreview_BackToStore_En_ThreeThree() {
    LtrPreview {
        TaskCard(
            title = "Back to Store",
            current = 3,
            total = 3,
            iconResId = Theme.icons.store
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - BackToStore EN 2/9")
@Composable
private fun TaskCardPreview_BackToStore_En_TwoNine() {
    LtrPreview {
        TaskCard(
            title = "Back to Store",
            current = 2,
            total = 9,
            iconResId = Theme.icons.store
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - BackToStore AR ٣/٣")
@Composable
private fun TaskCardPreview_BackToStore_Ar_ThreeThree() {
    RtlPreview {
        TaskCard(
            title = "العودة إلى المتجر",
            current = 3,
            total = 3,
            iconResId = Theme.icons.store
        )
    }
}

@Preview(showBackground = true, name = "TaskCard - BackToStore AR ٢/٩")
@Composable
private fun TaskCardPreview_BackToStore_Ar_TwoNine() {
    RtlPreview {
        TaskCard(
            title = "العودة إلى المتجر",
            current = 2,
            total = 9,
            iconResId = Theme.icons.store
        )
    }
}