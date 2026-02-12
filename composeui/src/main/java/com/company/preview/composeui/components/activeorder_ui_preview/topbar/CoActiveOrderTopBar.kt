package com.company.preview.composeui.components.activeorder_ui_preview.topbar

import androidx.compose.runtime.Composable

@Composable
fun CoActiveOrderTopBar(
    title: String,
    isSupportEnabled: Boolean,
    onBackClick: () -> Unit,
    onSupportClick: () -> Unit
){
    val uiModel = ActiveOrderTopBarUiModel(
        title = title,
        isSupportVisible = isSupportEnabled
    )

    ActiveOrderTopBar(
        title = uiModel.title,
        isSupportVisible = uiModel.isSupportVisible,
        onBackClick = onBackClick,
        onSupportClick = onSupportClick
    )
}