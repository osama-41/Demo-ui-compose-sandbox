package com.company.preview.composeui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.R

data class AppTypography(
    val materialTypography: Typography
) {
    val displayLarge get() = materialTypography.displayLarge
    val displayMedium get() = materialTypography.displayMedium
    val displaySmall get() = materialTypography.displaySmall
    val headlineLarge get() = materialTypography.headlineLarge
    val headlineMedium get() = materialTypography.headlineMedium
    val headlineSmall get() = materialTypography.headlineSmall
    val titleLarge get() = materialTypography.titleLarge
    val titleMedium get() = materialTypography.titleMedium
    val titleSmall get() = materialTypography.titleSmall

    val bodyLarge get() = materialTypography.bodyLarge
    val bodyMedium get() = materialTypography.bodyMedium
    val bodySmall get() = materialTypography.bodySmall
    val labelLarge get() = materialTypography.labelLarge
    val labelMedium get() = materialTypography.labelMedium
    val labelSmall get() = materialTypography.labelSmall

    val titleSmallBold get() =
        materialTypography.titleSmall.copy(fontWeight = FontWeight.Bold, fontSize = 12.sp)
    val titleSmallExtraBold get() =
        materialTypography.titleSmall.copy(fontWeight = FontWeight.ExtraBold, fontSize = 12.sp)
    val titleMediumBold get() =
        materialTypography.titleMedium.copy(fontWeight = FontWeight.Bold)
    val titleLargeBold get() =
        materialTypography.titleLarge.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp)
    val labelSmallCompact get() =
        materialTypography.labelSmall.copy(fontSize = 9.sp)
    val labelSmallCompactLineHeight get() =
        materialTypography.labelSmall.copy(fontSize = 9.sp, lineHeight = 12.sp)
}
private val AppFontFamily = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
)
private val MaterialTypographyWithFont: Typography = Typography().run {
    Typography(
        displayLarge = displayLarge.copy(fontFamily = AppFontFamily),
        displayMedium = displayMedium.copy(fontFamily = AppFontFamily),
        displaySmall = displaySmall.copy(fontFamily = AppFontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = AppFontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = AppFontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = AppFontFamily),
        titleLarge = titleLarge.copy(fontFamily = AppFontFamily),
        titleMedium = titleMedium.copy(fontFamily = AppFontFamily),
        titleSmall = titleSmall.copy(fontFamily = AppFontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = AppFontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = AppFontFamily),
        bodySmall = bodySmall.copy(fontFamily = AppFontFamily),
        labelLarge = labelLarge.copy(fontFamily = AppFontFamily),
        labelMedium = labelMedium.copy(fontFamily = AppFontFamily),
        labelSmall = labelSmall.copy(fontFamily = AppFontFamily),
    )
}
val DefaultAppTypography = AppTypography(materialTypography = MaterialTypographyWithFont)
val LocalAppTypography = staticCompositionLocalOf { DefaultAppTypography }