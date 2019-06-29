package ua.devserhii.kpihelper.pages.main.timetable.presentation

import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
sealed class TimetableEvents {
    class ShowTimetable(val timetable: Timetable) : TimetableEvents()
}