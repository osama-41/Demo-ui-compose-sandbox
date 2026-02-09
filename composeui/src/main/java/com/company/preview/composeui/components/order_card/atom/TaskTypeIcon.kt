package com.company.preview.composeui.components.order_card.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun TaskTypeIcon(
    @DrawableRes iconRes:Int,
    modifier: Modifier= Modifier,
    contentDescription: String?=null,
){
    val shape=RoundedCornerShape(Theme.spacing.radiusSm)
    Box(
        modifier = modifier
            .size(Theme.spacing.x3l)
            .clip(shape = shape)
            .background(Theme.colors.surface)
            .border(
                width = Theme.spacing.buttonBorderSize,
                color = Theme.colors.greyOutlined,
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
    LtrPreview {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
        TaskTypeIcon(iconRes = Theme.icons.taskPickup)
             }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun TaskTypeIconPreview_RTL() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
        TaskTypeIcon(iconRes = Theme.icons.taskPickup)
            }
        }
    }
}