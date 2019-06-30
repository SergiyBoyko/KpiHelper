package ua.devserhii.kpihelper.global.extensions

import ua.devserhii.kpihelper.global.model.LessonStatus
import ua.devserhii.kpihelper.pages.main.timetable.models.Lesson
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
const val BREAK_TIME_MINUTES = 20
val TIME_FORMAT = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)

fun Lesson.status(func: (status: LessonStatus, minutes: Int, percent: Int) -> Unit) {
    val dateStart: Date = TIME_FORMAT.parse(timeStart)
    val calendarStart: Calendar = Calendar.getInstance()
    calendarStart.set(Calendar.HOUR_OF_DAY, dateStart.hours)
    calendarStart.set(Calendar.MINUTE, dateStart.minutes)

    val calendarPreparation: Calendar = Calendar.getInstance()
    calendarPreparation.time = calendarStart.time
    calendarPreparation.add(Calendar.MINUTE, -BREAK_TIME_MINUTES)
    val dateEnd: Date = TIME_FORMAT.parse(timeEnd)
    val calendarEnd: Calendar = Calendar.getInstance()
    calendarEnd.set(Calendar.HOUR_OF_DAY, dateEnd.hours)
    calendarEnd.set(Calendar.MINUTE, dateEnd.minutes)
    val now = Calendar.getInstance()

    when {
        now.before(calendarPreparation) -> {
            func(LessonStatus.PENDING, now.minuteDifference(calendarStart), 0)
        }
        now.after(calendarPreparation) && now.before(calendarStart) -> {
            func(LessonStatus.PREPARATION, now.minuteDifference(calendarStart), 0)
        }
        now.after(calendarStart) && now.before(calendarEnd) -> {
            val minutesToEnd = now.minuteDifference(calendarEnd).toDouble()
            val duration: Double = calendarStart.minuteDifference(calendarEnd).toDouble()
            func(
                    LessonStatus.IN_PROGRESS,
                    minutesToEnd.toInt(),
                    (100 - minutesToEnd / (duration / 100)).toInt()
            )
        }
        now.after(calendarEnd) -> {
            func(LessonStatus.COMPLETED, calendarEnd.minuteDifference(now), 100)
        }
    }
}

fun Lesson.inTime(startOffset: Int = 0): Boolean {
    val dateStart: Date = TIME_FORMAT.parse(timeStart)
    val calendarStart: Calendar = Calendar.getInstance()
    calendarStart.set(Calendar.HOUR_OF_DAY, dateStart.hours)
    calendarStart.set(Calendar.MINUTE, dateStart.minutes)
    calendarStart.add(Calendar.MINUTE, -startOffset)
    val dateEnd: Date = TIME_FORMAT.parse(timeEnd)
    val calendarEnd: Calendar = Calendar.getInstance()
    calendarEnd.set(Calendar.HOUR_OF_DAY, dateEnd.hours)
    calendarEnd.set(Calendar.MINUTE, dateEnd.minutes)
    val now = Calendar.getInstance()
    return now.after(calendarStart) && now.before(calendarEnd)
}