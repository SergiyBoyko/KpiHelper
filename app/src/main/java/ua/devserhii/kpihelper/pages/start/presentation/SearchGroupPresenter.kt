package ua.devserhii.kpihelper.pages.start.presentation

import org.koin.core.KoinComponent
import ua.devserhii.kpihelper.global.liteMoxy.MvpPresenter
import ua.devserhii.kpihelper.pages.start.logic.SearchGroupUseCase

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
class SearchGroupPresenter(
    private val searchGroupUseCase: SearchGroupUseCase
) : MvpPresenter<SearchGroupEvents>(), KoinComponent {

    fun searchGroup(text: String) {
        searchGroupUseCase.search(text) {
            view.update(SearchGroupEvents.ShowSearchResult(it))
        }
    }
}