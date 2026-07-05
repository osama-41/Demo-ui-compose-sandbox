package com.company.preview.composeui.components.activeorder_ui_preview.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.ActiveOrderTaskCompactCardModel
import com.company.preview.composeui.components.model.ActiveOrderTaskStackModel
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun ActiveOrderTaskStack(
    model: ActiveOrderTaskStackModel,
    modifier: Modifier = Modifier
) {
    val spacing = Theme.spacing

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TaskConnectorDivider(
            modifier = Modifier.padding(
                start = spacing.lg,
                bottom = spacing.xs
            )
        )

        ActiveOrderTaskCompactCard(
                model = model.first
        )

        TaskConnectorDivider(
            modifier = Modifier.padding(
                start = spacing.lg,
                top = spacing.xs,
                bottom = spacing.xs
            )
        )

        ActiveOrderTaskCompactCard(
            model = model.second
        )
    }
}

@Preview(showBackground = true, name = "Active Order - EN")
@Composable
private fun ActiveOrderTaskStackPreviewEn() {
    LtrPreview {
        ActiveOrderTaskStack(
            model = ActiveOrderTaskStackModel(
                first = ActiveOrderTaskCompactCardModel(
                    title = "Delivery",
                    orderNumber = "#Orders-8036-5323",
                    current = 2,
                    total = 3,
                    icon = OrderScreenIcons.AccountCircle
                ),
                second = ActiveOrderTaskCompactCardModel(
                    title = "Back to Store",
                    orderNumber = null,
                    current = 3,
                    total = 3,
                    icon = OrderScreenIcons.Store
                )
            )
        )
    }
}

@Preview(showBackground = true, name = "Active Order - AR")
@Composable
private fun ActiveOrderTaskStackPreviewAr() {
    RtlPreview {
        ActiveOrderTaskStack(
            model = ActiveOrderTaskStackModel(
                first = ActiveOrderTaskCompactCardModel(
                    title = "التوصيل",
                    orderNumber = "#الطلبات-٨٠٣٦-٥٣٢٣",
                    current = 2,
                    total = 3,
                    icon = OrderScreenIcons.AccountCircle
                ),
                second = ActiveOrderTaskCompactCardModel(
                    title = "العودة إلى المتجر",
                    orderNumber = null,
                    current = 3,
                    total = 3,
                    icon = OrderScreenIcons.Store
                )
            )
        )
    }
}