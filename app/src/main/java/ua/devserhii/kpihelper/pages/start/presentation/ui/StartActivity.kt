package ua.devserhii.kpihelper.pages.start.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.replaceFragment

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        showGroupContainer()
    }

    fun showGroupContainer() =
            replaceFragment(R.id.start_fragment_container, SearchGroupFragment())

    fun showTeacherContainer() =
            replaceFragment(R.id.start_fragment_container, SearchTeacherFragment())
}