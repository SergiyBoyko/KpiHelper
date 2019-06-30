package ua.devserhii.kpihelper.pages.start.presentation

import ua.devserhii.kpihelper.pages.start.models.Teacher

/**
 * Created by Serhii Boiko on 30.06.2019.
 */
sealed class SearchTeacherEvents {
    class ShowSearchResult(val teachers: List<Teacher>) : SearchTeacherEvents()
}