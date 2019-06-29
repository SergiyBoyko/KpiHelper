package ua.devserhii.kpihelper.pages.main.timetable.persistance.remote

import ua.devserhii.kpihelper.global.extensions.getHandledBody
import ua.devserhii.kpihelper.global.extensions.getHandledData
import ua.devserhii.kpihelper.global.model.KpiResponse
import ua.devserhii.kpihelper.pages.main.timetable.models.Timetable
import ua.devserhii.kpihelper.pages.main.timetable.persistance.TimetableDataSource
import ua.devserhii.kpihelper.persistance.api.KpiApi
import ua.devserhii.kpihelper.persistance.database.AppDatabase

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class TimetableRemoteDataSource(private val api: KpiApi, private val appDatabase: AppDatabase) : TimetableDataSource {

    override suspend fun updateTimetable(groupName: String): Timetable {
        val timetable: Timetable = api.fetchTimetableAsync(groupName).await().getHandledData()
        val weekResponse: KpiResponse<Int> = api.fetchWeekNumberAsync().await().getHandledBody()
        timetable.weekNumberTimestamp = weekResponse.timeStamp
        timetable.weekNumber = weekResponse.data
        appDatabase.timetableDao().insertCurrent(timetable)
        return timetable
    }

    override suspend fun getTimetable(): Timetable {
        return appDatabase.timetableDao().getCurrent()
    }

    override suspend fun deleteTimetable() {
        val timetableDao = appDatabase.timetableDao()
        timetableDao.delete(timetableDao.getCurrent())
    }

}