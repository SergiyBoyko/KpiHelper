package ua.devserhii.kpihelper.pages.main.timetable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import ua.devserhii.kpihelper.R
import ua.devserhii.kpihelper.global.extensions.inTime
import ua.devserhii.kpihelper.global.extensions.name
import ua.devserhii.kpihelper.global.view.LessonView
import ua.devserhii.kpihelper.pages.main.timetable.models.Day
import java.util.*

/**
 * Created by Serhii Boiko on 29.06.2019.
 */
class TimetableAdapter(
        private val days: List<Day>,
        private val currentWeek: Int
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

        val now: Calendar = Calendar.getInstance()
        val currentDay: Int = now.get(Calendar.DAY_OF_WEEK)

        val day = days[position]
        val weekNumber = day.lessons.first().lessonWeek

        val dayName = holder.itemView.findViewById<TextView>(R.id.day_name)
        val today = day.dayNumber == currentDay && weekNumber == currentWeek
        if (today) {
            dayName.textColor = ContextCompat.getColor(dayName.context, R.color.colorPrimary)
            dayName.backgroundColor = ContextCompat.getColor(dayName.context, R.color.colorAccent)
        }

        dayName.text = day.name(weekNumber)

        for (lesson in day.lessons) {
            val lessonView = LessonView(holder.itemView.context)
            lessonView.bindLesson(lesson, today && lesson.inTime())
            list.addView(lessonView)
        }
    }


    class TimetableViewHolder(inflater: LayoutInflater?, parent: ViewGroup) :
            RecyclerView.ViewHolder(
                    inflater!!.inflate(R.layout.item_timetable, parent, false)
            )
}