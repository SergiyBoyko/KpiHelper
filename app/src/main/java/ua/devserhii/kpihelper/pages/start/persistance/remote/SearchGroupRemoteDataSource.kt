package ua.devserhii.kpihelper.pages.start.persistance.remote

import ua.devserhii.kpihelper.global.extensions.getHandledData
import ua.devserhii.kpihelper.pages.start.models.Group
import ua.devserhii.kpihelper.pages.start.persistance.SearchGroupDataSource
import ua.devserhii.kpihelper.persistance.api.KpiApi

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
class SearchGroupRemoteDataSource(private val api: KpiApi) : SearchGroupDataSource {
    override suspend fun search(text: String): List<Group> {
        return api.searchGroupAsync("{'query':'$text'}").await().getHandledData()
    }
}