package ua.devserhii.kpihelper.pages.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivity
import ua.devserhii.kpihelper.pages.main.presentation.ui.MainActivity
import ua.devserhii.kpihelper.pages.start.presentation.ui.StartActivity

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openApp()
    }

    private fun openApp() {
        if (defaultSharedPreferences.getBoolean("helper_focused", false)) {
            startActivity<MainActivity>()
            finish()
        } else {
            startActivity<StartActivity>()
            finish()
        }
    }
}