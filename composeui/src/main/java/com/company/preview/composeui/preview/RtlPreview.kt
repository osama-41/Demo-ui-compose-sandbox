package com.company.preview.composeui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.runtime.CompositionLocalProvider
import com.company.preview.composeui.theme.PreviewTheme

@Composable
fun RtlPreview(content: @Composable () -> Unit) {
    PreviewTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            content()
        }
    }
}
