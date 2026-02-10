package com.company.preview.composeui.components.activeorder_ui_preview.task


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.company.preview.composeui.preview.LtrPreview
import com.company.preview.composeui.preview.RtlPreview
import com.company.preview.composeui.theme.Theme

@Composable
fun BackToStoreTaskCard(
    title: String,
    current: Int,
    total: Int,
    modifier: Modifier = Modifier
) {
    TaskItemContainer(
        modifier = modifier.fillMaxWidth()
    ) {
        TaskHeaderRow(
            title = title,
            current = current,
            total = total,
            iconResId = Theme.icons.store
        )
    }
}

@Preview(showBackground = true, name = "BackToStore EN 0/3")
@Composable
private fun BackToStorePreviewEn_ZeroThree() {
    LtrPreview {
        BackToStoreTaskCard(
            title = "Back to Store",
            current = 0,
            total = 3
        )
    }
}

@Preview(showBackground = true, name = "BackToStore EN 2/9")
@Composable
private fun BackToStorePreviewEn_TwoNine() {
    LtrPreview {
        BackToStoreTaskCard(
            title = "Back to Store",
            current = 2,
            total = 9
        )
    }
}

@Preview(showBackground = true, name = "BackToStore EN 3/3")
@Composable
private fun BackToStorePreviewEn_ThreeThree() {
    LtrPreview {
        BackToStoreTaskCard(
            title = "Back to Store",
            current = 3,
            total = 3
        )
    }
}

@Preview(showBackground = true, name = "BackToStore AR 0/3")
@Composable
private fun BackToStorePreviewAr_ZeroThree() {
    RtlPreview {
        BackToStoreTaskCard(
            title = "العودة إلى المتجر",
            current = 0,
            total = 3
        )
    }
}

@Preview(showBackground = true, name = "BackToStore AR 2/9")
@Composable
private fun BackToStorePreviewAr_TwoNine() {
    RtlPreview {
        BackToStoreTaskCard(
            title = "العودة إلى المتجر",
            current = 2,
            total = 9
        )
    }
}

@Preview(showBackground = true, name = "BackToStore AR 3/3")
@Composable
private fun BackToStorePreviewAr_ThreeThree() {
    RtlPreview {
        BackToStoreTaskCard(
            title = "العودة إلى المتجر",
            current = 3,
            total = 3
        )
    }
}