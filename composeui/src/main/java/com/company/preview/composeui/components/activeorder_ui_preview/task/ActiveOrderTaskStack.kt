package com.company.preview.composeui.components.activeorder_ui_preview.task


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
 fun ActiveOrderTaskStack(
    modifier: Modifier = Modifier,
    deliveryTitle: String,
    deliveryOrderNumber: String,
    deliveryCurrent: Int,
    deliveryTotal: Int,
    backToStoreTitle: String,
    backToStoreCurrent: Int,
    backToStoreTotal: Int,
) {
    val spacing = Theme.spacing

    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {
        TaskConnectorDivider(
            modifier = Modifier.padding(
                start = spacing.sm,
                bottom = spacing.sm
            )
        )

        DeliveryTaskCard(
            title = deliveryTitle,
            orderNumber = deliveryOrderNumber,
            current = deliveryCurrent,
            total = deliveryTotal,
            iconResId = Theme.icons.accountCircle
        )

        TaskConnectorDivider(
            modifier = Modifier.padding(
                start = spacing.sm,
                top = spacing.sm,
                bottom = spacing.sm
            )
        )

        BackToStoreTaskCard(
            title = backToStoreTitle,
            current = backToStoreCurrent,
            total = backToStoreTotal
        )
    }
}

@Preview(showBackground = true, name = "Active Order - EN")
@Composable
private fun ActiveOrderTaskStackPreviewEn() {
    LtrPreview {
        ActiveOrderTaskStack(
            deliveryTitle = "Delivery",
            deliveryOrderNumber = "#Orders-8036-5323",
            deliveryCurrent = 2,
            deliveryTotal = 3,
            backToStoreTitle = "Back to Store",
            backToStoreCurrent = 3,
            backToStoreTotal = 3
        )
    }
}

@Preview(showBackground = true, name = "Active Order - AR")
@Composable
private fun ActiveOrderTaskStackPreviewAr() {
    RtlPreview {
        ActiveOrderTaskStack(
            deliveryTitle = "التوصيل",
            deliveryOrderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
            deliveryCurrent = 2,
            deliveryTotal = 3,
            backToStoreTitle = "العودة إلى المتجر",
            backToStoreCurrent = 3,
            backToStoreTotal = 3
        )
    }
}