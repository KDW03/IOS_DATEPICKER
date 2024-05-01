package com.kimdowoo.datepicker.componenet

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kimdowoo.datepicker.utils.SelectorOptions
import com.kimdowoo.datepicker.utils.YearMonthDay

@Composable
fun WheelView(
    modifier: Modifier = Modifier,
    items: List<Int>,
    selectedItem: Int,
    height: Dp,
    darkModeEnabled: Boolean,
    offset: Int,
    selectorEffectEnabled: Boolean,
    isTransformationEnabled: Boolean,
    yearMonthDay: YearMonthDay,
    horizontalAlignment: Alignment.Horizontal,
    textAlign: TextAlign,
    textStyle: TextStyle,
    onFocusItem: (Int) -> Unit,
) {
    WheelView(
        modifier = modifier,
        itemSize = DpSize(150.dp, height),
        selection = maxOf(items.indexOf(selectedItem), 0),
        itemCount = items.size,
        rowOffset = offset,
        selectorOption = SelectorOptions().copy(selectEffectEnabled = selectorEffectEnabled),
        onFocusItem = onFocusItem,
        horizontalAlignment = horizontalAlignment,
        isTransformationEnabled = isTransformationEnabled,
        content = {
            Text(
                text = items[it].toString() + yearMonthDay.label,
                textAlign = textAlign,
                modifier = Modifier.width(80.dp),
                style = textStyle,
            )
        }
    )
}

@Composable
private fun WheelView(
    modifier: Modifier = Modifier,
    itemSize: DpSize,
    selection: Int = 0,
    itemCount: Int,
    rowOffset: Int = 3,
    isEndless: Boolean = true,
    onFocusItem: (Int) -> Unit,
    userScrollEnabled: Boolean = true,
    selectorOption: SelectorOptions,
    lazyWheelState: LazyListState? = null,
    horizontalAlignment: Alignment.Horizontal,
    isTransformationEnabled: Boolean,
    content: @Composable LazyItemScope.(index: Int) -> Unit,
) {
    InfiniteWheelViewImpl(
        modifier = modifier,
        itemSize = itemSize,
        selection = selection,
        itemCount = itemCount,
        rowOffset = rowOffset,
        isEndless = isEndless,
        onFocusItem = onFocusItem,
        userScrollEnabled = userScrollEnabled,
        selectorOption = selectorOption,
        lazyWheelState = lazyWheelState,
        horizontalAlignment = horizontalAlignment,
        isTransformationEnabled = isTransformationEnabled
    ) {
        content(it)
    }
}
