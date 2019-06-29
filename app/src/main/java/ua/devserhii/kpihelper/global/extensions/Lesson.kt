package ua.devserhii.kpihelper.global.extensions

import ua.devserhii.kpihelper.pages.main.timetable.models.Lesson
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Serhii Boiko on 29.06.2019.
 */

fun Lesson.inTime(): Boolean {
    val format = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val dateStart: Date = format.parse(timeStart)
    val calendarStart: Calendar = Calendar.getInstance()
    calendarStart.set(Calendar.HOUR_OF_DAY, dateStart.hours)
    calendarStart.set(Calendar.MINUTE, dateStart.minutes)
    val dateEnd: Date = format.parse(timeEnd)
    val calendarEnd: Calendar = Calendar.getInstance()
    calendarEnd.set(Calendar.HOUR_OF_DAY, dateEnd.hours)
    calendarEnd.set(Calendar.MINUTE, dateEnd.minutes)
    val now = Calendar.getInstance()
    return now.after(calendarStart) && now.before(calendarEnd)
}