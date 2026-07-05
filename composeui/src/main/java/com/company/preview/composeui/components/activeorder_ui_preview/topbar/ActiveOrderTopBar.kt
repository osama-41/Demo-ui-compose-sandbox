package com.company.preview.composeui.components.activeorder_ui_preview.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme
import androidx.compose.foundation.clickable
import androidx.compose.ui.semantics.Role
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.ActiveOrderTopBarModel


@Composable
fun ActiveOrderTopBar(
    model: ActiveOrderTopBarModel,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    onSupportClick: (() -> Unit)? = null,
) {
    val spacing = Theme.spacing

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(Theme.spacing.topBarHeight)
            .background(Theme.colors.primary)
            .padding(horizontal = Theme.spacing.lg),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(spacing.topBarSideSlotSize),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    painter = painterResource(OrderScreenIcons.ArrowBack.resId),
                    contentDescription = "Back",
                    tint = Theme.colors.white,
                    modifier = Modifier
                        .size(Theme.spacing.lg)
                        .clickable(
                            enabled = onBackClick != null,
                            role = Role.Button,
                            onClickLabel = "Back"
                        ) { onBackClick?.invoke() }
                )
            }

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = model.title,
                    color = Theme.colors.white,
                    style = Theme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }

            Box(
                modifier = Modifier.size(spacing.topBarSideSlotSize),
                contentAlignment = Alignment.CenterEnd
            ) {
                if (model.isSupportVisible) {
                    Icon(
                        painter = painterResource(OrderScreenIcons.Headset.resId),
                        contentDescription = "Support",
                        tint = Theme.colors.white,
                        modifier = Modifier
                            .size(Theme.spacing.xl)
                            .clickable(
                                enabled = onSupportClick != null,
                                role = Role.Button,
                                onClickLabel = "Support"
                            ) { onSupportClick?.invoke() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "ActiveOrderTopBar - EN")
@Composable
private fun ActiveOrderTopBarPreview_Ltr() {
    LtrPreview{
        ActiveOrderTopBar(
            model = ActiveOrderTopBarModel(
                title = "Active Order",
                isSupportVisible = true
            )
        )
    }
}

@Preview(showBackground = true, name = "ActiveOrderTopBar - AR")
@Composable
private fun ActiveOrderTopBarPreview_Rtl() {
    RtlPreview{
        ActiveOrderTopBar(
            model = ActiveOrderTopBarModel(
                title = "الطلبات الحالية",
                isSupportVisible = true
            )
        )
    }
}