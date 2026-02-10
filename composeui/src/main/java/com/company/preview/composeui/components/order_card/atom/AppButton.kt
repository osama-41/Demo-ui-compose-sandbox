package com.company.preview.composeui.components.order_card.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun AppButton(
    text: String,
    onClick: ()-> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean=true,
    height: Dp = Theme.spacing.buttonHeight,
    radius: Dp = Theme.spacing.sm,
    containerColor: Color = Theme.colors.primary,
    contentColor: Color = Theme.colors.white,
    border: BorderStroke? = null,
    defaultElevation: Dp = Theme.spacing.elevationSm ,
    pressedElevation:Dp = Theme.spacing.elevationMd,
    disabledElevation:Dp = Theme.spacing.elevationNone,
    @DrawableRes iconRes: Int?=null,
    iconSize: Dp = Theme.spacing.buttonIconSize,
    iconTint: Color = contentColor,
    contentDescription: String? = null,
    textStyle: TextStyle=Theme.typography.button,
    contentPaddingHorizontal: Dp = Theme.spacing.lg,
    contentPaddingVertical :Dp = Theme.spacing.md
    ){

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .height(height),
        shape = RoundedCornerShape(radius),
        border = border,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor.copy(alpha = 0.7f),
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = defaultElevation,
            pressedElevation = pressedElevation ,
            disabledElevation = disabledElevation
        ),
        contentPadding = PaddingValues(
            horizontal = contentPaddingHorizontal,
            vertical = contentPaddingVertical
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (iconRes != null) {
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = contentDescription,
                    modifier = Modifier.size(iconSize),
                    tint = iconTint

                )

                Spacer(modifier = Modifier.width(Theme.spacing.sm))
            }

            Text(
                text = text,
                style = textStyle,
                color = contentColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppButtonPreview_Ltr() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {

                AppButton(
                    text = "Pick-up Location",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    radius = Theme.spacing.radiusMd,
                    contentDescription = "Location icon",
                    containerColor = Theme.colors.white,
                    contentColor = Theme.colors.black,
                    border = BorderStroke(1.dp, Theme.colors.greyOutlined),
                    defaultElevation = Theme.spacing.elevationNone,
                    iconRes = Theme.icons.location
                )

                AppButton(
                    text = "Start Pickup",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = "Start icon",
                    containerColor = Theme.colors.primary,
                    contentColor = Theme.colors.white,
                    iconRes = Theme.icons.start
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AppButtonPreview_Rtl() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {

                AppButton(
                    text = "موقع الالتقاط",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    radius = Theme.spacing.radiusMd,
                    contentDescription = "Location icon",
                    containerColor = Theme.colors.white,
                    contentColor = Theme.colors.black,
                    border = BorderStroke(1.dp, Theme.colors.greyOutlined),
                    defaultElevation = Theme.spacing.elevationNone,
                    iconRes = Theme.icons.location
                )

                AppButton(
                    text = "ابدأ الالتقاط",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = "Start icon",
                    containerColor = Theme.colors.primary,
                    contentColor = Theme.colors.white,
                    iconRes = Theme.icons.start
                )
            }
        }
    }
}