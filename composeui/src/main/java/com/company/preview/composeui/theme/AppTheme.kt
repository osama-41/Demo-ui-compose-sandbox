package com.company.preview.composeui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    colors: AppColors = LocalColors.current,
    typography: AppTypography = LocalAppTypography.current,
    spacing: AppSpacing = localSpacing.current,
    icons: AppIcons = localIcons.current,
    content: @Composable () -> Unit
) {
    val scheme = lightColorScheme(
        primary = colors.primary,
        background = colors.white,
        outline = colors.greyOutlined,
    )

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalAppTypography provides typography,
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
