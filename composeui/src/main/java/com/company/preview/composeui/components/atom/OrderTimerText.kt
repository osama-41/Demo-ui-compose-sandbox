package com.company.preview.composeui.components.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview
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
    ThemedPreview {
        OrderTimer(time = "01:16")
    }
}
@Preview(showBackground = true)
@Composable
private fun OrderTimerPreview_RTL() {
    RtlPreview {
        OrderTimer(time = "٠١:١٦")
    }
}
