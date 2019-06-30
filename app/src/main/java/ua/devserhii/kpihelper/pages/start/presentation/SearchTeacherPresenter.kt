package ua.devserhii.kpihelper.pages.start.presentation

import ua.devserhii.kpihelper.global.liteMoxy.MvpPresenter
import ua.devserhii.kpihelper.pages.start.logic.SearchTeacherUseCase

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
class SearchTeacherPresenter(
        private val searchTeacherUseCase: SearchTeacherUseCase
) : MvpPresenter<SearchTeacherEvents>() {

    fun searchTeacher(text: String) {
        searchTeacherUseCase.search(text) {
            view.update(SearchTeacherEvents.ShowSearchResult(it))
        }
    }

    fun downloadTeacherTimetable(teacherId: Int) {
        TODO("not implemented")
    }
}