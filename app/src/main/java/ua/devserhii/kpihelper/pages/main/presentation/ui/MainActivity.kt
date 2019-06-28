package ua.devserhii.kpihelper.pages.main.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.pages.main.dashboard.presentation.ui.DashboardFragment
import ua.devserhii.kpihelper.pages.main.lessons.presentation.ui.LessonsFragment
import ua.devserhii.kpihelper.pages.main.prefs.presentation.ui.PrefsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_bottom_navigation.setOnNavigationItemSelectedListener {
            useFragment(getFragment(it.itemId))
            true
        }
        useFragment(DashboardFragment())
    }

    private fun getFragment(menuId: Int): Fragment = when (menuId) {
        R.id.menu_dashboard -> DashboardFragment()
        R.id.menu_lessons -> LessonsFragment()
        R.id.menu_prefs -> PrefsFragment()
        else -> DashboardFragment()
    }

    private fun useFragment(fragment: Fragment) {
        val fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.fragment_container, fragment)
        fm.commit()
    }
}
