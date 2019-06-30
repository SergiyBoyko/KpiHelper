package ua.devserhii.kpihelper.pages.main.dashboard.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.android.ext.android.inject
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.liteMoxy.MvpFragment
import ua.devserhii.kpihelper.global.view.ProgressLessonView
import ua.devserhii.kpihelper.pages.main.dashboard.presentation.DashboardEvents
import ua.devserhii.kpihelper.pages.main.dashboard.presentation.DashboardPresenter

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class DashboardFragment : MvpFragment<DashboardEvents>() {

    override val presenter: DashboardPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.fillDashboardData()
    }

    override fun update(event: DashboardEvents) {
        when (event) {
            is DashboardEvents.ShowTitle -> dashboard_title.title = "Group: ${event.title}"
            is DashboardEvents.ShowLessonsDay -> {
                progress_lessons_container.removeAllViews()
                for (lesson in event.day.lessons) {
                    val progressLessonView = ProgressLessonView(activity!!)
                    progressLessonView.bindProgressLesson(lesson)
                    progress_lessons_container.addView(progressLessonView)
                }
            }
            is DashboardEvents.ShowWeek -> day_of_week.text = event.week
        }
    }
}
