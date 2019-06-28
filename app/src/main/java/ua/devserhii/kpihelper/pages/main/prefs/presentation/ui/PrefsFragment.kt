package ua.devserhii.kpihelper.pages.main.prefs.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.devserhii.kpihelper.R

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class PrefsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_prefs, container, false)
    }
}