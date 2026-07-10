package com.company.preview.composeui.components.vegetables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.R
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

private data class VegetableProduct(
    @param:DrawableRes val imageResId: Int,
    val name: String,
    val price: String,
)

@Composable
fun VegetablesGridComponent(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onAddProductClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(Theme.spacing.lg),
    ) {
        VegetablesTopBarComponent(
            title = stringResource(R.string.vegetables_title),
            onBackClick = onBackClick,
            onSearchClick = onSearchClick,
        )

        Spacer(modifier = Modifier.height(Theme.spacing.lg))

        VegetablesProductsGrid(
            onAddProductClick = onAddProductClick,
        )
    }
}

@Composable
private fun VegetablesProductsGrid(
    onAddProductClick: (String) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.spacing.md),
    ) {
        vegetablesProducts.chunked(2).forEach { rowProducts ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(Theme.spacing.md),
            ) {
                rowProducts.forEach { product ->
                    VegetableProductCardComponent(
                        productImageResId = product.imageResId,
                        productName = product.name,
                        productPrice = product.price,
                        onAddClick = {
                            onAddProductClick(product.name)
                        },
                    )
                }
            }
        }
    }
}

private val vegetablesProducts = listOf(
    VegetableProduct(
        imageResId = R.drawable.bell_pepper_red2,
        name = "Bell Pepper Red",
        price = "1kg, 6$",
    ),
    VegetableProduct(
        imageResId = R.drawable.arabic_ginger,
        name = "Arabic Ginger",
        price = "1kg, 4$",
    ),
    VegetableProduct(
        imageResId = R.drawable.fresh_lettuce,
        name = "Fresh Lettuce",
        price = "1kg, 2$",
    ),
    VegetableProduct(
        imageResId = R.drawable.butternut_squash,
        name = "Butternut Squash",
        price = "1kg, 8$",
    ),
    VegetableProduct(
        imageResId = R.drawable.organic_carrots,
        name = "Organic Carrots",
        price = "1kg, 4$",
    ),
    VegetableProduct(
        imageResId = R.drawable.fresh_broccoli,
        name = "Fresh Broccoli",
        price = "1kg, 2$",
    ),
)

@Preview(
    showBackground = true,
    widthDp = 292,
    heightDp = 640,
)
@Composable
private fun VegetablesGridComponentPreview() {
    LtrPreview {
        Surface(
            color = Theme.colors.white,
        ) {
            VegetablesGridComponent(
                onBackClick = {},
                onSearchClick = {},
                onAddProductClick = {},
            )
        }
    }
}