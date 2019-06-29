package ua.devserhii.kpihelper.pages.main.prefs.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.devserhii.kpihelper.global.liteMoxy.MvpPresenter
import ua.devserhii.kpihelper.pages.main.prefs.logic.ExitUseCase

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class PrefsPresenter(private val exitUseCase: ExitUseCase) : MvpPresenter<PrefsEvents>() {

    fun exit() = CoroutineScope(Dispatchers.Default).launch {
        exitUseCase.exit()
        view.update(PrefsEvents.Exit)
    }

}