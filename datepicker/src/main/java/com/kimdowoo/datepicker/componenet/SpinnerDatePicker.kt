package com.kimdowoo.datepicker.componenet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kimdowoo.datepicker.model.Date
import com.kimdowoo.datepicker.theme.PickerTheme
import com.kimdowoo.datepicker.theme.colorLightPrimary
import com.kimdowoo.datepicker.theme.colorLightTextPrimary
import com.kimdowoo.datepicker.utils.DateUtils
import com.kimdowoo.datepicker.utils.YearMonthDay
import com.kimdowoo.datepicker.utils.daysOfDate
import com.kimdowoo.datepicker.utils.monthsOfDate
import com.kimdowoo.datepicker.utils.withDay
import com.kimdowoo.datepicker.utils.withMonth
import com.kimdowoo.datepicker.utils.withYear

@Composable
fun SpinnerDatePicker(
    modifier: Modifier = Modifier,
    offset: Int = 3,
    yearsRange: IntRange = IntRange(1923, 2121),
    startDate: Date = Date(DateUtils.getCurrentTime()),
    textSize: Int = 16,
    isTransformationEnabled : Boolean = true,
    selectorEffectEnabled: Boolean = false,
    selectViewEnable: Boolean = false,
    onDateChanged: (Int, Int, Int) -> Unit = { _, _, _ -> },
    darkModeEnabled: Boolean = false,
) {

    var selectedDate by remember { mutableStateOf(startDate) }
    val months = selectedDate.monthsOfDate()
    val days = selectedDate.daysOfDate()

    val years = yearsRange.toList()

    LaunchedEffect(selectedDate) {
        onDateChanged(selectedDate.day, selectedDate.month, selectedDate.year)
    }

    val fontSize = maxOf(13, minOf(19, textSize))

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(getPickerBackgroundColor(darkModeEnabled)),
        contentAlignment = Alignment.Center
    ) {

        val height = (fontSize + 11).dp

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))

            WheelView(
                modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                years,
                selectedDate.year,
                height,
                fontSize,
                darkModeEnabled,
                offset,
                selectorEffectEnabled,
                isTransformationEnabled,
                YearMonthDay.YEAR,
                Alignment.End,
                TextAlign.Start,
            ) {
                selectedDate = selectedDate.withYear(years[it])
            }

            WheelView(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                months,
                selectedDate.month,
                height,
                fontSize,
                darkModeEnabled,
                offset,
                selectorEffectEnabled,
                isTransformationEnabled,
                YearMonthDay.MONTH,
                Alignment.CenterHorizontally,
                TextAlign.Center,
            ) {
                selectedDate = selectedDate.withMonth(months[it])
            }

            key(days.size) {
                WheelView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    days,
                    selectedDate.day,
                    height,
                    fontSize,
                    darkModeEnabled,
                    offset,
                    selectorEffectEnabled,
                    isTransformationEnabled,
                    YearMonthDay.DAY,
                    Alignment.Start,
                    TextAlign.End,
                ) {
                    selectedDate = selectedDate.withDay(days[it])
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }

        SelectorView(
            darkModeEnabled = darkModeEnabled,
            offset = offset,
            selectViewEnable = selectViewEnable
        )
    }
}

@Composable
fun getPickerBackgroundColor(darkModeEnabled: Boolean) =
    if (darkModeEnabled) PickerTheme.colors.primary else colorLightPrimary

@Composable
fun getTextColor(darkModeEnabled: Boolean) =
    if (darkModeEnabled) PickerTheme.colors.textPrimary else colorLightTextPrimary