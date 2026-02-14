package com.company.preview.composeui.utils

import java.util.Locale

object AppLocales {
    val ARABIC: Locale = Locale.forLanguageTag("ar-u-nu-arab")
    val ENGLISH: Locale = Locale.ENGLISH
    fun getLocale(isRtl: Boolean): Locale = if (isRtl) ARABIC else ENGLISH
}
