package ua.devserhii.kpihelper.pages.start.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_search_group.*
import org.jetbrains.anko.support.v4.defaultSharedPreferences
import org.jetbrains.anko.support.v4.startActivity
import org.koin.android.ext.android.inject
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.afterTextChanged
import ua.devserhii.kpihelper.global.liteMoxy.MvpFragment
import ua.devserhii.kpihelper.pages.main.presentation.ui.MainActivity
import ua.devserhii.kpihelper.pages.start.presentation.SearchGroupEvents
import ua.devserhii.kpihelper.pages.start.presentation.SearchGroupPresenter

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
class SearchGroupFragment : MvpFragment<SearchGroupEvents>() {

    override val presenter: SearchGroupPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        group_name_input.afterTextChanged {
            val group = it.toString()
            if (group.isNotBlank() && group.length > 1) {
                presenter.searchGroup(group)
            }
        }
    }

    override fun update(event: SearchGroupEvents) =
            when (event) {
                is SearchGroupEvents.ShowSearchResult -> {
                    group_autocomplete.setAdapter(ArrayAdapter(
                            activity!!, // Context
                            R.layout.simple_dropdown_item, // Layout
                            event.groups.toTypedArray().map { it.groupFullName } // Array
                    ))
                    group_autocomplete.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                        val groupFullName = event.groups[position].groupFullName
                        group_name_input.setText(groupFullName)
                        presenter.downloadTimetable(groupFullName)
                    }
                    group_autocomplete.showDropDown()
                }
                SearchGroupEvents.ShowLoading -> progress_group_loading.visibility = View.VISIBLE
                SearchGroupEvents.HideLoading -> {
                    defaultSharedPreferences.edit().putBoolean("helper_focused", true).apply()
                    progress_group_loading.visibility = View.GONE
                    startActivity<MainActivity>()
                    activity!!.finish()
                }
            }
}