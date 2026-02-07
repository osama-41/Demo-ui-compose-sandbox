package com.company.preview.composeui.components.molecule

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.components.atom.StoreBadge
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.preview.ThemedPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun OrderInfoRow(
    orderText: String,
    storeName: String,
    modifier: Modifier= Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = orderText,
            style = Theme.typography.titleLarge,
            color = Theme.colors.black
        )
        Spacer(modifier = Modifier.size(Theme.spacing.sm))
        StoreBadge(text = storeName)
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderInfoRowPreview_LTR() {
    ThemedPreview {
        OrderInfoRow(
            orderText = "Order #05323",
            storeName = "Ninja Grocery"
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun OrderInfoRowPreview_RTL() {
    RtlPreview {
        OrderInfoRow(
            orderText = "طلب #05323",
            storeName = "نينجا"
        )
    }
}