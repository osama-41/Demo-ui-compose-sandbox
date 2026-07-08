package com.company.preview.composeui.components.product_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.components.shopping_item.QuantitySelectorComponent
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

private val ProductDetailQuantityButtonSize = 36.dp
private val ProductDetailQuantityButtonTextSize = 22.sp
private val ProductDetailQuantitySpacing = 12.dp

@Composable
fun ProductDetailHeaderComponent(
    productName: String,
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = productName,
            modifier = Modifier.weight(1f),
            style = Theme.typography.titleLargeBold,
            color = Theme.colors.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Spacer(modifier = Modifier.width(Theme.spacing.sm))

        QuantitySelectorComponent(
            quantity = quantity,
            onIncrease = onIncrease,
            onDecrease = onDecrease,
            buttonSize = ProductDetailQuantityButtonSize,
            itemSpacing = ProductDetailQuantitySpacing,
            buttonTextSize = ProductDetailQuantityButtonTextSize,
            quantityTextStyle = Theme.typography.titleMediumBold,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailHeaderComponentPreview() {
    var quantity by remember { mutableIntStateOf(4) }

    LtrPreview {
        Surface(
            color = Theme.colors.white,
        ) {
            ProductDetailHeaderComponent(
                productName = "Arabic Ginger",
                quantity = quantity,
                onIncrease = {
                    quantity++
                },
                onDecrease = {
                    if (quantity > 0) {
                        quantity--
                    }
                },
            )
        }
    }
}