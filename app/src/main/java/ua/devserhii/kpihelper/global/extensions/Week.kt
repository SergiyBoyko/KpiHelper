package ua.devserhii.kpihelper.global.extensions

import ua.devserhii.kpihelper.global.model.Sunday
import ua.devserhii.kpihelper.pages.main.timetable.models.Day
import ua.devserhii.kpihelper.pages.main.timetable.models.Week
import java.util.*

/**
 * Created by Serhii Boiko on 30.06.2019.
 */


fun Week.today(): Day {
    val now: Calendar = Calendar.getInstance()
    return when (now.get(Calendar.DAY_OF_WEEK)) {
        Calendar.MONDAY -> days.monday
        Calendar.TUESDAY -> days.tuesday
        Calendar.WEDNESDAY -> days.wednesday
        Calendar.THURSDAY -> days.thursday
        Calendar.FRIDAY -> days.friday
        Calendar.SATURDAY -> days.saturday
        else -> Sunday
    }
}