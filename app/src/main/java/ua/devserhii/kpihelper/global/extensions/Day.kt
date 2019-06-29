package ua.devserhii.kpihelper.global.extensions

import ua.devserhii.kpihelper.pages.main.timetable.models.Day

/**
 * Created by Serhii Boiko on 29.06.2019.
 */

fun Day.name(): String = when (dayNumber) {
    1 -> "Monday"
    2 -> "Tuesday"
    3 -> "Wednesday"
    4 -> "Thursday"
    5 -> "Friday"
    6 -> "Saturday"
    else -> ""
}
