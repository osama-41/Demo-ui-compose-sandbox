package com.company.preview.composeui.preview


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.theme.Theme

@Preview(showBackground = true)
@Composable
fun ThemeSmokePreview_LTR() {
    ThemedPreview {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.white)
                .padding(Theme.spacing.lg)
        ) {
            Text("Title Large", style = Theme.typography.titleLarge, color = Theme.colors.black)
            Spacer(Modifier.height(Theme.spacing.md))
            Text("Body Medium", style = Theme.typography.bodyMedium, color = Theme.colors.secondaryText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeSmokePreview_RTL() {
    RtlPreview {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colors.white)
                .padding(Theme.spacing.lg)
        ) {
            Text("عنوان", style = Theme.typography.titleLarge, color = Theme.colors.black)
            Spacer(Modifier.height(Theme.spacing.md))
            Text("نص تجريبي", style = Theme.typography.bodyMedium, color = Theme.colors.secondaryText)
        }
    }

}

