package ua.devserhii.kpihelper.global.extensions

import ua.devserhii.kpihelper.pages.main.timetable.models.Day
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable
import java.util.*
import kotlin.math.abs

/**
 * Created by Serhii Boiko on 29.06.2019.
 */

fun Timetable.getDays(): List<Day> {
    val days: MutableList<Day> = mutableListOf()
    val firstWeekDays = this.weeks.firstWeek.days
    if (firstWeekDays.monday.lessons.isNotEmpty()) {
        days.add(firstWeekDays.monday)
    }
    if (firstWeekDays.tuesday.lessons.isNotEmpty()) {
        days.add(firstWeekDays.tuesday)
    }
    if (firstWeekDays.wednesday.lessons.isNotEmpty()) {
        days.add(firstWeekDays.wednesday)
    }
    if (firstWeekDays.thursday.lessons.isNotEmpty()) {
        days.add(firstWeekDays.thursday)
    }
    if (firstWeekDays.friday.lessons.isNotEmpty()) {
        days.add(firstWeekDays.friday)
    }
    if (firstWeekDays.saturday.lessons.isNotEmpty()) {
        days.add(firstWeekDays.saturday)
    }

    val secondWeekDays = this.weeks.secondWeek.days
    if (secondWeekDays.monday.lessons.isNotEmpty()) {
        days.add(secondWeekDays.monday)
    }
    if (secondWeekDays.tuesday.lessons.isNotEmpty()) {
        days.add(secondWeekDays.tuesday)
    }
    if (secondWeekDays.wednesday.lessons.isNotEmpty()) {
        days.add(secondWeekDays.wednesday)
    }
    if (secondWeekDays.thursday.lessons.isNotEmpty()) {
        days.add(secondWeekDays.thursday)
    }
    if (secondWeekDays.friday.lessons.isNotEmpty()) {
        days.add(secondWeekDays.friday)
    }
    if (secondWeekDays.saturday.lessons.isNotEmpty()) {
        days.add(secondWeekDays.saturday)
    }
    return days
}

fun Timetable.getCurrentWeek(): Int {
    val now: Calendar = Calendar.getInstance()

    val saved: Calendar = Calendar.getInstance()
            .also { it.timeInMillis = weekNumberTimestamp.toLong() }

    val weekSince: Int = (now.get(Calendar.WEEK_OF_YEAR) - saved.get(Calendar.WEEK_OF_YEAR)) % 2
    return when {
        abs(weekSince) == 0 -> weekNumber
        weekSince == 1 -> 2
        else -> 1
    }
}