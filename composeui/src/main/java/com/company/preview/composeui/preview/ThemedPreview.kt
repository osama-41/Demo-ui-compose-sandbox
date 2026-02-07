package com.company.preview.composeui.preview

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.company.preview.composeui.theme.AppTheme
import com.company.preview.composeui.theme.Theme
import java.util.Locale
@Composable
fun ThemedPreview(
    layoutDirection: LayoutDirection = LayoutDirection.Ltr,
    localeTag: String? = null, // e.g. "ar"
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    LocaleOverride(context = context, localeTag = localeTag)

    AppTheme {
        CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Theme.colors.surface)
                    .padding(Theme.spacing.lg)
            ) {
                content()
            }
        }
    }
}
@Composable
private fun LocaleOverride(
    context: Context,
    localeTag: String?
) {
    if (localeTag == null) return

    val appContext = context.applicationContext
    val locale = remember(localeTag) { Locale.forLanguageTag(localeTag) }

    DisposableEffect(localeTag) {
        val res = appContext.resources
        val oldConfig = Configuration(res.configuration)

        // Save old locale(s)
        val oldLocale: Locale? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                oldConfig.locales[0]
            } else {
                @Suppress("DEPRECATION")
                oldConfig.locale
            }
        Locale.setDefault(locale)
        val newConfig = Configuration(res.configuration).apply {
            setLocale(locale)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                setLocales(LocaleList(locale))
            }
        }
        @Suppress("DEPRECATION")
        res.updateConfiguration(newConfig, res.displayMetrics)
        onDispose {
            val restoreConfig = Configuration(res.configuration).apply {
                if (oldLocale != null) {
                    setLocale(oldLocale)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        setLocales(LocaleList(oldLocale))
                    }
                }
            }
            @Suppress("DEPRECATION")
            res.updateConfiguration(restoreConfig, res.displayMetrics)
        }
    }
}
@Composable
private fun ThemeShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(Theme.spacing.md)) {

        Text(
            text = "Display / Headline",
            style = Theme.typography.headlineMedium,
            color = Theme.colors.primary
        )

        Text(
            text = "Title Small (Bold)",
            style = Theme.typography.titleSmallBold,
            color = Theme.colors.onSurface
        )

        Text(
            text = "Body Medium – default text",
            style = Theme.typography.bodyMedium,
            color = Theme.colors.onSurface
        )

        Text(
            text = "Label / Muted",
            style = Theme.typography.labelSmallCompact,
            color = Theme.colors.labelGray
        )

        Spacer(modifier = Modifier.height(Theme.spacing.lg))

        Row(horizontalArrangement = Arrangement.spacedBy(Theme.spacing.sm)) {
            ColorSwatch("Primary", Theme.colors.primary)
            ColorSwatch("Outline", Theme.colors.greyOutlined)
            ColorSwatch("Track", Theme.colors.trackGray)
        }
    }
}
@Composable
private fun ColorSwatch(
    label: String,
    color: androidx.compose.ui.graphics.Color
) {
    Column(
        modifier = Modifier.width(80.dp),
        verticalArrangement = Arrangement.spacedBy(Theme.spacing.xs)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color)
        )
        Text(
            text = label,
            style = Theme.typography.labelSmall,
            color = Theme.colors.onSurface
        )
    }
}
@Preview(name = "Theme – LTR", showBackground = true)
@Composable
private fun ThemePreview_LTR() {
    ThemedPreview {
        ThemeShowcase()
    }
}

