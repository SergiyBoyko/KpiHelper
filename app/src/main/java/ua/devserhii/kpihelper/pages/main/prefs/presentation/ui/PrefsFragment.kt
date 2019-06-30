package ua.devserhii.kpihelper.pages.main.prefs.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_prefs.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.defaultSharedPreferences
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.liteMoxy.MvpFragment
import ua.devserhii.kpihelper.pages.main.prefs.presentation.PrefsEvents
import ua.devserhii.kpihelper.pages.main.prefs.presentation.PrefsPresenter
import ua.devserhii.kpihelper.pages.start.presentation.ui.StartActivity

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class PrefsFragment : MvpFragment<PrefsEvents>() {
    override val presenter: PrefsPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_prefs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exit_button.onClick { presenter.exit() }
        theme_button.onClick { toast("Coming soon") }
        rate_button.onClick { toast("Not published yet") }
    }

    override fun update(event: PrefsEvents) {
        when (event) {
            PrefsEvents.Exit -> {
                defaultSharedPreferences.edit().putBoolean("helper_focused", false).apply()
                startActivity<StartActivity>()
                activity!!.finish()
            }
        }
    }
}
