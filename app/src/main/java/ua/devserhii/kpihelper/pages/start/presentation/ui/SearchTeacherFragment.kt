package ua.devserhii.kpihelper.pages.start.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_search_teacher.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.android.ext.android.inject
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.afterTextChanged
import ua.devserhii.kpihelper.global.liteMoxy.MvpFragment
import ua.devserhii.kpihelper.pages.start.presentation.SearchTeacherEvents
import ua.devserhii.kpihelper.pages.start.presentation.SearchTeacherPresenter

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class SearchTeacherFragment : MvpFragment<SearchTeacherEvents>() {
    override val presenter: SearchTeacherPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_teacher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input_group_button.onClick {
            (activity as StartActivity).showGroupContainer()
        }
        teacher_name_input.afterTextChanged {
            val teacher = it.toString()
            if (teacher.isNotBlank() && teacher.length > 2) {
                presenter.searchTeacher(teacher)
            }
        }
    }

    override fun update(event: SearchTeacherEvents) {
        when (event) {
            is SearchTeacherEvents.ShowSearchResult -> {
                teacher_autocomplete.setAdapter(ArrayAdapter(
                        activity!!, // Context
                        R.layout.simple_dropdown_item, // Layout
                        event.teachers.toTypedArray().map { it.teacherName } // Array
                ))
                teacher_autocomplete.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    val teacher = event.teachers[position]
                    teacher_name_input.setText(teacher.teacherName)
                    presenter.downloadTeacherTimetable(teacher.teacherId)
                }
                teacher_autocomplete.showDropDown()
            }
        }
    }
}