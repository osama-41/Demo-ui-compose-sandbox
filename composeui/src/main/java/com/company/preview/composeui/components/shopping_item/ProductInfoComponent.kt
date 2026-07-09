package com.company.preview.composeui.components.shopping_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.theme.Theme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.R
import com.company.preview.composeui.preview.LtrPreview
private val ProductPriceColor = Color(0xFFFF3D57)
private val ProductImageSize = 72.dp

@Composable
fun ProductInfoComponent(
    productImageResId: Int,
    productName: String,
    productPrice: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = productImageResId),
            contentDescription = productName,
            modifier = Modifier.size(ProductImageSize),
            contentScale = ContentScale.Fit,
        )

        Spacer(modifier = Modifier.width(Theme.spacing.md))

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = productName,
                style = Theme.typography.titleLargeBold,
                color = Theme.colors.primary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(Theme.spacing.xs))

            Text(
                text = productPrice,
                style = Theme.typography.titleLargeBold,
                color = ProductPriceColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun ProductInfoComponentPreview() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white,
        ) {
            ProductInfoComponent(
                productImageResId = R.drawable.bell_pepper_red2,
                productName = "Bell Pepper Red",
                productPrice = "1kg, 6$",
            )
        }
    }
}