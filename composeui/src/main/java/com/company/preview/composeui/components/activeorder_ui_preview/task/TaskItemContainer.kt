package com.company.preview.composeui.components.activeorder_ui_preview.task

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.components.activeorder_ui_preview.format.TaskProgressFormatter
import com.company.preview.composeui.theme.Theme

@Composable
internal fun TaskItemContainer(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(Theme.spacing.md),
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(Theme.spacing.lg)

    Card(
        modifier = modifier.heightIn(min = Theme.spacing.taskItemMinHeight),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = Theme.colors.white),
        elevation = CardDefaults.cardElevation(defaultElevation = Theme.spacing.elevationNone)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(Theme.spacing.buttonBorderSize,Theme.colors.greyOutlined, shape = shape)
                .padding(contentPadding)
        ) {
            content()
        }
    }
}

@Composable
internal fun TaskHeaderRow(
    title: String,
    current: Int,
    total: Int,
    iconResId: Int,
    modifier: Modifier = Modifier
) {

    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val progress = TaskProgressFormatter.formatProgress(
        current = current,
        total = total,
        isRtl = isRtl
    )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TaskIcon(iconResId = iconResId)

        Spacer(modifier = Modifier.width(Theme.spacing.sm))

        Text(
            text = title,
            color = Theme.colors.secondaryText,
            style = Theme.typography.titleMediumBold
        )

        Spacer(modifier = Modifier.width(Theme.spacing.sm))

        Text(
            text = progress,
            color = Theme.colors.secondaryText,
            style = Theme.typography.titleMediumBold
        )
    }
}

@Composable
private fun TaskIcon(
    iconResId: Int,
    modifier: Modifier = Modifier
) {
    val colors = Theme.colors

    Icon(
        modifier = modifier
            .width(Theme.spacing.xl)
            .heightIn(min = Theme.spacing.xl),
        painter = painterResource(id = iconResId),
        contentDescription = null,
        tint = colors.mediumGray
    )
}
