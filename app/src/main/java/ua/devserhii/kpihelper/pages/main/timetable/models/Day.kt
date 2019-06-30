package ua.devserhii.kpihelper.pages.main.timetable.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Serhii Boiko on 28.06.2019.
 */
open class Day(

        @SerializedName("day_name") val dayName: String,
        @SerializedName("day_number") val dayNumber: Int,
        @SerializedName("lessons") val lessons: List<Lesson>
)