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
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.ActiveOrderTaskCompactCardModel
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun ActiveOrderTaskCompactCard(
    model: ActiveOrderTaskCompactCardModel,
    modifier: Modifier = Modifier
) {
    val spacing = Theme.spacing

    TaskItemContainer(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            TaskHeaderRow(
                title = model.title,
                current = model.current,
                total = model.total,
                iconResId = model.icon.resId
            )

            if (model.orderNumber != null) {
                Spacer(modifier = Modifier.height(spacing.xs))

                Text(
                    text = model.orderNumber,
                    color = Theme.colors.secondaryText,
                    style = Theme.typography.titleMediumBold,
                    modifier = Modifier.padding(start = spacing.xl + spacing.sm)
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "CompactCard - Delivery EN 2/3")
@Composable
private fun CompactCardPreview_Delivery_En_TwoThree() {
    LtrPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "Delivery",
                orderNumber = "#Orders-8036-5323",
                current = 2,
                total = 3,
                icon = OrderScreenIcons.AccountCircle
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - Delivery EN Long Order 2/3")
@Composable
private fun CompactCardPreview_Delivery_En_LongOrder_TwoThree() {
    LtrPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "Delivery",
                orderNumber = "#Orders-8036-5323-1029-5588-7712",
                current = 2,
                total = 3,
                icon = OrderScreenIcons.AccountCircle
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - Delivery AR ٢/٣")
@Composable
private fun CompactCardPreview_Delivery_Ar_TwoThree() {
    RtlPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "التوصيل",
                orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
                current = 2,
                total = 3,
                icon = OrderScreenIcons.AccountCircle
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - Delivery AR طلب كبير ٢/٣")
@Composable
private fun CompactCardPreview_Delivery_Ar_LongOrder_TwoThree() {
    RtlPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "التوصيل",
                orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣-١٠٢٩-٥٥٨٨-٧٧١٢",
                current = 2,
                total = 3,
                icon = OrderScreenIcons.AccountCircle
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - BackToStore EN 3/3")
@Composable
private fun CompactCardPreview_BackToStore_En_ThreeThree() {
    LtrPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "Back to Store",
                orderNumber = null,
                current = 3,
                total = 3,
                icon = OrderScreenIcons.Store
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - BackToStore EN 2/9")
@Composable
private fun CompactCardPreview_BackToStore_En_TwoNine() {
    LtrPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "Back to Store",
                orderNumber = null,
                current = 2,
                total = 9,
                icon = OrderScreenIcons.Store
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - BackToStore AR ٣/٣")
@Composable
private fun CompactCardPreview_BackToStore_Ar_ThreeThree() {
    RtlPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "العودة إلى المتجر",
                orderNumber = null,
                current = 3,
                total = 3,
                icon = OrderScreenIcons.Store
            )
        )
    }
}

@Preview(showBackground = true, name = "CompactCard - BackToStore AR ٢/٩")
@Composable
private fun CompactCardPreview_BackToStore_Ar_TwoNine() {
    RtlPreview {
        ActiveOrderTaskCompactCard(
            model = ActiveOrderTaskCompactCardModel(
                title = "العودة إلى المتجر",
                orderNumber = null,
                current = 2,
                total = 9,
                icon = OrderScreenIcons.Store
            )
        )
    }
}