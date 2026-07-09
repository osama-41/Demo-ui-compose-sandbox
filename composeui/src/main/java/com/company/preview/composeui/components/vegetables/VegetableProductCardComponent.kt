package com.company.preview.composeui.components.vegetables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.R
import com.company.preview.composeui.components.shared.CircleTextButtonComponent
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

private val ProductCardBackgroundColor = Color(0xFFF3F4F6)
private val ProductPriceColor = Color(0xFFFF3D57)
private val ProductAddButtonColor = Color(0xFF12C7C7)
private val ProductCardShape = 10.dp
private val ProductCardWidth = 122.dp
private val ProductCardHeight = 160.dp
private val ProductImageAreaHeight = 98.dp
private val ProductImageSize = 78.dp
private val ProductAddButtonSize = 30.dp
private val ProductAddButtonOffsetX = (-8).dp
private val ProductAddButtonOffsetY = (-8).dp
private val ProductPriceEndPadding = 38.dp
private val ProductNameTextSize = 10.sp
private val ProductPriceTextSize = 10.sp
private val ProductTextSpacing = 2.dp

@Composable
fun VegetableProductCardComponent(
    @DrawableRes productImageResId: Int,
    productName: String,
    productPrice: String,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.size(
            width = ProductCardWidth,
            height = ProductCardHeight,
        ),
        color = ProductCardBackgroundColor,
        shape = RoundedCornerShape(ProductCardShape),
    ) {
        Box {
            Column(
                modifier = Modifier.padding(Theme.spacing.sm),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ProductImageAreaHeight),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = productImageResId),
                        contentDescription = productName,
                        modifier = Modifier.size(ProductImageSize),
                        contentScale = ContentScale.Fit,
                    )
                }

                Text(
                    text = productName,
                    color = Theme.colors.primary,
                    fontSize = ProductNameTextSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(ProductTextSpacing))

                Text(
                    text = productPrice,
                    modifier = Modifier.padding(end = ProductPriceEndPadding),
                    color = ProductPriceColor,
                    fontSize = ProductPriceTextSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            CircleTextButtonComponent(
                text = "+",
                containerColor = ProductAddButtonColor,
                contentColor = Theme.colors.white,
                buttonSize = ProductAddButtonSize,
                textSize = 22.sp,
                onClick = onAddClick,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(
                        x = ProductAddButtonOffsetX,
                        y = ProductAddButtonOffsetY,
                    ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VegetableProductCardComponentPreview() {
    LtrPreview {
        Surface(
            color = Theme.colors.white,
        ) {
            VegetableProductCardComponent(
                productImageResId = R.drawable.bell_pepper_red2,
                productName = "Bell Pepper Red",
                productPrice = "1kg, 6$",
                onAddClick = {},
            )
        }
    }
}