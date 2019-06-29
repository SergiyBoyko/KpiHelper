package ua.devserhii.kpihelper.pages.main.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.replaceFragment
import ua.devserhii.kpihelper.pages.main.dashboard.presentation.ui.DashboardFragment
import ua.devserhii.kpihelper.pages.main.prefs.presentation.ui.PrefsFragment
import ua.devserhii.kpihelper.pages.main.timetable.presentation.ui.TimetableFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_bottom_navigation.setOnNavigationItemSelectedListener {
            replaceFragment(R.id.fragment_container, getFragment(it.itemId))
            true
        }
        replaceFragment(R.id.fragment_container, DashboardFragment())
    }

    private fun getFragment(menuId: Int): Fragment = when (menuId) {
        R.id.menu_dashboard -> DashboardFragment()
        R.id.menu_lessons -> TimetableFragment()
        R.id.menu_prefs -> PrefsFragment()
        else -> DashboardFragment()
    }

}
