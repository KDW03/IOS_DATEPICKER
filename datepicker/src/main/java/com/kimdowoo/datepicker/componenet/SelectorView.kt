package com.kimdowoo.datepicker.componenet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.kimdowoo.datepicker.theme.PickerTheme
import com.kimdowoo.datepicker.theme.colorLightTextPrimary


@Composable
fun SelectorView(
    modifier: Modifier = Modifier,
    darkModeEnabled: Boolean,
    offset: Int,
    selectViewEnable: Boolean
) {
    Column(
        modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(offset.toFloat())
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .weight(1.13f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .height(0.5.dp)
                    .alpha(0.5f)
                    .then(if (selectViewEnable)
                        Modifier.background(if (darkModeEnabled) PickerTheme.colors.textPrimary else colorLightTextPrimary)
                    else Modifier
                    )
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .height(0.5.dp)
                    .alpha(0.5f)
                    .then(if (selectViewEnable)
                        Modifier.background(if (darkModeEnabled) PickerTheme.colors.textPrimary else colorLightTextPrimary)
                    else Modifier
                    )
                    .fillMaxWidth()
            )

        }



        Box(
            modifier = Modifier
                .weight(offset.toFloat())
                .fillMaxWidth()
        )
    }
}