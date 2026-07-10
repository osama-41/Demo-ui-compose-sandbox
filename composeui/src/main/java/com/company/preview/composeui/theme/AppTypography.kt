package com.company.preview.composeui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.company.preview.composeui.R

private val interFont = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

@Immutable
data class AppTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val labelSmall: TextStyle,
    val button: TextStyle,
    val titleSmallBold: TextStyle,
    val titleSmallExtraBold: TextStyle,
    val titleMediumBold: TextStyle,
    val titleLargeBold: TextStyle,
    val labelSmallCompactLineHeight: TextStyle,
    val appBarBold: TextStyle,
    val titleXlBold: TextStyle,
    val displayBold: TextStyle
)

private val defaultAppTypography = AppTypography(
    titleLarge = TextStyle(fontFamily = interFont, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, lineHeight = 24.sp),
    titleMedium = TextStyle(fontFamily = interFont, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 20.sp),
    titleSmall = TextStyle(fontFamily = interFont, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp),
    bodyMedium = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 18.sp),
    bodySmall = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp),
    labelSmall = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 14.sp),
    button = TextStyle(fontFamily = interFont, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 18.sp),
    titleSmallBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Bold, fontSize = 12.sp, lineHeight = 20.sp),
    titleSmallExtraBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.ExtraBold, fontSize = 12.sp, lineHeight = 20.sp),
    titleMediumBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Bold, fontSize = 16.sp, lineHeight = 20.sp),
    titleLargeBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Bold, fontSize = 20.sp, lineHeight = 24.sp),
    labelSmallCompactLineHeight = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Medium, fontSize = 9.sp, lineHeight = 12.sp),
    appBarBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.SemiBold, fontSize = 18.sp),
    titleXlBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Bold, fontSize = 22.sp, lineHeight = 26.sp),
    displayBold = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Bold, fontSize = 30.sp, lineHeight = 36.sp),
    )

val localAppTypography = staticCompositionLocalOf { defaultAppTypography }

val materialTypography = Typography(
    titleLarge = defaultAppTypography.titleLarge,
    titleMedium = defaultAppTypography.titleMedium,
    titleSmall = defaultAppTypography.titleSmall,
    bodyLarge = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = defaultAppTypography.bodyMedium,
    bodySmall = defaultAppTypography.bodySmall,
    labelLarge = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
    labelMedium = TextStyle(fontFamily = interFont, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp),
    labelSmall = defaultAppTypography.labelSmall,
)