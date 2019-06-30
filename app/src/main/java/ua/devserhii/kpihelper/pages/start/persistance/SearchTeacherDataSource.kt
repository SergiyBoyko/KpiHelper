package ua.devserhii.kpihelper.pages.start.persistance

import ua.devserhii.kpihelper.pages.start.models.Teacher

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
interface SearchTeacherDataSource {
    suspend fun search(text: String): List<Teacher>
}