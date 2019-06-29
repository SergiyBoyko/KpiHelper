package ua.devserhii.kpihelper.pages.start.logic

import ua.devserhii.kpihelper.global.logic.UseCase
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable
import ua.devserhii.kpihelper.pages.main.timetable.persistance.TimetableDataSource

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class DownloadTimetableUseCase(private val timetableDataSource: TimetableDataSource) : UseCase<Timetable>() {

    fun download(groupName: String, callback: (Timetable) -> Unit) {
        execute({ timetableDataSource.updateTimetable(groupName) }) { callback(it) }
    }
}