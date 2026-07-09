package com.company.preview.composeui.components.shopping_item

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.components.shared.CircleTextButtonComponent
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

private val IncreaseButtonColor = Color(0xFF12C7C7)
private val DecreaseButtonColor = Color(0xFFF5F6F8)
private val DecreaseButtonTextColor = Color(0xFF8D8D8D)
private val DefaultQuantityButtonSize = 56.dp
private val DefaultQuantityButtonTextSize = 30.sp
private val DefaultQuantityItemSpacing = 16.dp

@Composable
fun QuantitySelectorComponent(
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    modifier: Modifier = Modifier,
    buttonSize: Dp = DefaultQuantityButtonSize,
    itemSpacing: Dp = DefaultQuantityItemSpacing,
    buttonTextSize: TextUnit = DefaultQuantityButtonTextSize,
    quantityTextStyle: TextStyle = Theme.typography.titleLargeBold,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircleTextButtonComponent(
            text = "-",
            containerColor = DecreaseButtonColor,
            contentColor = DecreaseButtonTextColor,
            buttonSize = buttonSize,
            textSize = buttonTextSize,
            onClick = onDecrease,
        )

        Spacer(modifier = Modifier.width(itemSpacing))

        Text(
            text = quantity.toString(),
            style = quantityTextStyle,
            color = Theme.colors.primary,
        )

        Spacer(modifier = Modifier.width(itemSpacing))

        CircleTextButtonComponent(
            text = "+",
            containerColor = IncreaseButtonColor,
            contentColor = Theme.colors.white,
            buttonSize = buttonSize,
            textSize = buttonTextSize,
            onClick = onIncrease,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantitySelectorComponentPreview() {
    var quantity by remember { mutableIntStateOf(2) }

    LtrPreview {
        Surface(
            color = Theme.colors.white,
        ) {
            QuantitySelectorComponent(
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