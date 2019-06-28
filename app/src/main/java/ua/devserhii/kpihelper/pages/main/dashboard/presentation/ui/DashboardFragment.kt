package ua.devserhii.kpihelper.pages.main.dashboard.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.devserhii.kpihelper.R

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class DashboardFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}