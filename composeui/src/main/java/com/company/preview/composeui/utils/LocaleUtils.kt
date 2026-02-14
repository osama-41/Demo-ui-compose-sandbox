package com.company.preview.composeui.utils

import java.text.NumberFormat
import java.util.Locale
import kotlin.math.max

object AppLocales {
    val ARABIC: Locale = Locale.forLanguageTag("ar-u-nu-arab")
    val ENGLISH: Locale = Locale.ENGLISH
    fun getLocale(isRtl: Boolean): Locale = if (isRtl) ARABIC else ENGLISH

    fun formatTaskProgress(
        completed: Int,
        total: Int,
        locale: Locale
    ): String {
        val safeTotal = max(total, 1)
        val safeCompleted = completed.coerceIn(0, safeTotal)

        val nf = NumberFormat.getInstance(locale)
        val c = nf.format(safeCompleted.toLong())
        val t = nf.format(safeTotal.toLong())

        return if (locale.language == "ar") {
            "$c من $t"
        } else {
            "$c of $t"
        }
    }
}
