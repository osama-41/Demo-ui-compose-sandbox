package com.company.preview.composeui.components.order_card.organism

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.company.preview.composeui.components.enums.OrderScreenIcons
import com.company.preview.composeui.components.model.AppButtonElevationModel
import com.company.preview.composeui.components.model.AppButtonModel
import com.company.preview.composeui.components.model.TaskCardModel
import com.company.preview.composeui.components.model.TaskHeaderModel
import com.company.preview.composeui.components.order_card.atom.AppButton
import com.company.preview.composeui.components.order_card.molecule.OrderInfoRow
import com.company.preview.composeui.components.order_card.molecule.TaskHeader
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskCard(
    model: TaskCardModel,
    modifier: Modifier = Modifier,
    onLocationClick: () -> Unit,
    onStartClick: () -> Unit,
){
    val shape = RoundedCornerShape(Theme.spacing.radiusCard)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = Theme.spacing.elevationCard,
                shape = shape
            )
            .clip(shape)
            .background(Theme.colors.surface)
            .border(width = Theme.spacing.cardBorderSize, color = Theme.colors.primary, shape = shape)
            .padding(Theme.spacing.lg)
    ) {
        TaskHeader(
            model = model.header
        )

        Spacer(modifier = Modifier.height(Theme.spacing.md))

        OrderInfoRow(
            orderText = model.orderNumber,
            storeName = model.storeName,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Theme.spacing.lg))


        AppButton(
            model = model.locationButton,
            onClick = onLocationClick,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Theme.spacing.md))

        AppButton(
            model = model.startButton,
            onClick = onStartClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TaskCard_Ltr() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {
                TaskCard(
                    model = TaskCardModel(
                        header = TaskHeaderModel(
                            icon = OrderScreenIcons.TaskPickup,
                            title = "Pick up",
                            progressText = "(1/3)",
                            timerText = "01:16",
                            progress = 0.35f
                        ),
                        orderNumber = "Order #05323",
                        storeName = "Ninja Grocery",
                        locationButton = AppButtonModel(
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
                            contentColor = Theme.colors.black,
                            border = BorderStroke(
                                Theme.spacing.buttonBorderSize,
                                Theme.colors.greyOutlined
                            ),
                            elevation = AppButtonElevationModel(
                                defaultElevation = Dp.Unspecified,
                                pressedElevation = Dp.Unspecified,
                                disabledElevation = Dp.Unspecified
                            ),
                            icon = OrderScreenIcons.Location,
                            iconSize = Theme.spacing.buttonIconSize,
                            iconTint = Theme.colors.black,
                            contentDescription = "Location icon"
                        ),
                        startButton = AppButtonModel(
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
                            contentDescription = "Start icon"
                        )
                    ),
                    onLocationClick = {},
                    onStartClick = {}
                )
                TaskCard(
                    model = TaskCardModel(
                        header = TaskHeaderModel(
                            icon = OrderScreenIcons.TaskPickup,
                            title = "Pick up",
                            progressText = "(2/3)",
                            timerText = "01:1616:16",
                            progress = 0.65f
                        ),
                        orderNumber = "Order #3205323",
                        storeName = "Ninja Grocery",
                        locationButton = AppButtonModel(
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
                            contentColor = Theme.colors.black,
                            border = BorderStroke(
                                Theme.spacing.buttonBorderSize,
                                Theme.colors.greyOutlined
                            ),
                            elevation = AppButtonElevationModel(
                                defaultElevation = Dp.Unspecified,
                                pressedElevation = Dp.Unspecified,
                                disabledElevation = Dp.Unspecified
                            ),
                            icon = OrderScreenIcons.Location,
                            iconSize = Theme.spacing.buttonIconSize,
                            iconTint = Theme.colors.black,
                            contentDescription = "Location icon"
                        ),
                        startButton = AppButtonModel(
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
                            contentDescription = "Start icon"
                        )
                    ),
                    onLocationClick = {},
                    onStartClick = {}
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskCard_Rtl() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {
                TaskCard(
                    model = TaskCardModel(
                        header = TaskHeaderModel(
                            icon = OrderScreenIcons.TaskPickup,
                            title = "التقاط",
                            progressText = "(١/٣)",
                            timerText = "٠١:١٦",
                            progress = 0.35f
                        ),
                        orderNumber = "طلب #٠٥٣٢٣",
                        storeName = "متجر نينجا",
                        locationButton = AppButtonModel(
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
                            contentColor = Theme.colors.black,
                            border = BorderStroke(
                                Theme.spacing.buttonBorderSize,
                                Theme.colors.greyOutlined
                            ),
                            elevation = AppButtonElevationModel(
                                defaultElevation = Dp.Unspecified,
                                pressedElevation = Dp.Unspecified,
                                disabledElevation = Dp.Unspecified
                            ),
                            icon = OrderScreenIcons.Location,
                            iconSize = Theme.spacing.buttonIconSize,
                            iconTint = Theme.colors.black,
                            contentDescription = "Location icon"
                        ),
                        startButton = AppButtonModel(
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
                            contentDescription = "Start icon"
                        )
                    ),
                    onLocationClick = {},
                    onStartClick = {}
                )


                TaskCard(
                    model = TaskCardModel(
                        header = TaskHeaderModel(
                            icon = OrderScreenIcons.TaskPickup,
                            title = "التقاط",
                            progressText = "(٢/٣)",
                            timerText = "٠١:١٦١٦:١٦",
                            progress = 0.65f
                        ),
                        orderNumber = "طلب #٣٢٠٥٣٢٣",
                        storeName = "متجر نينجا",
                        locationButton = AppButtonModel(
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
                            contentColor = Theme.colors.black,
                            border = BorderStroke(
                                Theme.spacing.buttonBorderSize,
                                Theme.colors.greyOutlined
                            ),
                            elevation = AppButtonElevationModel(
                                defaultElevation = Dp.Unspecified,
                                pressedElevation = Dp.Unspecified,
                                disabledElevation = Dp.Unspecified
                            ),
                            icon = OrderScreenIcons.Location,
                            iconSize = Theme.spacing.buttonIconSize,
                            iconTint = Theme.colors.black,
                            contentDescription = "Location icon"
                        ),
                        startButton = AppButtonModel(
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
                            contentDescription = "Start icon"
                        )
                    ),
                    onLocationClick = {},
                    onStartClick = {}
                )

            }
        }
    }
}
