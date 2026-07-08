package com.company.preview.composeui.components.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.R
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

private val ProductPriceColor = Color(0xFFFF3D57)
private val AddToCartButtonColor = Color(0xFF12C7C7)
private val ProductDetailCardShape = 24.dp
private val AddToCartButtonHeight = 48.dp

@Composable
fun ProductDetailComponent(
    productName: String,
    productPrice: String,
    productDescription: String,
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = Theme.colors.white,
        shape = RoundedCornerShape(ProductDetailCardShape),
    ) {
        Column(
            modifier = Modifier.padding(Theme.spacing.lg),
        ) {
            ProductDetailHeaderComponent(
                productName = productName,
                quantity = quantity,
                onIncrease = onIncrease,
                onDecrease = onDecrease,
            )

            Spacer(modifier = Modifier.height(Theme.spacing.sm))

            Text(
                text = productPrice,
                style = Theme.typography.titleLargeBold,
                color = ProductPriceColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(Theme.spacing.md))

            Text(
                text = productDescription,
                style = Theme.typography.bodyMedium,
                color = Theme.colors.secondaryText,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(Theme.spacing.lg))

            ProductDetailInfoCards()

            Spacer(modifier = Modifier.height(28.dp))

            AddToCartButton(
                text = "Add to cart",
                onClick = onAddToCart,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun ProductDetailInfoCards() {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.spacing.md),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Theme.spacing.md),
        ) {
            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_organic,
                value = "100%",
                label = "Organic",
                modifier = Modifier.weight(1f),
            )

            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_expiration,
                value = "1 Year",
                label = "Expiration",
                modifier = Modifier.weight(1f),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Theme.spacing.md),
        ) {
            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_review_star,
                value = "4.8",
                valueSuffix = "(256)",
                label = "Reviews",
                modifier = Modifier.weight(1f),
            )

            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_calories,
                value = "80 kcal",
                label = "100 Gram",
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun AddToCartButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(AddToCartButtonHeight)
            .clip(RoundedCornerShape(AddToCartButtonHeight))
            .background(AddToCartButtonColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = Theme.typography.titleMediumBold,
            color = Theme.colors.white,
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 356,
    heightDp = 430,
)
@Composable
private fun ProductDetailComponentPreview() {
    var quantity by remember { mutableIntStateOf(4) }

    LtrPreview {
        ProductDetailComponent(
            productName = "Arabic Ginger",
            productPrice = "1kg, 4$",
            productDescription = "Ginger is a flowering plant whose rhizome, ginger root or ginger, is widely used as a spice and a folk medicine.",
            quantity = quantity,
            onIncrease = {
                quantity++
            },
            onDecrease = {
                if (quantity > 0) {
                    quantity--
                }
            },
            onAddToCart = {},
            modifier = Modifier.padding(Theme.spacing.lg),
        )
    }
}