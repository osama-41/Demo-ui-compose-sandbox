package com.company.preview.composeui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Theme {

    val colors: AppColors
        @Composable @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable @ReadOnlyComposable
        get() = LocalAppTypography.current

    val spacing: AppSpacing
        @Composable @ReadOnlyComposable
        get() = localSpacing.current

    val icons: AppIcons
        @Composable @ReadOnlyComposable
        get() = localIcons.current
}