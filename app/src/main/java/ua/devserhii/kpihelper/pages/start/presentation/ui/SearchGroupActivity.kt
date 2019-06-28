package ua.devserhii.kpihelper.pages.start.presentation.ui

import android.content.Context
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_search_group.*
import org.koin.android.ext.android.inject
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.afterTextChanged
import ua.devserhii.kpihelper.global.liteMoxy.MvpAppCompatActivity
import ua.devserhii.kpihelper.pages.start.presentation.SearchGroupEvents
import ua.devserhii.kpihelper.pages.start.presentation.SearchGroupPresenter

/**
 * Created by Serhii Boiko on 23.06.2019.
 */
class SearchGroupActivity : MvpAppCompatActivity<SearchGroupEvents>() {
    override val presenter: SearchGroupPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_group)


        group_name_input.afterTextChanged {
            val group = it.toString()
            if (group.isNotBlank() && group.length > 2) {
                presenter.searchGroup(group)
            }
        }
    }

    override fun update(event: SearchGroupEvents) =
        when (event) {
            is SearchGroupEvents.ShowSearchResult -> {
                group_name_input.setAdapter(ArrayAdapter(
                    this, // Context
                    android.R.layout.simple_dropdown_item_1line, // Layout
                    event.groups.toTypedArray().map { it.groupFullName } // Array
                ))
                group_name_input.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    group_name_input.setText(event.groups[position].groupFullName)
                }
                group_name_input.threshold = 3
                group_name_input.showDropDown()
            }
        }

}

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()