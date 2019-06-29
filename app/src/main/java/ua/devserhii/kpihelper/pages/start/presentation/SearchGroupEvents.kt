package ua.devserhii.kpihelper.pages.start.presentation

import ua.devserhii.kpihelper.pages.start.models.Group

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
sealed class SearchGroupEvents {
    class ShowSearchResult(val groups: List<Group>) : SearchGroupEvents()
    object ShowLoading : SearchGroupEvents()
    object HideLoading : SearchGroupEvents()
}