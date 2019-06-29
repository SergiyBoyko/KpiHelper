package ua.devserhii.kpihelper.pages.main.timetable.presentation

import org.koin.core.KoinComponent
import ua.devserhii.kpihelper.global.liteMoxy.MvpPresenter
import ua.devserhii.kpihelper.pages.main.timetable.logic.GetCurrentTimetableUseCase

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class TimetablePresenter(
        private val getCurrentTimetableUseCase: GetCurrentTimetableUseCase
) : MvpPresenter<TimetableEvents>(), KoinComponent {

    fun getCurrentTimetable() {
        getCurrentTimetableUseCase.get {
            view.update(TimetableEvents.ShowTimetable(it))
        }
    }
}