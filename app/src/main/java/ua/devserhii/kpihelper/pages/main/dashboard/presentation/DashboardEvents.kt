package ua.devserhii.kpihelper.pages.main.dashboard.presentation

import ua.devserhii.kpihelper.pages.main.timetable.models.Day

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
sealed class DashboardEvents {
    class ShowTitle(val title: String) : DashboardEvents()
    class ShowWeek(val week: String) : DashboardEvents()
    class ShowLessonsDay(val day: Day) : DashboardEvents()
    object ShowNoLessonsDay : DashboardEvents()
}