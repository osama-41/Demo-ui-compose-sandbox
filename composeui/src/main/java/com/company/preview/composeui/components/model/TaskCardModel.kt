package com.company.preview.composeui.components.model

data class TaskCardModel(
    val header: TaskHeaderModel,
    val orderNumber: String,
    val storeName: String,
    val locationButton: AppButtonModel,
    val startButton: AppButtonModel
)