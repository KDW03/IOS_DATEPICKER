package com.kimdowoo.datepicker.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object PickerTheme {
    val colors: PickerColors
        @Composable @ReadOnlyComposable get() = darkColors()
}