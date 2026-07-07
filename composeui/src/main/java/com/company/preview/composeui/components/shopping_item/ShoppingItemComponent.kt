package com.company.preview.composeui.components.shopping_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.R
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun ShoppingItemComponent(
    productImageResId: Int,
    productName: String,
    productPrice: String,
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Theme.colors.white,
        shape = RoundedCornerShape(Theme.spacing.radiusXs),
        border = BorderStroke(
            width = Theme.spacing.borderThin,
            color = Theme.colors.primary,
        ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = Theme.spacing.lg,
                vertical = Theme.spacing.md,
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            ProductInfoComponent(
                productImageResId = productImageResId,
                productName = productName,
                productPrice = productPrice,
                modifier = Modifier
                    .weight(1f)
                    .widthIn(min = 230.dp),
            )

            QuantitySelectorComponent(
                quantity = quantity,
                onIncrease = onIncrease,
                onDecrease = onDecrease,
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 520,
    heightDp = 120,
)
@Composable
private fun ShoppingItemComponentPreview() {
    var quantity by remember { mutableIntStateOf(2) }

    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white,
        ) {
            ShoppingItemComponent(
                productImageResId = R.drawable.bell_pepper_red,
                productName = "Bell Pepper Red",
                productPrice = "1kg, 6$",
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