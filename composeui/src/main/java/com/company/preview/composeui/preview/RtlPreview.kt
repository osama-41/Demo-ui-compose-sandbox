package com.company.preview.composeui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.components.organism.TaskCard
import com.company.preview.composeui.theme.AppTheme
import com.company.preview.composeui.theme.Theme

@Composable
fun ThemedPreview(content: @Composable () -> Unit) {
    AppTheme { content() }
}

@Composable
fun RtlPreview(content: @Composable () -> Unit) {
    AppTheme {
        CompositionLocalProvider(
            LocalLayoutDirection provides LayoutDirection.Rtl
        ) {
            content()
        }

    }
}
@Preview(showBackground = true, widthDp = 360)
@Composable
private fun OrderTaskCardPreview_RTL() {
    RtlPreview {
        ThemedPreview {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Theme.colors.white)
                    .padding(Theme.spacing.lg)
            ) {
                TaskCard (
                    taskTitle = "التقاط",
                    progressText = "(١/٣)",
                    timer = "٠١:١٦",
                    progress = 0.35f,
                    orderText = "طلب #٠٥٣٢٣",
                    storeName = "متجر نينجا",
                    locationText = "موقع الالتقاط",
                    startText = "ابدأ الالتقاط",
                    taskIconRes = Theme.icons.taskPickup,
                    onLocationClick = {},
                    onStartClick = {}
                )
            }}
    }
}