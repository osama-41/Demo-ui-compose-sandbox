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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.R
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

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
        shape = RoundedCornerShape(Theme.spacing.radiusLg),
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
                color = Theme.colors.priceHighlight,
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

            Spacer(modifier = Modifier.height(Theme.spacing.sectionSpacing))

            AddToCartButton(
                text = stringResource(R.string.product_detail_add_to_cart),
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
                value = stringResource(R.string.product_detail_organic_value),
                label = stringResource(R.string.product_detail_organic_label),
                modifier = Modifier.weight(1f),
            )

            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_expiration,
                value = stringResource(R.string.product_detail_expiration_value),
                label = stringResource(R.string.product_detail_expiration_label),
                modifier = Modifier.weight(1f),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Theme.spacing.md),
        ) {
            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_review_star,
                value = stringResource(R.string.product_detail_reviews_value),
                valueSuffix = stringResource(R.string.product_detail_reviews_count),
                label = stringResource(R.string.product_detail_reviews_label),
                modifier = Modifier.weight(1f),
            )

            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_calories,
                value = stringResource(R.string.product_detail_calories_value),
                label = stringResource(R.string.product_detail_calories_label),
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
            .height(Theme.spacing.buttonHeightSm)
            .clip(RoundedCornerShape(Theme.spacing.buttonHeightSm))
            .background(Theme.colors.accent)
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