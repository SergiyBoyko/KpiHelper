package ua.devserhii.kpihelper.pages.main.timetable.logic

import ua.devserhii.kpihelper.global.logic.UseCase
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable
import ua.devserhii.kpihelper.pages.main.timetable.persistance.TimetableDataSource

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class GetCurrentTimetableUseCase(
        private val timetableDataSource: TimetableDataSource
) : UseCase<Timetable>() {

    fun get(callback: (Timetable) -> Unit) {
        execute({ timetableDataSource.getTimetable() }) { callback(it) }
    }

}