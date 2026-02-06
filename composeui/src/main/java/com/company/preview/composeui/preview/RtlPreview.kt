package com.company.preview.composeui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.company.preview.composeui.theme.AppTheme

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