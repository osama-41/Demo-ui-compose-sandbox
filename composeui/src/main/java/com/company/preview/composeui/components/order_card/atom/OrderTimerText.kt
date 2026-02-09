package com.company.preview.composeui.components.order_card.atom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun OrderTimer(
    time: String,
    modifier: Modifier = Modifier
){
    Text(
        text = time,
        style = Theme.typography.titleLarge,
        modifier = modifier,
        color = Theme.colors.black
    )
}
@Preview(showBackground = true)
@Composable
private fun OrderTimerPreview_LTR() {
    LtrPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {
                OrderTimer(time = "01:16")
                OrderTimer(time = "01:16:16")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderTimerPreview_RTL() {
    RtlPreview {
        Surface(
            modifier = Modifier.padding(Theme.spacing.lg),
            color = Theme.colors.white
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.lg)
            ) {
                OrderTimer(time = "٠١:١٦")
                OrderTimer(time = "٠١:١٦:١٦")
            }
        }
    }
}
