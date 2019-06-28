package ua.devserhii.kpihelper.pages.start.persistance

import ua.devserhii.kpihelper.pages.start.models.Group

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
interface SearchGroupDataSource {
    suspend fun search(text: String): List<Group>
}