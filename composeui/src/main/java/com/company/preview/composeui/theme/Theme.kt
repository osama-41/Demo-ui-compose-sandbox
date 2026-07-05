package com.company.preview.composeui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Theme {
    val colors: AppColors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = localAppTypography.current

    val spacing: AppSpacing
        @Composable
        @ReadOnlyComposable
        get() = localSpacing.current
}