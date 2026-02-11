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
fun DeliveryTaskCard(
    title: String,
    orderNumber: String,
    current: Int,
    total: Int,
    iconResId: Int,
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

            Spacer(modifier = Modifier.height(Theme.spacing.xs))

            Text(
                text = orderNumber,
                color = Theme.colors.secondaryText,
                style = Theme.typography.titleMediumBold,
                modifier = Modifier.padding(start = spacing.xl + spacing.sm)
            )
        }
    }
}

@Preview(showBackground = true, name = "Delivery EN 0/3")
@Composable
private fun DeliveryPreviewEn_ZeroThree() {
    LtrPreview {
        DeliveryTaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323",
            current = 0,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery EN 1/3")
@Composable
private fun DeliveryPreviewEn_OneThree() {
    LtrPreview {
        DeliveryTaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323",
            current = 1,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery EN 2/9")
@Composable
private fun DeliveryPreviewEn_TwoNine() {
    LtrPreview {
        DeliveryTaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323",
            current = 2,
            total = 9,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery EN 3/3")
@Composable
private fun DeliveryPreviewEn_ThreeThree() {
    LtrPreview {
        DeliveryTaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323",
            current = 3,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery EN Order Big 2/3")
@Composable
private fun DeliveryPreviewEn_OrderBig_TwoThree() {
    LtrPreview {
        DeliveryTaskCard(
            title = "Delivery",
            orderNumber = "#Orders-8036-5323-1029-5588-7712",
            current = 2,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery AR ٠/٣")
@Composable
private fun DeliveryPreviewAr_ZeroThree() {
    RtlPreview {
        DeliveryTaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
            current = 0,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery AR ١/٣")
@Composable
private fun DeliveryPreviewAr_OneThree() {
    RtlPreview {
        DeliveryTaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
            current = 1,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery AR ٢/٩")
@Composable
private fun DeliveryPreviewAr_TwoNine() {
    RtlPreview {
        DeliveryTaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
            current = 2,
            total = 9,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery AR ٣/٣")
@Composable
private fun DeliveryPreviewAr_ThreeThree() {
    RtlPreview {
        DeliveryTaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
            current = 3,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}

@Preview(showBackground = true, name = "Delivery AR طلب كبير ٢/٣")
@Composable
private fun DeliveryPreviewAr_OrderBig_TwoThree() {
    RtlPreview {
        DeliveryTaskCard(
            title = "التوصيل",
            orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣-١٠٢٩-٥٥٨٨-٧٧١٢",
            current = 2,
            total = 3,
            iconResId = Theme.icons.accountCircle
        )
    }
}