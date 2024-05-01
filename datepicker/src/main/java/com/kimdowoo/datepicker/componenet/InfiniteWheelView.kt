package com.kimdowoo.datepicker.componenet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.kimdowoo.datepicker.utils.SelectorOptions
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun InfiniteWheelViewImpl(
    modifier: Modifier,
    itemSize: DpSize,
    selection: Int,
    itemCount: Int,
    rowOffset: Int,
    isEndless: Boolean,
    onFocusItem: (Int) -> Unit,
    selectorOption: SelectorOptions,
    userScrollEnabled: Boolean = true,
    lazyWheelState: LazyListState? = null,
    horizontalAlignment: Alignment.Horizontal,
    isTransformationEnabled: Boolean,
    content: @Composable LazyItemScope.(index: Int) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val haptic = LocalHapticFeedback.current

    val count = if (isEndless) itemCount else itemCount + 2 * rowOffset
    val rowOffsetCount = maxOf(1, minOf(rowOffset, 4))
    val rowCount = ((rowOffsetCount * 2) + 1)
    val startIndex = if (isEndless) selection + (itemCount * 1000) - rowOffset else selection

    val state = lazyWheelState ?: rememberLazyListState(startIndex)

    val size = DpSize(itemSize.width, itemSize.height * rowCount)

    val isScrollInProgress = state.isScrollInProgress
    val focusedIndex = remember {
        derivedStateOf { state.firstVisibleItemIndex + rowOffsetCount }
    }

    LaunchedEffect(key1 = itemCount) {
        coroutineScope.launch {
            state.scrollToItem(startIndex)
        }
    }

    LaunchedEffect(key1 = isScrollInProgress) {
        if (!isScrollInProgress) {
            calculateIndexToFocus(state, size.height).let {
                val indexToFocus = if (isEndless) {
                    (it + rowOffsetCount) % itemCount
                } else {
                    ((it + rowOffsetCount) % count) - rowOffset
                }

                onFocusItem(indexToFocus)
                if (state.firstVisibleItemScrollOffset != 0) {
                    coroutineScope.launch {
                        state.animateScrollToItem(it, 0)
                    }
                }
            }
        }
    }

    LaunchedEffect(state) {
        snapshotFlow { state.firstVisibleItemIndex }.collect {
            if (selectorOption.selectEffectEnabled) haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    Box(
        modifier = modifier
            .height(size.height)
            .fillMaxWidth(),
    ) {
        LazyColumn(
            modifier = Modifier
                .height(size.height)
                .fillMaxWidth(),
            state = state,
            userScrollEnabled = userScrollEnabled,
            horizontalAlignment = horizontalAlignment
        ) {
            items(if (isEndless) Int.MAX_VALUE else count) {
                val rotateDegree = if (isTransformationEnabled) calculateIndexRotation(focusedIndex.value, it, rowOffset) else 0f
                val scale = if (isTransformationEnabled) calculateScale(focusedIndex.value, it) else 1f
                Box(
                    modifier = Modifier
                        .height(size.height / rowCount).scale(scale)
                        .fillMaxWidth()
                        .graphicsLayer {
                            this.rotationX = rotateDegree
                            this.alpha = if (focusedIndex.value == it) 1f else maxOf(
                                0.45f - 0.1f * abs(focusedIndex.value - it), 0.08f
                            )
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    if (isEndless) {
                        content(it % itemCount)
                    } else if (it >= rowOffsetCount && it < itemCount + rowOffsetCount) {
                        content((it - rowOffsetCount) % itemCount)
                    }
                }
            }
        }
    }
}


private fun calculateIndexToFocus(listState: LazyListState, height: Dp): Int {
    val currentItem = listState.layoutInfo.visibleItemsInfo.firstOrNull()
    var index = currentItem?.index ?: 0

    if (currentItem?.offset != 0) {
        if (currentItem != null && currentItem.offset <= -height.value * 3 / 10) {
            index++
        }
    }
    return index
}

@Composable
private fun calculateIndexRotation(focusedIndex: Int, index: Int, offset: Int): Float {
    return (6 * offset + 1).toFloat() * (focusedIndex - index)
}

private fun calculateScale(focusedIndex: Int, index: Int): Float {
    val distance = abs(focusedIndex - index)
    return 1f - 0.1f * (distance)
}

