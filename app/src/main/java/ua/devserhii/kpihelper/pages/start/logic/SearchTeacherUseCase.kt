package ua.devserhii.kpihelper.pages.start.logic

import ua.devserhii.kpihelper.global.logic.UseCase
import ua.devserhii.kpihelper.pages.start.models.Teacher
import ua.devserhii.kpihelper.pages.start.persistance.SearchTeacherDataSource

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
class SearchTeacherUseCase(private val searchTeacherDataSource: SearchTeacherDataSource) :
        UseCase<List<Teacher>>() {

    fun search(text: String, callback: (List<Teacher>) -> Unit) {
        execute({ searchTeacherDataSource.search(text) }) { callback(it) }
    }
}