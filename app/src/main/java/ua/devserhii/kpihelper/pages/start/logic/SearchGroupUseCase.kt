package ua.devserhii.kpihelper.pages.start.logic

import ua.devserhii.kpihelper.global.logic.UseCase
import ua.devserhii.kpihelper.pages.start.models.Group
import ua.devserhii.kpihelper.pages.start.persistance.SearchGroupDataSource

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
class SearchGroupUseCase(private val searchGroupDataSource: SearchGroupDataSource) :
    UseCase<List<Group>>() {

    fun search(text: String, callback: (List<Group>) -> Unit) {
        execute({ searchGroupDataSource.search(text) }) { callback(it) }
    }
}