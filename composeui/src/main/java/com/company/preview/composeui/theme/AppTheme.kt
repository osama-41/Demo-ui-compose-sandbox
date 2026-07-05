package com.company.preview.composeui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    colors: AppColors = localColors.current,
    typography: AppTypography = localAppTypography.current,
    spacing: AppSpacing = localSpacing.current,
    content: @Composable () -> Unit
){
    val scheme = lightColorScheme(
        primary = colors.primary,
        onPrimary = colors.onPrimary,
        background = colors.white,
        surface = colors.surface,
        outline = colors.greyOutlined,
    )
    CompositionLocalProvider(
        localColors provides colors,
        localAppTypography provides typography,


        localSpacing provides spacing,
    ) {
        MaterialTheme(
            colorScheme = scheme,
            typography = materialTypography,
            content = content
        )
    }
}