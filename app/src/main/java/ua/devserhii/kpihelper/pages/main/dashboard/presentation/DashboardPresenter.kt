package ua.devserhii.kpihelper.pages.main.dashboard.presentation

import org.koin.core.KoinComponent
import ua.devserhii.kpihelper.global.extensions.getCurrentWeek
import ua.devserhii.kpihelper.global.extensions.name
import ua.devserhii.kpihelper.global.extensions.today
import ua.devserhii.kpihelper.global.liteMoxy.MvpPresenter
import ua.devserhii.kpihelper.pages.main.timetable.logic.GetCurrentTimetableUseCase
import ua.devserhii.kpihelper.pages.main.timetable.models.Day
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
class DashboardPresenter(
        private val getCurrentTimetableUseCase: GetCurrentTimetableUseCase
) : MvpPresenter<DashboardEvents>(), KoinComponent {

    fun fillDashboardData() {
        getCurrentTimetableUseCase.get {
            view.update(DashboardEvents.ShowTitle(it.group.groupFullName.toUpperCase()))
            val day = getToday(it)
            view.update(DashboardEvents.ShowWeek(day.name(it.weekNumber)))
            if (day.lessons.isEmpty()) {
                view.update(DashboardEvents.ShowNoLessonsDay)
            } else {
                view.update(DashboardEvents.ShowLessonsDay(day))
            }
        }
    }

    private fun getToday(timetable: Timetable): Day = if (timetable.getCurrentWeek() == 1) {
        timetable.weeks.firstWeek.today()
    } else {
        timetable.weeks.secondWeek.today()
    }
}