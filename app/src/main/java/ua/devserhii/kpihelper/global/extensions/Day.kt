package ua.devserhii.kpihelper.global.extensions

import ua.devserhii.kpihelper.pages.main.timetable.models.Day

/**
 * Created by Serhii Boiko on 29.06.2019.
 */

fun Day.name(weekNumber: Int): String = when (dayNumber) {
    1 -> "Monday-$weekNumber"
    2 -> "Tuesday-$weekNumber"
    3 -> "Wednesday-$weekNumber"
    4 -> "Thursday-$weekNumber"
    5 -> "Friday-$weekNumber"
    6 -> "Saturday-$weekNumber"
    7 -> "Sunday-$weekNumber"
    else -> ""
}
