package ua.devserhii.kpihelper.global.extensions

import java.util.*
import java.util.concurrent.TimeUnit

fun Calendar.minuteDifference(calendarEnd: Calendar): Int {
    return TimeUnit.MILLISECONDS
            .toMinutes(calendarEnd.timeInMillis - timeInMillis)
            .toInt()
}

val Calendar.dayOfMonth
    get() = get(Calendar.DAY_OF_MONTH)

val Calendar.month
    get() = get(Calendar.MONTH)

val Calendar.year
    get() = get(Calendar.YEAR)