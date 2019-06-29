package ua.devserhii.kpihelper.pages.main.timetable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.name
import ua.devserhii.kpihelper.global.view.LessonView
import ua.devserhii.kpihelper.pages.main.timetable.models.Day

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class TimetableAdapter(
        private val days: List<Day>
) : RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {
        return TimetableViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun getItemCount(): Int {
        return days.size
    }

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        val list = holder.itemView.findViewById<LinearLayout>(R.id.day_lessons)
        list.removeAllViews()

        val day = days[position]
        holder.itemView.findViewById<TextView>(R.id.day_name)
                .text = day.name(day.lessons.first().lessonWeek)
        for (lesson in day.lessons) {
            val lessonView = LessonView(holder.itemView.context)
            lessonView.bindLesson(lesson)
            list.addView(lessonView)
        }
    }


    class TimetableViewHolder(inflater: LayoutInflater?, parent: ViewGroup) :
            RecyclerView.ViewHolder(
                    inflater!!.inflate(R.layout.item_timetable, parent, false)
            )
}