package com.company.preview.composeui.components.shopping_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.theme.Theme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
private val IncreaseButtonColor = Color(0xFF12C7C7)
private val DecreaseButtonColor = Color(0xFFF5F6F8)
private val DecreaseButtonTextColor = Color(0xFF8D8D8D)
private val QuantityButtonSize = 56.dp

@Composable
fun QuantitySelectorComponent(
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        QuantityButton(
            text = "-",
            containerColor = DecreaseButtonColor,
            contentColor = DecreaseButtonTextColor,
            onClick = onDecrease,
        )

        Spacer(modifier = Modifier.width(Theme.spacing.lg))

        Text(
            text = quantity.toString(),
            style = Theme.typography.titleLargeBold,
            color = Theme.colors.primary,
        )

        Spacer(modifier = Modifier.width(Theme.spacing.lg))

        QuantityButton(
            text = "+",
            containerColor = IncreaseButtonColor,
            contentColor = Theme.colors.white,
            onClick = onIncrease,
        )
    }
}

@Composable
private fun QuantityButton(
    text: String,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(QuantityButtonSize)
            .clip(CircleShape)
            .background(containerColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = contentColor,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
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