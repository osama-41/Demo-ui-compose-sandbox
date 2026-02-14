package com.company.preview.composeui.components.model

data class TaskProgressIndicatorModel(
    val completed: Int,
    val total: Int,
    val centerText: String,
    val subtitleText: String
)
