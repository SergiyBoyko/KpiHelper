package ua.devserhii.kpihelper.pages.main.timetable.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_timetable.*
import org.koin.android.ext.android.inject
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.getDays
import ua.devserhii.kpihelper.global.liteMoxy.MvpFragment
import ua.devserhii.kpihelper.pages.main.timetable.adapter.TimetableAdapter
import ua.devserhii.kpihelper.pages.main.timetable.presentation.TimetableEvents
import ua.devserhii.kpihelper.pages.main.timetable.presentation.TimetablePresenter

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class TimetableFragment : MvpFragment<TimetableEvents>() {

    override val presenter: TimetablePresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_timetable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCurrentTimetable()

    }

    override fun update(event: TimetableEvents) {
        when (event) {
            is TimetableEvents.ShowTimetable -> {
                recycler_timetable.adapter = TimetableAdapter(event.timetable.getDays())
                recycler_timetable.layoutManager = GridLayoutManager(context, 2)
            }
        }
    }
}