package com.kimdowoo.datepicker.utils

import com.kimdowoo.datepicker.model.Date
import java.util.Calendar

object DateUtils {

    fun getTimeMiles(year: Int, month: Int, day: Int): Long {
        val calendar = Calendar.getInstance()
        calendar[Calendar.YEAR] = year
        calendar[Calendar.MONTH] = month
        val maxDayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar[Calendar.DAY_OF_MONTH] = Math.min(day, maxDayCount)
        return calendar.timeInMillis
    }

    fun getCurrentTime(): Long {
        val calendar = Calendar.getInstance()
        calendar[Calendar.HOUR_OF_DAY] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        calendar[Calendar.MILLISECOND] = 0
        return calendar.timeInMillis
    }

    fun getMonthDayCount(timeStamp: Long): Int {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeStamp
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    fun getDay(timeStamp: Long): Int {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeStamp
        return calendar[Calendar.DAY_OF_MONTH]
    }

    fun getMonth(timeStamp: Long): Int {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeStamp
        return calendar[Calendar.MONTH]
    }

    fun getYear(timeStamp: Long): Int {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeStamp
        return calendar[Calendar.YEAR]
    }
}


fun Date.monthsOfDate(): List<Int> {
    val months = mutableListOf<Int>()
    for (month in 1..12) {
        months.add(month)
    }
    return months
}


fun Date.daysOfDate(): List<Int> {
    val days = mutableListOf<Int>()
    val monthDayCount = DateUtils.getMonthDayCount(this.date)
    for (day in 1..monthDayCount) {
        days.add(day)
    }
    return days
}

fun Date.withYear(year: Int): Date {
    return Date(year, this.month, this.day)
}

fun Date.withMonth(month: Int): Date {
    return Date(this.year, month - 1, this.day)
}

fun Date.withDay(day: Int): Date {
    return Date(this.year, this.month, day)
}
