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
    radius: AppRadius = localRadius.current,
    elevation: AppElevation = localElevation.current,
    icons: AppIcons = localIcons.current,
    content: @Composable () -> Unit
){
    val scheme = lightColorScheme(
        primary = colors.primary,
        onPrimary = colors.onPrimary,
        background = colors.background,
        surface = colors.surface,
        onSurface = colors.textPrimary,
        outline = colors.outline,
    )
    CompositionLocalProvider(
        localColors provides colors,
        localAppTypography provides typography,
        localSpacing provides spacing,
        localRadius provides radius,
        localElevation provides elevation,
        localIcons provides icons,
    ) {
        MaterialTheme(
            colorScheme = scheme,
            typography = materialTypography,
            content = content
        )
    }
}