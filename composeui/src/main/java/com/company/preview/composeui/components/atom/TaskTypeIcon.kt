package com.company.preview.composeui.components.atom

import android.accessibilityservice.GestureDescription
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskTypeIcon(
    @DrawableRes iconRes:Int,
    modifier: Modifier= Modifier,
    contentDescription: String?=null,
    size: Int=36
){
    val shape=RoundedCornerShape(Theme.radius.sm)
    Box(
        modifier = modifier
            .size(size.dp)
            .clip(shape = shape)
            .background(Theme.colors.surface)
            .border(
                width = Theme.spacing.borderSize,
                color = Theme.colors.outline,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            modifier = modifier.size(Theme.spacing.iconSize)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TaskTypeIconPreview_LTR() {
    ThemedPreview {
        TaskTypeIcon(iconRes = Theme.icons.taskPickup)
    }
}
@Preview(showBackground = true)
@Composable
private fun TaskTypeIconPreview_RTL() {
    RtlPreview {
        TaskTypeIcon(iconRes = Theme.icons.taskPickup)
    }
}