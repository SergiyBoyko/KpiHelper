package ua.devserhii.kpihelper.pages.start.persistance.remote

import ua.devserhii.kpihelper.global.extensions.getHandledData
import ua.devserhii.kpihelper.pages.start.models.Teacher
import ua.devserhii.kpihelper.pages.start.persistance.SearchTeacherDataSource
import ua.devserhii.kpihelper.persistance.api.KpiApi

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
class SearchTeacherRemoteDataSource(private val api: KpiApi) : SearchTeacherDataSource {
    override suspend fun search(text: String): List<Teacher> {
        return api.searchTeacherAsync("{'query':'$text'}").await().getHandledData()
    }
}