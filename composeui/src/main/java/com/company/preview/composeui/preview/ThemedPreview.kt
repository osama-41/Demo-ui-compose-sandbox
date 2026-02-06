package com.company.preview.composeui.preview

import androidx.compose.runtime.Composable
import com.company.preview.composeui.theme.PreviewTheme

@Composable
fun ThemedPreview(content: @Composable () -> Unit) {
    PreviewTheme { content() }
}

