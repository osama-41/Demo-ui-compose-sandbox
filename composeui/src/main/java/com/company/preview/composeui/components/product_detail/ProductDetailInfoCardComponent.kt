package com.company.preview.composeui.components.product_detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.R
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun ProductDetailInfoCardComponent(
    @DrawableRes iconResId: Int,
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueSuffix: String? = null,
) {
    Surface(
        modifier = modifier.height(Theme.spacing.infoCardHeight),
        color = Theme.colors.white,
        shape = RoundedCornerShape(Theme.spacing.radiusMd),
        border = BorderStroke(
            width = Theme.spacing.borderThin,
            color = Theme.colors.cardBorder,
        ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = Theme.spacing.sm,
                vertical = Theme.spacing.xs,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = label,
                modifier = Modifier.size(Theme.spacing.infoCardIconSize),
            )

            Spacer(modifier = Modifier.width(Theme.spacing.sm))

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = value,
                        style = Theme.typography.titleMediumBold,
                        color = Theme.colors.accent,
                    )

                    valueSuffix?.let { suffixText ->
                        Spacer(modifier = Modifier.width(Theme.spacing.xs))

                        Text(
                            text = suffixText,
                            style = Theme.typography.labelSmall,
                            color = Theme.colors.secondaryText,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(Theme.spacing.xs))

                Text(
                    text = label,
                    style = Theme.typography.bodyMedium,
                    color = Theme.colors.secondaryText,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailInfoCardComponentPreview() {
    LtrPreview {
        Surface(
            color = Theme.colors.white,
        ) {
            ProductDetailInfoCardComponent(
                iconResId = R.drawable.ic_organic,
                value = "100%",
                label = "Organic",
            )
        }
    }
}