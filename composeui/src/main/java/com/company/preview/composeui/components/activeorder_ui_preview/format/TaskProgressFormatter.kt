package com.company.preview.composeui.components.activeorder_ui_preview.format

object TaskProgressFormatter {

    fun formatProgress(current: Int, total: Int, isRtl: Boolean): String {
        val c = if (isRtl) toArabicDigits(current) else current.toString()
        val t = if (isRtl) toArabicDigits(total) else total.toString()
        return if (isRtl) "($t/$c)" else "($c/$t)"
    }

    fun toArabicDigits(value: Int): String {
        val map = charArrayOf('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩')
        return value
            .toString()
            .map { ch -> if (ch in '0'..'9') map[ch - '0'] else ch }
            .joinToString("")
    }
}