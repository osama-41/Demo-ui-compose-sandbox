package com.company.preview.composeui.components.order_card.atom

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.AppButtonElevationModel
import com.company.preview.composeui.components.model.AppButtonModel
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun AppButton(
    model: AppButtonModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    ){

    Button(
        onClick = onClick,
        enabled = model.enabled,
        modifier = modifier.height(model.height),
        shape = RoundedCornerShape(model.radius),
        border = model.border,
        colors = ButtonDefaults.buttonColors(
            containerColor = model.containerColor,
            contentColor = model.contentColor,
            disabledContainerColor = model.containerColor.copy(alpha = 0.5f),
            disabledContentColor = model.contentColor.copy(alpha = 0.7f),
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = model.elevation.defaultElevation,
            pressedElevation = model.elevation.pressedElevation,
            disabledElevation = model.elevation.disabledElevation
        ),
        contentPadding = model.contentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            model.icon?.let { icon ->
                Icon(
                    painter = painterResource(icon.resId),
                    contentDescription = model.contentDescription,
                    modifier = Modifier.size(model.iconSize),
                    tint = model.iconTint
                )
                Spacer(modifier = Modifier.width(Theme.spacing.sm))
            }

            Text(
                text = model.text,
                style = model.textStyle,
                color = model.contentColor
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
                    model = AppButtonModel(
                        text = "Pick-up Location",
                        textStyle = Theme.typography.button,
                        enabled = true,

                        height = Theme.spacing.buttonHeight,
                        radius = Theme.spacing.radiusMd,
                        contentPadding = PaddingValues(
                            horizontal = Theme.spacing.lg,
                            vertical = Theme.spacing.md
                        ),

                        containerColor = Theme.colors.white,
                        contentColor = Theme.colors.primary,

                        border = BorderStroke(Theme.spacing.xxs, Theme.colors.greyOutlined),
                        elevation = AppButtonElevationModel(
                            defaultElevation = Dp.Unspecified,
                            pressedElevation = Dp.Unspecified,
                            disabledElevation = Dp.Unspecified
                        ),

                        icon = OrderScreenIcons.Location,
                        iconSize = Theme.spacing.buttonIconSize,
                        iconTint = Theme.colors.primary,
                        contentDescription = "Location icon",
                    ),
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
                AppButton(
                    model = AppButtonModel(
                        text = "Start Pickup",
                        textStyle = Theme.typography.button,
                        enabled = true,

                        height = Theme.spacing.buttonHeight,
                        radius = Theme.spacing.radiusMd,
                        contentPadding = PaddingValues(
                            horizontal = Theme.spacing.lg,
                            vertical = Theme.spacing.md
                        ),

                        containerColor = Theme.colors.primary,
                        contentColor = Theme.colors.white,

                        border = null,

                        elevation = AppButtonElevationModel(
                            defaultElevation = Dp.Unspecified,
                            pressedElevation = Dp.Unspecified,
                            disabledElevation = Dp.Unspecified
                        ),

                        icon = OrderScreenIcons.Start,
                        iconSize = Theme.spacing.buttonIconSize,
                        iconTint = Theme.colors.white,
                        contentDescription = "Start icon",
                    ),
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
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
                    model = AppButtonModel(
                        text = "موقع الالتقاط",
                        textStyle = Theme.typography.button,
                        enabled = true,

                        height = Theme.spacing.buttonHeight,
                        radius = Theme.spacing.radiusMd,
                        contentPadding = PaddingValues(
                            horizontal = Theme.spacing.lg,
                            vertical = Theme.spacing.md
                        ),

                        containerColor = Theme.colors.white,
                        contentColor = Theme.colors.primary,

                        border = BorderStroke(Theme.spacing.xxs, Theme.colors.greyOutlined),
                        elevation = AppButtonElevationModel(
                            defaultElevation = Dp.Unspecified,
                            pressedElevation = Dp.Unspecified,
                            disabledElevation = Dp.Unspecified
                        ),

                        icon = OrderScreenIcons.Location,
                        iconSize = Theme.spacing.buttonIconSize,
                        iconTint = Theme.colors.primary,
                        contentDescription = "Location icon",
                    ),
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )

                AppButton(
                    model = AppButtonModel(
                        text = "ابدأ الالتقاط",
                        textStyle = Theme.typography.button,
                        enabled = true,

                        height = Theme.spacing.buttonHeight,
                        radius = Theme.spacing.radiusMd,
                        contentPadding = PaddingValues(
                            horizontal = Theme.spacing.lg,
                            vertical = Theme.spacing.md
                        ),

                        containerColor = Theme.colors.primary,
                        contentColor = Theme.colors.white,

                        border = null,

                        elevation = AppButtonElevationModel(
                            defaultElevation = Dp.Unspecified,
                            pressedElevation = Dp.Unspecified,
                            disabledElevation = Dp.Unspecified
                        ),

                        icon = OrderScreenIcons.Start,
                        iconSize = Theme.spacing.buttonIconSize,
                        iconTint = Theme.colors.white,
                        contentDescription = "Start icon",
                    ),
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }
}