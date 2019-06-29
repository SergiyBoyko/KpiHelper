package ua.devserhii.kpihelper.pages.main.timetable.persistance

import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
interface TimetableDataSource {
    suspend fun updateTimetable(groupName: String): Timetable

    suspend fun getTimetable(): Timetable

    suspend fun deleteTimetable()
}