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
    icons: AppIcons = localIcons.current,
    content: @Composable () -> Unit
){
    val scheme = lightColorScheme(
        primary = colors.primary,
        onPrimary = colors.secondary,
        background = colors.white,
        surface = colors.surface,
        onSurface = colors.surface,
        outline = colors.greyOutlined,
    )
    CompositionLocalProvider(
        localColors provides colors,
        localAppTypography provides typography,


        localSpacing provides spacing,
        localIcons provides icons,
    ) {
        MaterialTheme(
            colorScheme = scheme,
            typography = typography.materialTypography,
            content = content
        )
    }
}
